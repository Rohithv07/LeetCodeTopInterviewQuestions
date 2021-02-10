
https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs



import java.io.*;
import java.util.*;

public class Solution {
    
    public static int [] shortestPath(int [][] grid, int n, int m, int start) {
        Map<Integer, List<Integer>> graph = buildGraph(grid, n);
        int [] distance = new int [n + 1];
        Arrays.fill(distance, n);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        distance[start] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            List<Integer> children = graph.get(current);
            for (Integer child : children) {
                if (distance[child] > distance[current] + 1) {
                    distance[child] = distance[current] + 1;
                    queue.offer(child);
                }
            }
        }
        return distance;
    }
    
    public static Map<Integer, List<Integer>> buildGraph(int [][] grid, int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=1; i<=n; i++)
            map.put(i, new ArrayList<>());
        for (int [] g : grid) {
            map.get(g[0]).add(g[1]);
            map.get(g[1]).add(g[0]);
        }
        return map;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][] grid = new int [m][2];
            for (int i=0; i<m; i++) {
                grid[i][0] = sc.nextInt();
                grid[i][1] = sc.nextInt();
            }
            int start = sc.nextInt();
            int [] result = shortestPath(grid, n, m, start);
            for (int i=1; i<=n; i++) {
                if (i != start)
                    System.out.print((result[i] == n ? -1 : result[i] * 6) + " ");
            }
            System.out.println();
        }
    }
}
