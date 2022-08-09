Find the count of numbers less than equal to N having exactly 9 divisors.
 

Example 1:

Input:
N = 100
Output:
2
Explanation:
The two numbers which have 
exactly 9 divisors are 36 and 100.
Example 2:

Input:
N = 1000
Output:
8 
Explanation:
The numbers are:
36 100 196 225 256 441 484 676

Your Task:  
You don't need to read input or print anything. Your task is to complete the function nineDivisors() which takes an integer N as an input parameter and returns the total number of elements from 1 to N inclusive, that have exactly 9 divisors.

Expected Time Complexity: O(sqrt(N))
Expected Auxiliary Space:  O(sqrt(N))
 

Constraints:
1<=N<=1010'




/*
C++ - Sieve + binary search + O(sqrt(N) * log(sqrt(N))
9 divisors --> The number must be presented by p1^2 * p2^2 or p^8
List all primes not exceed sqrt(N) by Sieve. It creates a sort array
1. p1^2 * p2^2. We need p1^2 * p2^2 <= N --> p1 * p2 <= sqrt(N)
Let p2 pivot. We have p1 <= sqrt(N) / p2
--> Count p1 is count number of elements in an array such that not exceed sqrt(N) / p2. Because sort array --> Binary search
2. p^8 --> O(n^(1/8))
Solution:
*/
class Solution {
public:
    vector <long long> listPrime;
    int countNotExceed(long long val, int n) {
        int l = 0, r = n - 1, res = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (listPrime[mid] <= val)
                l = mid + 1;
            else {
                r = mid - 1;
                res = mid;
            }
        }
        return res;
    }
    long long int nineDivisors(long long int N) {
        //Code Here
        vector <bool> isPrime(sqrt(N) + 1, true);
        for (int p = 2; p * p <= sqrt(N); p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= sqrt(N); i += p)
                    isPrime[i] = false;
            }
        }
        for (int i = 2; i <= sqrt(N); i++) {
            if (isPrime[i])
                listPrime.push_back(i * 1LL);
        }
        
        // Number present by p1^2 * p2^2
        int n = listPrime.size();
        long long res = 0;
        for (int i = n - 1; i >= 0; i--) {
            long long notExceedVal = floor(sqrt(N * 1.0) / listPrime[i]);
            res += (countNotExceed(notExceedVal, i) * 1LL);
        }

        // Number present by p^8
        for (int i = 0; i < n; i++) {
            long long square = listPrime[i] * 1LL * listPrime[i];
            if (square * square * square * square <= N)
                res++;
            else
                break;
        }
        return res;
    }
};