package com.pizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VuePizzaSwing extends JFrame {

    private JTextArea zoneCommande;
    private JComboBox<String> pizzaBox;
    private JComboBox<String> tailleBox;
    private JSpinner quantiteSpinner;
    private JLabel labelPrixTotal;
    private JButton ajouterBtn;
    private JButton payerBtn;
    private JButton historiqueBtn; // ✅ Ajouté

    public VuePizzaSwing() {
        setTitle("Commande de Pizza");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel du haut
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Pizza:"));
        pizzaBox = new JComboBox<>();
        topPanel.add(pizzaBox);

        topPanel.add(new JLabel("Taille:"));
        tailleBox = new JComboBox<>(new String[]{"NAINE", "HUMAINE", "OGRESSE"});
        topPanel.add(tailleBox);

        topPanel.add(new JLabel("Quantité:"));
        quantiteSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        topPanel.add(quantiteSpinner);

        ajouterBtn = new JButton("Ajouter");
        topPanel.add(ajouterBtn);

        add(topPanel, BorderLayout.NORTH);

        // Zone centrale
        zoneCommande = new JTextArea();
        zoneCommande.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(zoneCommande);
        add(scrollPane, BorderLayout.CENTER);

        // Bas de fenêtre
        JPanel bottomPanel = new JPanel(new BorderLayout());
        labelPrixTotal = new JLabel("Prix Total : 0€");
        bottomPanel.add(labelPrixTotal, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new GridLayout(2, 1));
        payerBtn = new JButton("Payer et Livrer");
        historiqueBtn = new JButton("Voir Historique"); // ✅ Ajouté
        rightPanel.add(payerBtn);
        rightPanel.add(historiqueBtn); // ✅ Ajouté

        bottomPanel.add(rightPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // === Accesseurs pour le contrôleur ===

    public void setPizzaOptions(String[] nomsPizzas) {
        pizzaBox.setModel(new DefaultComboBoxModel<>(nomsPizzas));
    }

    public String getPizzaSelectionnee() {
        return (String) pizzaBox.getSelectedItem();
    }

    public String getTailleSelectionnee() {
        return (String) tailleBox.getSelectedItem();
    }

    public int getQuantiteSelectionnee() {
        return (int) quantiteSpinner.getValue();
    }

    public void setZoneCommandeText(String texte) {
        zoneCommande.setText(texte);
    }

    public void appendZoneCommande(String texte) {
        zoneCommande.append(texte);
    }

    public void setPrixTotal(double prix) {
        labelPrixTotal.setText("Prix Total : " + prix + "€");
    }

    public void setAjouterListener(ActionListener listener) {
        ajouterBtn.addActionListener(listener);
    }

    public void setPayerListener(ActionListener listener) {
        payerBtn.addActionListener(listener);
    }

    public void setHistoriqueListener(ActionListener listener) {
        historiqueBtn.addActionListener(listener); // ✅ Ajouté
    }
}
