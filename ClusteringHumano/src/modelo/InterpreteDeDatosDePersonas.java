package modelo;

import java.util.ArrayList;
import java.util.List;

public class InterpreteDeDatosDePersonas {

	public static List<Persona> generarPersonas(ArrayList<Object[]> datosDePersonas) {
		if (datosDePersonas.isEmpty()) throw new IllegalArgumentException("No se ingresaron datos.");
		
		ArrayList<Persona> personas = new ArrayList<>();

		for (Object[] datosDePersona : datosDePersonas) {
			String nombre = (String) datosDePersona[0];
			if (nombre == null) nombre = "null";

			validarDatosNumericos(datosDePersona);

			int interesDeportes = (int) datosDePersona[1];
			int interesEspectaculos = (int) datosDePersona[2];
			int interesCiencia = (int) datosDePersona[3];
			int interesMusica = (int) datosDePersona[4];

			personas.add(new Persona(nombre, interesDeportes, interesEspectaculos, interesCiencia, interesMusica));
		}

		return personas;
	}

	private static void validarDatosNumericos(Object[] datosDePersona) {
		for (int i = 0; i < datosDePersona.length; i++) {
			if (datosDePersona[i] == null) {
				datosDePersona[i] = 0;
			}
		}
	}
}
