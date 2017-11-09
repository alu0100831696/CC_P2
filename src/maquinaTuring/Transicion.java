package maquinaTuring;

/**
 * @author Sofía Pizarro - alu0100831696
 * @category CC - Práctica1 - Autómata con Pila
 * @date 22/10/2017
 * @class Transicion
 **/

public class Transicion {
	private FuncionDeTransicion ftran = null;
	private Cinta cinta = null;
	//private Pila pila = null;

	Transicion(Cinta c, FuncionDeTransicion n) {
		ftran = n;
		cinta = new Cinta(c);
		
	}

	public FuncionDeTransicion getFtran() {
		return ftran;
	}

	public Cinta getCinta() {
		return cinta;
	}

}

