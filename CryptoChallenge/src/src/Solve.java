package src;

import java.util.ArrayList;
import java.util.Arrays;

public class Solve {

	public static ArrayList<int[]> rmNull(int[][] m, int length) {
		// l�nge der Zeilen
		length = length * length;
		ArrayList<int[]> o = new ArrayList<int[]>();
		ArrayList<int[]> l = new ArrayList<int[]>(Arrays.asList(m));
		boolean oneFound = false;
		
		// vergleichs-Array f�r 0 Zeilen
		int[] test = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		//schleife f�r Zeilen
		for (int i = 0; i < l.size(); i++) {
			//Schleife f�r Spalten
			for (int j = 0; j < l.get(i).length; j++) {
				if (l.get(i)[j] == 1) { //Falls 1 gefunden in Zeile i
					oneFound = true;
				}
			}
			if (oneFound == false) { //Zeile entfernen, falls keine 1 gefunden wurde
				l.remove(i);
			}
			oneFound = false; // r�cksetzten des Wertes f�r n�chste zeile
		}
		// verschieben alle beschriebenen Zeilen in neue Matrix
		for (int i = 0; i < l.size(); i++) {
			if (Arrays.equals(l.get(i), test)) {
			} else {
				o.add(i, l.get(i));
			}
		}
		
		// Ausgabe der Matrix
		for (int i = 0; i < o.size(); i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(o.get(i)[j] + " ");
			}
			System.out.println();
		}
		return o; //R�ckgabe der Matrix
	}

	public static ArrayList<int[]> aufrollen(int[][] m, int[][] lsg) {
		int[] temp = new int[m[0].length];
		int rndCount = 0, countOne = 0; // Z�hlen der bereits festgestellten einsen und der noch unbest�tigketen in einer Zeile
		
		// Hilfs-listen/Matritzen f�r die Rekursion
		ArrayList<int[]> templ2 = new ArrayList<int[]>();
		ArrayList<int[]> templ1 = new ArrayList<int[]>();
		int[][] templsg2 = new int[m.length][m[0].length];
		int[][] tempm2 = new int[m.length - 1][m[0].length];
		int[][] templsg1 = new int[m.length][m[0].length];
		int[][] tempm1 = new int[m.length - 1][m[0].length];
		// Alle Zeilen durchgehen
		for (int i = m.length - 1; i >= 0; i--) {
			// Alle Spalten einer Zeile durchgehen und "unbekannte" einsem notieren in temp array
			for (int j = m[0].length - 1; j >= 0; j--) {
				if (m[i][j] == 1 && lsg[0][j] == lsg[1][0]) {
					rndCount++;
					temp[j] = 1;
				}
			}
			// 
			for (int k = 0; k < m[0].length; k++) {
				// Z�hlen Welche einsen bekannt sind
				if (lsg[0][k] == 1 && temp[k] == 1) {
					countOne++;
				}
				// Z�hlen Welche einen keine aussage treffen
				if (lsg[0][k] == 0 && temp[k] == 1) {
					rndCount--;
				}
			}
			// Pr�fen ob sich l�sungsm�glichkeit auftrennt
			if ((rndCount - countOne) % 2 == 0) {
				tempm1 = m;
				for (int l = m[0].length - 1; l >= 0; l--) {
					if (temp[l] == 1) {
						lsg[0][l] = 1;
						templsg1[0][l] = 0;
					}
				}
				//Rekursiv neuer Aufruf f�r neue L�sungsm�glichekit (mit verkleinerter matrix)
				templ1 = Solve.aufrollen(tempm1, templsg1);
				// Pr�fen ob sich l�sungsm�glichkeit auftrennt
			} else if ((rndCount) % 2 == 0 && rndCount != 1) {

				boolean second = false;
				tempm2 = m;
				for (int l = m[0].length - 1; l >= 0; l--) {
					if (temp[l] == 1 && !second) {
						lsg[0][l] = 1;
						templsg2[0][l] = 0;
						second = true;
					} else if (temp[l] == 1 && second) {
						lsg[0][l] = 0;
						templsg2[0][l] = 1;
					}
				}
				//Rekursiv neuer Aufruf f�r neue L�sungsm�glichekit (mit verkleinerter matrix)
				templ2 = Solve.aufrollen(tempm2, templsg2);

			}
		}
		// Neue Arraylist f�r endg�ltige L�sung
		ArrayList<int[]> loesung = new ArrayList<int[]>(Arrays.asList(lsg));
		//Errechnete L�sungend der rekursiv aufrufe in die L�sung aufnehmen
		if (!templ1.isEmpty()) {
			loesung.addAll(templ1);
		}
		if (!templ2.isEmpty()) {
			loesung.addAll(templ2);
		}
		//r�ckgabe der L�sung
		return loesung;

	}

	public static ArrayList<int[]> einsetzen(ArrayList<int[]> m, int[] c) {
		//Matrix in zweidimensionales Array aufnehmen
		int[][] l = new int[m.size()][m.get(0).length];
		l = m.toArray(l);
		
		
		int r = 0;
		// alle Zeilen durchiterieren
		for (int i = 0; i < m.size(); i++) {
			// alle spalten durchiterieren
			for (int j = 0; j < m.get(0).length; j++) {
				r = Math.round(j / c.length); // Richtiges Array des Chiffrats errechnen
				//Vergleichen, ob Chiffrat und x = 1 sind, falls ja 1 einf�gen ansonsten 0
				if (m.get(i)[j] == 1 && c[r] == 1) {
					l[i][j] = 1;
				} else {
					l[i][j] = 0;
				}
			}
		}
		// nullen entfernen
		rmNull(l, c.length);
		
		ArrayList<int[]> loesung = new ArrayList<int[]>(Arrays.asList(l));
		
		//R�ckgabe der neuen Matrix
		return loesung;
	}

}
