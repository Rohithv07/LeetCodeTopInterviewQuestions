import java.util.*;
import java.io.*;

public class ConcertTicket {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt(); // Number of tickets
        int m = sc.nextInt(); // Number of customers

        // TreeMap to store Price -> Count (acts as a Multiset)
        TreeMap<Integer, Integer> tickets = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int price = sc.nextInt();
            tickets.put(price, tickets.getOrDefault(price, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            int maxPrice = sc.nextInt();
            
            // Find the largest price <= maxPrice
            Integer bestFit = tickets.floorKey(maxPrice);

            if (bestFit == null) {
                out.println("-1");
            } else {
                out.println(bestFit);
                
                // Remove one instance of this ticket
                int count = tickets.get(bestFit);
                if (count == 1) {
                    tickets.remove(bestFit);
                } else {
                    tickets.put(bestFit, count - 1);
                }
            }
        }
        out.close();
    }

    // Fast I/O Utility
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }
}