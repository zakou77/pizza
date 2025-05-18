package com.pizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VueClient extends JFrame {

    private JButton voirSoldeBtn;
    private JButton ajouterSoldeBtn;
    private JButton commanderBtn;
    private JButton retourBtn;
    private JButton historiqueBtn;
    private JLabel labelAccueil;

    public VueClient() {
        setTitle("Interface Pizza - GridBagLayout version clean");
        setSize(950, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Fond personnalisé
        JPanel fondPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon("src/assets/FondClient.png");
                g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        fondPanel.setLayout(new GridBagLayout());
        setContentPane(fondPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(111, 10, 0, 10);


        // texte d’accueil
        GridBagConstraints gbcText = new GridBagConstraints();
        gbcText.gridx = 1;
        gbcText.gridy = 0;
        gbcText.anchor = GridBagConstraints.WEST;
        gbcText.insets = new Insets(40, 250, 0, 10); // marge à gauche pour décaler le texte
        gbcText.weightx = 1.0;
        gbcText.fill = GridBagConstraints.HORIZONTAL;

        labelAccueil = new JLabel("", SwingConstants.LEFT);
        labelAccueil.setFont(new Font("SansSerif", Font.BOLD, 25));
        labelAccueil.setForeground(Color.BLACK);

        fondPanel.add(labelAccueil, gbcText);



        // boutons sous le texte
        JPanel boutonPanel = new JPanel(new GridBagLayout());
        boutonPanel.setOpaque(false);

        GridBagConstraints btnGbc = new GridBagConstraints();
        btnGbc.insets = new Insets(100, 20, 10, 20);

        voirSoldeBtn = creerBouton("Voir solde");
        ajouterSoldeBtn = creerBouton("Ajouter solde");
        commanderBtn = creerBouton("Commander");
        historiqueBtn = creerBouton("Voir historique");
        retourBtn = creerBouton("Retour");

        JButton[] boutons = {voirSoldeBtn, ajouterSoldeBtn, commanderBtn, historiqueBtn, retourBtn};

        for (int i = 0; i < boutons.length; i++) {
            btnGbc.gridx = i;
            boutonPanel.add(boutons[i], btnGbc);
        }

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        fondPanel.add(boutonPanel, gbc);

        setVisible(true);
    }

    private JButton creerBouton(String texte) {
        JButton btn = new JButton(texte);
        btn.setFont(new Font("SansSerif", Font.BOLD, 18));
        btn.setBackground(new Color(14, 54, 44));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setOpaque(true);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return btn;
    }

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

    public void setMessageAccueil(String texte) {
        labelAccueil.setText(texte);
    }
}
