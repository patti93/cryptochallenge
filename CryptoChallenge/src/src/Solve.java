package src;

import java.util.ArrayList;
import java.util.Arrays;

public class Solve {

	public static ArrayList<int[]> rmNull(int[][] m, int length) {
		length = length*length;
		ArrayList<int[]> o = new ArrayList<int[]>();
		ArrayList<int[]> l = new ArrayList<int[]>(Arrays.asList(m));

		boolean oneFound = false;
		int[] test = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		
		for (int i = 0; i < l.size(); i++) {
			for (int j = 0; j < l.get(i).length; j++) {
				if (l.get(i)[j] == 1) {
					oneFound = true;
				}
			}
			if (oneFound == false) {
				l.remove(i);
			}
			oneFound = false;
		}

		for (int i = 0; i < l.size(); i++) {
			if (Arrays.equals(l.get(i), test)) {
			} else {
				o.add(i, l.get(i));
			}
		}

		for (int i = 0; i < o.size(); i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(o.get(i)[j] + " ");
			}
			System.out.println();
		}
		return o;
	}
	
	public static ArrayList<int[]> aufrollen(int[][] m, int [][] lsg){
		int [] temp = new int[m[0].length];
		int rndCount = 0, countOne = 0;
		ArrayList<int[]> templ2 = new ArrayList<int[]>();
		ArrayList<int[]> templ1 = new ArrayList<int[]>();
		int[][] templsg2 = new int[m.length][m[0].length];
		int[][] tempm2 = new int[m.length-1][m[0].length];
		int[][] templsg1 = new int[m.length][m[0].length];
		int[][] tempm1 = new int[m.length-1][m[0].length];
		for(int i = m.length-1; i >= 0; i--){
			
			for(int j = m[0].length-1; j >= 0; j--){
				if(m[i][j] == 1 && lsg[0][j] == lsg[1][0]){
					rndCount++;
					temp[j] = 1;
				}
			}
			for(int k = 0;k < m[0].length; k++){
				if(lsg[0][k] == 1 && temp[k] == 1){
					countOne++;
				}
				if(lsg[0][k] == 0 && temp[k] == 1){
					rndCount--;
				}
			}
			if((rndCount-countOne) % 2 == 0){

				tempm1 = m;
					for(int l = m[0].length-1; l >= 0; l--){
						if(temp[l] == 1){
							lsg[0][l] = 1;
							templsg1[0][l] = 0;
						}
					}

					templ1 = Solve.aufrollen(tempm1, templsg1);
			}
			else if((rndCount) % 2 == 0 && rndCount != 1){

				boolean second = false;
				tempm2 = m;
				for(int l = m[0].length-1; l >= 0; l--){
					if(temp[l] == 1 && !second){
						lsg[0][l] = 1;
						templsg2[0][l] = 0;
						second = true;
					}
					else if(temp[l] == 1 && second){
						lsg[0][l] = 0;
						templsg2[0][l] = 1;
					}
				}
				
				templ2 = Solve.aufrollen(tempm2, templsg2);
				
			}
		}
		
		ArrayList<int[]> loesung = new ArrayList<int[]>(Arrays.asList(lsg));
		
		if(!templ1.isEmpty()){
			loesung.addAll(templ1);
		}
		if(!templ2.isEmpty()){
			loesung.addAll(templ2);
		}
		
		return loesung;
		
	}
	public static ArrayList<int[]> einsetzen(ArrayList<int[]> m, int[] c) {
		
		int[][] l = new int[m.size()][m.get(0).length];
		l = m.toArray(l);
		
		for (int i = 0; i < (l.length / 2); i++) {
			System.out.println(Arrays.toString(l[i]));
		}
		int r = 0;
		for(int i = 0; i < m.size(); i++){
			for(int j = 0; j < m.get(0).length; j++){
				r = Math.round(j/c.length);
				System.out.println("i= " + i+ "    j = "+ j  + "     r= "+r);
				if(m.get(i)[j] == 1  && c[r] == 1){
					l[i][j] = 1;
				}
				else {
					l[i][j] = 0;
				}
			}
		}
		rmNull(l, c.length);
		
		for (int i = 0; i < l.length; i++) {
			System.out.println(Arrays.toString(l[i]));
		}
		
		return null;
	}

}
