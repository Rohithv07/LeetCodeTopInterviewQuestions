https://practice.geeksforgeeks.org/contest/weekly-interview-series-72/problems/#


//User function Template for Java
class Solution
{
    public String[] count(int n,String s)
    {
        String [] result = new String [2];
        if (n == 1) {
            result[0] = s;
            result[1] = "1";
            return result;
        }
        int pointer = 0;
        String characterResult = "";
        int count = 0;
        while (pointer < n) {
            char currentChar = s.charAt(pointer);
            int currentCount = 0;
            while (pointer < n && s.charAt(pointer) == currentChar) {
                currentCount++;
                pointer++;
            } 
            if (currentCount > count) {
                count = currentCount;
                characterResult = Character.toString(currentChar);
            }
        }
        result[0] = characterResult;
        result[1] = Integer.toString(count);
        return result;
    }
}