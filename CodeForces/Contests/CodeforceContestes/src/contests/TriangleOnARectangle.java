package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 06-Jul-2025
 */
public class TriangleOnARectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long width = sc.nextLong();
			long height = sc.nextLong();
			long horizontalNumberSide1 = sc.nextLong();
			long firstFirstHorizontal = 0;
			long firstLastHorizontal = 0;
			for (int index = 0; index < horizontalNumberSide1; index++) {
				if (index == 0) {
					firstFirstHorizontal = sc.nextLong();
				} else if (index == horizontalNumberSide1 - 1) {
					firstLastHorizontal = sc.nextLong();
				} else {
					sc.nextLong();
				}
			}
			long horizontalNumberSide2 = sc.nextLong();
			long secondFirstHorizontal = 0;
			long secondLastHorizontal = 0;
			for (int index = 0; index < horizontalNumberSide2; index++) {
				if (index == 0) {
					secondFirstHorizontal = sc.nextLong();
				} else if (index == horizontalNumberSide2 - 1) {
					secondLastHorizontal = sc.nextLong();
				} else {
					sc.nextLong();
				}
			}
			long verticalNumberSide1 = sc.nextLong();
			long firstFirstVertical = 0;
			long firstLastVertical = 0;
			for (int index = 0; index < verticalNumberSide1; index++) {
				if (index == 0) {
					firstFirstVertical = sc.nextLong();
				} else if (index == verticalNumberSide1 - 1) {
					firstLastVertical = sc.nextLong();
				} else {
					sc.nextLong();
				}
			}
			long verticalNumberSide2 = sc.nextLong();
			long secondFirstVertical = 0;
			long secondLastVertical = 0;
			for (int index = 0; index < verticalNumberSide2; index++) {
				if (index == 0) {
					secondFirstVertical = sc.nextLong();
				} else if (index == verticalNumberSide2 - 1) {
					secondLastVertical = sc.nextLong();
				} else {
					sc.nextLong();
				}
			}
			long maxBase1 = firstLastHorizontal - firstFirstHorizontal;
			long maxBase2 = secondLastHorizontal - secondFirstHorizontal;
			long maxBase3 = firstLastVertical - firstFirstVertical;
			long maxBase4 = secondLastVertical - secondFirstVertical;
			long maxArea = Math.max(maxBase1 * height,
					Math.max(maxBase2 * height, Math.max(maxBase3 * width, maxBase4 * width)));
			System.out.println(maxArea);
		}
		sc.close();
	}

}
