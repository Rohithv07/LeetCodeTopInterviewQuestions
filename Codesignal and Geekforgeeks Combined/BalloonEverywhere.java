// https://practice.geeksforgeeks.org/contest/interview-series-58/problems/

// User function Template for Java


// https://www.youtube.com/watch?v=xRkM3vuqGko
class Solution {
    public int maxInstance(String s) {
        // Code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int countOfL = map.get('l');
        int countOfO = map.get('o');
        map.put('l', countOfL / 2);
        map.put('o', countOfO / 2);
        String balloon = "balloon";
        int minimumBalloon = map.get('b');
        for (char ch : balloon.toCharArray()) {
            minimumBalloon = Math.min(minimumBalloon, map.get(ch));
        }
        return minimumBalloon;
    }
}


class Solution {
    public int maxInstance(String s) {
        // Code here
        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                b++;
            }
            else if (ch == 'a') {
                a++;
            }
            else if (ch == 'l') {
                l++;
            }
            else if (ch == 'o') {
                o++;
            }
            else if (ch == 'n') {
                n++;
            }
        }
        if (b == 0 || a == 0 || l == 0 || n == 0 || o == 0) {
            return 0;
        }
        int minSingleChar = Math.min(b, Math.min(a, n));
        int minDoubleChar = Math.min(l, o);
        minDoubleChar /= 2;
        return Math.min(minSingleChar, minDoubleChar);
    }
}