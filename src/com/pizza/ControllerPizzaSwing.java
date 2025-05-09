package com.pizza;

import java.util.List;
import javax.swing.*;

public class ControllerPizzaSwing {

    private final VuePizzaSwing vue;
    private final Point_Pizzaria pizzaria;
    private final Client client;
    private final Livreur livreur;
    private final List<Commande> historiqueCommandes;

    private Commande commande;
    private int numeroCommande = 1;

    public ControllerPizzaSwing(VuePizzaSwing vue, Point_Pizzaria pizzaria, Client client, Livreur livreur, List<Commande> historiqueCommandes) {
        this.vue = vue;
        this.pizzaria = pizzaria;
        this.client = client;
        this.livreur = livreur;
        this.historiqueCommandes = historiqueCommandes;

        vue.setPizzaOptions(getNomsPizzas());
        nouvelleCommande();

        vue.setAjouterListener(e -> ajouterPizzaCommande());
        vue.setPayerListener(e -> payerCommande());
        vue.setRetourListener(e -> retourAccueil());
    }

    private String[] getNomsPizzas() {
        return pizzaria.getMenu().stream()
                .map(Pizza::getNom)
                .distinct()
                .toArray(String[]::new);
    }

    private void nouvelleCommande() {
        commande = new Commande(numeroCommande++, "2025-05-09", client);
        vue.setZoneCommandeText("Nouvelle commande n°" + commande.getNumCommande() + " créée\n");
        vue.setPrixTotal(0);
    }

    private void ajouterPizzaCommande() {
        String nomPizza = vue.getPizzaSelectionnee();
        String taille = vue.getTailleSelectionnee();
        int quantite = vue.getQuantiteSelectionnee();

        Pizza pizza = pizzaria.getPizza(nomPizza);
        if (pizza != null) {
            double coef = switch (taille) {
                case "NAINE" -> 0.8;
                case "OGRESSE" -> 1.2;
                default -> 1.0;
            };

            double prixTaille = pizza.getPrixBase() * coef;

            LigneCommande ligne = new LigneCommande(commande.getNumCommande(), quantite, pizza, taille);
            commande.ajouterLigne(ligne);
            vue.appendZoneCommande("+ " + quantite + " x " + nomPizza + " (" + taille + ") – " + String.format("%.2f", ligne.getPrixLigne()) + "€\n");

            // 🎁 Vérifier cumul + si déjà offerte
            int totalQuantite = 0;
            boolean dejaOfferte = false;

            for (LigneCommande l : commande.getLignes()) {
                if (l.getPizza().getNom().equals(nomPizza) && l.getTaille().equals(taille)) {
                    if (l.getQuantite() == 1 && l.getPrixLigne() == 0) {
                        dejaOfferte = true;
                    } else {
                        totalQuantite += l.getQuantite();
                    }
                }
            }

            if (totalQuantite >= 10 && !dejaOfferte) {
                LigneCommande gratuite = new LigneCommande(commande.getNumCommande(), 1, pizza, taille);
                gratuite.setTaille(taille);
                gratuite.setTaille(taille); // utile si logique change
                commande.ajouterLigne(gratuite);
                vue.appendZoneCommande("🎁 1 " + nomPizza + " (" + taille + ") OFFERTE !\n");
            }

            vue.setPrixTotal(commande.calculerPrixTotal());
        } else {
            vue.appendZoneCommande("❌ Pizza non trouvée : " + nomPizza + "\n");
        }
    }

    private void payerCommande() {
        double total = commande.calculerPrixTotal();
        if (client.peutPayer(total)) {
            client.payer(total);
            commande.setLivreur(livreur);
            vue.appendZoneCommande("\n✅ Commande payée : " + String.format("%.2f", total) + "€\n");
            vue.appendZoneCommande("🚚 Livrée par " + livreur.getNom_L() + " en " + livreur.getType_Vec() + "\n");

            historiqueCommandes.add(commande);
            nouvelleCommande();
        } else {
            vue.appendZoneCommande("\n❌ Solde insuffisant !\n");
        }
    }

    private void retourAccueil() {
        vue.dispose();
        VueClient vueClient = new VueClient();
        new ControlerClient(vueClient, client, pizzaria, livreur, historiqueCommandes);
    }
}
