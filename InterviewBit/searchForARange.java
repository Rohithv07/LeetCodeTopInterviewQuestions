
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
        int st = 0;
        int end = A.size()-1;
        ArrayList<Integer> result = new ArrayList<>();
        while(st <= end) {
            int mid = (st+end)/2;
            int stPos = -1;
            int endPos = -1;
            if(A.get(mid) == B) {
                int k = mid;
                while(k-1 >= 0 && A.get(k-1) == B) {
                    k--;
                }
                 stPos = k;
                k = mid;
                while(k+1 <= A.size()-1 && A.get(k+1) == B) {
                    k++;
                }
                 endPos = k;
                result.add(stPos);
                result.add(endPos);
                return result;
            } else if (A.get(mid) < B) st = mid+1;
            else end = mid-1;
        }
        result.add(-1);
        result.add(-1);
        return result;
        
    }
}
