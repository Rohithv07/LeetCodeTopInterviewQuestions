Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.


public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public String largestNumber(final int[] A) {
        if (A == null || A.length == 0)
            return "";
        String [] array = new String[A.length];
        for (int i=0; i<array.length; i++)
            array[i] = String.valueOf(A[i]);
        Arrays.sort(array, (a1, a2) -> (a2+a1).compareTo(a1+a2));
        if (array[0].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String s: array)
            sb.append(s);
        return sb.toString();
    }
}

