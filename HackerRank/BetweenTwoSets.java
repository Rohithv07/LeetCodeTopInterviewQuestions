https://www.hackerrank.com/challenges/between-two-sets/problem



class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        int lowest = lcm(a);
        int greatest = gcd(b);
        int count = 0;
        for (int i=lowest, j=2; i<=greatest; i = lowest * j, j++) {
            if (greatest % i == 0)
                count += 1;
        } 
        return count;
    }
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    
    public static int gcd(List<Integer> a) {
        int result = a.get(0);
        for (int i=1; i<a.size(); i++) {
            result = gcd(result, a.get(i));
        }
        return result;
    }
    
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    public static int lcm(List<Integer> a) {
        int result = a.get(0);
        for (int i=1; i<a.size(); i++) {
            result = lcm(result, a.get(i));
        }
        return result;
    }
}
