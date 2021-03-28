import java.util.*;

public class ReverSort {

	public static long findCost(int [] nums) {
		int sum = 0;
		// int [] temp = nums.clone();
		// Arrays.sort(temp);
		// for (int number : temp)
		// 	System.out.println(number);
		int regularity = 0;
		for (int i=0; i<nums.length; i++) {
			if (i+1 == nums[i])
				regularity += 1;
		}
		if (regularity == nums.length)
			return nums.length - 1;
		// if (regularity == 1)
		// 	return (nums.length - 1) * 2;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i=0; i<nums.length - 1; i++) {
			int index = map.get(i+1);
			int mid = (index - i + 1) / 2;
			for (int j=0; j<mid; j++) {
				int temp = nums[i+j];
				nums[i+j] = nums[index - j];
				nums[index - j] = temp;
				map.replace(nums[i+j], i+j);
				map.replace(nums[index - j], index - j);
			}
			// for (int j=i; j<=index/2; j++) {
			// 		int temp = nums[j];
			// 		nums[j] = nums[index / 2 + 1];
			// 		nums[index / 2 + 1] = temp;
			// 		map.replace(nums[j], j);
			// 		map.replace(nums[index / 2 + 1], index / 2 + 1);
			// }
			//System.out.print(nums[i] + " ");
			// for (int key : map.keySet()) {
			// 	System.out.println(key + "->" + map.get(key));
			// }
			sum += index - i + 1;
		}
		// for (int number : nums)
		// 	System.out.print(number + " ");
		return sum;
		// for (int i=0; i<nums.length; i++) {
		// 	int currentMin = i + 1;
		// 	int currentIndex = map.get(currentMin);
		// 	sum += (currentIndex + 1) - (i + 1) + 1;
		// }
		// return sum + regularity * 2;


		// for (int i=0; i<nums.length; i++) {
		// 	if (nums[i] != temp[i])
		// 		irregularity += 1;
		// }
		// if (irregularity == nums.length) {
		// 	return (irregularity - 1) * 2;
		// }
		// if (irregularity == 0) {
		// 	return 1;
		// }
		// if (irregularity == 1)
		// 	return irregularity * 2;
		// return irregularity * nums.length;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t=1; t<=test; t++) {
			int n = sc.nextInt();
			int [] nums = new int[n];
			for (int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println("Case #" + t + ": " + findCost(nums));
		}
	}
}
