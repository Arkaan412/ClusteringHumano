package vista;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.GeneradorDeGruposDePersonas;

import javax.swing.JTabbedPane;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Pantalla {

	private JFrame frame;
	private JTable tablaPersonas;
	private JTable tablaResultados;
	
	private int cantidadFilas;
	private int cantidadColumnas;
	
	private static final int columnaDePersonas = 0;
	
	private static final int columnaDeInteresDeportes = 1;
	private static final int columnaDeInteresMusica = 2;
	private static final int columnaDeInteresEspectaculos = 3;
	private static final int columnaDeInteresCiencia = 4;
	
	private static final int columnaDeGrupoA = 0;
	private static final int columnaDeGrupoB = 1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					Pantalla window = new Pantalla();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Pantalla() {
		this.cantidadFilas = 26;
		this.cantidadColumnas = 5;

		initialize();
	}

	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500); // Mas grande?. NO resizeable
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null); // Centrar en pantalla.
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 584, 461);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Personas y gustos", null, panel, "Personas y gustos");
		
		panel.setLayout(null);
		JScrollPane scrollPanePersonas = new JScrollPane();
		scrollPanePersonas.setBounds(0, 0, 579, 353);
		panel.add(scrollPanePersonas);
				
				
		tablaPersonas = new JTable();
		scrollPanePersonas.setViewportView(tablaPersonas);
		tablaPersonas.setCellSelectionEnabled(true);
		tablaPersonas.setColumnSelectionAllowed(true);
		
				tablaPersonas.setFillsViewportHeight(true);
				tablaPersonas.setModel(new DefaultTableModel(
					new Object[][] {
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
						{"", 0, 0, 0, 0},
					},
					new String[] {
						"Personas", " Deportes", " Noticias del espectáculo", " Ciencia", " Música"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, Integer.class, Integer.class, Integer.class, Integer.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
				tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(160);
				tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(130);
				tablaPersonas.getColumnModel().getColumn(2).setPreferredWidth(200);
				tablaPersonas.getColumnModel().getColumn(3).setPreferredWidth(115);
				tablaPersonas.getColumnModel().getColumn(4).setPreferredWidth(115);
			
		JButton botonGenerar = new JButton("Generar grupos");
		botonGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarGrupos();
			}
		});
		botonGenerar.setBounds(new Rectangle(11, 110, 111, 111));
		botonGenerar.setBounds(0, 353, 579, 80);
		panel.add(botonGenerar);
		
		JScrollPane scrollPaneResultados= new JScrollPane();
		tabbedPane.addTab("Resultados", null, scrollPaneResultados, "Resultados");

		tablaResultados = new JTable();
		tablaResultados.setColumnSelectionAllowed(true);
		tablaResultados.setCellSelectionEnabled(true);
		tablaResultados.setFillsViewportHeight(true);
		tablaResultados.setModel(new DefaultTableModel(
			new String[][] {
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
			},
			new String[] {
				"Grupo 1", "Grupo 2"
			}
		) {
			Class<?>[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablaResultados.getColumnModel().getColumn(0).setPreferredWidth(362);
		tablaResultados.getColumnModel().getColumn(1).setPreferredWidth(362);
		
		scrollPaneResultados.setViewportView(tablaResultados);
	}

	private void generarGrupos() {
		System.out.println(1);
		ArrayList<Object[]> datosDePersonas = obtenerDatosDePersonas();
		System.out.println(2);
		
		GeneradorDeGruposDePersonas gruposDePersonas = Controlador.generarGruposDePersonas(datosDePersonas);
		System.out.println(3);
		
		cargarResultados(gruposDePersonas);
		System.out.println(4);
	}

	private ArrayList<Object[]> obtenerDatosDePersonas() {
		ArrayList<Object[]> datosDePersonas = new ArrayList<>();

		for (int i = 0; i < cantidadFilas; i++) {
			String stringDeFilaActual = (String) tablaPersonas.getValueAt(i, columnaDePersonas);

			boolean esStringVacio = stringDeFilaActual.equals("");

			if (!esStringVacio) {

				String nombre = stringDeFilaActual;

				Integer interesDeportes = (Integer) tablaPersonas.getValueAt(i, columnaDeInteresDeportes);
				Integer interesMusica = (Integer) tablaPersonas.getValueAt(i, columnaDeInteresMusica);
				Integer interesEspectaculos = (Integer) tablaPersonas.getValueAt(i, columnaDeInteresEspectaculos);
				Integer interesCiencia = (Integer) tablaPersonas.getValueAt(i, columnaDeInteresCiencia);

				Object[] datosDePersona = { nombre, interesDeportes, interesMusica, interesEspectaculos,
						interesCiencia };

				datosDePersonas.add(datosDePersona);
			}
		}

		return datosDePersonas;
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
