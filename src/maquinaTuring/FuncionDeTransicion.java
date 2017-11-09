package maquinaTuring;

/**
 * @author Sofía Pizarro - alu0100831696
 * @category CC - Práctica1 - Autómata con Pila
 * @date 22/10/2017
 * @class FunTranscn
 **/

import java.util.ArrayList;

public class FuncionDeTransicion {
	private ArrayList<String> lee = new ArrayList<String>();
	private ArrayList<String> escribe = new ArrayList<String>();
	private String siguiente;
	//private String movimiento;
		private ArrayList<String> movimiento  = new ArrayList<String>();
		private int cinta;

	//Constructor
	FuncionDeTransicion(ArrayList<String> func, int cinta) {
		for (int i = 0; i < cinta; i++) {
			lee.add(func.get(i + 1));
		}
		siguiente = func.get(cinta + 1);
		for (int i = 0; i < cinta; i++) {
			escribe.add(func.get(i + cinta + 2));
		}
		for (int i = 0; i < cinta; i++) {
			movimiento.add(func.get(2 * cinta + 2 + i));
		}
		this.cinta = cinta;
	}

	public ArrayList<String> lectura() {
		return lee;
	}

	public ArrayList<String> escritura() {
		return escribe;
	}

	public String getSiguiente() {
		return siguiente;
	}
	
	public String movimiento(int cintaN) {
		return movimiento.get(cintaN);
	}

	public boolean transita(ArrayList<String> lectura) {
		boolean aux = true;
		for (int i = 0; i < cinta; i++) {
			if (!lectura.get(i).equals(lee.get(i))) {
				aux = false;
			}
		}
		return aux;
	}


}
