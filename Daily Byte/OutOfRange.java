/*
You are given two bounds, lower and upper and a sorted integer array, nums. Return a list of strings that represents the missing ranges between lower and upper that are not covered in nums.

Ex: Given the following nums, lower, and upper…

nums = [2, 5, 7], lower = 0, upper = 10, return ["0->1","3->4","6","8->10"] (0 - 1, 3 - 4, 6, and 8 - 10 are not covered in nums).
Ex: Given the following nums, lower, and upper…

nums = [], lower = 15, upper = 20, return ["15->20"].
*/



// https://medium.com/@rebeccahezhang/leetcode-163-missing-ranges-6ac21b477e96
import java.util.*;

public class OutOfRange {

	public static List<String> findMissingRange(int [] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		int n = nums.length;
		int possibleNext = lower;
		for (int i=0; i<n; i++) {
			if (lower == Integer.MAX_VALUE)
				return result;
			if (nums[i] < possibleNext) {
				continue;
			}
			else if (nums[i] == possibleNext) {
				possibleNext += 1;
				continue;
			}
			String s = getTheMissingRangeAsString(possibleNext, nums[i] - 1);
			result.add(s);
			if (nums[i] == Integer.MAX_VALUE)
				return result;
			possibleNext = nums[i] + 1;
		}
		if (possibleNext <= upper) {
			String s = getTheMissingRangeAsString(possibleNext, upper);
			result.add(s);
		}
		return result;
	}

	public static String getTheMissingRangeAsString(int now, int then) {
		return now == then ? String.valueOf(now) : String.format("%d->%d", now, then);
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int lower = sc.nextInt();
		int upper = sc.nextInt();
		System.out.println(findMissingRange(nums, lower, upper));
	}
}
