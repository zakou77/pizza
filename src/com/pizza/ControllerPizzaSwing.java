package com.pizza;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

        // Remplir la liste des pizzas dans la vue
        vue.setPizzaOptions(getNomsPizzas());

        // Initialiser la première commande
        nouvelleCommande();

        // Lier les boutons à leurs actions
        vue.setAjouterListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterPizzaCommande();
            }
        });

        vue.setPayerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                payerCommande();
            }
        });
    }

    private String[] getNomsPizzas() {
        return pizzaria.getMenu().stream()
                .map(Pizza::getNom)
                .distinct()
                .toArray(String[]::new);
    }

    private void nouvelleCommande() {
        commande = new Commande(numeroCommande++, "2025-05-06", client);
        vue.setZoneCommandeText("Nouvelle commande n°" + commande.getNumCommande() + " créée\n");
        vue.setPrixTotal(0);
    }

    private void ajouterPizzaCommande() {
        String nomPizza = vue.getPizzaSelectionnee();
        String taille = vue.getTailleSelectionnee();
        int quantite = vue.getQuantiteSelectionnee();

        Pizza pizza = pizzaria.getPizza(nomPizza, taille);
        if (pizza != null) {
            LigneCommande ligne = new LigneCommande(commande.getNumCommande(), quantite, pizza);
            commande.ajouterLigne(ligne);

            double prixLigne = pizza.getPrixBase() * quantite;
            vue.appendZoneCommande("+ " + quantite + " x " + nomPizza + " (" + taille + ") – " + prixLigne + "€\n");
            vue.setPrixTotal(commande.calculerPrixTotal());
        } else {
            vue.appendZoneCommande("❌ Pizza non trouvée : " + nomPizza + " (" + taille + ")\n");
        }
    }

    private void payerCommande() {
        double total = commande.calculerPrixTotal();
        if (client.peutPayer(total)) {
            client.payer(total);
            commande.setLivreur(livreur);
            vue.appendZoneCommande("\n✅ Commande payée : " + total + "€\n");
            vue.appendZoneCommande("🚚 Livrée par " + livreur.getNom_L() + " en " + livreur.getType_Vec() + "\n");

            historiqueCommandes.add(commande);
            nouvelleCommande();
        } else {
            vue.appendZoneCommande("\n❌ Solde insuffisant !\n");
        }
    }
}
