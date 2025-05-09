package com.pizza;

public class Main {
    public static void main(String[] args) {
        // Création du point de vente
        Point_Pizzaria pizzaria = new Point_Pizzaria("123 Rue de la Pizza");

        pizzaria.ajouterPizza(new Pizza("Margherita", "NAINE", 7.5));
        pizzaria.ajouterPizza(new Pizza("Reine", "HUMAINE", 10.0));
        pizzaria.ajouterPizza(new Pizza("4 Fromages", "OGRESSE", 12.0));
        pizzaria.ajouterPizza(new Pizza("Pepperoni", "HUMAINE", 9.5));


        // Ajout d'un livreur fictif pour la démonstration
        Livreur livreur = new Livreur(1, "Mario", "a", 00);
        Client Client = new Client(12, "djdi", "3", 100, 1);
        // Optionnel : ajout d'exemples de pizzas
        pizzaria.ajouterPizza(new Pizza("Margherita", "Moyenne", 8.50));
        pizzaria.ajouterPizza(new Pizza("Pepperoni", "Grande", 10.50));

        // Création de la vue de connexion
        VueConnexion vueConnexion = new VueConnexion();


        // Lancement du contrôleur de connexion
        new ControleurConnexion(vueConnexion, pizzaria, livreur);


    }
}
