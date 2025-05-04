package com.pizza;

import java.util.Vector;

public class PointPizzaria {
    private int idPizzaria;
    private String adresse;
    private Vector<Pizza> listePizzas = new Vector<>();

    // Constructeur
    public PointPizzaria(int idPizzaria, String adresse) {
        this.idPizzaria = idPizzaria;
        this.adresse = adresse;
    }

    // Getters
    public int getIdPizzaria() {
        return idPizzaria;
    }

    public String getAdresse() {
        return adresse;
    }

    public Vector<Pizza> getListePizzas() {
        return listePizzas;
    }

    // Setters
    public void setIdPizzaria(int idPizzaria) {
        this.idPizzaria = idPizzaria;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setListePizzas(Vector<Pizza> listePizzas) {
        this.listePizzas = listePizzas;
    }

    // Méthode pour ajouter une pizza
    public void ajouterPizza(Pizza pizza) {
        listePizzas.add(pizza);
    }
}
