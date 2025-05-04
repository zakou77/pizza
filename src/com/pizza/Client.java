package com.pizza;

import java.util.Vector;

public class Client {
    private int idClient;
    private String nom;
    private String adresse;
    private double solde;

    private Vector<Commande> listCommande = new Vector<>();

    // Constructeur
    public Client(int idClient, String nom, String adresse, double solde) {
        this.idClient = idClient;
        this.nom = nom;
        this.adresse = adresse;
        this.solde = solde;
    }

    // Getters
    public int getIdClient() {
        return idClient;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public double getSolde() {
        return solde;
    }

    public Vector<Commande> getListCommande() {
        return listCommande;
    }

    // Setters
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setListCommande(Vector<Commande> listCommande) {
        this.listCommande = listCommande;
    }

    // Méthodes
    public void ajouterCommande(Commande commande) {
        listCommande.add(commande);
    }

    public boolean peutPayer(double montant) {
        return solde >= montant;
    }

    public void payer(double montant) {
        if (peutPayer(montant)) {
            solde -= montant;
        }
    }
}
