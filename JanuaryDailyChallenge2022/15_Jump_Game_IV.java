Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
Example 2:

Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You do not need to jump.
Example 3:

Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 

Constraints:

1 <= arr.length <= 5 * 104
-108 <= arr[i] <= 108


class Solution {
    public int minJumps(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> graph = buildGraph(arr);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int length = arr.length;
        boolean [] visited = new boolean [length];
        visited[0] = true;
        int jump = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int currentPos = queue.poll();
                if (currentPos == length - 1) {
                    return jump;
                }
                List<Integer> children = graph.get(arr[currentPos]);
                children.add(currentPos - 1);
                children.add(currentPos + 1);
                for (Integer child : children) {
                    if (child >= 0 && child < length && !visited[child]) {
                        queue.offer(child);
                        visited[child] = true;
                    }
                }
                children.clear();
            }
            jump += 1;
        }
        return jump;
    }
    
    public Map<Integer, List<Integer>> buildGraph(int [] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }
        return map;
    }
}