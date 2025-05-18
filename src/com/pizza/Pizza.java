package com.pizza;

import java.util.Vector;

public class Pizza {
    private String nom;
    private double prixBase;

    private Vector<LigneCommande> listLigne = new Vector<>();
    private Vector<Ingredient> listIng = new Vector<>();
    private Point_Pizzeria pizzaria;

    // Constructeurs
    public Pizza(String nomPizza, double prix) {
        this.nom = nomPizza;
        this.prixBase = prix;
    }

    public Pizza(String nomPizza, double prix, Point_Pizzeria pz) {
        this.nom = nomPizza;
        this.prixBase = prix;
        this.pizzaria = pz;
    }

    // Getters
    public String getNom() {
        return nom;
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

    public Point_Pizzeria getPizzaria() {
        return pizzaria;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
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

    public void setPizzaria(Point_Pizzeria pz) {
        this.pizzaria = pz;
    }
}
