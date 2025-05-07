package com.pizza;

import java.util.ArrayList;
import java.util.Collections;
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
        return Collections.unmodifiableList(menu);
    }

    public List<Livreur> getLivreurs() {
        return Collections.unmodifiableList(livreurs);
    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
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

    public Pizza getPizza(String nom, String taille) {
        return menu.stream()
                .filter(p -> p.getNom().equals(nom) && p.getTaille().equals(taille))
                .findFirst()
                .orElse(null);
    }

    public Client connecterClient(int numeroTelephone) {
        for (Client c : clients) {
            if (c.getTelephone() == numeroTelephone) {
                return c;
            }
        }
        Client nouveauClient = new Client(
                clients.size() + 1,
                "Client" + numeroTelephone,
                "Adresse inconnue",
                50.0,
                numeroTelephone
        );
        clients.add(nouveauClient);
        return nouveauClient;
    }
}
