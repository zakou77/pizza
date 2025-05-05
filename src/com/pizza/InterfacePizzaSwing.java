package com.pizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class InterfacePizzaSwing extends JFrame {

    private Point_Pizzaria pizzaria;
    private Client client;
    private Commande commande;
    private Livreur livreur;

    private JTextArea zoneCommande;
    private JComboBox<String> pizzaBox;
    private JComboBox<String> tailleBox;
    private JSpinner quantiteSpinner;
    private JLabel labelPrixTotal;
    private int numeroCommande = 1;
    private List<Commande> historiqueCommandes = new ArrayList<>();

    public InterfacePizzaSwing() {
        setTitle("Commande de Pizza");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Initialisation
        pizzaria = new Point_Pizzaria("Paris");
        initialiserMenuPizzas();
        client = new Client(1, "Zak", "Paris", 50);
        livreur = new Livreur(1, "Karim", "Scooter");

        // Panel du haut
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Pizza:"));
        pizzaBox = new JComboBox<>(getNomsPizzas());
        topPanel.add(pizzaBox);

        topPanel.add(new JLabel("Taille:"));
        tailleBox = new JComboBox<>(new String[]{"NAINE", "HUMAINE", "OGRESSE"});
        topPanel.add(tailleBox);

        topPanel.add(new JLabel("Quantité:"));
        quantiteSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        topPanel.add(quantiteSpinner);

        JButton ajouterBtn = new JButton("Ajouter");
        topPanel.add(ajouterBtn);

        add(topPanel, BorderLayout.NORTH);

        // Zone de texte centrale
        zoneCommande = new JTextArea();
        zoneCommande.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(zoneCommande);
        add(scrollPane, BorderLayout.CENTER);

        // Bas de fenêtre
        JPanel bottomPanel = new JPanel(new BorderLayout());
        labelPrixTotal = new JLabel("Prix Total : 0€");
        bottomPanel.add(labelPrixTotal, BorderLayout.WEST);

        JButton payerBtn = new JButton("Payer et Livrer");
        bottomPanel.add(payerBtn, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        // Initialisation de la commande
        nouvelleCommande();

        // Action : Ajouter au panier
        ajouterBtn.addActionListener((ActionEvent e) -> {
            String nomPizza = (String) pizzaBox.getSelectedItem();
            String taille = (String) tailleBox.getSelectedItem();
            int quantite = (Integer) quantiteSpinner.getValue();

            Pizza pizza = getPizza(nomPizza, taille);
            if (pizza != null) {
                LigneCommande ligne = new LigneCommande(commande.getNumCommande(), quantite, pizza);
                commande.ajouterLigne(ligne);

                zoneCommande.append("+ " + quantite + " x " + nomPizza + " (" + taille + ") – " + (pizza.getPrixBase() * quantite) + "€\n");
                labelPrixTotal.setText("Prix Total : " + commande.calculerPrixTotal() + "€");
            } else {
                zoneCommande.append("❌ Pizza non trouvée : " + nomPizza + " (" + taille + ")\n");
            }
        });

        // Action : Payer
        payerBtn.addActionListener((ActionEvent e) -> {
            double total = commande.calculerPrixTotal();
            if (client.peutPayer(total)) {
                client.payer(total);
                commande.setLivreur(livreur);
                zoneCommande.append("\n✅ Commande payée : " + total + "€\n");
                zoneCommande.append("🚚 Livrée par " + livreur.getNom_L() + " en " + livreur.getType_Vec() + "\n");

                historiqueCommandes.add(commande);
                nouvelleCommande();
            } else {
                zoneCommande.append("\n❌ Solde insuffisant !\n");
            }
        });

        setVisible(true);
    }

    private void nouvelleCommande() {
        zoneCommande.setText("Nouvelle commande n°" + numeroCommande + " créée\n");
        commande = new Commande(numeroCommande++, "2025-05-04", client);
        labelPrixTotal.setText("Prix Total : 0€");
    }

    private void initialiserMenuPizzas() {
        pizzaria.ajouterPizza(new Pizza("Margherita", "NAINE", 5.0));
        pizzaria.ajouterPizza(new Pizza("Margherita", "HUMAINE", 7.0));
        pizzaria.ajouterPizza(new Pizza("Margherita", "OGRESSE", 9.0));
        pizzaria.ajouterPizza(new Pizza("Pepperoni", "NAINE", 6.0));
        pizzaria.ajouterPizza(new Pizza("Pepperoni", "HUMAINE", 8.0));
        pizzaria.ajouterPizza(new Pizza("Pepperoni", "OGRESSE", 10.0));
        // Ajoute d'autres pizzas si nécessaire
    }

    private String[] getNomsPizzas() {
        return pizzaria.getMenu().stream()
                .map(Pizza::getNom)
                .distinct()
                .toArray(String[]::new);
    }

    private Pizza getPizza(String nom, String taille) {
        return pizzaria.getMenu().stream()
                .filter(p -> p.getNom().equals(nom) && p.getTaille().equals(taille))
                .findFirst()
                .orElse(null);
    }
}
