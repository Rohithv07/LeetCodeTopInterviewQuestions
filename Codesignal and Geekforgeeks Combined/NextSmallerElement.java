import java.util.*;

public class NextSmallerElement {

	public static int [] findNextSmallerElement(int [] nums, int n) {
		if (nums == null || n == 0) {
			return new int []{};
		}
		// here we are not considering the cyclic fashion
		int [] result = new int [n];
		Stack<Integer> stack = new Stack<>();
		for (int i=n-1; i>=0; i--) {
			int currentNumber = nums[i];
			while (!stack.isEmpty() && stack.peek() >= currentNumber) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result[i] = -1;
			}
			else {
				result[i] = stack.peek();
			}
			stack.push(currentNumber);
		}
		return result;
	}

	public static int [] findNextSmallerElementForCycleCase(int [] nums, int n) {
		if (nums == null || n == 0) {
			return new int []{};
		}
		// here when we need to consider for the cycle
		int [] result = new int [n];
		Stack<Integer> stack = new Stack<>();
		for (int i=2*n-1; i>=0; i--) {
			int currentNumber = nums[i % n];
			while (!stack.isEmpty() && stack.peek() >= currentNumber) {
				stack.pop();
			}
			if (i < n) {
				if (stack.isEmpty()) {
					result[i % n] = -1;
				}
				else {
					result[i % n] = stack.peek();
				}
			}
			stack.push(currentNumber);
		}
		return result;
	}


	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int [] result = findNextSmallerElement(nums, n);
		//int [] result = findNextSmallerElementForCycleCase(nums, n);
		for (int number : result) {
			System.out.print(number + " ");
		}
	}
}