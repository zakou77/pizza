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
    private JButton supprimerBtn;
    private JButton payerBtn;
    private JButton retourBtn;

    public VuePizzaSwing() {
        setTitle("Commande de Pizza");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ✅ Top bar classique sans espace inutile
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pizzaBox = new JComboBox<>();
        tailleBox = new JComboBox<>(new String[]{"NAINE", "HUMAINE", "OGRESSE"});
        quantiteSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        ajouterBtn = new JButton("Ajouter");
        supprimerBtn = new JButton("Supprimer");

        topPanel.add(new JLabel("Pizza:"));
        topPanel.add(pizzaBox);
        topPanel.add(new JLabel("Taille:"));
        topPanel.add(tailleBox);
        topPanel.add(new JLabel("Quantité:"));
        topPanel.add(quantiteSpinner);
        topPanel.add(ajouterBtn);
        topPanel.add(supprimerBtn);
        add(topPanel, BorderLayout.NORTH);

        // ✅ Zone centrale
        zoneCommande = new JTextArea();
        zoneCommande.setEditable(false);
        zoneCommande.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(zoneCommande), BorderLayout.CENTER);

        // ✅ Bottom bar
        JPanel bottomPanel = new JPanel(new BorderLayout());
        labelPrixTotal = new JLabel("Prix Total : 0.00€");
        bottomPanel.add(labelPrixTotal, BorderLayout.CENTER);

        retourBtn = new JButton("Retour");
        payerBtn = new JButton("Payer et Livrer");

        JPanel leftPanel = new JPanel();
        leftPanel.add(retourBtn);
        bottomPanel.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        rightPanel.add(payerBtn);
        bottomPanel.add(rightPanel, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // === Getters pour le contrôleur ===

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
        labelPrixTotal.setText("Prix Total : " + String.format("%.2f", prix) + "€");
    }

    public void setAjouterListener(ActionListener listener) {
        ajouterBtn.addActionListener(listener);
    }

    public void setPayerListener(ActionListener listener) {
        payerBtn.addActionListener(listener);
    }

    public void setRetourListener(ActionListener listener) {
        retourBtn.addActionListener(listener);
    }

    public void setSupprimerListener(ActionListener listener) {
        supprimerBtn.addActionListener(listener);
    }
}
