class Solution {
    public int minJumps(int[] arr) {
        if (arr.length == 1)
            return 0;
        Map<Integer, List<Integer>> graph = buildGraph(arr);
        boolean [] visited = new boolean[arr.length];
        int count = 0;
        visited[0] = true;
        // bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=size; i>0; i--) {
                int current = queue.poll();
                if (current == arr.length - 1)
                    return count;
                List<Integer> possibleNext = graph.get(arr[current]);
                possibleNext.add(current - 1);
                possibleNext.add(current + 1);
                for (Integer next : possibleNext) {
                    if (next >= 0 && next < arr.length && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
                possibleNext.clear();
            }
            count += 1;
        }
        return count;
    }
    
    public Map<Integer, List<Integer>> buildGraph(int [] arr) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // build the graph
        for (int i=0; i<arr.length; i++) {
            graph.computeIfAbsent(arr[i], x->new LinkedList<>()).add(i);
        }
        return graph;
    }
}
