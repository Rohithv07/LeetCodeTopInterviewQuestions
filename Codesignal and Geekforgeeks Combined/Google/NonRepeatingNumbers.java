Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs whereas the other two number occur exactly once and are distinct. Find the other two numbers.


Example 1:

Input: 
N = 2
arr[] = {1, 2, 3, 2, 1, 4}
Output:
3 4 
Explanation:
3 and 4 occur exactly once.
Example 2:

Input:
N = 1
arr[] = {2, 1, 3, 2}
Output:
1 3
Explanation:
1 3 occur exactly once.

Your Task:
You do not need to read or print anything. Your task is to complete the function singleNumber() which takes the array as input parameter and returns a list of two numbers which occur exactly once in the array. The list must be in ascending order.


Expected Time Complexity: O(N)
Expected Space Complexity: O(1)


Constraints:
1 <= length of array <= 106 
1 <= Elements in array <= 5 * 106


class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        int [] result = new int [2];
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        int index = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                result[index++] = key;
            }
        }
        Arrays.sort(result);
        return result;
    }
}

// using bit manipulation O(1) space in cpp

vector<int> singleNumber(vector<int> nums)
{
int ans = nums[0];
for (int i = 1; i < nums.size(); i++) {
ans ^= nums[i];
}
int temp = ans;
int pos = 0;
while ((temp & 1) != 1) {
pos++;
temp = temp >> 1;
}
int mask = 1 << pos;
int x = 0;
int y = 0;
for (int i = 0; i < nums.size(); i++) {
if ((nums[i]&mask) > 0)
x ^= nums[i];
}
y = ans ^ x;
vector<int>a(2);
a[0] = min(x, y);
a[1] = max(x, y);
return a;
}
