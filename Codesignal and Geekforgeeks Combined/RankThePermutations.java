Given a string, find the rank of the string amongst its permutations sorted lexicographically. 

Example 1:

Input:
S = "abc"
Output:
1
Explanation:
The order permutations with letters 
'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
Example 2:

Input:
S = "acb"
Output:
2

Your Task:
You don't need to read input or print anything. Your task is to complete the function findRank() which takes the string S as input parameter and returns the rank of the string amongst its permutations.
It is guaranteed no characters are repeated in the string.


Expected Time Complexity: O(|S|*26)
Expected Auxiliary Space: O(|S|)
Note: |S| represents the length of string S.


Constraints:
1 ≤ |S| ≤ 18




class Solution
{
    public long findRank(String s)
    {
        // Code here
        long result = 0;
        int length = s.length();
        List<Integer> list = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            list.add((int)ch);
        }
        for (int i = 0; i < length; i++) {
            int rank = findIndex(list, (int)s.charAt(i));
            result += (rank) * findFactorial(length - i - 1);
            list.remove(rank);
        }
        return result + 1;
    }
    
    public int findIndex(List<Integer> list, int number) {
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == number) {
                return i;
            }
        }
        return -1;
    }
    
    public long findFactorial(int n) {
        return n == 0 ? 1 : n * findFactorial(n - 1);
    }
}