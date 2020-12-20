import java.util.*;

public class SwapWords {

	public static String reverseTheWord(String s) {
		if (s.length() == 0)
			return "";
		String [] wordArray = s.split(" ");
		StringBuilder sb = new StringBuilder();
		int length = wordArray.length;
		for (int i=length - 1; i>=0; i--) {
			sb.append(wordArray[i]);
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		System.out.println(reverseTheWord(word));
	}
}