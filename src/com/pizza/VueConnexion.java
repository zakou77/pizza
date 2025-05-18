package com.pizza;

import javax.swing.*;
import java.awt.*;

public class VueConnexion extends JFrame {

    private JTextField numeroField;
    private JButton connexionBtn;

    public VueConnexion() {
        setTitle("Connexion Client");
        setSize(850, 580);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // === Fond personnalisé ===
        JPanel fond = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon("src/assets/FondConnexion.png");
                g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        fond.setLayout(new GridBagLayout());
        setContentPane(fond);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 5, 15, 110);

        // === Label titre ===
        JLabel labelTel = new JLabel("Numéro de téléphone :");
        labelTel.setFont(new Font("SansSerif", Font.BOLD, 22));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        fond.add(labelTel, gbc);

        // === Sous-panel : champ + bouton ===
        JPanel ligneConnexion = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        ligneConnexion.setOpaque(false);

        numeroField = new JTextField(15);
        numeroField.setFont(new Font("SansSerif", Font.PLAIN, 20));
        ligneConnexion.add(numeroField);

        connexionBtn = new JButton("Se connecter");
        connexionBtn.setFont(new Font("SansSerif", Font.BOLD, 18));
        connexionBtn.setForeground(Color.WHITE);
        connexionBtn.setBackground(new Color(215, 38, 61));
        connexionBtn.setFocusPainted(false);
        connexionBtn.setBorderPainted(false);
        connexionBtn.setOpaque(true);
        connexionBtn.setContentAreaFilled(true);
        ligneConnexion.add(connexionBtn);

        // === Positionner la ligne champ+bouton ===
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;

        // 🔽 ==> Ici tu peux modifier facilement le décalage
        gbc.insets = new Insets(10, 70, 10, 10);  // Haut, Gauche, Bas, Droite
        fond.add(ligneConnexion, gbc);

        setVisible(true);
    }

    public String getNumeroSaisi() {
        return numeroField.getText().trim();
    }

    public void setConnexionListener(java.awt.event.ActionListener listener) {
        connexionBtn.addActionListener(listener);
    }

    public void afficherMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
