/*
This question is asked by Amazon. Given N distinct rooms that are locked we want to know if you can unlock and visit every room. Each room has a list of keys in it that allows you to unlock and visit other rooms. We start with room 0 being unlocked. Return whether or not we can visit every room.
 
Ex: Given the following rooms…

rooms = [[1], [2], []], return true
Ex: Given the following rooms…

rooms = [[1, 2], [2], [0], []], return false, we can’t enter room 3.
*/

import java.util.*;

public class LockedRooms {
	public static boolean canVisitRooms(List<List<Integer>> rooms) {
		int size = rooms.size();
		boolean [] visited = new boolean[size];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		visited[0] = true;
		while (!stack.isEmpty()) {
			int currentNode = stack.pop();
			for (int child : rooms.get(currentNode)) {
				if (!visited[child]) {
					visited[child] = true;
					stack.push(child);
				}
			} 
		}
		for (boolean isVisit : visited) {
			if (!isVisit)
				return false;
		}
		return true;
	}
}