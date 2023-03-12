You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        ListNode result = new ListNode(-1);
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((l1, l2) -> Integer.compare(l1.val, l2.val));
        for (ListNode list : lists) {
            ListNode current = list;
            while (current != null) {
                minHeap.offer(current);
                current = current.next;
            }
        }
        ListNode moving = result;
        while (!minHeap.isEmpty()) {
            ListNode top = minHeap.poll();
            moving.next = new ListNode(top.val);
            moving = moving.next;
        }
        return result.next;
    }
}