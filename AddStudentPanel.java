package Ui;
import Modele.Student;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddStudentPanel extends JPanel {
    public AddStudentPanel(ArrayList<Student> studentList) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblFirstName = new JLabel("Prénom :");
        JLabel lblLastName = new JLabel("Nom :");
        JLabel lblAge = new JLabel("Âge :");
        JLabel lblEmail = new JLabel("Email :");

        JTextField txtFirstName = new JTextField(15);
        JTextField txtLastName = new JTextField(15);
        JTextField txtAge = new JTextField(15);
        JTextField txtEmail = new JTextField(15);

        JButton btnAdd = new JButton("Ajouter");
        btnAdd.setBackground(new Color(46, 204, 113));
        btnAdd.setForeground(Color.WHITE); //effet apres utilisation de la souris

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblFirstName, gbc);
        gbc.gridx = 1;
        add(txtFirstName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblLastName, gbc);
        gbc.gridx = 1;
        add(txtLastName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblAge, gbc);
        gbc.gridx = 1;
        add(txtAge, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblEmail, gbc);
        gbc.gridx = 1;
        add(txtEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(btnAdd, gbc);

        btnAdd.addActionListener(e -> {
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            int age = Integer.parseInt(txtAge.getText());
            String email = txtEmail.getText();

            studentList.add(new Student(firstName, lastName, age, email));
            JOptionPane.showMessageDialog(this, "Étudiant ajouté avec succès !");

            txtFirstName.setText("");
            txtLastName.setText("");
            txtAge.setText("");
            txtEmail.setText("");
        });
    }
}
