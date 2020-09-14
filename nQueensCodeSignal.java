In chess, queens can move any number of squares vertically, horizontally, or diagonally. The n-queens puzzle is the problem of placing n queens on an n × n chessboard so that no two queens can attack each other.

Given an integer n, print all possible distinct solutions to the n-queens puzzle. Each solution contains distinct board configurations of the placement of the n queens, where the solutions are arrays that contain permutations of [1, 2, 3, .. n]. The number in the ith position of the results array indicates that the ith column queen is placed in the row with that number. In your solution, the board configurations should be returned in lexicographical order.

Example

For n = 1, the output should be
nQueens(n) = [[1]];

For n = 4, the output should be

  nQueens(n) = [[2, 4, 1, 3],
                [3, 1, 4, 2]]
This diagram of the second permutation, [3, 1, 4, 2], will help you visualize its configuration:



The element in the 1st position of the array, 3, indicates that the queen for column 1 is placed in row 3. Since the element in the 2nd position of the array is 1, the queen for column 2 is placed in row 1. The element in the 3rd position of the array is 4, meaning that the queen for column 3 is placed in row 4, and the element in the 4th position of the array is 2, meaning that the queen for column 4 is placed in row 2.


Solution:

int[][] nQueens(int n) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    helperFunction(result, current, n, 0);
    int [][] array = new int [result.size()][];
    for (int i=0; i<array.length; i++) {
        array[i] = new int [result.get(i).size()];
    }
    for (int i=0; i<array.length; i++) {
        for (int j=0; j<result.get(i).size(); j++) {
            array[i][j] = result.get(i).get(j);
        }
    }
    return array;
}
public void helperFunction(List<List<Integer>> result, List<Integer> current, int n, int start) {
    if (start == n) {
        result.add(new ArrayList<>(current));
        return;
    }
    for (int i=1; i<=n; i++) {
        current.add(i);
        if (isFeasible(current)) {
            helperFunction(result, current, n, start+1);
        }
        current.remove(current.size()-1);
    }
}
public boolean isFeasible(List<Integer> current) {
    int rowId = current.size()-1;
    for (int i=0; i<rowId; i++) {
        int diff = Math.abs(current.get(i) - current.get(rowId));
        if (diff == 0 || diff == rowId-i)
            return false;
    }
    return true;
}


