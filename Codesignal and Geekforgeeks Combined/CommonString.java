// https://www.youtube.com/watch?v=zA4PpSPDh30

// https://practice.geeksforgeeks.org/contest/interview-series-67/problems/#




class Solution {
    
    private static String answer;
    
    private static void updateAnswer(String newAnswer) {
        if (answer.equals("")) {
            answer = newAnswer;
        }
        else if (answer.length() < newAnswer.length()) {
            return;
        }
        else if (answer.length() > newAnswer.length()) {
            answer = newAnswer;
        }
        else if (answer.compareTo(newAnswer) > 0) {
            answer = newAnswer;
        }
    }
    
    private static boolean isTInsideS(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            boolean isPresent = true;
            for (int j = 0; j < t.length(); j++) {
                if (i + j >= s.length()) {
                    isPresent = false;
                    break;
                }
                else if (s.charAt(i + j) != t.charAt(j)) {
                    isPresent = false;
                    break;
                }
            }
            if (isPresent) {
                return true;
            }
        }
        return false;
    }
    
    private static void compute(String s, String t) {
        updateAnswer(s + t);
        if (isTInsideS(s, t)) {
            updateAnswer(s);
        }
        else {
            // finding longest suffix of s which is prefix of t
            for (int i = s.length() - 1; i >= 0; i--) {
                int n = s.length() - i;
                String prefix = "";
                String suffix = s.substring(i);
                if (n < t.length())
                    prefix = t.substring(0, n);
                if (suffix.equals(prefix)) {
                    updateAnswer(s + t.substring(n));
                }
            }
        }
    }
    
    
    public static String commonString(String s, String t) {
        // code here
        answer = "";
        compute(s, t);
        compute(t, s);
        return answer;
    }
}
        
