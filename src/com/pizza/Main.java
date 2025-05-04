package com.pizza;

public class Main {
    public static void main(String[] args) {

        // Création d'un client
        Client client = new Client(1, "Zakarya", "Paris", 100.0);

        // Création d'un livreur
        Livreur livreur = new Livreur(1, "Scooter");

        // Création d'une pizzaria
        Point_Pizzaria pizzaria = new Point_Pizzaria(1, "10 rue de Paris");

        // Création d'une pizza
        Pizza pizza1 = new Pizza("Margherita", "Humaine", 10.0, pizzaria);
        Pizza pizza2 = new Pizza("4 Fromages", "Ogresse", 13.0, pizzaria);

        // Ajout des pizzas à la pizzaria
        pizzaria.ajouterPizza(pizza1);
        pizzaria.ajouterPizza(pizza2);

        // Création d'une commande
        Commande commande = new Commande(1, "29/04/2025", client, livreur);

        // Création de lignes de commande
        Ligne_Com ligne1 = new Ligne_Com(1, 2, pizza1); // 2 pizzas Margherita
        Ligne_Com ligne2 = new Ligne_Com(2, 1, pizza2); // 1 pizza 4 Fromages

        // Ajout des lignes à la commande
        commande.ajouterLigne(ligne1);
        commande.ajouterLigne(ligne2);

        // Ajout de la commande au client
        client.ajouterCommande(commande);

        // Affichage
        double total = commande.calculerPrixTotal();
        System.out.println("=== Résumé de la commande ===");
        System.out.println("Client : " + client.getNom());
        System.out.println("Adresse : " + client.getAdresse());
        System.out.println("Date de commande : " + commande.getDate_com());
        System.out.println("Pizzas commandées :");
        for (Ligne_Com ligne : commande.getList_ligne()) {
            System.out.println("- " + ligne.getQuantite() + " x " + ligne.getPizza().getNom() +
                    " (" + ligne.getPizza().getTaille() + ") - " +
                    ligne.getPizza().getPrixBase() + "€ l'unité");
        }
        System.out.println("Prix total : " + total + "€");

        // Paiement
        if (client.peutPayer(total)) {
            client.payer(total);
            System.out.println("✅ Paiement effectué !");
            System.out.println("Livraison assurée par : " + livreur.getMoyen_transport());
        } else {
            System.out.println("❌ Solde insuffisant pour payer !");
        }

        // Nouveau solde du client
        System.out.println("Solde restant du client : " + client.getSold() + "€");
    }
}
