package com.pizza;

public class Main {
    public static void main(String[] args) {
        // Lancer l’interface Swing dans le thread graphique
        javax.swing.SwingUtilities.invokeLater(() -> {
            new InterfacePizzaSwing();
        });
    }
}
