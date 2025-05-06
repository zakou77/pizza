package com.pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Point_Pizzaria {
    private String adresse;
    private List<Pizza> menu = new Vector<Pizza>();
    private List<Livreur> livreurs = new Vector<Livreur>();

    private Vector<Client> listCl = new Vector<Client>();

    public Point_Pizzaria(String adresse) {
        this.adresse = adresse;
        this.menu = new ArrayList<>();
        this.livreurs = new ArrayList<>();
    }

    public String getAdresse() {
        return adresse;
    }

    public List<Pizza> getMenu() {
        return menu;
    }

    public void ajouterPizza(Pizza pizza) {
        menu.add(pizza);
    }

    public void ajouterLivreur(Livreur livreur) {
        livreurs.add(livreur);
    }

    public List<Livreur> getLivreurs() {
        return livreurs;
    }

    public Pizza getPizza(String nom, String taille) {
        return menu.stream()
                .filter(p -> p.getNom().equals(nom) && p.getTaille().equals(taille))
                .findFirst()
                .orElse(null);
    }

}
