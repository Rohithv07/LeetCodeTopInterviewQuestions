package com.rohith.datastructures;

public class MinPathCostConstantSpace {
	private static int min(int x, int y, int z) {
		if (x < y)
			return (x < z) ? x:z;
		else
			return (y < z) ? y:z;
	}
	private static int minCost(int cost[][], int m, int n) {
		for (int i=1; i<m; i++) 
			cost[i][0] += cost[i-1][0];
		for (int j=1; j<n; j++)
			cost[0][j] += cost[0][j-1];
		for (int i=1; i<m; i++) {
			for (int j=1; j<n; j++) {
				cost[i][j] += min(cost[i-1][j], cost[i][j-1], cost[i-1][j-1]);
			}
		}
		return cost[m-1][n-1];
	}

	public static void main(String[] args) {
		int cost[][]= {{1, 2, 3}, 
                {4, 8, 2}, 
                {1, 5, 3}}; 
        System.out.println(minCost(cost,3,3)); 
	}

}
