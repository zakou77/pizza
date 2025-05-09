package com.pizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VueClient extends JFrame {

    private JButton voirSoldeBtn;
    private JButton ajouterSoldeBtn;
    private JButton commanderBtn;
    private JButton historiqueBtn;
    private JButton retourBtn;

    private JTextArea zoneAffichage;

    public VueClient() {
        setTitle("Interface Pizza - Améliorée");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Zone centrale
        zoneAffichage = new JTextArea();
        zoneAffichage.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(zoneAffichage);
        add(scrollPane, BorderLayout.CENTER);

        // Boutons du bas
        JPanel boutonPanel = new JPanel();
        Dimension boutonPanelSize = boutonPanel.getSize();
        boutonPanel.setPreferredSize(new Dimension(boutonPanelSize.width, boutonPanelSize.height + 75));

        voirSoldeBtn = new JButton("Voir solde");
        ajouterSoldeBtn = new JButton("Ajouter solde");
        commanderBtn = new JButton("Commander");
        historiqueBtn = new JButton("Voir historique");
        retourBtn = new JButton("Retour");

        boutonPanel.add(voirSoldeBtn);
        boutonPanel.add(ajouterSoldeBtn);
        boutonPanel.add(commanderBtn);
        boutonPanel.add(historiqueBtn);
        boutonPanel.add(retourBtn);

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

    public void setHistoriqueListener(ActionListener listener) {
        historiqueBtn.addActionListener(listener);
    }

    public void setRetourListener(ActionListener listener) {
        retourBtn.addActionListener(listener);
    }

    public void appendTexte(String texte) {
        zoneAffichage.append(texte + "\n");
    }

    public void setTexte(String texte) {
        zoneAffichage.setText(texte);
    }
}
