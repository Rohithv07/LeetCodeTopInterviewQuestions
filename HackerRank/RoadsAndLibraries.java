https://www.hackerrank.com/challenges/torque-and-development/submissions/code/199751444?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs

public class Solution {
    static int count = 0;
    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, long c_lib, long c_road, int[][] cities) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        long sum = 0;
        for (int i=1; i<=n; i++) {
            graph.put(i, new LinkedList<>());
        }
        for (int [] city : cities) {
            graph.get(city[0]).add(city[1]);
            graph.get(city[1]).add(city[0]);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i=1; i<=graph.size(); i++) {
            if (!visited.contains(i)) {
                count = 0; // connected
                dfs(graph, i, visited);
                if (c_lib > c_road) {
                    sum += c_lib + c_road * (count - 1);  
                }
                else {
                    sum += c_lib * count;
                }
            }
        }
        return sum;
    }
    
    static void dfs(Map<Integer, List<Integer>> graph, int i, Set<Integer> visited) {
        visited.add(i);
        count += 1;
        List<Integer> children = graph.get(i);
        for (Integer child : children) {
            if (!visited.contains(child)) {
                dfs(graph, child, visited);
            }
        }
        
    }
