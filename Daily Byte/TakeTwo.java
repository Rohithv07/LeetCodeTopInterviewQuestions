Given an array of integers, nums, each element in the array either appears once or twice. Return a list containing all the numbers that appear twice.
Note: Each element in nums is between one and nums.length (inclusive).

Ex: Given the following array nums…

nums = [2, 3, 1, 5, 5], return [5].
Ex: Given the following array nums…

nums = [1, 2, 3], return [].
Ex: Given the following array nums…

nums = [7, 2, 2, 3, 3, 4, 4], return [2,3,4].


import java.util.*;

public class TakeTwo {

	public static List<Integer> findTheTwo(int [] nums) {
		List<Integer> twoAppearance = new ArrayList<>();
		if (nums.length < 2)
			return twoAppearance;
		Map<Integer, Integer> frequencyTracker = new HashMap<>();
		for (int number : nums) {
			frequencyTracker.put(number, frequencyTracker.getOrDefault(number, 0) + 1);
		}
		for (int key : frequencyTracker.keySet()) {
			if (frequencyTracker.get(key) == 2)
				twoAppearance.add(key);
		}
		return twoAppearance;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int nums [] = new int [size];
		for (int i=0; i<size; i++)
			nums[i] = sc.nextInt();
		List<Integer> twoAppearance = findTheTwo(nums);
		System.out.println(twoAppearance);
	}
}
