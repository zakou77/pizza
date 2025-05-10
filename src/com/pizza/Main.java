package com.pizza;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Point_Pizzaria pizzaria = new Point_Pizzaria("123 Rue de la Pizza");

        pizzaria.ajouterPizza(new Pizza("Margherita", 7.5));
        pizzaria.ajouterPizza(new Pizza("Reine",  10.0));
        pizzaria.ajouterPizza(new Pizza("4 Fromages", 12.0));
        pizzaria.ajouterPizza(new Pizza("Pepperoni", 9.5));

        Livreur livreur = new Livreur(1, "Mario", "Scooter", 0);

        List<Commande> historiqueCommandes = new ArrayList<>();

        // ✅ Profils simulés avec tableaux [prenom, nom, numero]
        List<String[]> profils = new ArrayList<>();
        profils.add(new String[]{"Jean", "Dupont", "0612345678"});
        profils.add(new String[]{"KARIM", "benzema", "0711121314"});
        profils.add(new String[]{"Jacques", "Martin", "0698765432"});

        VueConnexion vueConnexion = new VueConnexion();
        new ControleurConnexion(vueConnexion, pizzaria, livreur, historiqueCommandes, profils);
    }
}


