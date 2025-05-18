package com.pizza;

import java.util.List;

public class ControleurConnexion {

    private VueConnexion vueConnexion;
    private Point_Pizzeria pizzaria;
    private Livreur livreur;
    private List<Commande> historiqueCommandes;
    private List<String[]> profils;

    public ControleurConnexion(VueConnexion vueConnexion, Point_Pizzeria pizzaria, Livreur livreur, List<Commande> historiqueCommandes, List<String[]> profils) {
        this.vueConnexion = vueConnexion;
        this.pizzaria = pizzaria;
        this.livreur = livreur;
        this.historiqueCommandes = historiqueCommandes;
        this.profils = profils;

        this.vueConnexion.setConnexionListener(e -> {
            String numero = vueConnexion.getNumeroSaisi();
            verifierConnexion(numero);
        });
    }

    public void verifierConnexion(String numero) {
        if (!numero.matches("\\d+")) {
            vueConnexion.afficherMessage("Le numéro ne doit contenir que des chiffres.");
            return;
        }

        if (numero.length() != 10) {
            vueConnexion.afficherMessage("Le numéro doit contenir exactement 10 chiffres.");
            return;
        }

        if (!numero.startsWith("06") && !numero.startsWith("07")) {
            vueConnexion.afficherMessage("Le numéro doit commencer par 06 ou 07.");
            return;
        }

        for (String[] profil : profils) {
            String prenom = profil[0];
            String nom = profil[1];
            String tel = profil[2];

            if (tel.equals(numero)) {
                vueConnexion.afficherMessage("Bienvenue " + prenom + " " + nom + " !");
                vueConnexion.dispose(); // Ferme la fenêtre de connexion
                int numeroInt = Integer.parseInt(tel);
                Client client = new Client(1, nom, prenom, 50.0, numeroInt);
                // Lancement de la fenêtre client
                VueClient vueClient = new VueClient();
                new ControlerClient(vueClient, client, pizzaria, livreur, historiqueCommandes, profils);
                return;
            }
        }
        vueConnexion.afficherMessage("Aucun compte n’est associé à ce numéro.");
    }
}