package com.pizza;

import java.util.Vector;

public class Pizza {
    public String nom;
    public String taille;
    public double prixBase;

    private Vector<LigneCommande> listLigne = new Vector<>();
    private Vector<Ingredient> listIng = new Vector<>();
    private Point_Pizzaria pizzaria;

    // Constructeurs
    public Pizza(String nomPizza, String taille, double prix) {
        this.nom = nomPizza;
        this.taille = taille;
        this.prixBase = prix;
    }

    public Pizza(String nomPizza, String taille, double prix, Point_Pizzaria pz) {
        this.nom = nomPizza;
        this.taille = taille;
        this.prixBase = prix;
        this.pizzaria = pz;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getTaille() {
        return taille;
    }

    public double getPrixBase() {
        return prixBase;
    }

    public Vector<LigneCommande> getListLigne() {
        return listLigne;
    }

    public Vector<Ingredient> getListIng() {
        return listIng;
    }

    public Point_Pizzaria getPizzaria() {
        return pizzaria;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public void setPrixBase(double prix) {
        this.prixBase = prix;
    }

    public void setListLigne(Vector<LigneCommande> listLigne) {
        this.listLigne = listLigne;
    }

    public void setListIng(Vector<Ingredient> listIng) {
        this.listIng = listIng;
    }

    public void setPizzaria(Point_Pizzaria pz) {
        this.pizzaria = pz;
    }
}
