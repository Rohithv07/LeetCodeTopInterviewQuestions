// Implement Merge sort

import java.util.*;

public class MergeSort {

	public static void mergeSort(int [] nums, int left, int right) {
		if (left < right) {
			int middle = left + (right - left) / 2;
			mergeSort(nums, left, middle);
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




// another way of doing mergsort along with counting inversion logic
// follow this code and print the array to the sorted array

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long n)
    {
        // Your Code Here
        if (n == 0 || arr == null) {
            return 0;
        }
        long [] temp = new long [(int)n];
        long count =  mergeSort(arr, temp, 0, n-1);
        for (long number : arr) {
                System.out.print(number + " ");
            } // here the array will be sorted
            return count; // this will give the inversion count;
    }
    
    static long mergeSort(long [] arr, long [] temp, long left, long right) {
        long inversionCount = 0;
        if (left < right) {
            long middle = left + (right - left) / 2;
            inversionCount += mergeSort(arr, temp, left, middle);
            inversionCount += mergeSort(arr, temp, middle + 1, right);
            inversionCount += merge(arr, temp, left, middle + 1, right);
        }
        return inversionCount;
    }
    
    static long merge(long [] arr, long [] temp, long left, long middle, long right) {
        long count = 0;
        long i = left;
        long j = middle;
        long k = left;
        while (i < middle && j <= right) {
            if (arr[(int)i] <= arr[(int)j]) {
                temp[(int)k++] = arr[(int)i++];
            }
            else {
                temp[(int)k++] = arr[(int)j++];
                count += (middle - i);
            }
        }
        while (i < middle) {
            temp[(int)k++] = arr[(int)i++];
        }
        while (j <= right) {
            temp[(int)k++] = arr[(int)j++];
        }
        for (long p=left; p<=right; p++) {
            arr[(int)p] = temp[(int)p];
        }
        return count;
    }
}