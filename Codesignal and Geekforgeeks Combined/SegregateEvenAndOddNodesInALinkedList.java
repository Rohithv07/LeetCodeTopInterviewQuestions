Given a link list of size N, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be same as that in the original list.

NOTE: Don't create a new linked list, instead rearrange the provided one.


Example 1:

Input: 
N = 7
Link List:
17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6 -> NULL

Output: 8 2 4 6 17 15 9

Explaination: 8,2,4,6 are the even numbers 
so they appear first and 17,15,9 are odd 
numbers that appear later.

Example 2:

Input:
N = 4
Link List:
1 -> 3 -> 5 -> 7

Output: 1 3 5 7

Explaination: There is no even number. 
So ne need for modification.

Your Task:
You do not need to read input or print anything. Your task is to complete the function divide() which takes N and head of Link List as input parameters and returns the head of modified link list. Don't create a new linked list, instead rearrange the provided one.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ Each element of the list ≤ 105


/* 
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution{
    Node divide(int n, Node head){
        // code here
        if (head == null) {
            return null;
        }
        Node even = new Node(0);
        Node evenCurrent = even;
        Node odd = new Node(0);
        Node oddCurrent = odd;
        Node current = head;
        while (current != null) {
            if (current.data % 2 == 0) {
                evenCurrent.next = new Node(current.data);
                evenCurrent = evenCurrent.next;
            }
            else {
                oddCurrent.next = new Node(current.data);
                oddCurrent = oddCurrent.next;
            }
            current = current.next;
        }
        if (even.next == null) {
            return odd.next;
        }
        evenCurrent.next = odd.next;
        return even.next;
    }
}