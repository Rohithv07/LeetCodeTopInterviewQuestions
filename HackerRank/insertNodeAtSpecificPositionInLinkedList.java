https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem

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

    // Complete the insertNodeAtPosition function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
     static SinglyLinkedListNode getNode(int data) {
         return new SinglyLinkedListNode(data);
     }
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
    SinglyLinkedListNode current = head;  
    
    if( position == 0 ){
        newNode.next = head;
        return newNode;
    }
    
    int counter = 0;
    while( ++counter < position ){
        current = current.next;
    }
        
    newNode.next = current.next;   
    current.next = newNode;   
    
    return head;
    }
/*
Node newNode = new Node();
    newNode.data = data;
    Node current = head;  
    
    if( position == 0 ){
        newNode.next = head;
        return newNode;
    }
    
    int counter = 0;
    while( ++counter < position ){
        current = current.next;
    }
        
    newNode.next = current.next;   
    current.next = newNode;   
    
    return head;
*/
    private static final Scanner scanner = new Scanner(System.in);
