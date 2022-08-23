Given a string S containing only digits, Your task is to complete the function genIp() which returns a vector containing all possible combinations of valid IPv4 IP addresses and takes only a string S as its only argument.
Note: Order doesn't matter.

For string 11211 the IP address possible are 
1.1.2.11
1.1.21.1
1.12.1.1
11.2.1.1

Example 1:

Input:
S = 1111
Output: 1.1.1.1
Example 2:

Input:
S = 55
Output: -1

Your Task:

Your task is to complete the function genIp() which returns a vector containing all possible combinations of valid IPv4 IP addresses in sorted order or -1 if no such IP address could be generated through the input string S, the only argument to the function.

Expected Time Complexity: O(N * N * N * N)
Expected Auxiliary Space: O(N * N * N * N)

Constraints:
1<=N<=16
here, N = length of S.
S only contains digits(i.e. 0-9)


class Solution {
    public ArrayList<String> genIp(String s) 
    {
        ArrayList<String> res = new ArrayList<>();
        int n = s.length();
        for(int i=1;i<n-2;i++)
        {
            for(int j=i+1;j<n-1;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j,k);
                    String s4 = s.substring(k,n);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
                    {
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    private boolean isValid(String s)
    {
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
        {
            return false;
        }
        return true;
    }
}