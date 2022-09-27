There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.

After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

You are given a string dominoes representing the initial state where:

dominoes[i] = 'L', if the ith domino has been pushed to the left,
dominoes[i] = 'R', if the ith domino has been pushed to the right, and
dominoes[i] = '.', if the ith domino has not been pushed.
Return a string representing the final state.

 

Example 1:

Input: dominoes = "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.
Example 2:


Input: dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
 

Constraints:

n == dominoes.length
1 <= n <= 105
dominoes[i] is either 'L', 'R', or '.'.



class Solution {
    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() == 0)
            return "";
        int length = dominoes.length();
        int l = -1;
        int r = -1;
        char [] result = dominoes.toCharArray();
        for (int i=0; i<=length; i++) {
            if (i == length || result[i] == 'R') {
                if (r > l) {
                    while (r < i) {
                        result[r++] = 'R';
                    }
                }
                r = i;
            }
            else if (result[i] == 'L') {
                if (l > r || (l == -1 && r == -1)) {
                    while (++l < i) {
                        result[l] = 'L';
                    }
                }
                else {
                    l = i;
                    int low = r + 1;
                    int high = l - 1;
                    while (low < high) {
                        result[low++] = 'R';
                        result[high--] = 'L';
                    }
                }
            }
        }
        return new String(result);
    }
}