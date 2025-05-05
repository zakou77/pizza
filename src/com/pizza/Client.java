package com.pizza;

import java.util.Vector;

public class Client {
    private int id_Client;
    private String nom;
    private String adresse;
    private double solde;
    private String telephone; // Ajout pour la connexion

    private Vector<Commande> listCommandes = new Vector<>();

    // Constructeur
    public Client(int id_Client, String nom, String adresse, double solde) {
        this.id_Client = id_Client;
        this.nom = nom;
        this.adresse = adresse;
        this.solde = solde;
    }

    // Getters
    public int getId_Client() {
        return id_Client;
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

    public String getTelephone() {
        return telephone;
    }

    public Vector<Commande> getListCommandes() {
        return listCommandes;
    }

    // Setters
    public void setId_Client(int id_Client) {
        this.id_Client = id_Client;
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

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void ajouterCommande(Commande com) {
        listCommandes.add(com);
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
