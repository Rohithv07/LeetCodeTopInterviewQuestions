class Solution {
    public int bitwiseComplement(int N) {
        int x = 1;
        while (N > x) {
            x = x * 2 + 1;
        }
        return (N - x) * -1;
    }
}