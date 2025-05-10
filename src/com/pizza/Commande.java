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

    public void retirerDerniereLigne() {
        if (!lignes.isEmpty()) {
            lignes.remove(lignes.size() - 1);
        }
    }

    public int getNombreTotalPayant() {
        int total = 0;
        for (LigneCommande ligne : lignes) {
            if (ligne.getPrixLigne() > 0) {
                total += ligne.getQuantite();
            }
        }
        return total;
    }

    public void setLivreur(Livreur l) {
        this.livreur = l;
    }

    public double calculerPrixTotal() {
        double total = 0;
        for (LigneCommande ligne : lignes) {
            total += ligne.getPrixLigne();
        }
        return total;
    }

    public LigneCommande[] getLignes() {
        return lignes.toArray(new LigneCommande[0]);
    }
}
