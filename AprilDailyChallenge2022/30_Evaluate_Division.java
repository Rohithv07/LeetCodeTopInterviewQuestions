You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

 

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 

Constraints:

1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.


class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // dfs, find a path between node and multiply everything bw nodes
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double [] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }
        return result;
    }
    
    private double dfs(Map<String, Map<String, Double>> graph, String q1, String q2, Set<String> visited) {
        if (!graph.containsKey(q1)) {
            return -1.0;
        }
        if (graph.get(q1).containsKey(q2)) {
            return graph.get(q1).get(q2);
        }
        visited.add(q1);
        for (Map.Entry<String, Double> children : graph.get(q1).entrySet()) {
            if (!visited.contains(children.getKey())) {
                double product = dfs(graph, children.getKey(), q2, visited);
                if (product != -1.0) {
                    return children.getValue() * product;
                }
            }
        }
        return -1.0;
    }
    
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double [] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int index = 0;
        for (List<String> equation : equations) {
            String u = equation.get(0);
            String v = equation.get(1);
            double weight = values[index++];
            graph.computeIfAbsent(u, x -> new HashMap<>()).put(v, weight);
            graph.computeIfAbsent(v, x -> new HashMap<>()).put(u, 1 / weight);
        }
        return graph;
    }
}