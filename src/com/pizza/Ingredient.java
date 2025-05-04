package com.pizza;

public class Ingredient {
    private int idIngredient;
    private String nom;
    private double prix;

    // Constructeur
    public Ingredient(int idIngredient, String nom, double prix) {
        this.idIngredient = idIngredient;
        this.nom = nom;
        this.prix = prix;
    }

    // Getters
    public int getIdIngredient() {
        return idIngredient;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    // Setters
    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
