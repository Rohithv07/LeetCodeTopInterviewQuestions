// Implement Merge sort

import java.util.*;

public class MergeSort {

	public static void mergeSort(int [] nums, int left, int right) {
		if (left < right) {
			int middle = left + (right - left) / 2;
			mergeSort(nums, 0, middle);
			mergeSort(nums, middle+1, right);
			merge(nums, left, right, middle);
		}
	}

	public static void merge(int [] nums, int left, int right, int middle) {
		int leftSubLength = middle - left + 1;
		int rightSubLength = right - middle;
		int [] leftPart = new int [leftSubLength];
		int [] rightPart = new int [rightSubLength];
		for (int i=0; i<leftSubLength; i++) {
			leftPart[i] = nums[i + left];
		}
		for (int i=0; i<rightSubLength; i++) {
			rightPart[i] = nums[middle + i + 1];
		}
		int i = 0;
		int j = 0;
		int k = left;
		while (i < leftSubLength && j < rightSubLength) {
			if (leftPart[i] <= rightPart[j]) {
				nums[k] = leftPart[i];
				i++;
			}
			else {
				nums[k] = rightPart[j];
				j++;
			}
			k++;
		}
		while (i < leftSubLength) {
			nums[k] = leftPart[i];
			k++;
			i++;
		}
		while (j < rightSubLength) {
			nums[k] = rightPart[j];
			k++;
			j++;
		}
	}

	public static void main(String [] args) {
		int [] nums = {5, 3, 2, 12, 100, 11, 1, 5, 6, 7,83, 4, 45, 56, 7, 4, 3,1};
		mergeSort(nums, 0, nums.length - 1);
		for (int number : nums) {
			System.out.print(number + " ");
		}
	}
}