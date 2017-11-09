package maquinaTuring;

/**
 * @author Sofía Pizarro - alu0100831696
 * @category CC - Práctica1 - Autómata con Pila
 * @date 22/10/2017
 * @class Cinta
 **/

import java.util.ArrayList;


public class Cinta {
	private final int CINTA_TAM = 1000;
	private Alfabeto alfabeto;
	private ArrayList<ArrayList<String>> valores;
	private ArrayList<Integer> puntero = new ArrayList<Integer>();
	private int cinta;
	private String resetCinta;
	private int valorMax = 0;
	private int valorMin = 0;
	

	// Constructor
	Cinta(ArrayList<String> alp, int cinta, String resetCinta) {
		alfabeto = new Alfabeto(alp);
		this.cinta = cinta;
		this.resetCinta = resetCinta;
		valores = new ArrayList<ArrayList<String>>(cinta);
		for (int i = 0; i < cinta; i++) {
			valores.add(new ArrayList<String>(CINTA_TAM));
		}
		
		for (int i = 0; i < CINTA_TAM; i++) {
			for (int j = 0; j < cinta; j++) {
				valores.get(j).add(resetCinta);
			}
		}
		for (int i = 0; i < cinta; i++) {
			puntero.add(0);
		}
	}

	// Constructor copia
	@SuppressWarnings("unchecked")
	Cinta(Cinta original) {
		valores = (ArrayList<ArrayList<String>>) original.valores.clone();
		alfabeto = new Alfabeto(original.alfabeto);
		puntero = (ArrayList<Integer>) original.puntero.clone();
		cinta = original.cinta;
		valorMax = original.valorMax;
		valorMin = original.valorMin;
	}

	public ArrayList<String> read() {
		ArrayList<String> aux = new ArrayList<String>();
		for (int i = 0; i < cinta; i++) {
			aux.add(valores.get(i).get(punterosMed().get(i)));
		}
		return aux;
	}
	
	public void write(ArrayList<String> datos) {
		for (int i = 0; i < cinta; i++) {
			if (alfabeto.contiene(datos.get(i))) {
				valores.get(i).set(punterosMed().get(i), datos.get(i));
			} else {
				System.err.println("Este símbolo no pertenece al alfabeto de la cinta: ");
				System.exit(1);
			}
		}
	}

	public void moveRight(int cinta) {
		puntero.set(cinta, (puntero.get(cinta) - 1));
		if (valorMin > puntero.get(cinta)){
			valorMin = puntero.get(cinta);
		}
	}

	public void moveLeft(int cinta) {

		puntero.set(cinta, (puntero.get(cinta) + 1));
		if (valorMax < puntero.get(cinta)){
			valorMax = puntero.get(cinta);
		}

	}


	public void setCinta(ArrayList<String> cadena) {
		for (int i = 0; i < cadena.size(); i++) {
			int k = 0;
			for (int j = (cadena.get(i).length() - 1); j >= 0; j--) {

				if (alfabeto.contiene("" + cadena.get(i).charAt(j))) {
					valores.get(i).set(k, "" + cadena.get(i).charAt(j));
				} else {
					System.err
					.println("Este símbolo no pertenece al alfabeto de la cinta: ");
					System.exit(1);
				}
				k++;
			}
		}
		for (String aux : cadena) {
			if (aux.length() > valorMax) {
				valorMax = aux.length();
			}
		}
		for (int i = 0; i < cinta ; i++){
			puntero.set(i, valorMax-1);
		}

	}
	
	public String toString() {
		String aux = "";
		for (int i = 0; i < cinta; i++) {
			for (int j = valorMax ; j >= valorMin; j--) {
				if (pNorm(j) == punterosMed().get(i)) {
					aux += "[" + valores.get(i).get(pNorm(j)) + "] ";
				} else {
					aux += valores.get(i).get(pNorm(j)) + " ";
				}
			}
			aux += " | ";
		}
		return aux;
	}

	private ArrayList <Integer> punterosMed(){
		ArrayList <Integer> aux = new ArrayList <Integer>();
		for (int p : puntero){
			aux.add(((p%CINTA_TAM)+CINTA_TAM)%CINTA_TAM);
		}
		return aux;
	}

	private int pNorm(int n){
		return ((n%CINTA_TAM)+CINTA_TAM)%CINTA_TAM;
	}

}
