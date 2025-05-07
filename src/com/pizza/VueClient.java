package com.pizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VueClient extends JFrame {

    private JButton voirSoldeBtn;
    private JButton ajouterSoldeBtn;
    private JButton commanderBtn;

    private JTextArea zoneAffichage;

    public VueClient() {
        setTitle("Interface Pizza - Améliorée");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Zone centrale d'affichage
        zoneAffichage = new JTextArea();
        zoneAffichage.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(zoneAffichage);
        add(scrollPane, BorderLayout.CENTER);

        // Barre de boutons en bas
        JPanel boutonPanel = new JPanel();
        voirSoldeBtn = new JButton("Voir solde");
        ajouterSoldeBtn = new JButton("Ajouter solde");
        commanderBtn = new JButton("Commander");

        boutonPanel.add(voirSoldeBtn);
        boutonPanel.add(ajouterSoldeBtn);
        boutonPanel.add(commanderBtn);

        add(boutonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // === Accesseurs pour le contrôleur ===

    public void setVoirSoldeListener(ActionListener listener) {
        voirSoldeBtn.addActionListener(listener);
    }

    public void setAjouterSoldeListener(ActionListener listener) {
        ajouterSoldeBtn.addActionListener(listener);
    }

    public void setCommanderListener(ActionListener listener) {
        commanderBtn.addActionListener(listener);
    }

    public void appendTexte(String texte) {
        zoneAffichage.append(texte + "\n");
    }

    public void setTexte(String texte) {
        zoneAffichage.setText(texte);
    }
}
