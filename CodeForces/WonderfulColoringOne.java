import java.util.*;

public class WonderfulColoringOne {

	public static int findColorCount(String s) {
		if (s.length() == 1)
			return 0;
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		// if (map.size() == 1)
		// 	return 1;
		int letterOneFrequency = 0;
		int letterMoreThanOneFrequency = 0;
		for (char key : map.keySet()) {
			if (map.get(key) == 1)
				letterOneFrequency += 1;
			else if (map.get(key) > 1)
				letterMoreThanOneFrequency += 1;
		}
		return (letterOneFrequency / 2)+ letterMoreThanOneFrequency;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			System.out.println(findColorCount(s));
		}
	}
}