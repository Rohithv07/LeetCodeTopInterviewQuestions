This question is asked by Facebook. Given a string, reverse the vowels of it.
Note: In this problem y is not considered a vowel.

Ex: Given the following strings s…

s = "computer", return "cemputor"
Ex: Given the following strings s…

s = "The Daily Byte", return "The Dialy Byte"


// here we can make use of two pointers approach. Here I just consider the small letters only
// since string is immutable we need to copy s to a stringbuilder and then swap the letters required
import java.util.*;
public class Solution {
	public static String reverseVowels(String s) {
		if (s.length() == 0 || s.length() == 1)
			return s;
		Set<Character> vowelSet = new HashSet<>();
		vowelSet.add('a');
		vowelSet.add('e');
		vowelSet.add('i');
		vowelSet.add('o');
		vowelSet.add('u');
		int leftPointer = 0;
		int rightPointer = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
		while (leftPointer < rightPointer) {
			if (vowelSet.contains(s.charAt(leftPointer)) && vowelSet.contains(s.charAt(rightPointer))) {
				sb.setCharAt(leftPointer, s.charAt(rightPointer));
                sb.setCharAt(rightPointer, s.charAt(leftPointer));
				leftPointer += 1;
				rightPointer -= 1;
			}
			else if (vowelSet.contains(s.charAt(leftPointer))) {
				rightPointer -= 1;
            }
			else if (vowelSet.contains(s.charAt(rightPointer))) {
				leftPointer += 1;
            }
            else {
                leftPointer += 1;
                rightPointer -= 1;
            }
		}
		return sb.toString();
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(reverseVowels(s));
	}
}
