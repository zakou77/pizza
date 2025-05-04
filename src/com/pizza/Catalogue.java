package com.pizza;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private List<Pizza> listePizzas;

    public Catalogue() {
        this.listePizzas = new ArrayList<>();
    }

    public void ajouterPizza(Pizza pizza) {
        listePizzas.add(pizza);
    }

    public Pizza trouverPizza(String nom) {
        for (Pizza p : listePizzas) {
            if (p.getNom().equalsIgnoreCase(nom)) {
                return p;
            }
        }
        return null;
    }

    public List<Pizza> getListePizzas() {
        return listePizzas;
    }
}
