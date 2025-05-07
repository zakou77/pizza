package com.pizza;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurConnexion {

    private VueConnexion vue;
    private Point_Pizzaria pizzaria;
    private Livreur livreur;

    public ControleurConnexion(VueConnexion vue, Point_Pizzaria pizzaria, Livreur livreur) {
        this.vue = vue;
        this.pizzaria = pizzaria;
        this.livreur = livreur;

        vue.setConnexionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connecterClient();
            }
        });
    }

    private void connecterClient() {
        String input = vue.getNumeroSaisi().trim();

        if (input.isEmpty()) {
            vue.afficherMessage("❗ Veuillez entrer un numéro de téléphone.");
            return;
        }

        int numero;
        try {
            numero = Integer.parseInt(input);
            if (numero <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            vue.afficherMessage("❌ Numéro invalide. Veuillez entrer uniquement des chiffres positifs.");
            return;
        }

        Client client = pizzaria.connecterClient(numero);
        vue.afficherMessage("✅ Connexion réussie. Bienvenue, " + client.getNom() + " (ID : " + client.getId_Client() + ")");

        vue.dispose();

        VueClient vueClient = new VueClient();
        new ControlerClient(vueClient, client, pizzaria, livreur);
    }
}
