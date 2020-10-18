https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem




    // Complete the getNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        int index = 0;
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode result = head;
        while (current != null) {
            current = current.next;
            if (index ++ > positionFromTail)
                result = result.next;
        }
        return result.data;
    }


