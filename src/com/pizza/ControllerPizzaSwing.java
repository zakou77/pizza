package com.pizza;

import java.util.List;
import javax.swing.*;

public class ControllerPizzaSwing {

    private final VuePizzaSwing vue;
    private final Point_Pizzeria pizzaria;
    private final Client client;
    private final Livreur livreur;
    private final List<Commande> historiqueCommandes;

    private Commande commande;
    private int numeroCommande = 1;

    public ControllerPizzaSwing(VuePizzaSwing vue, Point_Pizzeria pizzaria, Client client, Livreur livreur, List<Commande> historiqueCommandes) {
        this.vue = vue;
        this.pizzaria = pizzaria;
        this.client = client;
        this.livreur = livreur;
        this.historiqueCommandes = historiqueCommandes;

        vue.setPizzaOptions(getNomsPizzas());
        nouvelleCommande();

        vue.setAjouterListener(e -> ajouterPizzaCommande());
        vue.setSupprimerListener(e -> supprimerDernierePizza());
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
        vue.setZoneCommandeText("Une PIZZA offerte après 10 PIZZA acheter\n" +
                "Nouvelle commande n°" + commande.getNumCommande() + " créée\n");
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

            LigneCommande ligne = new LigneCommande(commande.getNumCommande(), quantite, pizza, taille);
            commande.ajouterLigne(ligne);
            vue.appendZoneCommande("+ " + quantite + " x " + nomPizza + " (" + taille + ") – " + String.format("%.2f", ligne.getPrixLigne()) + "€\n");

            vue.setPrixTotal(commande.calculerPrixTotal());
        } else {
            vue.appendZoneCommande("❌ Pizza non trouvée : " + nomPizza + "\n");
        }
    }

    private void supprimerDernierePizza() {
        commande.retirerDerniereLigne();
        vue.setZoneCommandeText("Commande n°" + commande.getNumCommande() + " mise à jour :\n");

        for (LigneCommande l : commande.getLignes()) {
            vue.appendZoneCommande("+ " + l.getQuantite() + " x " + l.getPizza().getNom()
                    + " (" + l.getTaille() + ") – " + String.format("%.2f", l.getPrixLigne()) + "€\n");
        }

        vue.setPrixTotal(commande.calculerPrixTotal());
    }

    private void payerCommande() {
        int totalPayantes = commande.getNombreTotalPayant();
        double totalSansBonus = commande.calculerPrixTotal();

        if (commande.getNombreTotalPayant() == 0) {
            vue.appendZoneCommande("\n❌ Commande vide. Veuillez ajouter au moins une pizza.\n");
            return;
        }

        if (!client.peutPayer(totalSansBonus)) {
            vue.appendZoneCommande("\n❌ Solde insuffisant !\n");
            return;
        }

        if (totalPayantes >= 10) {
            String[] pizzas = getNomsPizzas();
            String choixNom = (String) JOptionPane.showInputDialog(
                    vue,
                    "🎁 Vous avez droit à une pizza OFFERTE !\nChoisissez la pizza :",
                    "Pizza offerte",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    pizzas,
                    pizzas[0]
            );

            if (choixNom != null) {
                String[] tailles = {"NAINE", "HUMAINE", "OGRESSE"};
                String choixTaille = (String) JOptionPane.showInputDialog(
                        vue,
                        "Choisissez la taille :",
                        "Taille offerte",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        tailles,
                        "HUMAINE"
                );

                if (choixTaille != null) {
                    Pizza pizza = pizzaria.getPizza(choixNom);
                    LigneCommande gratuite = new LigneCommande(commande.getNumCommande(), 1, pizza, choixTaille);
                    commande.ajouterLigne(gratuite);
                    vue.appendZoneCommande("🎁 Pizza offerte ajoutée : " + choixNom + " (" + choixTaille + ")\n");
                }
            }
        }

        double totalFinal = commande.calculerPrixTotal();
        client.payer(totalFinal);
        commande.setLivreur(livreur);

        vue.appendZoneCommande("\n✅ Commande payée : " + String.format("%.2f", totalFinal) + "€\n");
        vue.appendZoneCommande("🚚 Livrée par " + livreur.getNom_L() + " en " + livreur.getType_Vec() + "\n");

        JOptionPane.showMessageDialog(vue,
                "✅ Merci pour votre commande n°" + commande.getNumCommande() + " !",
                "Confirmation",
                JOptionPane.INFORMATION_MESSAGE);

        historiqueCommandes.add(commande);
        nouvelleCommande();
    }

    private void retourAccueil() {
        vue.dispose();
        VueClient vueClient = new VueClient();
        new ControlerClient(vueClient, client, pizzaria, livreur, historiqueCommandes, List.of());
    }
}
