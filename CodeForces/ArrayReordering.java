/*
1 <= i < j <= n and gcd(ai, 2aj) > 1

3 6 5 3

3-6  gcd(3, 12) = 3 > 1 - 1
3-5 gcd(3, 10) = 1 !> 1 - 0
3-3 gcd(3, 6) = 3 > 1 - 1
6-3 gcd(6, 10) = 2> 1 - 1
6-3 gcd(6, 6) = 6 > 1 - 1 n ^ 2 log(min(a, b)) 


1 4 2 4 1
1-4 gcd(1, 8) = 1 - 0
1-2 gcd(1, 4) = 1 - 0
1-4 gcd(1, 8) = 1 - 0
1-1 gcd(1, 2) = 1 - 0
4-2
4-4
4-1
2-4
2-1
4-1

6 3 5 3
*/


import java.util.*;

public class ArrayReordering {

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a%b);
	}

	public static int findNumberOfGoodPair(Integer [] nums, int n) {
		reorder(nums);
		int count = 0;
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				if (gcd(nums[i], 2*nums[j]) > 1)
					count += 1;
			}
		}
		return count;
	}

	public static void reorder(Integer [] nums) {
		Arrays.sort(nums, (a, b) -> a % 2 - b % 2);
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			Integer [] nums = new Integer [n];
			for (int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(findNumberOfGoodPair(nums, n));
		}
	}
}


/*
This also works perfectly fine and we dont want to sort
int count=0;
			for(int i=0;i<n;i++){
				for(int j=i+1;j<n;j++){
					if(gcd(a[i],2*a[j])>1||gcd(a[j],2*a[i])>1){
						count++;
					}
				}
			}

*/