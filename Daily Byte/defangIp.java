This question is asked by Amazon. Given a valid IP address, defang it.
Note: To defang an IP address, replace every ”.”, with ”[.]”.

Ex: Given the following address…

address = "127.0.0.1", return "127[.]0[.]0[.]1"

import java.util.*;

public class Solution {
	public static String defangIpAddress(String ip) {
		Stack<Character> stack = new Stack<>(); // storing the characters of the ip
		// now we traverse thorught the string and check for .
		for (char letter: ip.toCharArray()) {
			if (letter == '.') {
				stack.push('[');
				stack.push('.');
				stack.push(']');
			}
			else
				stack.push(letter);
		}
		// now makw use of a string builder and append the characters from the stack and finally reverse it
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.push());
		}
		return sb.reverse().toString();
	}
	public static void main(String [] args) {
		String ip = "127.0.0.1";
		System.out.println(defangIpAddress(ip));
	}
}


// 2nd approach with no stack and making use of only stringbuilder
import java.util.*;

public class Solution {
	public static String defangIpAddress(String ip) {
		StringBuilder sb = new StringBuilder();
        for (char letter: ip.toCharArray()) {
            if (letter == '.') {
                sb.append('[');
                sb.append('.');
                sb.append(']');
            }
            else
                sb.append(letter);
        }
        return sb.toString();
	}
	public static void main(String [] args) {
		String ip = "127.0.0.1";
		System.out.println(defangIpAddress(ip));
	}
}
