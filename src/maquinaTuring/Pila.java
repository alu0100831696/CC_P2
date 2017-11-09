/*package maquinaTuring;

import java.util.ArrayList;
import java.util.Stack;

*//**
 * @author Sofía Pizarro - alu0100831696
 * @category CC - Práctica1 - Autómata con Pila
 * @date 22/10/2017
 * @class Pila
 **//*

public class Pila {
	private Stack<String> pila = new Stack<String>();
	private ArrayList<String> pilaArray = new ArrayList<String>();

	// Constructor
	Pila(ArrayList<String> simbolo) {
		pilaArray = simbolo;
	}

	@SuppressWarnings("unchecked")
	// Constructor copia
	Pila(Pila original) {
		pila = (Stack<String>) original.pila.clone();
		pilaArray = (ArrayList<String>) original.pilaArray.clone();
	}

	public String consultar() {
		return pila.peek();
	}

	public String extraer() {
		return pila.pop();
	}

	public void insertar(ArrayList<String> simbolos) {
		if (!simbolos.get(0).equals(".")) {
			for (int i = simbolos.size() - 1; i >= 0; i--) {
				if (pilaArray.contains(simbolos.get(i))) {
					pila.push(simbolos.get(i));
				} else {
					System.err.println("Este símbolo no pertenece al alfabeto de la pila: " + simbolos.get(i));
					System.exit(1);
				}
			}
		}
	}

	public int size() {
		return pila.size();
	}

	public boolean siVacia() {
		return pila.isEmpty();
	}

	public String getPila() {
		String aux = "";
		for (String item : pila) {
			aux += " " + item;
		}
		return aux;
	}
}
*/