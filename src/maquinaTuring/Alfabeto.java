package maquinaTuring;

/**
 * @author Sof�a Pizarro - alu0100831696
 * @category CC - Pr�ctica1 - Aut�mata con Pila
 * @date 03/11/2017
 * @class Alfabeto
 **/

import java.util.ArrayList;

public class Alfabeto {

	private ArrayList<String> alfabeto = new ArrayList<String>();

	//Constructor
	Alfabeto(ArrayList<String> entrada) {
		alfabeto = entrada;

	}

	//Constructor de copia
	@SuppressWarnings("unchecked")
	Alfabeto(Alfabeto original) {
		alfabeto = (ArrayList<String>) original.alfabeto.clone();
	}

	// Devuelve true si pertenece al alfabeto
	public boolean contiene(String caracter) {
		boolean aux = false;
		for (String a : alfabeto) {
			if (a.equals(caracter)) {
				aux = true;
			}
		}
		return aux;
	}
}
