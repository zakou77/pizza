package com.pizza;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Création du point de vente
        Point_Pizzaria pizzeria = new Point_Pizzaria(1, "12 rue des Oliviers", "PizzaHouse");

        // Création des ingrédients
        Ingredient ing1 = new Ingredient("Tomate", 2);
        Ingredient ing2 = new Ingredient("Mozzarella", 2);

        // Création de la pizza
        Pizza pizza = new Pizza("Margherita", "HUMAINE", 10.0);
        pizza.setPizzaria(pizzeria);
        pizza.getListIng().add(ing1);
        pizza.getListIng().add(ing2);

        // Ajout de la pizza à la pizzeria
        pizzeria.getMenu().add(pizza);

        // Création du client
        Client client = new Client(1, "Zak", "5 rue des Tulipes", 100);

        // Création du livreur
        Livreur livreur = new Livreur(1, "Karim", "Scooter");
        livreur.setPizzaria(pizzeria);

        // Création de la commande
        Commande commande = new Commande(1, "2025-05-04", client);
        Ligne_Commande ligne = new Ligne_Commande(1, 2, pizza);
        commande.ajouterLigne(ligne);

        // Affichage
        System.out.println("Commande n°" + commande.getNum_com() + " passée par " + client.getNom());
        for (Ligne_Commande l : commande.getListLigne()) {
            System.out.println("- " + l.getQuantite() + " x " + l.getPizza().getNom());
        }
    }
}
