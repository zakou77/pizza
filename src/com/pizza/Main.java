package com.pizza;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Point_Pizzaria pizzaria = new Point_Pizzaria("123 Rue de la Pizza");

        pizzaria.ajouterPizza(new Pizza("Margherita", "NAINE", 7.5));
        pizzaria.ajouterPizza(new Pizza("Reine", "HUMAINE", 10.0));
        pizzaria.ajouterPizza(new Pizza("4 Fromages", "OGRESSE", 12.0));
        pizzaria.ajouterPizza(new Pizza("Pepperoni", "HUMAINE", 9.5));

        Livreur livreur = new Livreur(1, "Mario", "Scooter", 0);

        // ✅ Liste partagée entre toutes les vues
        List<Commande> historiqueCommandes = new ArrayList<>();

        VueConnexion vueConnexion = new VueConnexion();
        new ControleurConnexion(vueConnexion, pizzaria, livreur, historiqueCommandes);
    }
}
