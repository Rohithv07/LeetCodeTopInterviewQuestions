/*
Students in a class are lining up in ascending height order, but are having some trouble doing so. Because of this, it’s possible that some students might be out of order. In particular, a student that is taller than both their neighboring students (i.e. the person to both their left and right) sticks out like a sore thumb. Given an integer array that represents each students height, return the index of a “sore thumb”.
Note: If there are multiple sore thumbs you may return the index of any of them. All numbers in the array will be unique.

Ex: Given the following students...

students = [1, 2, 3, 7, 5], return 3.

*/

import java.util.*;

public class SoreThumb {

	public static int findSoreThumb(int [] students) {
		for (int i=1; i<students.length-1; i++) {
			if (students[i - 1] < students[i] && students[i] > students[i + 1])
				return i;
		}
		return -1;
	}

	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] students = new int [n];
		for (int i=0; i<n; i++)
			students[i] = sc.nextInt();
		System.out.println(findSoreThumb(students));
	}
}