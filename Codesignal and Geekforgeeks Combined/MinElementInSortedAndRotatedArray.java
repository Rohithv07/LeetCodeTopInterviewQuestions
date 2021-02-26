class Solution
{
    int findMin(int nums[], int n)
    {
        //complete the function here
	this is the binary search code
        // int length = arr.length;
        // if (length == 1)
        //     return arr[0];
        // int left = 0;
        // int right = length - 1;
        // while (left < right) {
        //     int mid = left + (right - left) / 2;
        //     if (arr[mid] == arr[right])
        //         right -= 1;
        //     else if (arr[mid] > arr[right])
        //         left = mid + 1;
        //     else
        //         right = mid;
        // }
        // return arr[right];

	// this another approach but O(n)
        if (nums.length == 1)
			return nums[0];
		// already sorted or not
		// if (alreadySorted(nums))
		// 	return nums[0];
		int irregularityIndex = -1;
		for (int i=0; i<nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				irregularityIndex = i + 1;
				break;
			}
		}
		return irregularityIndex == - 1 ? nums[0] : nums[irregularityIndex];
    }
}

