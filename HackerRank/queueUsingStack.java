https://www.hackerrank.com/challenges/queue-using-two-stacks/problem

import java.io.*;
import java.util.*;

public class Solution {
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();
    private static int front;
    public Solution() {
        this.stack1 = stack1;
        this.stack2 = stack2;
        this.front = front;
    }
    public static void enqueue (int x) {
        if (stack1.isEmpty())
            front = x;
        stack1.push(x);
    }
    public static void dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        stack2.pop();
    }
    public static int top() {
        if (!stack2.isEmpty())
            return stack2.peek();
        return front;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == 1) {
                int x = sc.nextInt();
                enqueue(x);
            }
            else if (n == 2) {
                dequeue();
            }
            else
                System.out.println(top());
        }


    }
}
