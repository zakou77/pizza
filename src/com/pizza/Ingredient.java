package com.pizza;

public class Ingredient {
    public int id_ing;
    public String nom;
    public double prix;

    // Constructeur
    public Ingredient(int id, String nom, double prix) {
        this.id_ing = id;
        this.nom = nom;
        this.prix = prix;
    }

    // Getters
    public int getId_ing() {
        return id_ing;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    // Setters
    public void setId_ing(int id_ing) {
        this.id_ing = id_ing;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
