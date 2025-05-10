package com.pizza;

import java.util.ArrayList;
import java.util.List;

public class Point_Pizzaria {

    private String adresse;
    private List<Pizza> menu;
    private List<Livreur> livreurs;
    private List<Client> clients;

    public Point_Pizzaria(String adresse) {
        this.adresse = adresse;
        this.menu = new ArrayList<>();
        this.livreurs = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public String getAdresse() {
        return adresse;
    }

    public List<Pizza> getMenu() {
        return menu;
    }

    public List<Livreur> getLivreurs() {
        return livreurs;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void ajouterPizza(Pizza pizza) {
        menu.add(pizza);
    }

    public void ajouterLivreur(Livreur livreur) {
        livreurs.add(livreur);
    }

    public void ajouterClient(Client client) {
        clients.add(client);
    }

    public Pizza getPizza(String nom) {
        return menu.stream()
                .filter(p -> p.getNom().equalsIgnoreCase(nom))
                .findFirst()
                .orElse(null);
    }
}
