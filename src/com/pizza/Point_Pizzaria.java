package com.pizza;

import java.util.Vector;

public class Point_Pizzaria {
    public int id_Pizzaria;
    public String adresse;

    Vector<Pizza> listPizza = new Vector<Pizza>();

    // Constructeur
    public Point_Pizzaria(int id, String adresse) {
        this.id_Pizzaria = id;
        this.adresse = adresse;
    }

    // Getters
    public int getId_Pizzaria() {
        return id_Pizzaria;
    }

    public String getAdresse() {
        return adresse;
    }

    public Vector<Pizza> getListPizza() {
        return listPizza;
    }

    // Setters
    public void setId_Pizzaria(int id_Pizzaria) {
        this.id_Pizzaria = id_Pizzaria;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setListPizza(Vector<Pizza> listPizza) {
        this.listPizza = listPizza;
    }

    // Ajouter une pizza
    public void ajouterPizza(Pizza pizza) {
        listPizza.add(pizza);
    }
}
