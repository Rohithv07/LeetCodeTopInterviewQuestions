// https://practice.geeksforgeeks.org/contest/weekly-interview-series-74/problems/#

class Solution {
    public static String stringMirror(String str) {
        // code here
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        char previousChar = str.charAt(0);
        sb.append(previousChar);
        for (int i = 1; i < length; i++) {
            char currentChar = str.charAt(i);
            if (currentChar < previousChar) {
                previousChar = currentChar;
                sb.append(currentChar);
            }
            else {
                break;
            }
        }
        String finalAnswer = sb.toString() + sb.reverse().toString();
        return finalAnswer;
    }
}