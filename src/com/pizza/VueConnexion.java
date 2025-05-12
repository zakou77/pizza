package com.pizza;

import javax.swing.*;
import java.awt.*;

public class VueConnexion extends JFrame {

    private JTextField numeroField;
    private JButton connexionBtn;

    public VueConnexion() {
        setTitle("Connexion Client");
        setSize(900, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel fond = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon("src/assets/FondConnexion.png");
                g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        fond.setLayout(null);
        setContentPane(fond);

        // === Label ===
        JLabel labelTel = new JLabel("Numéro de téléphone :");
        labelTel.setFont(new Font("SansSerif", Font.BOLD, 22));
        labelTel.setBounds(250, 230, 300, 30);
        fond.add(labelTel);

        // === Champ texte ===
        numeroField = new JTextField();
        numeroField.setFont(new Font("SansSerif", Font.PLAIN, 20));
        numeroField.setBounds(200, 270, 330, 40); // décalé + largeur augmentée
        fond.add(numeroField);

        // === Bouton ===
        connexionBtn = new JButton("Se connecter");
        connexionBtn.setFont(new Font("SansSerif", Font.BOLD, 18));
        connexionBtn.setForeground(Color.WHITE);
        connexionBtn.setBackground(new Color(215, 38, 61));
        connexionBtn.setFocusPainted(false);
        connexionBtn.setBorderPainted(false);
        connexionBtn.setOpaque(true);
        connexionBtn.setContentAreaFilled(true);
        connexionBtn.setBounds(545, 270, 160, 40); // positionné juste à droite du champ
        fond.add(connexionBtn);

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
