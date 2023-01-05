You are given two four digit prime numbers Num1 and Num2. Find the distance of the shortest path from Num1 to Num2 that can be attained by altering only single digit at a time such that every number that we get after changing a digit is a four digit prime number with no leading zeros.

 

Example 1:

Input:
Num1 = 1033 
Num2 = 8179
Output: 6
Explanation:
1033 -> 1733 -> 3733 -> 3739 -> 3779 -> 8779 -> 8179.
There are only 6 steps reuired to reach Num2 from Num1. 
and all the intermediate numbers are 4 digit prime numbers.
 

Example 2:

Input:
Num1 = 1033 
Num2 = 1033
Output:
0
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function solve() which takes two integers Num1 and Num2 as input parameters and returns the distance of the shortest path from Num1 to Num2. If it is unreachable then return -1.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)



class Solution
{
    int[] prime;
    Solution()
    {
        // Every index of prime stores zero or one
        // If prime[i] is zero means i is not a prime
        // If prime[i] is one means i is a prime
        prime = new int [10001];
        Arrays.fill(prime, 1);
        for (int i=2; i*i <= 10000; i++) {
            if (prime[i] == 1) {
                for (int j=2; j*i<=10000; j++) {
                    prime[i * j] = 0;
                }
            }
        }
    }
    
    public int solve(int num1,int num2){
        // Complete this function using prime array
        if (num1 == num2)
            return 0;
        boolean [] visited = new boolean [10001];
        Queue<Integer> queue = new LinkedList<>();
        visited[num1] = true;
        queue.add(num1);
        int count = 0;
        List<List<Integer>> graph = buildGraph();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int current = queue.poll();
                if (current == num2)
                    return count;
                List<Integer> children = graph.get(current);
                for (Integer child : children) {
                    if (!visited[child])
                        queue.add(child);
                        visited[child] = true;
                }
            }
            count += 1;
        }
        return -1;
    }
    
    public boolean compareString(int n1, int n2) {
        String sn1 = String.valueOf(n1);
        String sn2 = String.valueOf(n2);
        int change = 0;
        if (sn1.charAt(0) != sn2.charAt(0))
            change += 1;
        if (sn1.charAt(1) != sn2.charAt(1))
            change += 1;
        if (sn1.charAt(2) != sn2.charAt(2))
            change += 1;
        if (sn1.charAt(3) != sn2.charAt(3))
            change += 1;
        return change == 1;
        
    }
    
    public List<List<Integer>> buildGraph() {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<=10000; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=1000; i<=10000; i++) {
            if (prime[i] == 1) {
                for (int j=i+1; j<=10000; j++) {
                    if (prime[j] == 1 && compareString(i, j)) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }
        }
        return graph;
    }
}


// without using strings

class Solution
{
    int[] prime;
    final int MAX = 9999;
    Solution()
    {
        // Every index of prime stores zero or one
        // If prime[i] is zero means i is not a prime
        // If prime[i] is one means i is a prime
        prime = new int [MAX + 1];
        Arrays.fill(prime, 1);
        prime[0] = 0;
        prime[1] = 0;
        for (int i = 2; i * i < MAX + 1; i++) {
            if (prime[i] == 1) {
                for (int j = i; j * i < MAX + 1; j++) {
                    prime[i * j] = 0;
                }
            }
        }
    }
    
    public int shortestPath(int num1,int num2){
        // Complete this function using prime array
        if (num1 == num2) {
            return 0;
        }
        return bfs(num1, num2);
    }
    
    private int bfs(int n1, int n2) {
        Queue<Integer> queue = new LinkedList<>();
        int shortestDistance = 0;
        queue.offer(n1);
        Set<Integer> visited = new HashSet<>();
        visited.add(n1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int top = queue.poll();
                if (top == n2) {
                    return shortestDistance;
                }
                // we have 4 digit numbers only
                for (int digit = 0; digit < 4; digit++) {
                    for (int num = 0; num < 10; num++) {
                        int nextNumber = top;
                        nextNumber -= (nextNumber / (int)(Math.pow(10, digit))) % 10 * (int)(Math.pow(10, digit));
                        nextNumber += num * (int)(Math.pow(10, digit));
                        if (nextNumber >= 1000 && nextNumber <= 9999 && !visited.contains(nextNumber)
                        && prime[nextNumber] == 1) {
                            queue.offer(nextNumber);
                            visited.add(nextNumber);
                        }
                    }
                }
            }
            shortestDistance++;
        }
        return -1;
    }
}
