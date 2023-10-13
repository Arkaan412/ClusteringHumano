package vista;

import javax.swing.*;
import java.awt.*;

public class ExcelLikeGridWithTabs {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Excel-like Grid with Tabs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Datos de ejemplo para la primera tabla
        Object[][] data1 = {
            {"A1", "B1", "C1", "D1"},
            {"A2", "B2", "C2", "D2"},
            {"A3", "B3", "C3", "D3"}
        };

        // Nombres de columnas para la primera tabla
        String[] columnNames1 = {"Columna 1", "Columna 2", "Columna 3", "Columna 4"};

        // Crea la primera tabla y la agrega a un JScrollPane
        JTable table1 = new JTable(data1, columnNames1);
        JScrollPane scrollPane1 = new JScrollPane(table1);

        // Datos de ejemplo para la segunda tabla
        Object[][] data2 = {
            {"E1", "F1", "G1", "H1"},
            {"E2", "F2", "G2", "H2"},
            {"E3", "F3", "G3", "H3"}
        };

        // Nombres de columnas para la segunda tabla
        String[] columnNames2 = {"Columna A", "Columna B", "Columna C", "Columna D"};

        // Crea la segunda tabla y la agrega a un JScrollPane
        JTable table2 = new JTable(data2, columnNames2);
        JScrollPane scrollPane2 = new JScrollPane(table2);

        // Agrega los JScrollPane a las pestañas del JTabbedPane
        tabbedPane.addTab("Tabla 1", scrollPane1);
        tabbedPane.addTab("Tabla 2", scrollPane2);

        // Agrega el JTabbedPane a la ventana
        frame.add(tabbedPane, BorderLayout.CENTER);

        // Ajusta el tamaño de la ventana y hazla visible
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}

