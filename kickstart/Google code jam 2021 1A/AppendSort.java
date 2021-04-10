import java.util.*;

public class AppendSort {

	public static long findMinOperation(long [] nums, int n) {
		long answer = 0;
		for (int i = 1; i<n; i++) {
			long l = nums[i];
			long r = nums[i];
			while (r <= nums[i - 1]) {
				l = l * 10 + 0;
				r = r * 10 + 9;
				answer += 1;
			}
			nums[i] = Math.max(nums[i - 1], l);
		}
		return answer;
		// System.out.print(digit + " " + first);
		// for (int i=maxIndex + 1; i<n; i++) {
		// 	long current = findDigit(nums[i]);
		// 	long firstNumber = firstNumber(nums[i]);
		// 	if (firstNumber > first) {
		// 		result += digit - current;
		// 		digit = result + current;
		// 		first = firstNumber;

		// 	}
		// 	// if (firstNumber > first) {
		// 	// 	result += digit - current;
		// 	// 	digit = result + current;
		// 	// 	first = firstNumber;
		// 	// 	max = nums[i];
		// 	// }
		// 	// else if (firstNumber < first) {
		// 	// 	result += digit - current + 1;
		// 	// 	digit = result + current;
		// 	// 	first = firstNumber;
		// 	// 	max = nums[i];
		// 	// }
		// 	// else if (firstNumber == first && nums[i] == max) {
		// 	// 	result +=  1;
		// 	// 	digit = result + current;
		// 	// 	first = firstNumber;
		// 	// 	max = nums[i];
		// 	// }
		// 	// else if (firstNumber == first && nums[i] < max) {
		// 	// 	result +=  digit - current;
		// 	// 	digit = result + current;
		// 	// 	first = firstNumber;
		// 	// 	max = nums[i];
		// 	// }
		// 	// else if (firstNumber == first && nums[i] > max) {
		// 	// 	result += digit - current;
		// 	// 	digit = result + current;
		// 	// 	first = firstNumber;
		// 	// 	max = nums[i];
		// 	// }
		// 	// result += digit - current;
		// 	// digit = result;
			
		// 	// result += digit - current;
		// 	// digit = result + current;
		// }
		// return result == 0 ? result + 1 : result;
		// long [] onlyDigit = new long [n];
		// for (int i=0; i<n; i++) {
		// 	onlyDigit[i] = findDigit(nums[i]);
		// }
		// for (long number : onlyDigit) {
		// 	result = (result -  number);
		// }
		// if (result == 0)
		// 	return result + 1;
		// return result > 0 ? result : 0;
	}

	public static long findDigit(long max) {
		long sum = 0;
		while (max > 0) {
			long rem = max % 10;
			sum += 1;
			max /= 10;
		}
		return sum;
	}

	public static long firstNumber(long max) {
		long answer = 0;
		while (max > 0) {
			long rem = max % 10;
			answer = rem;
			max /= 10;
		}
		return answer; 
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t=1; t<=test; t++) {
			int n = sc.nextInt();
			long [] nums = new long[n];
			for (int i=0; i<n; i++) {
				nums[i] = sc.nextLong();
			}
			System.out.println("Case #" + t + ": " +findMinOperation(nums, n));
		}
	}
}