package com.pizza;

import java.util.Vector;

public class Client {
    public int id_Client;
    public String nom;
    public String adresse;
    public double solde;

    private Vector<Commande> listC = new Vector<>();

    public Client(int id, String nom, String adresse, double solde) {
        this.id_Client = id;
        this.nom = nom;
        this.adresse = adresse;
        this.solde = solde;
    }

    public void ajouterCommande(Commande commande) {
        listC.add(commande);
    }

    public boolean peutPayer(double montant) {
        return solde >= montant;
    }

    public void payer(double montant) {
        solde -= montant;
    }

    public double getSolde() {
        return solde;
    }
}
