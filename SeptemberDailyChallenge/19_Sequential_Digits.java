An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]

Solution:

/* My thought process
Here we need to create certain numbers with in a range of values. So creating numbers with some constarints all comes under backtracking problem. So we need to find this as a backtracking problem and then we are good to go.

So what is our goal here: To create sequential digits if and only if each digit in the number is one more than the previous digit.

What is our constraints: The numbers must be in a specific range

So we need to take numbers from 1 to 9 and check whther the number satisifes the contraints or not. If yes, then we just add it to our resulting list and consider the number for the next digit by using recursion: Note We can consider the next digit by doing number * 10 + value. 

This is the whole problem and we need to sort the result as its specifiedd in the question.

*/
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        for (int i=1; i<=9; i++) {
            helper(result, low, high, 0, i);
        }
        Collections.sort(result);
        return result;
    }
    public void helper(List<Integer> result, int low, int high, int value, int i) {
        if (value > high)
            return;
        if (value >= low)
            result.add(value);
        if (i > 9)
            return;
        helper(result, low, high, value*10+i, i+1);
    }
}


