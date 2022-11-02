A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation is defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations needed to mutate from start to end. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

 

Example 1:

Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1
Example 2:

Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
Output: 2
Example 3:

Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
Output: 3
 

Constraints:

start.length == 8
end.length == 8
0 <= bank.length <= 10
bank[i].length == 8
start, end, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].


class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        Set<String> bankString = new HashSet<>();
        for (String s : bank) {
            bankString.add(s);
        }
        return bfs(start, end, bankString);
    }
    
    private int bfs(String start, String end, Set<String> bankString) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int minTime = 0;
        char [] tryChar = new char []{'A', 'C', 'G', 'T'};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(end)) {
                    return minTime;
                }
                char [] currentArray = current.toCharArray();
                for (int j = 0; j < 8; j++) {
                    char temp = currentArray[j];
                    for (int k = 0; k < 4; k++) {
                        if (temp != tryChar[k]) {
                            currentArray[j] = tryChar[k];
                            String afterString = new String(currentArray);
                            if (bankString.contains(afterString) && !visited.contains(afterString)) {
                                queue.offer(afterString);
                                visited.add(afterString);
                            }
                        }
                    }
                    currentArray[j] = temp;
                }
            }
            minTime++;
        }
        return -1;
    }
}