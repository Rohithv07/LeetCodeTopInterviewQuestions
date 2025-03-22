/*
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again 
by continuously following the next pointer. Internally, pos is used to denote the index of the node that 
tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 

Follow up: Can you solve it using O(1) (i.e. constant) memory?

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
 */


 
 class LinkedList {
    int nodeValue;
    LinkedList nextNode;

    public LinkedList(){}
    public LinkedList(int nodeValue) {
        this.nodeValue = nodeValue;
        this.nextNode = null;
    }
 }


 public class DetectCycleInLinkedList {
    public boolean isCycleInLinkedList(LinkedList node) {
        if (node == null || node.nextNode == null) {
            return false;
        }
        LinkedList slow = node;
        LinkedList fast = node;
        while (fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
 }

 /*
  * TC : O(Number of node)
  SC : O(1)

  Another approach involves using a hashset adn checking whether the node is already added to the set or not

  TC : O(Number of node)
  SC : O(Number of node)
  */