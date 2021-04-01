/*
Given an N x M matrix, containing distinct elements, return all special values.
Note: A special value in the matrix is an element that is the minimum element in the its row and the maximum element in its column.

Ex: Given the following matrix…

matrix = [
  [1, 2],
  [3, 4]
], return [3].
Ex: Given the following matrix…

matrix = [
  [1, 2, 5],
  [4, 8, 3],
  [9, 7, 6]
], return [6].
*/

import java.util.*;

public class SpecialValue {

	public static List<Integer> minRowMaxCol(int [][] grid, int row, int col) {
		List<Integer> result = new ArrayList<>();
		int [] minArray = new int [row];
		int [] maxArray = new int [col];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<row; i++) {
			int resultMin = Integer.MAX_VALUE;
			for (int j=0; j<col; j++) {
				resultMin = Math.min(grid[i][j], resultMin);
			}
			minArray[i] = resultMin;
		}
		for (int number : minArray) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		for (int i=0; i<col; i++) {
			int resultMax = Integer.MIN_VALUE;
			for (int j=0; j<row; j++) {
				resultMax = Math.max(grid[j][i], resultMax);
			}
			maxArray[i] = resultMax;
		}
		for (int number : maxArray) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		for (int key : map.keySet()) {
			int value = map.get(key);
			if (value == 2) {
				result.add(key);
			}
		}
		return result;
		
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int [][] grid = new int [row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		System.out.println(minRowMaxCol(grid, row, col));
	}
}
