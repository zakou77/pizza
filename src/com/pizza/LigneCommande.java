package com.pizza;

public class LigneCommande {
    private int idCommande;
    private int quantite;
    private Pizza pizza;

    // Constructeur
    public LigneCommande(int idCommande, int quantite, Pizza pizza) {
        this.idCommande = idCommande;
        this.quantite = quantite;
        this.pizza = pizza;
    }

    // Getters
    public int getIdCommande() {
        return idCommande;
    }

    public int getQuantite() {
        return quantite;
    }

    public Pizza getPizza() {
        return pizza;
    }

    // Setters
    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    // Méthode pour calculer le prix total de la ligne
    public double getPrixTotal() {
        return pizza.getPrixBase() * quantite;
    }
}
