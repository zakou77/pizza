package com.pizza;

public class LigneCommande {

    private int numCommande;
    private int quantite;
    private Pizza pizza;
    private String taille;

    public LigneCommande(int numCommande, int quantite, Pizza pizza, String taille) {
        this.numCommande = numCommande;
        this.quantite = quantite;
        this.pizza = pizza;
        this.taille = taille;
    }

    public int getNumCommande() {
        return numCommande;
    }

    public int getQuantite() {
        return quantite;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public double getPrixLigne() {
        double coef = switch (taille) {
            case "NAINE" -> 0.8;
            case "OGRESSE" -> 1.2;
            default -> 1.0;
        };
        return quantite * pizza.getPrixBase() * coef;
    }
}
