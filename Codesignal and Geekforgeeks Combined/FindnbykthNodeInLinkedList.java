Given a singly linked list and a number k. Write a function to find the (N/k)th element, where N is the number of elements in the list. We need to consider ceil value in case of decimals.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case consists of an integer N. The second line consists of N spaced integers.The last line consists of an integer k.

Output:
Print the data value of (N/k)th node in the Linked List.

User Task:
The task is to complete the function fractional_node() which should find the n/kth node in the linked list and return its data value.

Constraints: 
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
6
1 2 3 4 5 6
2
5
2 7 9 3 5
3

Output:
3
7

Explanation:
Testcase 1: 6/2th element is the 3rd(1-based indexing) element which is 3.






/*
class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class GfG
{
    public static int nknode(Node head, int k)
    {
       // add your code here
       if (head == null || k <= 0) {
           return -1;
       }
       int length = 0;
       Node current = head;
       while (current != null) {
           length += 1;
           current = current.next;
       }
       int placeOfNode = (length / k) + (length % k == 0 ? 0 : 1); // ceil
       if (placeOfNode > length) {
           return -1;
       }
       int mover = 0;
       current = head;
       while (placeOfNode-- > 1) {
           current = current.next;
       }
       return current.data;
    }
}


// optimised :

/*
class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class GfG
{
    public static int nknode(Node head, int k)
    {
       // add your code here
       Node slow = head;
       Node fast = head;
       // move fast as it is and move slow when we have a counter divisible by k
       int counter = 1;
       while (fast.next != null) {
           fast = fast.next;
           slow = (counter++%k == 0) ? slow.next : slow;
       }
       return slow.data;
    }
}
