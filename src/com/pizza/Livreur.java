package com.pizza;

public class Livreur {
    public int id_liv;
    public String nom_L;
    public String type_Vec;
    private Point_Pizzaria pizzaria;

    public Livreur(int id, String nom, String type) {
        id_liv = id;
        nom_L = nom;
        type_Vec = type;
    }

    public int getId_liv() {
        return id_liv;
    }

    public String getNom_L() {
        return nom_L;
    }

    public String getType_Vec() {
        return type_Vec;
    }

    public Point_Pizzaria getPizzaria() {
        return pizzaria;
    }

    public void setPizzaria(Point_Pizzaria pz) {
        pizzaria = pz;
    }
}
