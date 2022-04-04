// que : https://practice.geeksforgeeks.org/contest/interview-series-44/problems/#
// explanation: https://www.youtube.com/watch?v=AWyGB-P90sg


class Solution
{
    public:
        vector <int> lexiographicallyLargest(vector <int> &a,int n)
        {
            // Code here
            int i = 0;
            int j = 0;
            while (j < n) {
                if ((a[i] & 1) == (a[j] & 1)) {
                    j++;
                }
                else {
                    sort(a.begin() + i, a.begin() + j, greater<int>());
                    i = j;
                }
            }
            sort(a.begin() + i, a.end(), greater<int>());
            return a;
        }
};