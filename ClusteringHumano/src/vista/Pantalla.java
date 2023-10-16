package vista;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

import modelo.GeneradorDeGruposDePersonas;

public class Pantalla {

	private JFrame frame;
	private JTable tablaPersonas;
	private JTable tablaResultados;

	private static final int cantidadFilas = 10;
//	private static final int cantidadColumnas = 5;

	private static final int columnaDePersonas = 0;

	private static final int columnaDeInteresDeportes = 1;
	private static final int columnaDeInteresEspectaculos = 2;
	private static final int columnaDeInteresCiencia = 3;
	private static final int columnaDeInteresMusica = 4;

	private static final int columnaDeGrupoA = 0;
	private static final int columnaDeGrupoB = 1;

	public Pantalla() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.setLocationRelativeTo(null); // Centrar en pantalla.

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 584, 461);
		frame.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		tabbedPane.addTab("Personas y gustos", null, panel, "Personas y gustos");

		JScrollPane scrollPanePersonas = new JScrollPane();
		scrollPanePersonas.setBounds(0, 0, 579, 305);
		panel.add(scrollPanePersonas);

		inicializarTablaPersonas();

		scrollPanePersonas.setViewportView(tablaPersonas);

		JButton botonGenerar = new JButton("Generar grupos");
		botonGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarGrupos();
			}
		});

		botonGenerar.setBounds(0, 307, 579, 80);
		panel.add(botonGenerar);

		JScrollPane scrollPaneResultados = new JScrollPane();
		tabbedPane.addTab("Resultados", null, scrollPaneResultados, "Resultados");

		inicializarTablaResultados();

		scrollPaneResultados.setViewportView(tablaResultados);
	}

	private void inicializarTablaPersonas() {
		tablaPersonas = new JTable();

		tablaPersonas.setCellSelectionEnabled(true);
		tablaPersonas.setColumnSelectionAllowed(true);
		tablaPersonas.setFillsViewportHeight(true);

		DefaultTableModel tableModelPersonas = inicializarTableModelPersonas();
		tablaPersonas.setModel(tableModelPersonas);

		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(160);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(130);
		tablaPersonas.getColumnModel().getColumn(2).setPreferredWidth(200);
		tablaPersonas.getColumnModel().getColumn(3).setPreferredWidth(115);
		tablaPersonas.getColumnModel().getColumn(4).setPreferredWidth(115);
	}

	private DefaultTableModel inicializarTableModelPersonas() {
		DefaultTableModel tableModel = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if (columnIndex == 0) {
					return String.class;
				} else {
					return Integer.class;
				}
			}
		};
		tableModel.addColumn("Personas");
		tableModel.addColumn("Deportes");
		tableModel.addColumn("Noticias del espectáculo");
		tableModel.addColumn("Ciencia");
		tableModel.addColumn("Música");

		for (int i = 0; i < cantidadFilas; i++) {
			tableModel.addRow(new Object[] { "", 0, 0, 0, 0 });
		}
		return tableModel;
	}

	private void inicializarTablaResultados() {
		tablaResultados = new JTable();

		tablaResultados.setColumnSelectionAllowed(true);
		tablaResultados.setCellSelectionEnabled(true);
		tablaResultados.setFillsViewportHeight(true);

		DefaultTableModel tableModelResultados = inicializarTableModelResultados();
		tablaResultados.setModel(tableModelResultados);

		tablaResultados.getColumnModel().getColumn(0).setPreferredWidth(362);
		tablaResultados.getColumnModel().getColumn(1).setPreferredWidth(362);
	}

	private DefaultTableModel inicializarTableModelResultados() {
		DefaultTableModel tableModel = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return String.class;
			}
		};

		tableModel.addColumn("Grupo A");
		tableModel.addColumn("Grupo B");

		for (int i = 0; i < cantidadFilas; i++) {
			tableModel.addRow(new Object[] { "", "" });
		}
		return tableModel;
	}

	private void generarGrupos() {
		ArrayList<Object[]> datosDePersonas = obtenerDatosDePersonas();

		GeneradorDeGruposDePersonas gruposDePersonas = new GeneradorDeGruposDePersonas(datosDePersonas);

		cargarResultados(gruposDePersonas);
	}

	private ArrayList<Object[]> obtenerDatosDePersonas() {
		ArrayList<Object[]> datosDePersonas = new ArrayList<>();

		for (int i = 0; i < cantidadFilas; i++) {
			String stringDeFilaActual = (String) tablaPersonas.getValueAt(i, columnaDePersonas);

			boolean esStringVacio = stringDeFilaActual.equals("");
			if (!esStringVacio) {

				Object[] datosDePersona = obtenerDatosDePersona(i, stringDeFilaActual);

				datosDePersonas.add(datosDePersona);
			}
		}

		return datosDePersonas;
	}

	private Object[] obtenerDatosDePersona(int filaActual, String nombreDeLaFilaActual) {
		String nombre = nombreDeLaFilaActual;

		Integer interesDeportes = (Integer) tablaPersonas.getValueAt(filaActual, columnaDeInteresDeportes);
		Integer interesEspectaculos = (Integer) tablaPersonas.getValueAt(filaActual, columnaDeInteresEspectaculos);
		Integer interesCiencia = (Integer) tablaPersonas.getValueAt(filaActual, columnaDeInteresCiencia);
		Integer interesMusica = (Integer) tablaPersonas.getValueAt(filaActual, columnaDeInteresMusica);

		Object[] datosDePersona = { nombre, interesDeportes, interesEspectaculos, interesCiencia, interesMusica };

		return datosDePersona;
	}

	private void cargarResultados(GeneradorDeGruposDePersonas gruposDePersonas) {
		List<String> grupoA = gruposDePersonas.obtenerGrupoA();
		List<String> grupoB = gruposDePersonas.obtenerGrupoB();

		cargarGrupoA(grupoA);
		cargarGrupoB(grupoB);
	}

	private void cargarGrupoA(List<String> grupoA) {
		for (int i = 0; i < grupoA.size(); i++) {
			String nombreActual = grupoA.get(i);

			tablaResultados.setValueAt(nombreActual, i, columnaDeGrupoA);
		}
	}

	private void cargarGrupoB(List<String> grupoB) {
		for (int i = 0; i < grupoB.size(); i++) {
			String nombreActual = grupoB.get(i);

			tablaResultados.setValueAt(nombreActual, i, columnaDeGrupoB);
		}
	}

	public void mostrar() {
		frame.setVisible(true);
	}
}
