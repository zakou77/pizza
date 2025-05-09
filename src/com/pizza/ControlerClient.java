package com.pizza;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ControlerClient {

    private final VueClient vue;
    private final Client client;
    private final Point_Pizzaria pizzaria;
    private final Livreur livreur;
    private final ArrayList<Commande> historiqueCommandes = new ArrayList<>(); // ✅ Historique local

    public ControlerClient(VueClient vue, Client client, Point_Pizzaria pizzaria, Livreur livreur) {
        this.vue = vue;
        this.client = client;
        this.pizzaria = pizzaria;
        this.livreur = livreur;

        vue.setVoirSoldeListener(e -> afficherSolde());
        vue.setAjouterSoldeListener(e -> ajouterSolde());
        vue.setCommanderListener(e -> lancerCommande());
        vue.setHistoriqueListener(e -> afficherHistorique()); // ✅ Ajouté
    }

    private void afficherSolde() {
        double solde = client.getSolde();
        JOptionPane.showMessageDialog(vue, "💰 Solde actuel : " + solde + "€", "Solde du client", JOptionPane.INFORMATION_MESSAGE);
    }

    private void ajouterSolde() {
        String input = JOptionPane.showInputDialog(vue, "Montant à ajouter (€):", "Ajouter solde", JOptionPane.PLAIN_MESSAGE);
        try {
            double montant = Double.parseDouble(input);
            if (montant > 0) {
                client.crediter(montant);
                JOptionPane.showMessageDialog(vue, montant + "€ ajoutés avec succès !", "Ajout confirmé", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vue, "Le montant doit être positif.", "Erreur", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vue, "Entrée non valide. Veuillez saisir un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void lancerCommande() {
        vue.dispose();
        VuePizzaSwing vuePizza = new VuePizzaSwing();
        new ControllerPizzaSwing(vuePizza, pizzaria, client, livreur, historiqueCommandes); // ✅ Partage historique
    }

    private void afficherHistorique() {
        JFrame frame = new JFrame("Historique des commandes");
        JTextArea area = new JTextArea(20, 50);
        area.setEditable(false);

        if (historiqueCommandes.isEmpty()) {
            area.setText("Aucune commande passée.");
        } else {
            for (Commande cmd : historiqueCommandes) {
                area.append("Commande #" + cmd.getNumCommande() + "\n");
                for (LigneCommande ligne : cmd.getLignes()) {
                    area.append("- " + ligne.getQuantite() + " x " + ligne.getPizza().getNom() +
                            " (" + ligne.getPizza().getTaille() + ") = " +
                            (ligne.getQuantite() * ligne.getPizza().getPrixBase()) + "€\n");
                }
                area.append("Total : " + cmd.calculerPrixTotal() + "€\n\n");
            }
        }

        frame.add(new JScrollPane(area));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
