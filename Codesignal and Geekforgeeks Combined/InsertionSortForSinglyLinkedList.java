Given a singly linked list, sort the list (in ascending order) using insertion sort algorithm.

Example 1:

Input:
N = 10
Linked List = 30->23->28->30->11->14->
              19->16->21->25 
Output : 11 14 16 19 21 23 25 28 30 30 
Explanation :
The resultant linked list is sorted.
Example 2:

Input : 
N = 7
Linked List=19->20->16->24->12->29->30 
Output : 12 16 19 20 24 29 30 
Explanation : 
The resultant linked list is sorted.
Your task:
You don't need to read input or print anything. Your task is to complete the function insertionSort() which takes the head of the linked list, sorts the list using insertion sort algorithm and returns the head of the sorted linked list.
 
Expected Time Complexity : O(n2)
Expected Auxiliary Space : O(1)
 
Constraints:
1<=n<=10^5

class Solution
{
    
    public static Node insertionSort(Node head_ref)
    {
        Node ans=sortNode(head_ref);
        return ans;
    }
    
   public static Node sortNode(Node head){

        Node res = null;

        while(head != null){

            Node tmp=head.next;

            if(res == null || res.data > head.data){
                Node t=res;
                res=head;
                res.next=t;
            }

            else{
                Node cur=res;
                
                while(cur.next != null && cur.next.data <= head.data){
                    cur=cur.next;
                }

                Node nxt=cur.next;
                cur.next=head;
                head.next=nxt;
            }

            head=tmp;
        }

        return res;

    }

}