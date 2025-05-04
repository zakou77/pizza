package com.pizza;

import java.util.Vector;

public class Pizza {
    private String nom;
    private String taille;
    private double prixBase;

    private Vector<LigneCommande> listLigne = new Vector<>();
    private Vector<Ingredient> listIng = new Vector<>();
    private PointPizzaria pizzaria;

    // Constructeur simple
    public Pizza(String nom, String taille, double prixBase) {
        this.nom = nom;
        this.taille = taille;
        this.prixBase = prixBase;
    }

    // Constructeur complet avec point de vente
    public Pizza(String nom, String taille, double prixBase, PointPizzaria pizzaria) {
        this.nom = nom;
        this.taille = taille;
        this.prixBase = prixBase;
        this.pizzaria = pizzaria;
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

    public PointPizzaria getPizzaria() {
        return pizzaria;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public void setPrixBase(double prixBase) {
        this.prixBase = prixBase;
    }

    public void setListLigne(Vector<LigneCommande> listLigne) {
        this.listLigne = listLigne;
    }

    public void setListIng(Vector<Ingredient> listIng) {
        this.listIng = listIng;
    }

    public void setPizzaria(PointPizzaria pizzaria) {
        this.pizzaria = pizzaria;
    }
}
