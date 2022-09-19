/**
 * 
 */
package kickstart;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class SortTheFabric {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			Triple[] triple = new Triple[n];
			for (int i = 0; i < n; i++) {
				triple[i] = new Triple(sc.next(), sc.nextInt(), sc.nextInt());
			}
			System.out.println("Case #" + t + ": " + findCount(triple, n));
		}
	}

	private static int findCount(Triple[] triple, int n) {

		Triple[] ada = triple.clone();
		Triple[] charles = triple.clone();
		Arrays.sort(ada,
				(t1, t2) -> t1.s.equals(t2.s) ? Integer.compare(t1.identity, t2.identity) : t1.s.compareTo(t2.s));
		Arrays.sort(charles, (t1, t2) -> t1.durability == t2.durability ? Integer.compare(t1.identity, t2.identity)
				: Integer.compare(t1.durability, t2.durability));
		int sameCount = 0;
		for (int i = 0; i < n; i++) {
			Triple currentAda = ada[i];
			Triple currentCharles = charles[i];
			if (currentAda.s.equals(currentCharles.s) && currentAda.durability == currentCharles.durability
					&& currentAda.identity == currentCharles.identity) {
				sameCount++;
			}
		}
		return sameCount;
	}
}

class Triple {
	String s;
	int durability;
	int identity;

	public Triple(String s, int durability, int identity) {
		this.s = s;
		this.durability = durability;
		this.identity = identity;
	}
}
