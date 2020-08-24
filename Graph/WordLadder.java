package com.rohith.datastructures;
import java.util.*;

public class WordLadder {
	static int shortestChainLength(String start, String target, Set<String> dictionary) {
		if (!dictionary.contains(target))
			return 0;
		int length = 0;
		int startLength = start.length();
		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			length += 1;
			int size = queue.size();
			for (int i=0; i<size; i++) {
				char [] word = queue.peek().toCharArray();
				queue.remove();
				for (int pos=0; pos<startLength; pos++) {
					char originalPos = word[pos];
					for (char c='a'; c<='z'; c++) {
						word[pos] = c;
						if (String.valueOf(word).equals(target))
							return length + 1;
						if (!dictionary.contains(String.valueOf(word)))
							continue;
						dictionary.remove(String.valueOf(word));
						queue.add(String.valueOf(word));
					}
					word[pos] = originalPos;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		
		Set<String> D = new HashSet<String>(); 
	    D.add("poon"); 
	    D.add("plee"); 
	    D.add("same"); 
	    D.add("poie"); 
	    D.add("plie"); 
	    D.add("poin"); 
	    D.add("plea"); 
	    String start = "toon"; 
	    String target = "plea"; 
	    System.out.print("Length of shortest chain is: "
	        + shortestChainLength(start, target, D)); 

	}

}
