package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 07-Dec-2024
 */
public class OneAndTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			int countTwo = 0;
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
				if (nums[i] == 2) {
					countTwo++;
				}
			}
			if (countTwo % 2 == 1) {
				System.out.println(-1);
			} else {
				if (countTwo == 0) {
					System.out.println(1);
				} else {
					int needed = countTwo / 2;
					countTwo = 0;
					int cut = -1;
					for (int i = 0; i < n; i++) {
						if (nums[i] == 2) {
							countTwo++;
							if (countTwo == needed) {
								cut = i;
								break;
							}
						}
					}
					System.out.println(cut + 1);
				}
			}
		}
		sc.close();
	}

}
