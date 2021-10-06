package com.grupocastores.mcc.xml;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/**
* Título                    : SearchText.java
* Descripción               : Busca Coincidencia en el texto
* Compañía                  : Transportes Castores de Baja California S.A. de C.V. – Área de Desarrollo
* Fecha de creación         : 2021-10-06
* Autor                     : Jesús Ruiz Pacheco 
* Versión                   : 1.0.0.0
* ID Requerimiento/Ticket   : NULL
*/
public class SearchText {

	public String text;

	public char array[];

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public char[] getArray() {
		return array;
	}

	public void setArray(char[] array) {
		this.array = array;
	}

	 /**
	 * Título                    : SearchString()
	 * Descripción               : Funcion para buscar coincidencia en un texto
	 * Compañía                  : Transportes Castores de Baja California S.A. de C.V. – Área de Desarrollo
	 * Fecha de creación         : 2021-10-06
	 * Autor                     : Jesús Ruiz Pacheco 
	 * Versión                   : 1.0.0.0
	 * ID Requerimiento/Ticket   : NULL
	 * 
	 * @return true o false si encuentra o no una coincidencia
	 */
	public boolean SearchString() {
		HashMap<Integer, Character> hm = new HashMap<Integer, Character>();

		this.text = this.text.toLowerCase(); // texto a Minusculas

		boolean is_letra[] = new boolean[this.array.length];

		/*
		 * Busca coincidencias en la cadena y guarda la posicion en la que se encontro
		 */
		for (int x = 0; x < array.length; x++) {
			for (int i = -1; (i = text.indexOf(array[x], i + 1)) != -1; i++) {
				hm.put(i, array[x]);
			}
		}

		/*
		 * Ordenadamente Itera las coincidencias Valida que cumpla el orden y retorna
		 * TRUE de lo contrario retorna FALSE
		 */
		TreeMap<Integer, Character> tm = new TreeMap<Integer, Character>(hm);
		Iterator<Integer> itr = tm.keySet().iterator();
		int contadorvanderas = 0;
		int contador = 0;
		while (itr.hasNext()) {
			int key = (int) itr.next();
			Character letra = hm.get(key);

			if (letra.equals(array[contadorvanderas])) {
				contadorvanderas++;
			}

			for (int x = 0; x < is_letra.length; x++) {
				if (contadorvanderas == (x + 1)) {
					is_letra[x] = true;
					break;
				}
			}

			contador = 0;
			for (int x = 0; x < is_letra.length; x++) {
				if (is_letra[x]) {
					contador++;
				}
			}

			if (contador == is_letra.length) {
				System.out.println("no: " + key + " name: " + letra + " [ SUCCESS ]");
				return true;
			} else {
				System.out.println("no: " + key + " name: " + letra);
			}
		}
		return false;
	}
}
