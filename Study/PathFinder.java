import java.util.*;

class PathFinder {

	public static void main(String[] args) {
		char [][] path = new char[][]{
			{ '-', '*', '-', '-' },
			{'-', '1', '*', '-'},
			{'-', '-', '*', '*'},
            {'-', '-', '-', '2'}
		};
		List<Character> storeDigit = new ArrayList<>();
		boolean [][] visited = new boolean [4][4];
		int startingRow = -1;
		int startingCol = -1;
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col ++) {
				if (path[row][col] == '*' || Character.isDigit(path[row][col])) {
					startingRow = row;
					startingCol = col;
					break;
				}
			}
			if (startingRow != -1 && startingCol != -1) {
				break;
			}
		}
        //System.out.println(startingRow + " " + startingCol);
		findTheDigit(path, startingRow, startingCol, visited, storeDigit);
       
		for (Character digit : storeDigit) {
			System.out.print(digit + " ");
		}
	}

	// go through * using dfs and store only digits if found
	// traverse only if it is not visited and not out of bound
	private static void findTheDigit(char [][] path, int row, int col, boolean [][] visited, List<Character> result) {
		if (row >= path.length || col >= path[0].length || row < 0 || col < 0 || visited[row][col] || path[row][col] == '-') {
		return;
		}
		visited[row][col] = true;
		if (path[row][col] != '*') {
			result.add(path[row][col]);
		}
		findTheDigit(path, row + 1, col, visited, result);
		findTheDigit(path, row - 1, col, visited, result);
		findTheDigit(path, row, col - 1, visited, result);
		findTheDigit(path, row, col + 1, visited, result);
	}
}
