import java.util.*;

public class AggressiveCows {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int cows = sc.nextInt();
            int [] stalls = new int [n];
            for (int i = 0; i < n; i++) {
                stalls[i] = sc.nextInt();
            }
            System.out.println(maxDistance(stalls, cows, n));
        }
        sc.close();
    }

    private static int maxDistance(int [] stalls, int cows, int n) {
        if (stalls == null || stalls.length == 0) {
            return 0;
        }
        Arrays.sort(stalls);
        int low = 1;
        int high = (int)(1e9 + 7);
        int maxCowDistance = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (canCowBePlaced(stalls, cows, middle)) {
                maxCowDistance = middle;
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return maxCowDistance;
    }

    private static boolean canCowBePlaced(int [] stalls, int cows, int minDistance) {
        int cowCount = 1;
        int previousPositionOfCow = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            int currentStallPos = stalls[i];
            if (currentStallPos - previousPositionOfCow >= minDistance) {
                cowCount++;
                previousPositionOfCow = currentStallPos;
            }
        }
        return cowCount >= cows;
    }
}