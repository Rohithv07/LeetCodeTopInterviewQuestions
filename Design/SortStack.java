
// sort the stack using recursion


import java.util.*;

public class SortStack {

	static void sortedInsert(Stack<Integer> stack, int value) {
		if (stack.isEmpty()) {
			stack.push(value);
			return;
		}
		if (value > stack.peek()) {
			stack.push(value);
			return;
		}
		// else the current top is the largest value and we need that maximum value as the topmost everytime
		// so we just pop it out and recur again inorder find the position for insetting the value and atlast the stored
		// value is put back into the stack
		int store = stack.pop();
		sortedInsert(stack, value);
		stack.push(store);
	}

	static void sortStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int top = stack.pop();
		sortStack(stack);
		sortedInsert(stack, top);
	}


	static void printStack(Stack<Integer> s)
    {
        ListIterator<Integer> lt = s.listIterator();
 
        // forwarding
        while (lt.hasNext())
            lt.next();
 
        // printing from top to bottom
        while (lt.hasPrevious())
            System.out.print(lt.previous() + " ");
    }
 
    // Driver code
    public static void main(String[] args)
    {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
 
        System.out.println(
            "Stack elements before sorting: ");
        printStack(s);
 
        sortStack(s);
 
        System.out.println(
            " \n\nStack elements after sorting:");
        printStack(s);
    }
}