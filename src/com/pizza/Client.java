package com.pizza;

import java.util.Vector;

public class Client {
    private int id_Client;
    private String nom;
    private String adresse;
    private double solde;
    private int telephone;

    private Vector<Commande> listC = new Vector<>();

    public Client(int id, String nom, String adresse, double solde, int telephone) {
        this.id_Client = id;
        this.nom = nom;
        this.adresse = adresse;
        this.solde = solde;
        this.telephone = telephone;
    }

    public void ajouterCommande(Commande commande) {
        listC.add(commande);
    }

    public boolean peutPayer(double montant) {
        return solde >= montant;
    }

    public void payer(double montant) {
        if (peutPayer(montant)) {
            solde -= montant;
        }
    }

    public void crediter(double montant) {
        if (montant > 0) {
            solde += montant;
        }
    }

    public double getSolde() {
        return solde;
    }

    public int getTelephone() {
        return telephone;
    }

    public int getId_Client() {
        return id_Client;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public Vector<Commande> getListeCommandes() {
        return listC;
    }
}
