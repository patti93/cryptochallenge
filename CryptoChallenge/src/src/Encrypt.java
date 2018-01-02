package src;

import java.io.*;
import java.util.*;

public class Encrypt {

    private static char[] buffer;
    private static int[] message;
    private static String pKey;
 
    public static void setKey(String filename) throws IOException{
	
	FileReader fr = new FileReader(filename);
	BufferedReader br = new BufferedReader(fr);

	File f = new File(filename);

	buffer = new char[(int) f.length()];

	br.read(buffer);
	br.close();

	pKey = getKeyString(buffer);
    }
    
    
    
    public static void setMessage(int[] message) {
	Encrypt.message = message;
    }

    public static int addBin(int a, int b) {

	int result = 0;

	if (a == 0 && b == 0)
	    result = 0;
	else if (a == 1 && b == 1)
	    result = 0;
	else
	    result = 1;

	return result;

    }

    public static int multiBin(int a, int b) {
	int result = 0;

	if (a == 1 && b == 1)
	    result = 1;

	return result;
    }

    public static int getValueFromArray(String shit) {

	int value = 0, index = 0;

	if (shit.length() == 4) {

	    index = Integer.parseInt(shit.substring(2, 4));

	} else if (shit.length() == 3) {

	    index = Integer.parseInt(shit.substring(2, 3));
	}
	// System.out.println(shit);
	// System.out.println(index);
	value = message[index - 1];

	return value;
    }

    private static int doShit(String shit) {

	int length = shit.length();
	int result = 0;
	if (length < 6) {
	    result = getValueFromArray(shit);
	} else if (length > 6) {
	    List<String> splitted = new ArrayList<String>(Arrays.asList(shit.split("\\*")));

	    result = multiBin(getValueFromArray(splitted.get(0)), getValueFromArray(splitted.get(1)));
	}
	return result;
    }

    private static int doCalcLine(char[] c) {

	String summand = "";
	int value = 0, count = 0;
	int result = 0;
	List<Integer> temp = new ArrayList<Integer>();

	// durchlaufe gesamten Ausdruck
	for (int i = 0; i < c.length; i++) {

	    // summand ende!
	    if (c[i] == '+') {

		value = doShit(summand);
		temp.add(value);
		summand = "";

	    }

	    else if (c[i] != 32 && c[i] != 10 && c[i] != 9) {
		summand = summand + c[i];
	    }

	}
	// 1en Zählen für addition in der Zeile -> gerade Endergebnis 0 ungerade
	// Endergebnis 1
	for (int j = 0; j < temp.size(); j++) {

	    if (temp.get(j) == 1)
		count++;
	}

	if (count % 2 == 0)
	    result = 0;
	else
	    result = 1;

	return result;
    }

    private static String getKeyString(char[] mist) {
	String privKey = "";
	int read = 0, offset = 0;

	while (read != 'x') { // nach x suchen
	    read = buffer[offset];
	    offset++;
	}

	while (read != 93) {
	    privKey = privKey + (char) read;
	    read = buffer[offset];
	    offset++;
	}

	return privKey;
    }

    public static  int[] runEncryption() {

	int[] output = new int[message.length];

	// in die einzelnen Zeilen splitten
	List<String> expressions = new ArrayList<String>(Arrays.asList(pKey.split(",")));

	for (int i = 0; i < output.length; i++) {
	    output[i] = doCalcLine(expressions.get(i).toCharArray());
	}
	return output;
    }

    public static int[] createMatrixLine(int[] plain, int[] cipher) {
	
	int[] result = new int[plain.length * cipher.length];

	for (int i = 0; i < plain.length; i++) {

	    if (plain[i] == 1) {
		for (int j = 0; j < plain.length; j++) {
		    result[j + (cipher.length * i)] = cipher[j];
		}
	    } else {
		for (int j = 0; j < plain.length; j++) {
		    result[j + (plain.length * i)] = 0;
		}
	    }
	    // System.out.println("Cipher:" + Arrays.toString(cipher));
	    // System.out.println("Plain:" + Arrays.toString(plain));
	    // System.out.println("Ergebnis MatrixZeile" +
	    // Arrays.toString(result));
	}

	return result;
    }

    public static int[][] create(int lengthplain) {

	
	int lines = 2 * (lengthplain * lengthplain);
	int[] plain = new int[lengthplain];
	int[] cipher;
	int[][] resMatrix = new int[lines][lengthplain * lengthplain];
	int[][] plains = new int[lines][lengthplain];
	int[][] ciphers = new int[lines][lengthplain];

	// Erstellen der Klartexteee
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
	// resultierende Zeilen in Matrix ballern
	for (int l = 0; l < lines; l++) {
	    
	    resMatrix[l] = createMatrixLine(plains[l], ciphers[l]);

	}
	//Ausgabe der Matrix
	System.out.println("Resultierende Matrix:\n");
	for (int i = 0; i < lines; i++) {
	    System.out.println(Arrays.toString(resMatrix[i]));
	}
	return resMatrix;
    }

}
