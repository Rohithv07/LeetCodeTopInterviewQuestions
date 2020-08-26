package com.rohith.datastructures;

public class MatrixProbability {
	public static boolean isSafe(int x, int y, int row, int column) {
		return (x >= 0 && x < row && y >= 0 && y < column);
	}
	public static double probabilityCalculator(int x, int y, int row, int column, int N) {
		if (!isSafe(x, y, row, column))
			return 0.0;
		if (N == 0)
			return 1.0;
		double probability = 0.0;
		probability += probabilityCalculator(x-1, y, row, column, N-1) * 0.25;
		probability += probabilityCalculator(x+1, y, row, column, N-1) * 0.25;
		probability += probabilityCalculator(x, y-1, row, column, N-1) * 0.25;
		probability += probabilityCalculator(x, y+1, row, column, N-1) * 0.25;
		return probability;
	}

	public static void main(String[] args) {
		int m = 5, n = 5; 
		  
	    // coordinates of starting point 
	    int i = 1, j = 1; 
	  
	    // Number of steps 
	    int N = 2; 
	  
	    System.out.println("Probability is " +  
	                       probabilityCalculator(i, j, m, 
	                       n, N)); 
	  

	}

}
