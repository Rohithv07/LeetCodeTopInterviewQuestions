// https://youtu.be/W7btz7k8820


class Solution {
    
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
    
    public int mostBalloons(int n, int a[][]) {
        // Code here
        if (n <= 2) {
            return n;
        }
        // cases where balloons are on :
        // same row
        // same col
        // slope
        // same coordinate
        int answer = 2;
        for (int i=0; i<n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int sameCoordinate = 0;
            int sameRow = 0;
            int sameCol = 0;
            for (int j=0; j<n; j++) {
                if (i == j)
                    continue;
                if (a[i][0] == a[j][0] && a[i][1] == a[j][1]) {
                    sameCoordinate += 1;
                }
                else if (a[i][0] == a[j][0]) {
                    sameRow += 1;
                }
                else if (a[i][1] == a[j][1]) {
                    sameCol += 1;
                }
                else {
                    int dy = a[i][1] - a[j][1];
                    int dx = a[i][0] - a[j][0];
                    int gcdValue = gcd(Math.abs(dx), Math.abs(dy));
                    dx /= gcdValue;
                    dy /= gcdValue;
                    if (dx < 0) {
                        dx *= -1;
                        dy *= -1;
                    }
                    String key = dx + "-" + dy;
                    map.put(key, map.getOrDefault(key, 0) + 1); 
                }
            }
            int mostPointsSameLine = 1;
            for (String key : map.keySet()) {
                mostPointsSameLine = Math.max(mostPointsSameLine, map.get(key));
            }
            answer = Math.max(answer, 1 + sameCoordinate + mostPointsSameLine);
            answer = Math.max(answer, 1 + sameCoordinate + Math.max(sameRow, sameCol));
        }
        return answer;
    }
}