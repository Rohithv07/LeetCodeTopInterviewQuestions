// except one test case all other test case passed


import java.util.*;

public class TeamName {

	public static int goodTeamNamesNumber(List<String> list) {
		int n = list.size();
		int count = 0;
		Set<String> set = new HashSet<>(list);
		// whether first letter same for every string
		if (isFirstLetterSame(list))
			return 0;
		for (int i=0; i<list.size(); i++) {
			for (int j = i+1; j<list.size(); j++) {
				String word1 = list.get(i);
				char ch1 = word1.charAt(0);
				String word2 = list.get(j);
				char ch2 = word2.charAt(0);
				StringBuilder sb1 = new StringBuilder();
				sb1.append(ch2);
				StringBuilder sb2 = new StringBuilder();
				sb2.append(ch1);
				String remaining1 = word1.substring(1);
				String remaining2 = word2.substring(1);
				sb1.append(remaining1);
				sb2.append(remaining2);
				if (!set.contains(sb1.toString()) && !set.contains(sb2.toString()))
					count += 1;
			}
		}
		return count * 2;
	}

	public static boolean isFirstLetterSame(List<String> list) {
		String firstWord = list.get(0);
		char firstChar = firstWord.charAt(0);
		for (int i=1; i<list.size(); i++) {
			String word = list.get(i);
			char ch = word.charAt(0);
			if (ch != firstChar)
				return false;
		}
		return true;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			List<String> list = new ArrayList<>();
			for (int i=0; i<n; i++) {
				String funny = sc.next();
				list.add(funny);
			}
			System.out.println(goodTeamNamesNumber(list));
		}
	}
}