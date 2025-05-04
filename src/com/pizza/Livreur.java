package com.pizza;

public class Livreur {
    private int idLivreur;
    private String moyenTransport; // Ex: "Scooter", "Voiture", etc.

    // Constructeur
    public Livreur(int idLivreur, String moyenTransport) {
        this.idLivreur = idLivreur;
        this.moyenTransport = moyenTransport;
    }

    // Getters
    public int getIdLivreur() {
        return idLivreur;
    }

    public String getMoyenTransport() {
        return moyenTransport;
    }

    // Setters
    public void setIdLivreur(int idLivreur) {
        this.idLivreur = idLivreur;
    }

    public void setMoyenTransport(String moyenTransport) {
        this.moyenTransport = moyenTransport;
    }
}
