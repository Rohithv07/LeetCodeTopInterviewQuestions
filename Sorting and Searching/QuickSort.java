// Quick sort implementation

import java.util.*;

public class QuickSort {

	public static void quickSort(int [] nums, int start, int end) {
		if (start <  end) {
			int partitionIndex = partition(nums, start, end);
			quickSort(nums, start, partitionIndex - 1);
			quickSort(nums, partitionIndex + 1, end);
		}
	}

	public static int partition(int [] nums, int start, int end) {
		int pivot = nums[end];
		int partitionIndex = start;
		for (int i=start; i<end; i++) {
			// lesser than pivot
			if (nums[i] <= pivot) {
				swap(nums, i, partitionIndex);
				partitionIndex += 1;
			}
		}
		swap(nums, end, partitionIndex);
		return partitionIndex;
	}

	public static void swap(int [] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String [] args) {
		int [] nums = {5, 3, 2, 12, 100, 11, 1, 5, 6, 7,83, 4, 45, 56, 7, 4, 3,1};
		quickSort(nums, 0, nums.length - 1);
		for (int number : nums) {
			System.out.print(number + " ");
		}
	}
}