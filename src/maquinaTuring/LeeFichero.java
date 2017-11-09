package maquinaTuring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Sofía Pizarro - alu0100831696
 * @category CC - Práctica1 - Autómata con Pila
 * @date 22/10/2017
 * @class LeeFichero
 **/

public class LeeFichero {
	private FileReader fin = null;
	private BufferedReader bin = null;
	String linea;
	public ArrayList<ArrayList<String>> simula = new ArrayList<ArrayList<String>>();

	LeeFichero(String file) {
		try {
			fin = new FileReader(file);
			bin = new BufferedReader(fin);
			linea = bin.readLine();
			
			while (linea != null) {
				String[] token = linea.split("\\s");
				ArrayList<String> sentencia = new ArrayList<String>();
				for (String st : token) {
					if (st.matches("#.*") | token.length == 0) {
						break;
					} else {
						sentencia.add(st);
					}
				}
				if (sentencia.size() >= 1) {
					simula.add(sentencia);
				}
				linea = bin.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
