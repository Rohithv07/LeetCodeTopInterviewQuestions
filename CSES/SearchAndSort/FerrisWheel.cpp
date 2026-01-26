#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * Logic: Greedy approach using two pointers.
 * We pair the lightest child with the heaviest child to maximize gondola efficiency.
 * Made as the my java solution is TLE
 */
int findMinimumGondolas(vector<int>& nums, int limit) {
    // Sort the weights in ascending order
    sort(nums.begin(), nums.end());
    
    int count = 0;
    int left = 0;                   // Pointer to the lightest child
    int right = nums.size() - 1;    // Pointer to the heaviest child
    
    while (left <= right) {
        // If the lightest and heaviest child can fit together
        if (left != right && nums[left] + nums[right] <= limit) {
            left++; // The lightest child is paired, move to next lightest
        }
        
        // The heaviest child always takes a gondola (either alone or paired)
        right--;
        count++;
    }
    
    return count;
}

int main() {
    // Optimization for faster I/O in C++
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, limit;
    if (!(cin >> n >> limit)) return 0;
    
    vector<int> nums(n);
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }
    
    cout << findMinimumGondolas(nums, limit) << endl;
    
    return 0;
}