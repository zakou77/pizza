package com.pizza;

import java.util.ArrayList;
import java.util.List;

public class Point_Pizzaria {
    private String adresse;
    private List<Pizza> menu;
    private List<Livreur> livreurs;

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
}
