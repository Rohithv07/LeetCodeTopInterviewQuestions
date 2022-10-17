class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        
        int length = 0;
        ListNode temp = head;
        while(temp.next!=null){
            length++;
            temp = temp.next;
        }
        length++;
        
        temp.next = head;
        k = k%length;
        k = length-k-1;
        temp = head;
        while(k--!=0){
            temp = temp.next;
        }
        
        ListNode newHead = temp.next;
        temp.next = null;
        head = newHead;
        
        return head;
    }
}
