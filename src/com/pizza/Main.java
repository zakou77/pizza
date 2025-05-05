package com.pizza;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Création des clients fictifs avec numéro de téléphone
        Client client1 = new Client(1, "Zak", "5 rue des Tulipes", 100);
        client1.setTelephone("0601020304"); // Méthode à ajouter dans Client si elle n’existe pas

        Client client2 = new Client(2, "Lina", "10 avenue des Lilas", 80);
        client2.setTelephone("0604050607");

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        // Lancement de la fenêtre de connexion
        new InterfaceConnexion(clients);
    }
}
