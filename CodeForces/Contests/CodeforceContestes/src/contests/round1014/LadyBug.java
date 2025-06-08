package contests.round1014;

import java.util.*;
/**
 * @author rohithvazhathody
 * @date 2025-03-29
 */
public class LadyBug {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(isPossibleToCrack(s1, s2, n));
        }
        sc.close();
    }
    
    private static String isPossibleToCrack(String s1, String s2, int n) {
        int oddPositionOneS1 = 0;
        int eventPositionOneS1 = 0;
        int oddPositionZeroS2 = 0;
        int evenPositionZeroS2 = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == '1') {
                if (i % 2 == 0) {
                    eventPositionOneS1++;
                } else {
                    oddPositionOneS1++;
                }
            }
            if (s2.charAt(i) == '0') {
                if (i % 2 == 0) {
                    evenPositionZeroS2++;
                } else {
                    oddPositionZeroS2++;
                }
            }
        }
        if (oddPositionOneS1 == 0 && eventPositionOneS1 == 0) {
            return "YES";
        }
        return oddPositionOneS1 <= evenPositionZeroS2 && eventPositionOneS1 <= oddPositionZeroS2 ? "YES" : "NO";
    }
}