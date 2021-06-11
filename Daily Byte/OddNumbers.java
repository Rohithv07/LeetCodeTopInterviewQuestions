Given two non-negative integers low and high, return the total count of odd numbers between them (inclusive).

Ex: Given the following low and high…

low = 1, high = 3, return 2 (1 and 3 are both odd).
Ex: Given the following low and high…

low = 1, high = 10, return 5.



class Solution {
    public int countOdds(int low, int high) {
        int count = (high - low) / 2;
        if (high % 2 != 0 || low % 2 != 0)
            count ++;
        return count;
    }
}
