Write a program that receives a number n as input and prints it in the following format as shown below.
Like for n = 2 the pattern will be:
1*2*5*6
--3*4

Example 1:

Input: n = 3
Output: 
1*2*3*10*11*12
--4*5*8*9
----6*7
Explaination: If the pattern shown in question 
is followed, this will be the output.
Your Task:
You do not need to read input or print anything. Your task is to complete the function pattern() which takes n as input parameter and returns a list of string where each string denotes a new line of the pattern.

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n2)

Constraints:
1 ≤ n ≤ 70  




class Solution{
    static List<String> pattern(int n){
        // code here
        List<String> result = new ArrayList<>();
        int left = 1;
        int right = n * (n + 1);
        int temp = n;
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < 2*i; j++) {
                s += "-";
            }
            for (int j = 0; j < temp; j++) {
                s += Integer.toString(left++) + "*";
            }
            for (int j = temp; j > 0; j--) {
                s += Integer.toString(right - j + 1) + "*";
            }
            right -= temp;
            temp--;
            String sub = s.substring(0, s.length() - 1);
            result.add(sub);
        }
        return result;
    }
}