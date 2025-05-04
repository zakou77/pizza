package com.pizza;

import java.util.Vector;

public class Client {
    public int id_Client;
    public String Nom;
    public String Adresse;
    public double sold;

    Vector<Commande> listCommande = new Vector<Commande>();

    // Constructeur
    public Client(int id, String nom, String adresse, double solde) {
        this.id_Client = id;
        this.Nom = nom;
        this.Adresse = adresse;
        this.sold = solde;
    }

    // Getters
    public int getId_Client() {
        return id_Client;
    }

    public String getNom() {
        return Nom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public double getSold() {
        return sold;
    }

    public Vector<Commande> getListCommande() {
        return listCommande;
    }

    // Setters
    public void setId_Client(int id) {
        this.id_Client = id;
    }

    public void setNom(String nom) {
        this.Nom = nom;
    }

    public void setAdresse(String adresse) {
        this.Adresse = adresse;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public void setListCommande(Vector<Commande> commandes) {
        this.listCommande = commandes;
    }

    // Méthodes utiles
    public void ajouterCommande(Commande c) {
        listCommande.add(c);
    }

    public boolean peutPayer(double montant) {
        return sold >= montant;
    }

    public void payer(double montant) {
        if (peutPayer(montant)) {
            sold -= montant;
        }
    }
}
