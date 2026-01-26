#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath> // Include cmath if you need max/min/etc, though not strictly needed here

/**
 * Calculates the number of distinct values in a vector of integers.
 * Time complexity: O(N log N) due to sorting.
 * * @param nums The vector of integers.
 * @return The count of distinct values.
 */
int findDistinctNumbers(std::vector<int>& nums) {
    // Handling empty or null-like case
    if (nums.empty()) {
        return 0;
    }

    // Step 1: Sort the vector. This is O(N log N).
    // std::sort is highly optimized and works on primitive types efficiently.
    std::sort(nums.begin(), nums.end());

    int distinctCount = 0;

    // Step 2: Iterate through the sorted vector and count transitions. O(N)
    for (int i = 0; i < nums.size(); ++i) {
        // A number is distinct if:
        // 1. It is the first element (i == 0).
        // 2. It is different from the element immediately preceding it.
        if (i == 0 || nums[i] != nums[i - 1]) {
            distinctCount++;
        }
    }

    return distinctCount;
}

int main() {
    // Optimize input/output operations for speed in competitive programming
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int n;
    // Read the number of values (n)
    if (!(std::cin >> n)) {
        return 0; // Handle end of input or read error
    }

    // Use a vector to store the numbers dynamically (equivalent to Java array)
    std::vector<int> nums(n);

    // Read the n integers
    for (int i = 0; i < n; ++i) {
        if (!(std::cin >> nums[i])) {
            // Handle error during reading elements
            return 0; 
        }
    }

    // Output the result
    std::cout << findDistinctNumbers(nums) << "\n";

    return 0;
}