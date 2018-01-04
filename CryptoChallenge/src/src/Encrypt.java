package src;

import java.io.*;
import java.util.*;

public class Encrypt {

	private static char[] buffer;
	private static int[] message;
	private static String pKey;

	public static void setKey(String filename) throws IOException {
		
		
		//Reader zum einlesen aus der .txt datei
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		//nur benötigt für die länge des Buffers 
		File f = new File(filename);

		buffer = new char[(int) f.length()];

		br.read(buffer);
		br.close();

		pKey = getKeyString(buffer);
	}

	public static void printPk() {

		System.out.println(pKey);

	}

	public static void setMessage(int[] message) {
		Encrypt.message = message;
	}

	public static int addBin(int a, int b) {

		int result = 0;

		if (a == 0 && b == 0) // 0+0 = 0
			result = 0;
		else if (a == 1 && b == 1) // 1+1 = 0
			result = 0;
		else if (a != b)  // 1+0=1 0+1=1
			result = 1;

		return result;

	}

	public static int multiBin(int a, int b) {
		int result = 0;
		
		
		//Return ist nur 1 wenn beide Faktoren 1 sind
		if (a == 1 && b == 1)
			result = 1;

		return result;
	}

	public static int getValueFromArray(String summand) {

		int value = 0, index = 0;

		if (summand.length() == 4) {
			// Bsp x_10 -> length = 4 -> substring 2,4 = "10" -> int 10
			index = Integer.parseInt(summand.substring(2, 4));

		} else if (summand.length() == 3) {
			// Bsp x_1 -> length = 3 -> substring 2,3 = "1" -> int 1 
			index = Integer.parseInt(summand.substring(2, 3));
		}
		
		value = message[index - 1];

		return value;
	}

	public static int resolveSummand(String summand) {

		int length = summand.length();
		int result = 0;
		if (length < 6) {
			result = getValueFromArray(summand);
		} else if (length > 6) {
			List<String> splitted = new ArrayList<String>(Arrays.asList(summand.split("\\*")));

			result = multiBin(getValueFromArray(splitted.get(0)), getValueFromArray(splitted.get(1)));
		}
		return result;
	}

	public static int doCalcLine(char[] c) {

		String summand = "";
		int count = 0;
		int result = 0;
		List<Integer> temp = new ArrayList<Integer>();

		// durchlaufe gesamten Ausdruck
		for (int i = 0; i < c.length; i++) {

			// summand ende! 
			if (c[i] == '+') {

				temp.add(resolveSummand(summand));
				//summand zurücksetzen
				summand = "";

			}

			else if (c[i] != 32 && c[i] != 10 && c[i] != 9 && c[i] != 13) { // Auf Zeichen prüfen die wir nicht wollen,  \n, \t

				summand = summand + c[i];
			}

			// in the end do shit anyway
			if (i == c.length - 1)
				temp.add(resolveSummand(summand));

		}
		// 1en Zählen für addition in der Zeile -> gerade Endergebnis 0 
		//ungerade Endergebnis 1
		for (int j = 0; j < temp.size(); j++) {

			if (temp.get(j) == 1)
				count++;
		}
		// System.out.println(temp.toString());

		if (count % 2 == 0)
			result = 0;
		else
			result = 1;

		return result;
	}

	private static String getKeyString(char[] mist) {
		String privKey = "";
		int read = 0, offset = 0;

		while (read != 'x') { // nach x, Anfang des Public Keys suchen
			read = buffer[offset];
			offset++;
		}

		while (read != 93) { // nach ], Ende des Public Keys suchen
			privKey = privKey + (char) read;
			read = buffer[offset];
			offset++;
		}

		return privKey;
	}

	public static int[] runEncryption() {

		int[] output = new int[message.length];

		// in die einzelnen Zeilen splitten
		List<String> expressions = new ArrayList<String>(Arrays.asList(pKey.split(",")));

		
		//Führe Berechnung für jede Zeile aus
		for (int i = 0; i < output.length; i++) {
			// System.out.println(expressions.get(i));
			output[i] = doCalcLine(expressions.get(i).toCharArray());
		}
		return output;
	}

