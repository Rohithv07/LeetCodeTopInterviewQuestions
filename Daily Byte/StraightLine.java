/*
Given a two-dimensional integer array, points, return true if the three points you’re given do not form a straight line and false otherwise.

Ex: Given the following points…

points = [[1, 1,], [2, 2], [3, 3]], return false.
Ex: Given the following points…

points = [[1, 2], [4, 4], [2, 3]], return true.
*/


import java.util.*;

public class StraightLine {

	public static boolean isStraightLine(int [][] points) {
		// slope same
		int x1 = points[0][0];
		int y1 = points[0][1];
		int x2 = points[1][0];
		int y2 = points[1][1];
		int x3 = points[2][0];
		int y3 = points[2][1];
		return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int [][] points = new int [3][2];
		for (int i=0; i<3; i++) {
			points[i][0] = sc.nextInt();
			points[i][1] = sc.nextInt();
		}
		System.out.println(isStraightLine(points));
	}
}
