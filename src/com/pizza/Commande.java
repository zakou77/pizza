package com.pizza;

import java.util.Vector;

public class Commande {
    public int num_com;
    public String date_com;

    private Client client;
    private Livreur livreur;

    Vector<Ligne_Com> list_ligne = new Vector<Ligne_Com>();

    // Constructeur
    public Commande(int num, String date, Client client, Livreur livreur) {
        this.num_com = num;
        this.date_com = date;
        this.client = client;
        this.livreur = livreur;
    }

    // Getters
    public int getNum_com() {
        return num_com;
    }

    public String getDate_com() {
        return date_com;
    }

    public Client getClient() {
        return client;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public Vector<Ligne_Com> getList_ligne() {
        return list_ligne;
    }

    // Setters
    public void setNum_com(int num_com) {
        this.num_com = num_com;
    }

    public void setDate_com(String date_com) {
        this.date_com = date_com;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public void setList_ligne(Vector<Ligne_Com> lignes) {
        this.list_ligne = lignes;
    }

    // Ajout d'une ligne à la commande
    public void ajouterLigne(Ligne_Com ligne) {
        list_ligne.add(ligne);
    }

    // Calcul total
    public double calculerPrixTotal() {
        double total = 0;
        for (Ligne_Com ligne : list_ligne) {
            total += ligne.getPrixTotal();
        }
        return total;
    }
}
