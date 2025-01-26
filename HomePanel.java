package Ui;

import Modele.Student;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class HomePanel extends JPanel {
    public HomePanel() {
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Bienvenue dans l'application de gestion des étudiants", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        welcomeLabel.setForeground(new Color(39, 174, 96));

        add(welcomeLabel, BorderLayout.CENTER);

        // Add Logo
        JLabel logoLabel = new JLabel(new ImageIcon(getClass().getResource("/logo.jpg")));
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(Color.WHITE);
        logoPanel.add(logoLabel);

        add(logoPanel, BorderLayout.NORTH);
    }
}
