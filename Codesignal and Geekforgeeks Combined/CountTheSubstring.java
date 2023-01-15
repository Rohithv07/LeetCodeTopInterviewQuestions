Given a binary string S consists only of 0s and 1s. The task is to calculate the number of substrings that have more 1s than 0s.

Example 1:

Input:
S = "011"
Output: 4
Explanation: There are 4 substring which 
has more 1s than 0s. i.e "011","1","11" and "1"
Example 2:

Input:
S = "0000"
Output: 0
Explanation: There is no substring
which has more 1s than 0s
Your Task:  
You dont need to read input or print anything. Complete the function countSubstring() which takes the string S as input parameter and returns the number of substring which has more 1s than 0s.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)

Constraints:
1 < |S| < 105
|S| denotes the length of the string S


class Solution {

    long countSubstring(String S){

    long res=0;

   HashMap<Long,Integer> hm=new HashMap<>();

   long[] dp=new long[S.length()];

   long sum=-1;

   if(S.charAt(0)=='1'){

    dp[0]=1;

    res=1;

    sum=1;

   }

  hm.put(sum,0);

  hm.put((long) 0,-1);

  for(int i=1;i<S.length();i++){

    long tt=0;

    if(S.charAt(i)=='0'){

      sum-=1;

    }

    else{

      sum+=1;

    }

    if(S.charAt(i)=='0'){

      if(hm.containsKey(sum)){

        if(hm.get(sum)!=-1){

          tt+=dp[hm.get(sum)];

        }

      }

    }

    else{

      if(hm.containsKey(sum)){

        if(hm.get(sum)!=-1){

          tt=tt+dp[hm.get(sum)]+i-hm.get(sum)-1;

        }

        else{

          tt=tt+i-hm.get(sum)-1;

        }

      }

      else{

        tt+=i+1;

      }

 

    }

    hm.put(sum,i);

    dp[i]=tt;

    res+=tt;

  }

  return res;

    }

}

