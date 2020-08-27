package com.rohith.datastructures;
import java.util.*;

public class JumpingNumbers {
	void bfs(int x, int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		while (!queue.isEmpty()) {
			num = queue.peek();
			queue.remove();
			if (num <= x) {
				System.out.print(num + " ");
				int lastDigit = num % 10;
				if (lastDigit == 0) 
					queue.add((num * 10) + (lastDigit+1));
				else if (lastDigit == 9)
					queue.add((num * 10) + (lastDigit-1));
				else {
					queue.add((num * 10) + (lastDigit-1));
					queue.add((num * 10) + (lastDigit+1));
				}
			}
		}
	}
	void printNumbers(int x) {
		System.out.print("0 ");
		for (int i=1; i<=9 && i<=x; i++)
			bfs(x, i);
	}
	public static void main(String[] args) {
		JumpingNumbers jn = new JumpingNumbers();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number upto which the jumping numbers have to be found:");
		int x =sc.nextInt();
		jn.printNumbers(x);
	}

}
