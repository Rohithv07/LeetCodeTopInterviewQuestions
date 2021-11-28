Given a sorted linked list of distinct nodes (no two nodes have the same data) and an integer X. Count distinct triplets in the list that sum up to given integer X.

Example 1:

Input: LinkedList: 1->2->4->5->6->8->9, X = 17
Output: 2
Explanation: Distinct triplets are (2, 6, 9) 
and (4, 5, 8) which have sum equal to X i.e 17.

Example 2:

Input: LinkedList: 1->2->4->5->6->8->9, X = 15
Output: 5
Explanation: (1, 5, 9), (1, 6, 8), (2, 4, 9), 
(2, 5, 8), (4, 5, 6) are the distinct triplets
Your Task:  
You don't need to read input or print anything. Complete the function countTriplets() which takes a head reference and X as input parameters and returns the triplet count

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ Number of Nodes ≤ 103 
1 ≤ Node value ≤ 104


class Solve
{
    static int countTriplets(Node head, int x) 
    { 
        //code here.
        if (head == null) {
            return 0;
        }
        boolean [] visited = new boolean [10001];
        Arrays.fill(visited, false);
        int count = 0;
        while (head != null) {
            Node next = head.next;
            while (next != null) {
                int current = x - (next.data + head.data);
                if (visited[Math.max(0, current)]) {
                    count++;
                }
                next = next.next;
            }
            visited[head.data] = true;
            head = head.next;
        }
        return count;
    } 
}