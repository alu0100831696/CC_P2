package maquinaTuring;

/**
 * @author Sofía Pizarro - alu0100831696
 * @category CC - Práctica1 - Autómata con Pila
 * @date 22/10/2017
 * @class MaquinaTuring
 **/
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

public class MaquinaTuring {
	
	private Hashtable<String, EstadosQ> estados = new Hashtable<String, EstadosQ>();
	private EstadosQ estadoAct;
	private Cinta cinta;
	//private Pila pila;
	private Alfabeto alfabeto;
	private Stack<Transicion> transcn = new Stack<Transicion>();
	private String vacio;
	private int cintas;
	//private int estadoFin = 0;

	//Constructor
	MaquinaTuring(ArrayList<ArrayList<String>> simula) {
		
		for (String i : simula.get(0)) {						//estados
			estados.put(i, new EstadosQ(i));
		}
		
		alfabeto = new Alfabeto(simula.get(1));
		estadoAct = estados.get(simula.get(3).get(0));
		vacio = simula.get(4).get(0);
		for (String i : simula.get(5)) {
			if (estados.containsKey(i)) {
				estados.get(i).setFinal();
			} else {
				System.err.println("El conjunto de estados finales contiene un estado erróneo: " + i);
				System.exit(1);
			}
		}
		cintas = Integer.parseInt(simula.get(6).get(0));
		cinta = new Cinta(simula.get(2), cintas, vacio);
		for (int i = 7; i < simula.size(); i++) {
			if (estados.containsKey(simula.get(i).get(0))) {
				estados.get(simula.get(i).get(0)).insertarTranscn(simula.get(i), cintas);
			} else {
				System.err.println("Existe una función de transición que transita desde un estado erróneo: "
						+ simula.get(i));
				System.exit(1);
			}
		}
	}


	public boolean ejecutar(ArrayList<String> cadena, boolean traza) {
				
				for (int i = 0; i < cadena.size(); i++) {
					for (int j = (cadena.get(i).length() - 1); j >= 0; j--) {
						if (!alfabeto.contiene("" + cadena.get(i).charAt(j))) {
							System.err
							.println("Este símbolo no pertenece al alfabeto de la cinta: ");
							System.exit(1);
						} 
					}
				}

				cinta.setCinta(cadena);
				boolean ejecutando = true;
				boolean aceptada = false;

				while (ejecutando) {
					ArrayList<FuncionDeTransicion> transPosActual = estadoAct.explorar(cinta.read());
					if (traza) {
						String aux = "";
						for (FuncionDeTransicion t : transPosActual) {
							aux += t.getSiguiente() + " ";
						}

						System.out.println(estadoAct.getId() + " | " + cinta + aux);
					}
					for (FuncionDeTransicion tran : transPosActual) {
						transcn.push(new Transicion(new Cinta(cinta), tran));
					}
					if (transPosActual.isEmpty() && estadoAct.esFinal()) {
						ejecutando = false;
						aceptada = true;
					} else if (transPosActual.isEmpty() && !estadoAct.esFinal() && transcn.isEmpty()) {
						ejecutando = false;
						aceptada = false;
					} else {
						Transicion aux = transcn.pop();
						if (estados.containsKey(aux.getFtran().getSiguiente())) {
							estadoAct = estados.get(aux.getFtran().getSiguiente());
						} else {
							System.err
							.println("Se ha intentado transitar a un estado erróneo: " + aux.getFtran().getSiguiente());
							System.exit(1);
						}
						cinta = aux.getCinta();
						cinta.write(aux.getFtran().escritura());
						for (int i = 0 ; i < cintas ; i++){
							if (aux.getFtran().movimiento(i).equals("R")) {
								cinta.moveRight(i);
							} else if (aux.getFtran().movimiento(i).equals("L")) {
								cinta.moveLeft(i);
							} else if (aux.getFtran().movimiento(i).equals("S")){

							} else {
								System.err
								.println("Movimiento no permitido: " + aux.getFtran().movimiento(i));
								System.exit(1);
							}
						}

					}
				}
				return aceptada;
			}
	
	
	public int getCinta() {
		return cintas;
	}
}
