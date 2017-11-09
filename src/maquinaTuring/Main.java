package maquinaTuring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Sof�a Pizarro - alu0100831696
 * @category CC - Pr�ctica2 - M�quina de Turing
 * @date 01/11/2017
 * @class Main
 **/
public class Main {
	
	static boolean aceptada = false;
	static boolean traza = false;
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {

		
		
		LeeFichero lee = new LeeFichero(args[0]);
		MaquinaTuring automata = new MaquinaTuring(lee.simula);
		BufferedReader fichbr = new BufferedReader(new InputStreamReader(System.in));
		
		menu();
				
		ArrayList<String> cadena = new ArrayList<String>();
		
		for(int i =0; i < automata.getCinta(); i++) {
			System.out.println("Cadena en la cinta" + i + ": ");
			cadena.add(fichbr.readLine());
		}
		
			aceptada = automata.ejecutar(cadena, traza);
		
		if (aceptada) {
			System.out.println("La cadena de entrada pertenece al lenguaje que reconoce el aut�mata con pila.");
		} else {
			System.out.println("La cadena de entrada no pertenece al lenguaje que reconoce el aut�mata con pila.");
		}

		teclado.close();
		
	}
	
	static int menu() {
		
		int elige = 0;
		
		System.out.println("Aut�mata con Pila - Pr�ctica 1");
		System.out.println("�Ejecutar en modo traza?");
		System.out.println("1. S�");
		System.out.println("2. No");
		System.out.println("3. Salir");
		elige = teclado.nextInt();
		
		do {
					
			switch (elige) {
			case 1: 
				traza = true;
				break;
			case 2:
				traza = false;
				break;
			case 3: 
				System.out.println("Hasta pronto.");
				System.exit(0);
	
			}
			
		}while (elige <= 0 || elige > 2);
		
		return elige;
	}
}
