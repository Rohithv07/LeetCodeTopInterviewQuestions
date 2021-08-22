import java.util.*;

public class ShuffledAnagrams {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t=1; t<=test; t++) {
			String s = sc.next();
			System.out.println("Case #" + t + ": " + shuffle(s));
		}
	}

	public static String shuffle(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int max = -1;
		for (char key : map.keySet()) {
			max = Math.max(max, map.get(key));
		}
		if (max > s.length() - max) {
			return "IMPOSSIBLE";
		}
		int length = s.length();
		char [] ch = s.toCharArray();
		List<Pair> pos = new ArrayList<>();
		for (int i=0; i<length; i++) {
			pos.add(new Pair(ch[i], i));
		}
		Collections.sort(pos, (p1, p2) -> p1.ch - p2.ch);
		for (int i=0; i<length; i++) {
			ch[pos.get((i + max) % length).index] = pos.get(i).ch;
		}
		return new String(ch);
	}
}

class Pair {
	char ch;
	int index;

	public Pair(char ch, int index) {
		this.index = index;
		this.ch = ch;
	}
}