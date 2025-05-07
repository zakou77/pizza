package com.pizza;

public class Main {
    public static void main(String[] args) {
        // Initialisation du modèle
        Point_Pizzaria pizzaria = new Point_Pizzaria("Paris");
        initialiserMenuPizzas(pizzaria);

        Client client = new Client(1, "Zak", "Paris", 50.0, 123456789);
        Livreur livreur = new Livreur(1, "Karim", "Scooter");

        // Initialisation de la vue améliorée
        VueClient vueAmelioree = new VueClient();

        // Contrôleur associé
        new ControlerClient(vueAmelioree, client, pizzaria, livreur);
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
