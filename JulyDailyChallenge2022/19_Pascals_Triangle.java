Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 1) {
            result.add(new ArrayList<>(Arrays.asList(1)));
            return result;
        }
        List<Integer> current = new ArrayList<>();
        current.add(1);
        result.add(current);
        for (int i = 1; i < numRows; i++) {
            List<Integer> previous = result.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for (int j = 1; j < i; j++) {
                int value = previous.get(j - 1) + previous.get(j);
                currentRow.add(value);
            }
            currentRow.add(1);
            result.add(currentRow);
        }
        return result;
    }
}