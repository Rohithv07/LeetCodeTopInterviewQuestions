/*Given an integer array, nums, sort the array in increasing order based on frequency of elements. If two numbers appear the same number of times, sort them by their value in decreasing order.

Ex: Given the following nums…

nums = [1, 1, 2, 3], return [3, 2, 1, 1] (3 appears once and 2 appears once so 3 comes before 2 because it has a larger value, 1 appears twice so it at the end of our array).
Ex: Given the following nums…

nums = [5, 2, 4, 4, 9, 2, 2], return [9,5,4,4,2,2,2]
*/


class Solution {
    public int[] frequencySort(int[] nums) {
	int [] result = new int [nums.length];
        	Map<Integer, Integer> map = new HashMap<>();
	for (int number : nums) {
		map.put(number, map.getOrDefault(number, 0) + 1);
	}
	PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b));
	for (int number : nums) {
		pq.add(number);
	}
	for (int i=0; i<nums.length; i++) {
		result[i] = pq.poll();
	}
	return result;
    }
}

