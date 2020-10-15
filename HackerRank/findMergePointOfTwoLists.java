https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=7-day-campaign

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null || head2 == null)
            return 0;
        SinglyLinkedListNode nodeA = head1;
        SinglyLinkedListNode nodeB = head2;
        while (nodeA != nodeB) {
            if (nodeA == null)
                nodeA = head2;
            else
                nodeA = nodeA.next;
            if (nodeB == null)
                nodeB = head1;
            else
                nodeB = nodeB.next;
        }
        return nodeA.data;

    }

    private static final Scanner scanner = new Scanner(System.in);
