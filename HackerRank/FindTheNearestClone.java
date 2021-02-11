https://www.hackerrank.com/challenges/find-the-nearest-clone/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs



// ref : https://www.google.com/search?rlz=1C1GCEB_enIN931IN931&q=find+the+nearest+clone+hackerrank+solution+java&sa=X&ved=2ahUKEwir_IOswOHuAhVZOisKHTb-CbEQ1QIoAHoECAoQAQ&biw=1920&bih=969#kpvalbx=_0fYkYJ-ZLM_LrQG7nI_wCg17

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here
        List<Integer> [] map = new ArrayList[graphNodes];
        Map<Integer, Integer> count = new HashMap<>();
        for (int i=0; i<graphNodes; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i=0; i<graphFrom.length; i++) {
            map[graphFrom[i] - 1].add(graphTo[i]);
            map[graphTo[i] - 1].add(graphFrom[i]);
        }
        Queue<Integer> queue = new LinkedList<>();
        // search for those nodes with the target color value and add those nodes to the queue and do the bfs
        for (int i=0; i<ids.length; i++) {
            if (ids[i] == val) {
                queue.offer(i + 1);
                count.put(i + 1, 0);
            }
        }
        if (queue.size() < 2)
            return -1;
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited.add(current);
            List<Integer> children = map[current - 1];
            for (Integer child : children) {
                if (!visited.contains(child) && count.containsKey(child)) {
                    return count.get(child) + count.get(current) + 1;
                }
                queue.offer(child);
                count.put(child, count.get(current) + 1);
            }
        }
        return -1;
    }
