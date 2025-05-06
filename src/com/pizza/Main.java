package com.pizza;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialisation du modèle
        Point_Pizzaria pizzaria = new Point_Pizzaria("Paris");
        initialiserMenuPizzas(pizzaria);

        Client client = new Client(1, "Zak", "Paris", 50);
        Livreur livreur = new Livreur(1, "Karim", "Scooter");
        List<Commande> historiqueCommandes = new ArrayList<>();

        // Initialisation de la vue
        VuePizzaSwing vue = new VuePizzaSwing();

        // Lancement du contrôleur
        new ControllerPizzaSwing(vue, pizzaria, client, livreur, historiqueCommandes);
    }

    private static void initialiserMenuPizzas(Point_Pizzaria pizzaria) {
        pizzaria.ajouterPizza(new Pizza("Margherita", "NAINE", 5.0));
        pizzaria.ajouterPizza(new Pizza("Margherita", "HUMAINE", 7.0));
        pizzaria.ajouterPizza(new Pizza("Margherita", "OGRESSE", 9.0));
        pizzaria.ajouterPizza(new Pizza("Pepperoni", "NAINE", 6.0));
        pizzaria.ajouterPizza(new Pizza("Pepperoni", "HUMAINE", 8.0));
        pizzaria.ajouterPizza(new Pizza("Pepperoni", "OGRESSE", 10.0));
    }
}
