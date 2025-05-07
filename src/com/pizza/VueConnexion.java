package com.pizza;

import javax.swing.*;
import java.awt.*;

public class VueConnexion extends JFrame {

    private JTextField numeroField;
    private JButton connexionBtn;

    public VueConnexion() {
        setTitle("Connexion Client");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(new JLabel("Numéro de téléphone : "));
        numeroField = new JTextField(20);
        numeroField.setToolTipText("Entrez votre numéro de téléphone ici.");
        panel.add(numeroField);

        connexionBtn = new JButton("Se connecter");
        panel.add(connexionBtn);

        add(panel, BorderLayout.CENTER);

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
