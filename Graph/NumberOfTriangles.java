package com.rohith.datastructures;

public class NumberOfTriangles {
	int vertices = 4;
	void multiplyMatrix(int a[][], int b[][], int c[][]) {
		for (int i=0; i<vertices; i++) {
			for (int j=0; j<vertices; j++) {
				c[i][j] = 0;
				for (int k=0; k<vertices; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
	}
	int traceFinder(int a[][])  { // Sum of the diagonal
		int traceSum = 0;
		for (int i=0; i<vertices; i++) {
			traceSum += a[i][i];
		}
		return traceSum;
	}
	int numberOfTriangles(int graph [][]) {
		int [][] aux2 = new int[vertices][vertices];
		int [][] aux3 = new int[vertices][vertices];
		for (int i=0; i<vertices; i++) {
			for (int j=0; j<vertices; j++) {
				aux2[i][j] = 0;
				aux3[i][j] = 0;
			}
		}
		multiplyMatrix(graph, graph, aux2);
		multiplyMatrix(graph, aux2, aux3);
		return traceFinder(aux3) / 6;
	}
	public static void main(String[] args) {
		NumberOfTriangles n = new NumberOfTriangles();
		int graph[][] = { {0, 1, 1, 0}, 
                {1, 0, 1, 1}, 
                {1, 1, 0, 1}, 
                {0, 1, 1, 0} 
              }; 

System.out.println("Total number of Triangle in Graph : "+ 
     n.numberOfTriangles(graph)); 
		System.out.println();

	}

}
