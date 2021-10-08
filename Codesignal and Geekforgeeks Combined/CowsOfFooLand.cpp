Cows in the FooLand city are interesting animals. One of their specialities is related to producing offsprings. A cow in FooLand produces its first calve (female calf) at the age of two years and proceeds to produce other calves (one female calf a year).

Now the farmer Harold wants to know how many animals would he have at the end of N years, if we assume that none of the calves dies, given that initially, he has only one female calf?
 

Example 1:

Input: N = 2
Output: 2
Explanation: At the end of 1 year, he will have 
only 1 cow, at the end of 2 years he will have 
2 animals (one parent cow C1 and other baby 
calf B1 which is the offspring of cow C1).
Example 2:

Input: N = 4
Output: 5
Explanation: At the end of 1 year, he will have
only 1 cow, at the end of 2 years he will have
2 animals (one parent cow C1 and other baby
calf B1 which is the offspring of cow C1). At
the end of 3 years, he will have 3 animals (one
parent cow C1 and 2 female calves B1 and B2, C1
is the parent of B1 and B2).At the end of 4 
years,he will have 5 animals (one parent cow C1,
3 offsprings of C1 i.e. B1, B2, B3 and one 
offspring of B1).
 

Your Task:
You don't need to read or print anything. Your task is to complete the function TotalAnimal() which takes N as input parameter and returns the total number of animals at the end of N years modulo 109 + 7.
 

Expected Time Complexity: O(log2N)
Expected Space Complexity: O(1)
 

Constraints:
1 <= N <= 1018
class Solution {
public:
    int TotalAnimal(int64_t n) {
    vector<vector<int64_t>> ans(2, vector<int64_t>(2, 1)), d(2, vector<int64_t>(2, 1));
    d[1][1] = ans[0][1] = ans[1][0] = 0;
    while (n > 0) {
        if (n & 1)multiply(ans, d);
        multiply(d, d);
        n >>= 1;
    }
    return ans[0][0];
}
void multiply(vector<vector<int64_t>> &a, vector<vector<int64_t>> &b) {
    vector<vector<int64_t>> c(2, vector<int64_t>(2, 0));
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            for (int l=0;l<2;l++)(c[i][j]+=a[i][l]*b[l][j])%=((int)1e9 + 7);
        }
    }
    a = c;
}

};