class Solution {
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
    public int mirrorReflection(int p, int q) {
        int g = gcd(p, q);
        p = p / g;
        p = p % 2;
        q = q / g;
        q = q % 2;
        if (p == 1 && q == 1)
            return 1;
        return p == 1 ? 0 : 2;
    }
}