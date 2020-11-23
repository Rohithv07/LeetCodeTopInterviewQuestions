
Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.

Your algorithm’s runtime complexity must be in the order of O(log n).

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].



Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

 Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
Constraints

1 <= N <= 10^6
1 <= A[i], B <= 10^9
For Example

Input 1:
    A = [5, 7, 7, 8, 8, 10]
    B = 8
Output 1:
    [3, 4]
Explanation 1:
    First occurence of 8 in A is at index 3
    Second occurence of 8 in A is at index 4
    ans = [3, 4]

Input 2:
    A = [5, 17, 100, 111]
    B = 3
Output 2:
    [-1, -1]


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int length = A.size();
        int left = 0;
        int right = length - 1;
        ArrayList<Integer> result = new ArrayList<>();
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (A.get(middle) == B) {
                int currentIndex = middle;
                int startingPosition = -1;
                int endingPosition = -1;
                while (currentIndex-1 >= 0 && A.get(currentIndex-1) == B) {
                    currentIndex -= 1;
                }
                startingPosition = currentIndex;
                currentIndex = middle;
                while (currentIndex+1 < length && A.get(currentIndex+1) == B)
                    currentIndex += 1;
                endingPosition = currentIndex;
                result.add(startingPosition);
                result.add(endingPosition);
                return result;
            }
            else if (A.get(middle) < B)
                left = middle + 1;
            else
                right = middle - 1;
        }
        result.add(-1);
        result.add(-1);
        return result;
    }
}

