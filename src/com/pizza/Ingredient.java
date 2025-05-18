package com.pizza;

public class Ingredient {
    public String nom;
    public int quantite;
    Pizza pizza;


    public Ingredient(String nom, int quantite, Pizza pizza) {
        this.pizza = pizza;
        this.nom = nom;
        this.quantite = quantite;
    }
    // Getters
    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }
    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
