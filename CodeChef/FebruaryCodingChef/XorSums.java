import java.util.*;

public class XorSums {

	public static int [] findXorSum(int n, int [] nums, int q, int [] m) {
		int [] result = new int [q];
		int mod = (int) 998_244_353;
		for (int i=0; i<m.length; i++) {
			int sum = 0;
			int current = m[i];
			if (current == 1) {
				for (int number : nums) {
					sum += number;
				}
				result[i] = sum % mod;				
			}
			else {
				for (int j=0; j<n; j++) {
					for (int k=j+1; k<n-current+j; k++) {
						sum = (sum + (nums[j] ^ nums[k])) % mod;
					}
				}
				result[i] = sum % mod;
			}
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
		int q = sc.nextInt();
		int [] m = new int [q];
		int [] result = findXorSum(n, nums, q, m);
		for (int number : result) {
			System.out.println(number);
		}
	}
}