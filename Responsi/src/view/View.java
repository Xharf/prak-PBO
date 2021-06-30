package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;

public class View extends JFrame {

    private JLabel Ljudul = new JLabel("Judul");
    private JLabel Lalur = new JLabel("Alur");
    private JLabel Lpenokohan = new JLabel("Penokohan");
    private JLabel Lakting = new JLabel("Akting");

    public JTextField Tjudul = new JTextField(20);
    public JTextField Talur = new JTextField(20);
    public JTextField Tpenokohan = new JTextField(20);
    public JTextField Takting = new JTextField(20);

    public JButton Btambah = new JButton("Tambah");
    public JButton Bupdate = new JButton("Update");
    public JButton Bdelete = new JButton("Delete");
    public JButton Bclear = new JButton("Clear");

    public JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    public Object colName[] = {"Judul", "Alur", "Penokohan", "Akting", "Nilai"};

    public View() {
        super("Data Movie");

        tableModel = new DefaultTableModel(colName, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        JPanel newPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 10;
        newPanel.add(scrollPane, constraints);

        constraints.gridx = 1;
        constraints.gridheight = 1;
        constraints.insets = new java.awt.Insets(30, 10, 10, 10);
        newPanel.add(Ljudul, constraints);
        constraints.gridx = 2;
        newPanel.add(Tjudul, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new java.awt.Insets(10, 10, 10, 10);
        newPanel.add(Lalur, constraints);
        constraints.gridx = 2;
        newPanel.add(Talur, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        newPanel.add(Lpenokohan, constraints);
        constraints.gridx = 2;
        newPanel.add(Tpenokohan, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        newPanel.add(Lakting, constraints);
        constraints.gridx = 2;
        newPanel.add(Takting, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        newPanel.add(Btambah, constraints);
        constraints.gridy = 6;
        newPanel.add(Bupdate, constraints);
        constraints.gridy = 7;
        newPanel.add(Bdelete, constraints);
        constraints.gridy = 8;
        newPanel.add(Bclear, constraints);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(newPanel);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public String getJudul() {
        return Tjudul.getText();
    }

    public double getAlur() {
        String str = Talur.getText();
        if (str.equals("") || !this.isNumeric(str)) {
            return -1;
        }

        return Double.parseDouble(Talur.getText());
    }

    public double getPenokohan() {
        String str = Tpenokohan.getText();
        if (str.equals("") || !this.isNumeric(str)) {
            return -1;
        }

        return Double.parseDouble(Tpenokohan.getText());
    }

    public double getAkting() {
        String str = Takting.getText();
        if (str.equals("") || !this.isNumeric(str)) {
            return -1;
        }

        return Double.parseDouble(Takting.getText());
    }


    public static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }
}
