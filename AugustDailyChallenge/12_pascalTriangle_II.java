
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?





Solution: 1 ms O(k+k) space

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> saveResult = new ArrayList();
        List<Integer> firstRow = new ArrayList();
        firstRow.add(1);
        saveResult.add(firstRow);
        for (int i=1; i<=rowIndex; i++){
            List<Integer> previous = saveResult.get(i-1);
            List<Integer> current = new ArrayList();
            current.add(1);
            for (int j=1; j<i; j++){
                current.add(previous.get(j-1) + previous.get(j));
            }
            current.add(1);
            saveResult.add(current);
        }
        return saveResult.get(rowIndex);
    }
}



Solution : O(k) Space
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if(rowIndex == 0)return res;
        for(int i = 1; i <= rowIndex; i++){
            long num = ((long)res.get(i-1)*(long)(rowIndex-i+1))/i;
            res.add((int)num);
        }
        return res;
    }
}
