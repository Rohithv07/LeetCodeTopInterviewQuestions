// https://practice.geeksforgeeks.org/contest/interview-series-amdocs/problems/

//User function Template for Java

class Solution{
    static List<Long> minimumSquares(long l, long b)
    {
        List<Long> result = new ArrayList<>();
        long dimension = findGCD(l, b);
        long count = 0;
        count = (l / dimension) * (b / dimension);
        result.add(count);
        result.add(dimension);
        return result;
    }
    
    static long findGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}