package main;
import Modele.Student;
import Ui.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private ArrayList<Student> studentList;

    public MainFrame() {
        setTitle("Gestion des Étudiants");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        studentList = new ArrayList<>(); // Initialize student list

        // Left Menu Panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(5, 1, 10, 10));
        menuPanel.setPreferredSize(new Dimension(220, 0));
        menuPanel.setBackground(new Color(44, 62, 80));

        JButton btnHome = createMenuButton("Accueil", "icons/home.png");
        JButton btnAddStudent = createMenuButton("Ajouter Étudiant", "icons/add.png");
        JButton btnListStudents = createMenuButton("Liste des Étudiants", "icons/list.png");
        JButton btnExit = createMenuButton("Quitter", "icons/exit.png");

        menuPanel.add(btnHome);
        menuPanel.add(btnAddStudent);
        menuPanel.add(btnListStudents);
        menuPanel.add(btnExit);

        add(menuPanel, BorderLayout.WEST);

        // Main Content Panel
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        HomePanel homePanel = new HomePanel();
        AddStudentPanel addStudentPanel = new AddStudentPanel(studentList);
        StudentListPanel studentListPanel = new StudentListPanel(studentList);

        mainPanel.add(homePanel, "Home");
        mainPanel.add(addStudentPanel, "AddStudent");
        mainPanel.add(studentListPanel, "ListStudents");

        add(mainPanel, BorderLayout.CENTER);

        // Action Listeners for Menu Buttons
        btnHome.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
        btnAddStudent.addActionListener(e -> cardLayout.show(mainPanel, "AddStudent"));
        btnListStudents.addActionListener(e -> {
            studentListPanel.refreshTable(); // Refresh table before showing
            cardLayout.show(mainPanel, "ListStudents");
        });
        btnExit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private JButton createMenuButton(String text, String iconPath) {
        JButton button = new JButton(text, new ImageIcon(iconPath));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setBackground(new Color(52, 73, 94));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}