	public static int[] createMatrixLine(int[] plain, int[] cipher) {

		int[] result = new int[plain.length * cipher.length];

		for (int i = 0; i < plain.length; i++) {

			if (plain[i] == 1) { // schreibe cipher in result
				for (int j = 0; j < plain.length; j++) {
					result[j + (cipher.length * i)] = cipher[j];
				}
			} else { //fülle 0en in result
				for (int j = 0; j < plain.length; j++) {
					result[j + (plain.length * i)] = 0;
				}
			}

		}
		// System.out.println("Cipher:" + Arrays.toString(cipher));
		// System.out.println("Plain:" + Arrays.toString(plain));
		// System.out.println("Ergebnis MatrixZeile" +
		// Arrays.toString(result));
		return result;
	}

	public static int[][] create(int lengthplain) {

		int lines = 2 * (lengthplain * lengthplain);
		int[] plain = new int[lengthplain];
		int[] cipher;
		int[][] resMatrix = new int[lines][lengthplain * lengthplain];
		int[][] plains = new int[lines][lengthplain];
		int[][] ciphers = new int[lines][lengthplain];

		// Erstellen der Klartexte
		for (int i = 0; i < lines; i++) {

			for (int j = 0; j < plain.length; j++) {
				plains[i][j] = (int) Math.round(Math.random());
			}
		}

		// Diese verschlüsseln
		for (int k = 0; k < lines; k++) {

			setMessage(plains[k]);
			cipher = runEncryption();
			ciphers[k] = cipher;
		}
		// resultierende Zeilen in Matrix schreiben
		for (int l = 0; l < lines; l++) {

			resMatrix[l] = createMatrixLine(plains[l], ciphers[l]);

		}
		// Ausgabe der Matrix
		/*
		 * System.out.println("Resultierende Matrix:\n"); for (int i = 0; i <
		 * lines; i++) { System.out.println(Arrays.toString(resMatrix[i])); }
		 */
		return resMatrix;
	}

	public static int[][] swapLine(int[][] matrix, int line1, int line2) {

		int[] temp = new int[matrix[0].length];

		temp = matrix[line1];
		matrix[line1] = matrix[line2];
		matrix[line2] = temp;

		return matrix;

	}

	public static int[] eliminate(int[] line1, int[] line2) {

		for (int i = 0; i < line1.length; i++) {

			line1[i] = addBin(line1[i], line2[i]);

		}

		return line1;

	}

	public static int[][] gaussianElimination(int[][] input) {

		int indexpivot = 0;

		// just a copy for output
		int[][] old = new int[input.length][input[0].length];

		for (int i = 0; i < input.length; i++) {

			for (int j = 0; j < input[0].length; j++) {

				old[i][j] = input[i][j];

			}

		}
		// schleife für die spalten
		for (int i = 0; i < input[0].length; i++) {
			
			// spalten nach unten ablaufen
			for (int j = i + 1; j < input.length; j++) {
				
				// Keine 1 am Anfang-> tauschen
				if (input[i][i] == 0) {
					
					// suche nächste Zeile mit pivot element
					indexpivot = findNextPivot(input, i);
					if (indexpivot > 0)
						input = swapLine(input, i, indexpivot);
					
					// kein weiteres pivot gefunden
					else {
						//eventuell Zeilen hochtauschen
					}
				}
				// nach unten die 1en für die spalte eliminieren
				if (input[j][i] == 1)
					input[j] = eliminate(input[j], input[i]);

			}
			// System.out.println("Matrix nach schritt:"+ i +"\n");
			// for (int k = 0; k < input.length; k++) {
			// System.out.println(Arrays.toString(input[k]));
			// }

		}
		
		System.out.println("Input Matrix:\n"); for (int i = 0; i <
		input.length; i++) { System.out.println(Arrays.toString(old[i])); }
		 
		System.out.println("Output Matrix:\n");
		for (int i = 0; i < input.length; i++) {
			System.out.println(Arrays.toString(input[i]));
		}
		return input;
	}

	public static int findNextPivot(int[][] matrix, int col) {

		int pivotindex = 0;

		for (int index = col; index < matrix.length; index++) {

			if (matrix[index][col] == 1) {

				pivotindex = index;

			}
		}

		if (pivotindex == 0)
			return -1;
		else
			return pivotindex;

	}

	public static List<int[]> getSolutions(int[][] matrix) {

		// Ax=b b ist hier null vektor

		List<int[]> solutions = new ArrayList<>();

		for (int i = matrix.length - 1; i > 0; i--) {

			for (int k = matrix[0].length; k > 0; k--) {

			}

		}

		return solutions;
	}

}
