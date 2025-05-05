import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import com.pizza.Client;


public class InterfaceConnexion extends JFrame {
    private JTextField champNumero;
    private JButton boutonConnexion;
    private JLabel messageErreur;

    private List<Client> listeClients;

    public InterfaceConnexion(List<Client> clients) {
        super("Connexion Client");
        this.listeClients = clients;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel centrePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        centrePanel.add(new JLabel("Numéro de téléphone :"));
        champNumero = new JTextField();
        centrePanel.add(champNumero);

        boutonConnexion = new JButton("Se connecter");
        centrePanel.add(new JLabel()); // empty cell
        centrePanel.add(boutonConnexion);

        panel.add(centrePanel, BorderLayout.CENTER);

        messageErreur = new JLabel("", SwingConstants.CENTER);
        messageErreur.setForeground(Color.RED);
        panel.add(messageErreur, BorderLayout.SOUTH);

        add(panel);

        boutonConnexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numero = champNumero.getText().trim();
                boolean trouve = false;

                for (Client c : listeClients) {
                    if (c.getTelephone().equals(numero)) {
                        trouve = true;
                        dispose();
                        new InterfacePizzaSwing(c);
                        break;
                    }
                }

                if (!trouve) {
                    messageErreur.setText("Client non trouvé. Veuillez réessayer.");
                }
            }
        });

        setVisible(true);
    }
}
