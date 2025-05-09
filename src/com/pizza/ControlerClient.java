package com.pizza;

import javax.swing.*;
import java.util.List;

public class ControlerClient {

    private final VueClient vue;
    private final Client client;
    private final Point_Pizzaria pizzaria;
    private final Livreur livreur;
    private final List<Commande> historiqueCommandes;
    private final List<String[]> profils; // ✅ ajout de l’attribut profils

    public ControlerClient(VueClient vue, Client client, Point_Pizzaria pizzaria, Livreur livreur, List<Commande> historiqueCommandes, List<String[]> profils) {
        this.vue = vue;
        this.client = client;
        this.pizzaria = pizzaria;
        this.livreur = livreur;
        this.historiqueCommandes = historiqueCommandes;
        this.profils = profils; // ✅ enregistrement de la liste

        vue.setVoirSoldeListener(e -> afficherSolde());
        vue.setAjouterSoldeListener(e -> ajouterSolde());
        vue.setCommanderListener(e -> lancerCommande());
        vue.setHistoriqueListener(e -> afficherHistorique());
        vue.setRetourListener(e -> retourConnexion()); // ✅ si bouton retour utilisé
    }

    private void afficherSolde() {
        JOptionPane.showMessageDialog(vue, "💰 Solde actuel : " + client.getSolde() + "€", "Solde du client", JOptionPane.INFORMATION_MESSAGE);
    }

    private void ajouterSolde() {
        String input = JOptionPane.showInputDialog(vue, "Montant à ajouter (€):");
        try {
            double montant = Double.parseDouble(input);
            if (montant > 0) {
                client.crediter(montant);
                JOptionPane.showMessageDialog(vue, montant + "€ ajoutés avec succès !");
            } else {
                JOptionPane.showMessageDialog(vue, "Le montant doit être positif.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vue, "Entrée non valide.");
        }
    }

    private void lancerCommande() {
        vue.dispose();
        VuePizzaSwing vuePizza = new VuePizzaSwing();
        new ControllerPizzaSwing(vuePizza, pizzaria, client, livreur, historiqueCommandes, profils); // ✅ profils ajouté ici aussi
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
                            " (" + ligne.getTaille() + ") = " + ligne.getPrixLigne() + "€\n");
                }
                area.append("Total : " + cmd.calculerPrixTotal() + "€\n\n");
            }
        }

        frame.add(new JScrollPane(area));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private void retourConnexion() {
        vue.dispose();
        VueConnexion vueConnexion = new VueConnexion();
        new ControleurConnexion(vueConnexion, pizzaria, livreur, historiqueCommandes, profils); // ✅ profils ajouté ici
    }
}
