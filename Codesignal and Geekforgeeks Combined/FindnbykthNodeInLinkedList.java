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
