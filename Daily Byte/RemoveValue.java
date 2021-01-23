import java.util.*;

public class RemoveValue {
	private static int [] nums;

	public static int remove(int [] nums, int val) {
		int index = 0;
		for (int j=0; j<nums.length; j++) {
			if (nums[j] != val)
				nums[index++] = nums[j];
		}
		return index;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int val = sc.nextInt();
		System.out.println(remove(nums, val));
		for (int number : nums)
			System.out.print(number + " ");
	}
}