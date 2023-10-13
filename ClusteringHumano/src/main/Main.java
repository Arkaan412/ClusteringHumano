package main;

import java.awt.EventQueue;

import vista.Pantalla;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla pantalla = new Pantalla();

					pantalla.mostrar();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
