Given a string S. In one operation, you can remove the substring "pr" from the string S and get amount X or you can remove the substring "rp" and get the amount Y. 
Find the maximum amount you can get if you perform zero or more such operations optimally. 

Note : 

Substring of a string S is defined as a continuous sequence of characters in S.
After removing pr or rp, the order of remaining letters should remain the same.

Example 1:

Input:
X = 5, Y = 4
S = "abppprrr"
Output: 15
Explanation: 
Here, S = "abppprrr" 
X= 5, Y=4.
Remove "pr", new string S = "abpprr".
Remove "pr", new string S = "abpr".
Remove "pr", new string S = "ab".
In total, we removed "pr" 3 times, 
so total score is 3*X + 0*Y = 3*5 =15.
 

 

Example 2:

Input:
X = 7, Y = 7
S = "prpptppr"
Output: 14
Explanation: 
Here, S = "prpptppr" 
X= 7, Y=7.
As both have the same amount we can first 
remove either pr or rp. Here we start with pr
Remove "pr", new string S = "pptppr".
Remove "pr", new string S = "pptp".
In total, we removed "pr" 2 times, 
so total score is 2*X + 0*Y = 2*7 =14.

Your Task: 
You don't need to read input or print anything. Your task is to complete the function solve() which takes the X ,Y and string S as input parameters and returns the maximum amount you can get after performing the above operations.


Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)


Constraints:
1 ≤ |S| ≤ 105
1 ≤ X,Y ≤ 105
S contains lowercase English letters only.


class Solution 
{ 
    static long[] get(char c1,char c2,String str)
    {
        Stack<Character> s1=new Stack<>();
        Stack<Character> s2=new Stack<>();
        
        long cnt1=0,cnt2=0;
        
        s1.add(str.charAt(0));
        char temp=str.charAt(0);
        
        for(int i=1;i<str.length();i++)
        {
            if(!s1.isEmpty() && str.charAt(i)==c2 && s1.peek()==c1)
            {
                s1.pop();
                cnt1++;
            }
            else s1.add(str.charAt(i));
        }
        
        s2.add(s1.pop());
        
        temp=s2.peek();
        
        while(!s1.isEmpty())
        {
            if(!s2.isEmpty() && s1.peek()==c2 && s2.peek()==c1)
            {
                cnt2++;
                s2.pop();
            }
            else
            {
                s2.add(s1.peek());
            }
            
            s1.pop();
        }
        
        if(c1=='p') return new long[]{cnt1,cnt2}; 
        
            return new long[]{cnt2,cnt1};
    }
    static long solve(int X,int Y, String S)
	{    
	    long[] elements;
	    
	    if(X>Y)
	        elements=get('p','r',S);
	    else
	        elements=get('r','p',S);
	        
	    return elements[0]*X + elements[1]*Y;
	}
} 