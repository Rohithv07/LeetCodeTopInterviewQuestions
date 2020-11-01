Given a positive number, return its complementary number.
Note: The complement of a number is the number that results from flipping every bit in the original number. (i.e. zero bits become one bits and one bits become zero bits).

Ex: Given the following number…

number = 27, return 4.
27 in binary (not zero extended) is 11011.
Therefore, the complementary binary is 00100 which is 4.




class Solution {
    public int bitwiseComplement(int N) {
        int x = 1;
        while (N > x) {
            x = x * 2 + 1;
        }
        return (N - x) * -1;
    }
}