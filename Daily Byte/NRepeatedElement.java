/*
You are given an integer array, nums, which contains 2N elements. Within nums there are N + 1 unique elements and a specific element occurs N times. Return the element within nums that appears N times.

Ex: Given the following nums…

nums = [3, 3, 5, 1], return 3.
Ex: Given the following nums…

nums = [4, 2, 4, 5, 4, 1], return 4.
*/


// other method is to sort and fnd the adjacent repeating element
import java.util.*;

public class NRepeatedElement {

	public static int findTheRepeatedElement(int [] nums, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int number : nums) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		for (int key : map.keySet()) {
			int value = map.get(key);
			if (value * 2 ==  n)
				return key;
		}
		return -1;
	}	
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // n = 2N here
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(findTheRepeatedElement(nums, n));
	}
}
