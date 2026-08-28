/**
 * @author rohithvazhathody
 * @date 9 Aug 2026
 * Project: CodeforceContestes
 * File: HowLongUntilNothing.java
 */

package contests.round1116;

/**
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// not submitting as this is from AI

public class HowLongUntilNothing {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        String tStr = scanner.next();
        if (tStr == null) return;
        
        int t = Integer.parseInt(tStr);
        StringBuilder output = new StringBuilder();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            
            // Sort ascending. This allows us to easily drop the largest elements
            // from the end of the array when we have huge bits (>= 2^30) available.
            Arrays.sort(a);
            
            int ans = n; // Minimum possible time is n
            
            while (true) {
                // Any bit >= 30 is > 10^9, so it completely satisfies any element.
                // H is the number of "huge" bits we have available.
                int H = Math.max(0, ans - 30);
                
                // We keep the smallest elements that cannot be covered by huge bits.
                int elementsToKeep = n - H;
                
                // If we have enough huge bits to cover every single element, we're done.
                if (elementsToKeep <= 0) {
                    break;
                }
                
                // Put ONLY the remaining elements into a Max-Heap. (Size is at most 30)
                PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
                for (int i = 0; i < elementsToKeep; i++) {
                    pq.add(a[i]);
                }
                
                // Distribute the remaining non-huge bits (from min(ans-1, 29) down to 0)
                int maxBit = Math.min(ans - 1, 29);
                for (int k = maxBit; k >= 0; k--) {
                    if (pq.isEmpty()) break;
                    
                    long maxNeed = pq.poll();
                    if (maxNeed <= 0) break;
                    
                    pq.add(maxNeed - (1L << k));
                }
                
                // If the largest remaining need is <= 0, this number of seconds is valid
                if (pq.isEmpty() || pq.peek() <= 0) {
                    break;
                }
                
                ans++;
            }
            
            output.append(ans).append("\n");
        }
        
        System.out.print(output);
    }

    // Fast I/O class for Competitive Programming
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}