Given a list of points, return the k closest points to the origin (0, 0).

Ex: Given the following points and value of k…

points = [[1,1],[-2,-2]], k = 1, return [[1, 1,]].

import java.util.*;

public class ClosePoints {

	public static int [][] findClosePoint(int [][] points, int k) {
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1] - (a[0] * a[0] + a[1] * a[1])));
		int [][] result = new int [k][2];
		for (int [] p : points) {
			heap.add(p);
			if (heap.size() > k)
				heap.remove();
		}
		while (k -- > 0)
			result[k] = heap.remove();
		return result;

	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] points = new int [n][2];
		for (int i=0; i<n; i++) {
			for (int j=0; j<2; j++) {
				points[i][j] = sc.nextInt();
			}
		}
		int k = sc.nextInt();
		int [][] result = findClosePoint(points, k);
		for (int [] p : result)
			System.out.println(p[0] + " " + p[1]);
	}
} 