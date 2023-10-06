package tests;

import java.util.Collection;

public class Asserts {
	public static <T> boolean compararColecciones(Collection<T> coleccionA, Collection<T> coleccionB) {
		if (coleccionA == null || coleccionB == null)
			return false;

		if (coleccionA.size() != coleccionB.size())
			return false;

		return coleccionA.containsAll(coleccionB);
	}
}
