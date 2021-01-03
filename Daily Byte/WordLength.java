import java.util.*;

class WordLength {

	public static int lastWordLength(String s) {
		if (s.length() == 0 || s.charAt(0) == ' ')
			return 0;
		int length = s.length();
		int countLastWordLength = 0;
		for (int i=length-1; i>=0; i--) {
			char current = s.charAt(i);
			if (current == ' ')
				return countLastWordLength;
			countLastWordLength ++;
		}
		return countLastWordLength;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(lastWordLength(s));
	}
}