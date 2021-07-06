Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.

 

Example 1:

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.
Example 2:

Input: arr = [7,7,7,7,7,7]
Output: 1
Explanation: The only possible set you can choose is {7}. This will make the new array empty.
Example 3:

Input: arr = [1,9]
Output: 1
Example 4:

Input: arr = [1000,1000,3,7]
Output: 1
Example 5:

Input: arr = [1,2,3,4,5,6,7,8,9,10]
Output: 5
 

Constraints:

1 <= arr.length <= 10^5
arr.length is even.
1 <= arr[i] <= 10^5



// we are given an array and we can remove all the occurance of a set of integer and make the array length half.
// so I think we need to find the total count of each of the numbers.
// then we look for those numbers whose sum of occurance will >= to the half of the total length and we cna consider it as a possible answer.
// sometime there can only be 1 number repeated many times.

class Solution {
    public int minSetSize(int[] arr) {
        // here we can make use of map to track the occurances
        Map<Integer, Integer> map = new HashMap<>();
        int length = arr.length;
        int count = 0;
        // populate the map with count
        for (int num: arr)
            map.put(num, map.getOrDefault(num, 0) + 1);
        // now we use a priority queue inorder to get the maximum and minimum values from the map and add them into the queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // basically sorting based on large and small
        for (Integer values: map.values())
            pq.offer(values);
        // now we pop out the element from the queue and added with a varible say sum.
        // we will also be updating our count which is the final result.
        // so when our sum >= middle, then we 
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
            count += 1;
            if (sum >= (length ) / 2)
                return count;
        }
        return 0;
    }
}
