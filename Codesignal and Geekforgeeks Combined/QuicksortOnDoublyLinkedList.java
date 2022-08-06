Sort the given doubly linked list of size N using quicksort. Just complete the partition function using the quicksort technique.
 

Example 1:

Input:
LinkedList: 4->2->9
Output:
2 4 9
Explaination: After sorting output will look like this.

Example 2:
Input:
LinkedList: 1->4->9->2
Output:
1 2 4 9
Explaination: After sorting output will look like this.


Your Task:
Your task is to complete the given function partition(), which accepts the first and last node of the given linked list as input parameters and returns the pivot's address.
 

Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(1)
 

Constraints:
1 <= N <= 2000
1 <= Each Element of Double Linked List <= 105
class GfG
{
    public static Node partition(Node l, Node h)
    {
        //code here.
        int pivot = h.data;
        Node left1 = l;
        Node left2 = l;
        while (left1 != h) {
            if (left1.data < pivot) {
                swap(left1, left2);
                left2 = left2.next;
            }
            left1 = left1.next;
        }
        swap(left2, h);
        return left2;
    }
    
    private static void swap(Node node1, Node node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }
}