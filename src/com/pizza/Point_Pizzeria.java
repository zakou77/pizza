package com.pizza;

import java.util.Vector;

public class Point_Pizzeria {

    private String adresse;
    private Vector<Pizza> menu = new Vector<>();;
    private Vector<Livreur> livreurs = new Vector<>();;
    private Vector<Client> clients = new Vector<>();;

    public Point_Pizzeria(String adresse) {
        this.adresse = adresse;
    }

    // Getters
    public String getAdresse() {
        return adresse;
    }

    public Vector<Pizza> getMenu() {
        return menu;
    }

    public Vector<Livreur> getLivreurs() {
        return livreurs;
    }

    public Vector<Client> getClients() {
        return clients;
    }

    public void ajouterPizza(Pizza pizza) {
        menu.add(pizza);
    }

    public void ajouterLivreur(Livreur livreur) {
        livreurs.add(livreur);
    }

    public void ajouterClient(Client client) {
        clients.add(client);
    }

    public Pizza getPizza(String nom) {
        for (Pizza p : menu) {
            if (p.getNom().equalsIgnoreCase(nom)) {
                return p;
            }
        }
        return null;
    }
}
