package com.pizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterfacePizzaSwing extends JFrame {

    private Catalogue catalogue;
    private Client client;
    private SystemeLivraison systeme;
    private Commande commande;
    private JTextArea zoneCommande;
    private JComboBox<String> pizzaBox;
    private JComboBox<Taille> tailleBox;
    private JSpinner quantiteSpinner;
    private int numeroCommande = 1;
    private List<Commande> historiqueCommandes = new ArrayList<>();
    private JLabel labelPrixTotal;

    public InterfacePizzaSwing() {
        // Initialisation des données
        catalogue = new Catalogue();
        systeme = new SystemeLivraison();
        client = new Client("0601020304");
        client.ajouterSolde(100.0);

        catalogue.ajouterPizza(new Pizza("Margherita", Arrays.asList("Tomate", "Mozzarella"), 10.0));
        catalogue.ajouterPizza(new Pizza("Reine", Arrays.asList("Jambon", "Champignons"), 12.0));
        catalogue.ajouterPizza(new Pizza("4 Fromages", Arrays.asList("Mozzarella", "Gorgonzola", "Parmesan"), 13.0));

        // Interface
        setTitle("\uD83C\uDF55 Commande ta Pizza - Interface Swing \uD83C\uDF55");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout());

        // Centre : zone commande
        zoneCommande = new JTextArea();
        zoneCommande.setEditable(false);
        zoneCommande.setFont(new Font("Monospaced", Font.PLAIN, 14));
        zoneCommande.setBackground(new Color(255, 250, 240));
        add(new JScrollPane(zoneCommande), BorderLayout.CENTER);

        // Nord : panel de sélection
        JPanel panelTop = new JPanel();
        panelTop.setBackground(new Color(230, 230, 255));
        panelTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelTop.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        pizzaBox = new JComboBox<>();
        for (Pizza p : catalogue.getListePizzas()) {
            pizzaBox.addItem(p.getNom());
        }

        tailleBox = new JComboBox<>(Taille.values());
        quantiteSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        JButton ajouterBtn = new JButton("Ajouter au panier");

        ajouterBtn.setBackground(new Color(102, 205, 170));
        ajouterBtn.setForeground(Color.BLACK);

        panelTop.add(new JLabel("Pizza :"));
        panelTop.add(pizzaBox);
        panelTop.add(new JLabel("Taille :"));
        panelTop.add(tailleBox);
        panelTop.add(new JLabel("Quantité :"));
        panelTop.add(quantiteSpinner);
        panelTop.add(ajouterBtn);
        add(panelTop, BorderLayout.NORTH);

        // Sud : panel paiement
        JPanel panelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        labelPrixTotal = new JLabel("Prix Total : 0€");
        JButton payerBtn = new JButton("\uD83D\uDCB3 Payer & Livrer");
        payerBtn.setBackground(new Color(255, 165, 0));
        payerBtn.setForeground(Color.BLACK);
        payerBtn.setFont(new Font("SansSerif", Font.BOLD, 14));

        JButton viderBtn = new JButton("\u274C Vider le Panier");
        viderBtn.setBackground(new Color(220, 20, 60));
        viderBtn.setForeground(Color.BLACK);
        viderBtn.setFont(new Font("SansSerif", Font.BOLD, 14));

        panelBottom.add(labelPrixTotal);
        panelBottom.add(payerBtn);
        panelBottom.add(viderBtn);
        add(panelBottom, BorderLayout.SOUTH);

        // Action Ajouter
        ajouterBtn.addActionListener((ActionEvent e) -> {
            String nomPizza = (String) pizzaBox.getSelectedItem();
            Taille taille = (Taille) tailleBox.getSelectedItem();
            int qte = (int) quantiteSpinner.getValue();

            Pizza pizza = catalogue.trouverPizza(nomPizza);
            if (pizza != null) {
                LigneCommande ligne = new LigneCommande(pizza, taille, qte);
                commande.ajouterLigne(ligne);
                zoneCommande.append("\u2795 " + qte + " x " + nomPizza + " (" + taille + ") - " + String.format("%.2f", ligne.getPrixTotal()) + "\u20ac\n");
                labelPrixTotal.setText("Prix Total : " + String.format("%.2f", commande.getPrixTotal()) + "€");
            }
        });

        // Action Payer
        payerBtn.addActionListener((ActionEvent e) -> {
            if (commande.getListePizzas().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Le panier est vide !", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Livreur livreur = new Livreur(99, "scooter");
            systeme.payerEtLivrer(commande, livreur);
            zoneCommande.append("\n\u2705 Commande n°" + commande.getId() + " payée et livrée !\n");
            zoneCommande.append("\ud83d\udcc5 Historique de la commande :\n");
            for (LigneCommande lc : commande.getListePizzas()) {
                zoneCommande.append(" - " + lc.getQuantite() + " x " + lc.getPizza().getNom() + " (" + lc.getTaille() + ") = " + String.format("%.2f", lc.getPrixTotal()) + "€\n");
            }
            zoneCommande.append("\n\ud83d\udcb2 Total payé : " + String.format("%.2f", commande.getPrixTotal()) + "€\n");
            zoneCommande.append("\ud83d\udcb0 Solde restant client : " + String.format("%.2f", client.getSolde()) + "€\n");
            zoneCommande.append("\ud83d\udcc9 Pizzas achetées : " + client.getNbPizzasAchetees() + "\n\n");

            historiqueCommandes.add(commande);
            numeroCommande++;
            nouvelleCommande();
            labelPrixTotal.setText("Prix Total : 0€");
        });

        // Action Vider Panier
        viderBtn.addActionListener((ActionEvent e) -> {
            commande.getListePizzas().clear();
            zoneCommande.append("\n\u274C Panier vidé !\n");
            labelPrixTotal.setText("Prix Total : 0€");
        });

        setVisible(true);

        // Créer la commande APRÈS que l'interface soit prête
        nouvelleCommande();
    }

    private void nouvelleCommande() {
        this.commande = new Commande(numeroCommande, client);
        zoneCommande.setText("\uD83D\uDCCB Nouvelle commande n°" + numeroCommande + " créée\n\n");
    }
}
