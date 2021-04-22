// ref : https://leetcode.com/problems/brick-wall/discuss/888577/IntuitionC%2B%2BWith-PicturesHashMapDetailed-ExplanationCommentsSolutionCode

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int size = wall.size();
        int commonEdgeCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            // we dont want to consider the last element of each row as we cannot cut there
            for (int i=0; i<row.size() - 1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum , 0) + 1);
                commonEdgeCount = Math.max(commonEdgeCount, map.get(sum));
            }
        }
        return size - commonEdgeCount;
    }
}
