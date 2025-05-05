package com.pizza;

import java.util.ArrayList;

public class Commande {
    private int numCommande;
    private String dateCommande;
    private Client client;
    private Livreur livreur;
    private ArrayList<LigneCommande> lignes = new ArrayList<>();

    public Commande(int num, String date, Client c) {
        this.numCommande = num;
        this.dateCommande = date;
        this.client = c;
    }

    public int getNumCommande() {
        return numCommande;
    }

    public void ajouterLigne(LigneCommande ligne) {
        lignes.add(ligne);
    }

    public void setLivreur(Livreur l) {
        this.livreur = l;
    }

    public double calculerPrixTotal() {
        double total = 0;
        for (LigneCommande ligne : lignes) {
            total += ligne.getQuantite() * ligne.getPizza().getPrixBase();
        }
        return total;
    }
}
