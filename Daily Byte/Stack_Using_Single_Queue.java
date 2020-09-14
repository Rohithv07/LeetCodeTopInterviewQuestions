Implement stack using a single queue

import java.io.*;
import java.util.*;
class QueueStack {
    private static Queue<Integer> queue = new LinkedList<>();
    public QueueStack() {
        this.queue = queue;
    }
    public static void add(int x) {
        queue.add(x);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size --;
        }
    }
    public static int pop() {
        return queue.remove();
    }
    public static boolean empty() {
        return queue.isEmpty();
    }
    public static int top() {
        return queue.peek();
    }
	public static void main (String[] args) {
        QueueStack q = new QueueStack();
        q.add(5);
        q.add(10);
        q.add(15);
        System.out.println(q.pop());
        System.out.println(q.empty());
        System.out.println(q.top());
        
	}
}
