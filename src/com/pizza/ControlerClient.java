package com.pizza;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlerClient {

    private final VueClient vue;
    private final Client client;
    private final Point_Pizzaria pizzaria;
    private final Livreur livreur;

    public ControlerClient(VueClient vue, Client client, Point_Pizzaria pizzaria, Livreur livreur) {
        this.vue = vue;
        this.client = client;
        this.pizzaria = pizzaria;
        this.livreur = livreur;

        vue.setVoirSoldeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherSolde();
            }
        });

        vue.setAjouterSoldeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterSolde();
            }
        });

        vue.setCommanderListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lancerVueClient();
            }
        });
    }

    private void afficherSolde() {
        double solde = client.getSolde();
        javax.swing.JOptionPane.showMessageDialog(vue, "💰 Solde actuel : " + solde + "€", "Solde du client", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    private void ajouterSolde() {
        String input = javax.swing.JOptionPane.showInputDialog(vue, "Montant à ajouter (€):", "Ajouter solde", javax.swing.JOptionPane.PLAIN_MESSAGE);
        try {
            double montant = Double.parseDouble(input);
            if (montant > 0) {
                client.crediter(montant);
                javax.swing.JOptionPane.showMessageDialog(vue, montant + "€ ajoutés avec succès !", "Ajout confirmé", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                javax.swing.JOptionPane.showMessageDialog(vue, "Le montant doit être positif.", "Erreur", javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(vue, "Entrée non valide. Veuillez saisir un nombre.", "Erreur", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void lancerVueClient() {
        vue.dispose();
        new VuePizzaSwing();
    }
}
