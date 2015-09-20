package com.solution2;

public class biggestSquare1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int[][] array;
	static int[][] g;
	static int x = -1, y = -1;
	static String[][] output;
	static String outptFinal;

	public static String biggestSquare(String[] input1) {
		int[][] temparray = formatInput(input1);
		array = g = temparray;
		biggestSquare();
		outptFinal = construtcOP();

		return outptFinal;
	}

	private static String construtcOP() {
		if (x == -1) {
			outptFinal = "{}";
			return outptFinal;
		}
		int value = g[x][y];
		outptFinal = "{";
		output = new String[value][value];
		for (int i = 0; i < value;) {
			outptFinal += "(";
			for (int j = 0; j < value;) {
				outptFinal += x + i + "#" + (y + j);
				outptFinal += ",";
				j++;
			}
			outptFinal = outptFinal.substring(0, outptFinal.length() - 1);
			outptFinal += "),";

			// System.out.println("");
			i++;
		}
		outptFinal = outptFinal.substring(0, outptFinal.length() - 1);
		outptFinal += "}";
		return outptFinal;
	}

	private static int[][] formatInput(String[] temparrayN) {
		int[][] temparray = new int[temparrayN.length][temparrayN.length];
		for (int i = 0; i < temparrayN.length; i++) {
			String[] a = temparrayN[i].split("#");
			for (int j = 0; j < temparrayN.length; j++) {
				temparray[i][j] = (Integer.parseInt(a[j]));
			}
		}

		return temparray;
	}

	private static char[] biggestSquare() {
		for (int n = 2; n <= array.length; n++) {
			getNSize1(n);
		}
		if (x == -1) {
			checkOne();
		}
		return null;
	}

	private static void checkOne() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i][j] == 1) {
					x = i;
					y = j;
					return;
				}
			}
		}
	}

	private static void getNSize1(int n) {
		n--;
		for (int i = 0; i < array.length - n; i++) {
			for (int j = 0; j < array.length - n; j++) {
				if (array[i][j] == n) {
					if (array[i][j + 1] >= n && array[i + 1][j] >= n
							&& array[i + 1][j + 1] >= n) {
						g[i][j]++;
						x = i;
						y = j;
					}
				}
			}
		}
	}

}
