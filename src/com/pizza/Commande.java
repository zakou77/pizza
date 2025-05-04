package com.pizza;

import java.util.Vector;

public class Commande {
    private int numCommande;
    private String dateCommande;
    private Client client;
    private Livreur livreur;

    private Vector<LigneCommande> lignesCommande = new Vector<>();

    // Constructeur
    public Commande(int numCommande, String dateCommande, Client client, Livreur livreur) {
        this.numCommande = numCommande;
        this.dateCommande = dateCommande;
        this.client = client;
        this.livreur = livreur;
    }

    // Getters
    public int getNumCommande() {
        return numCommande;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public Client getClient() {
        return client;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public Vector<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }

    // Setters
    public void setNumCommande(int numCommande) {
        this.numCommande = numCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public void setLignesCommande(Vector<LigneCommande> lignesCommande) {
        this.lignesCommande = lignesCommande;
    }

    // Ajouter une ligne
    public void ajouterLigne(LigneCommande ligne) {
        lignesCommande.add(ligne);
    }

    // Calculer le prix total de la commande
    public double calculerPrixTotal() {
        double total = 0;
        for (LigneCommande ligne : lignesCommande) {
            total += ligne.getQuantite() * ligne.getPizza().getPrixBase();
        }
        return total;
    }
}
