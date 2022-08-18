You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.

 

Example 1:

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has a size greater than half of the size of the old array.
Example 2:

Input: arr = [7,7,7,7,7,7]
Output: 1
Explanation: The only possible set you can choose is {7}. This will make the new array empty.
 

Constraints:

2 <= arr.length <= 105
arr.length is even.
1 <= arr[i] <= 105




class Solution {
    public int minSetSize(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 2) {
            return 1;
        }
        int length = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int element = arr[i];
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.count, p1.count));
        int halfLength = length / 2;
        for (Integer key : map.keySet()) {
            maxHeap.offer(new Pair(key, map.get(key)));
        }
        int currentLength = 0;
        int minimumSize = 0;
        while (!maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            int count = current.count;
            currentLength += count;
            minimumSize += 1;
            if (currentLength >= halfLength) {
                return minimumSize;
            }
        }
        return 0;
    }
}

class Pair {
    int element;
    int count;
    public Pair(int element, int count) {
        this.element = element;
        this.count = count;
    }
}