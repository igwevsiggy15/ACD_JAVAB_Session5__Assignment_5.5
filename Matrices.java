package Assignment5;

import java.util.Scanner;

public class Matrices {
	public static void main(String[] args) {
		int[][] a = null, b = null;
		int choice = -1;
		Scanner sc = new Scanner(System.in);
		do {
			choice = scanInt(sc, "0. Show matrices."
					+ "\n1. Input matrices."
					+ "\n2. Print sum."
					+ "\n3. Print difference."
					+ "\n4. Print transpose."
					+ "\n5. Print product."
					+ "\n6. Exit."
					+ "\nEnter choice: ");
			switch(choice) {
			case 0: 
				if (a != null && b != null) {
					System.out.println();
					System.out.println("Matrix 1:");
					printMatrix(a);
					System.out.println("Matrix 2:");
					printMatrix(b);
					System.out.println();
				} else {
					System.out.println("No Matrices on record.\n");
				}
				break;
			case 1:
				System.out.println();
				a = inputMatrix(sc, "Matrix 1");
				b = inputMatrix(sc, "Matrix 2");
				System.out.println();
				break;
			case 2:
				System.out.println();
				int[][] sum = addMatrices(a, b);
				if (sum == null) {
					System.out.println("Can't add.");
				} else {
					printMatrix(sum);
				}
				System.out.println();
				break;
			case 3:
				System.out.println();
				choice = scanInt(sc, "1. Matrix 1 - Matrix 2."
						+ "\n2. Matrix 2 - Matrix 1."
						+ "\nEnter choice: ");
				int[][] diff = null;
				if (choice == 1) {
					diff = subtractMatrices(a,b);
				} else if (choice == 2) {
					diff = subtractMatrices(b,a);
				} 
				if (diff == null) {
					System.out.println("Can't subtract.");
				} else {
					printMatrix(diff);
				}
				System.out.println();
				break;
			case 4:
				System.out.println();
				choice = scanInt(sc, "1. Matrix 1 ^ T"
						+ "\n2. Matrix 2 ^ T"
						+ "\nEnter choice: ");
				int[][] trans = null;
				if (choice == 1) {
					trans = transpose(a);
				} else if (choice == 2) {
					trans = transpose(b);
				} else {
					System.out.println("");
				}
				if (trans != null) {
					printMatrix(trans);
				}
				System.out.println();
				break;
			case 5:
				System.out.println();
				int[][] prod = product(a,b);
				if (prod != null) {
					printMatrix(prod);
				} else {
					System.out.println("Can't multiply.");
				}
				System.out.println();
				break;
			case 6:
				break;
			default:
				System.out.println();
				System.out.println("Not a choice.");
				System.out.println();
			}
		} while (choice != 6);
		sc.close();
		System.out.println("Exiting...");
	}
	
	static void printMatrix(int[][] matrix) {
		for (int[] array: matrix) {
			for(int num: array) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
	
	static int[][] addMatrices(int[][] a, int[][] b){
		int [][] matrix = null;
		if (a != null && b != null && a.length == b.length && a[0].length == b[0].length) {
			matrix = new int[a.length][a[0].length];
			for(int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					matrix[i][j] = a[i][j] + b[i][j];
				}
			}
		}
		return matrix;
	}
	
	static int[][] subtractMatrices(int[][] a, int[][] b){
		int [][] matrix = null;
		if (a != null && b != null && a.length == b.length && a[0].length == b[0].length) {
			matrix = new int[a.length][a[0].length];
			for(int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					matrix[i][j] = a[i][j] - b[i][j];
				}
			}
		}
		return matrix;
	}
	
	static int[][] transpose(int[][] a){
		int[][] matrix = null;
		if (a != null) {
			matrix = new int[a[0].length][a.length];
			for (int i = 0; i < a.length; i++) {
				for (int j=0; j < a[0].length; j++) {
					matrix[j][i] = a[i][j];
				}
			}
		}
		return matrix;
	}
	
	static int[][] product(int[][] a, int [][] b){
		int[][] prod = null;
		if (a != null && b != null && a[0].length == b.length) {
			prod = new int[a.length][b[0].length];
			for (int i=0; i< prod.length; i++) {
				for(int j = 0; j < prod[0].length; j++) {
					int sum = 0;
					for(int k= 0; k < b.length; k++) {
						sum += a[i][k] * b[k][j];
					}
					prod[i][j] = sum;
				}
			}
		}
		return prod;
	}
	
	static int[][] inputMatrix(Scanner sc, String name) {
		System.out.println("Input " + name + ":");
		int row = -1;
		int col = -1;
		do {
			row = scanInt(sc, "Enter number of rows: ");
			col = scanInt(sc,"Enter number of columns: ");
			
			if (row < 1 || col < 1) {
				System.out.println("Row and columns must be positive numbers.");
			}
		} while (row < 1 || col < 1);
		int [][] matrix = new int[row][col];
		for (int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = scanInt(sc, "Row " + (i+1) + " Column " + (j+1) + " = ");
			}
		}
		return matrix;
	}
	
	static int scanInt(Scanner sc, String prompt) {
		int num = 0;
		boolean pass = false;
		while (!pass) {
			System.out.print(prompt);
			try {
				num = sc.nextInt();
				pass = true;
			} catch(Exception e){
				System.out.println("Input must be a number.");
			}
			if (sc.hasNextLine()) sc.nextLine();
		}
		return num;
	}
	
}