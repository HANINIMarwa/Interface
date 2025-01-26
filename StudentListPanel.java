package Ui;
import Modele.Student;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StudentListPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private ArrayList<Student> studentList;

    public StudentListPanel(ArrayList<Student> studentList) {
        this.studentList = studentList;
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{"Prénom", "Nom", "Âge", "Email"}, 0);
        table = new JTable(tableModel);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.setBackground(new Color(236, 240, 241));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnDelete = new JButton("Supprimer");
        btnDelete.setBackground(new Color(231, 76, 60));
        btnDelete.setForeground(Color.WHITE);
        add(btnDelete, BorderLayout.SOUTH);

        btnDelete.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                studentList.remove(selectedRow);
                refreshTable();
                JOptionPane.showMessageDialog(this, "Étudiant supprimé avec succès !");
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner un étudiant à supprimer.");
            }
        });
    }

    public void refreshTable() {
        tableModel.setRowCount(0);
        for (Student student : studentList) {
            tableModel.addRow(new Object[]{student.getFirstName(), student.getLastName(), student.getAge(), student.getEmail()});
        }
    }
}

