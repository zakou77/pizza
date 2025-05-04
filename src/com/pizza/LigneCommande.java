package com.pizza;

public class Ligne_Com {
    public int id_com;
    public int quantite;

    private Pizza pizza; // référence vers la pizza commandée

    // Constructeur
    public Ligne_Com(int id, int quantite, Pizza pizza) {
        this.id_com = id;
        this.quantite = quantite;
        this.pizza = pizza;
    }

    // Getters
    public int getId_com() {
        return id_com;
    }

    public int getQuantite() {
        return quantite;
    }

    public Pizza getPizza() {
        return pizza;
    }

    // Setters
    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    // Méthode utile : prix total de cette ligne
    public double getPrixTotal() {
        return pizza.getPrixBase() * quantite;
    }
}
