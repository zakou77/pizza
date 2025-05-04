package com.pizza;

public class Livreur {
    public int id_livreur;
    public String moyen_transport; // exemple: "Scooter", "Voiture", "Vélo"

    // Constructeur
    public Livreur(int id, String moyen) {
        this.id_livreur = id;
        this.moyen_transport = moyen;
    }

    // Getters
    public int getId_livreur() {
        return id_livreur;
    }

    public String getMoyen_transport() {
        return moyen_transport;
    }

    // Setters
    public void setId_livreur(int id_livreur) {
        this.id_livreur = id_livreur;
    }

    public void setMoyen_transport(String moyen_transport) {
        this.moyen_transport = moyen_transport;
    }
}
