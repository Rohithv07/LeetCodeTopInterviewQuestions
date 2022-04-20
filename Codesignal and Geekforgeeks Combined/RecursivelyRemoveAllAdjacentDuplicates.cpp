Given a string s, remove all its adjacent duplicate characters recursively. 

Example 1:

Input:
S = "geeksforgeek"
Output: "gksforgk"
Explanation: 
g(ee)ksforg(ee)k -> gksforgk

Example 2:

Input: 
S = "abccbccba"
Output: ""
Explanation: 
ab(cc)b(cc)ba->abbba->a(bbb)a->aa->(aa)->""(empty string)

Your Task:
You don't need to read input or print anything. Your task is to complete the function remove() which takes the string S as input parameter and returns the resultant string.
Note: For some test cases, the resultant string would be an empty string. For that case, the function should return the empty string only.


Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)


Constraints:
1<=|S|<=105'




class Solution{
public:
    string remove(string s){
       // code here
       string res="";
       int i=0;
       while(i<s.length()){
           char ch=s[i];
           int freq=0;
           while(ch==s[i]){
               freq++;
               i++;
           }
           if(freq==1){
               res+=ch;
           }
       }
       if(res==s){
           return res;
       }
       return remove(res);
   }
};