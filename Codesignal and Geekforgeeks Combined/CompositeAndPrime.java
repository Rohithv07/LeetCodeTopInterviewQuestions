Given two integers L and R find the difference of number of composites and primes between the range L and R (both inclusive).

Example 1:

Input: L = 4, R = 6
Output: 1
Explanation: Composite no. are 4 and 6.
And prime is 5.

Example 2:

Input: L = 4, R = 4
Output: 1
Explanation: There is no prime no. in [L,R]
 

Your Task:
You don't need to read or print anything. Your task is to complete the function Count() which takes L and R as input parameter and returns difference between no. of composites and primes between [L,R].
 

Expected Time Complexity: O(nlog(n)) where n = R - L + 1
Expected Space Complexity: O(n)
 

Constraints:
1 <= L <= R <= 105 


//User function Template for Java

class Solution
{
    public int Count(int l, int r)
    {
        // code here
        boolean [] primeCount = findPrimeCount(r);
        int prime = 0;
        int composite = 0;
        for (int low = l; low <= r; low++) {
            if (low == 1) {
                continue;
            }
            else if (!primeCount[low]) {
                //System.out.println("prime" + low);
                prime++;
            }
            else {
                composite++;
                //System.out.println("composite" + low);
            }
        }
        //System.out.println(prime + " " + composite);
        return composite - prime;
    }
    
    private boolean [] findPrimeCount(int r) {
        boolean [] prime = new boolean [r + 1];
        for (int i = 2; i * i <= r; i++) {
            if (!prime[i]) {
                for (int j = i; j * i <= r; j++) {
                    prime[i * j] = true;
                }
            }
        }
        return prime;
    }
}