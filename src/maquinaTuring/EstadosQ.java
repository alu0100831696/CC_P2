package maquinaTuring;

/**
 * @author Sofía Pizarro - alu0100831696
 * @category CC - Práctica1 - Autómata con Pila
 * @date 22/10/2017
 * @class EstadosQ
 **/

import java.util.ArrayList;

public class EstadosQ {
	
	private ArrayList<FuncionDeTransicion> funtranscn = new ArrayList<FuncionDeTransicion>();
	private boolean esFinal = false;
	private String id;

	// Constructor
	EstadosQ(String identificador) {
		id = identificador;
	}

	public void insertarTranscn(ArrayList<String> func, int cinta) {
		funtranscn.add(new FuncionDeTransicion(func, cinta));
	}

	public ArrayList<FuncionDeTransicion> getTranscn() {
		return funtranscn;
	}


	// Exploramos la sposibles transiciones 
	//recibe el caracter en la pila y la cinta
	public ArrayList<FuncionDeTransicion> explorar(ArrayList<String>  lee) {
		ArrayList<FuncionDeTransicion> aux = new ArrayList<FuncionDeTransicion>();
		for (FuncionDeTransicion func : funtranscn) {
			if (func.transita(lee)) {
				aux.add(func);
			}
		}
		return aux;
	}


	public String getId() {
		return id;
	}
	
	public boolean esFinal() {
		return esFinal;
	}
	
	public void setFinal() {
		esFinal = true;
	}
}
