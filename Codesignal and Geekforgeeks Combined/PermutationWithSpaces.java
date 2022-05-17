Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. The output should be printed in sorted increasing order of strings

Example 1:

Input:
S = "ABC"
Output: (A B C)(A BC)(AB C)(ABC)
Explanation:
ABC
AB C
A BC
A B C
These are the possible combination of "ABC".
 

Example 2:

Input:
S = "AB"
Output: (A B)(AB)

Your Task:  
You don't need to read input or print anything. Your task is to complete the function permutation() which takes the string S as input parameters and returns the sorted array of the string denoting the different permutation (DON'T ADD '(' and ')' it will be handled by the driver code only).

Expected Time Complexity: O(2^n)
Expected Auxiliary Space: O(1)

 

CONSTRAINTS:
1 < |S| < 10
S only contains lowercase and Uppercase English letters.


class Solution{ 
    ArrayList<String> permutation(String S){
        // Code Here
        ArrayList<String> wraplist = new ArrayList<>();
        String op = ""; 
        op += S.charAt(0);
        S= S.substring(1);
        permutationSpaces(wraplist , S, op);
        return wraplist;
    }
    void permutationSpaces(ArrayList<String> wraplist, String S, String op){
        
        if(S.length() == 0){ 
            wraplist.add(op);
            return;
        }
        String op1 = op, op2 = op;
        op1 += " "+S.charAt(0);
        op2 += S.charAt(0);
        
        S= S.substring(1);
            
        permutationSpaces(wraplist, S, op1); 
        permutationSpaces(wraplist, S, op2);
        
        return; 
    }
    
}