You are given a string S. Every sub-string of identical letters is replaced by a single instance of that letter followed by the hexadecimal representation of the number of occurrences of that letter. Then, the string thus obtained is further encrypted by reversing it [ See the sample for more clarity ]. Print the Encrypted String.

Note: All Hexadecimal letters should be converted to Lowercase letters.

 

Example 1:

Input:
S = "aaaaaaaaaaa"
Output:
ba 
Explanation: 
aaaaaaaaaaa
Step1: a11 (a occurs 11 times)
Step2: a11 is ab [since 11 is b in
hexadecimal]
Step3: ba [After reversing]
Example 2:

Input:
S = "abc"
Output:
1c1b1a
Explanation: 
abc
Step1: a1b1c1
Step2: 1c1b1a [After reversing]
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function encryptString() which takes a String S and returns the answer.

 

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)


Constraints
1 <= |S| <= 105






// tried but failing some test cases code

class Solution {
    static String encryptString(String s){
        // code here
        if (s == null || s.length() == 0) {
            return "";
        }
        char [] hex = new char []{'a', 'b', 'c', 'd', 'e', 'f'};
        int value [] = new int []{10, 11, 12, 13, 14, 15};
        int [] count = new int [256];
        for (char ch : s.toCharArray()) {
            count[ch] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<256; i++) {
            int currentCount = count[i];
            if (currentCount > 0) {
                char currentChar = (char)i;
                sb.append(currentChar);
                if (currentCount > 9) {
                    for (int j=0; j<6; j++) {
                        if (value[j] == currentCount % 16) {
                            sb.append(hex[j]);
                        }
                    }
                }
                else {
                    sb.append(currentCount);
                }
            }
        }
        return sb.reverse().toString();
    }
}


// passing test cases

static String encryptString(String s){
       // code here
       String res="";
       int n=s.length();
       for(int i=0; i<n; i++){
           
           int c=1; 
           while(i+1<n && s.charAt(i)==s.charAt(i+1)){
               c++; i++;
           }
           String hex=Integer.toHexString(c);
           res=res+s.charAt(i);
           StringBuffer b=new StringBuffer(hex);
           b.reverse();
           res=res+b.toString();
       }
       StringBuffer bf=new StringBuffer(res);
       bf.reverse();
       return bf.toString();
   }