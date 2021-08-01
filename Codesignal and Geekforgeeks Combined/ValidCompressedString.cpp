// https://youtu.be/vWf96plXQUQ



class Solution {
  public:
    int checkCompressed(string S, string T) {
        // code here
        int j = 0;
        for (int i=0; i<T.size(); i++) {
            if (isalpha(T[i])) {
                if (j < S.size() && T[i] != S[j])
                    return 0;
                j++;
            }
            else {
                int number = 0;
                while (i < T.size() && !isalpha(T[i])) {
                    int digit = T[i] - '0';
                    number = number * 10 + digit;
                    i++;
                }
                i--;
                j += number;
            }
        }
        return j == S.size();
    }
};

/*
Java Same code but giving runtime error

class Solution {
    static int checkCompressed(String s, String t) {
        // code here
        int lengthS = s.length();
        int lengthT = t.length();
        int i = 0;
        for (int j=0; j<lengthT; j++) {
            if (Character.isAlphabetic(t.charAt(j))) {
                if (i < lengthS && s.charAt(i) != t.charAt(j))
                    return 0;
                i ++;
            }
            else {
                int number = 0;
                while (j < lengthT && Character.isDigit(t.charAt(j))) {
                    int digit = t.charAt(j) - '0';
                    number = number * 10 + digit;
                    j++;
                }
                j--; // as we are doing a j++ for loop
                i += number;
            }
        }
        return i == lengthS ? 1 : 0;
    }
}
*/