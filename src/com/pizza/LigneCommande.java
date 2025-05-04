package com.pizza;

public class LigneCommande {
    public int id_com;
    public int quantite;

    private Pizza pizza;

    public LigneCommande(int id, int quantite, Pizza pizza) {
        this.id_com = id;
        this.quantite = quantite;
        this.pizza = pizza;
    }

    public int getId_com() {
        return id_com;
    }

    public int getQuantite() {
        return quantite;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }
}
