/*
Given an integer, num, return its base seven representation as a string.

Ex: Given the following num...

num = 42, return “60”.

*/
class Solution {
    public String convertToBase7(int num) {
        if (num < 0) 
            return "-" + convertToBase7(-num);
        if (num < 7)
            return Integer.toString(num);
        return convertToBase7(num/7) + Integer.toString(num % 7);
    }
}
