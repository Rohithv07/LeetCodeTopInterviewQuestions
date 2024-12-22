/**
 * 
 */
package practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 */
public class SantaClausII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		long sRow = sc.nextLong();
		long sCol = sc.nextLong();
		long[][] mat = new long[n][2];
		for (int i = 0; i < n; i++) {
			mat[i][0] = sc.nextLong();
			mat[i][1] = sc.nextLong();
		}
		Doubles[] seq = new Doubles[m];
		for (int i = 0; i < m; i++) {
			seq[i] = new Doubles(sc.next().charAt(0), sc.nextLong());
		}
		findFinalMoves(seq, mat, sRow, sCol, n, m);
		sc.close();
	}

	private static void findFinalMoves(Doubles[] seq, long[][] mat, long sRow, long sCol, int n, int m) {
		Set<String> houses = new HashSet<>();
		StringBuilder sb;
		for (long[] mm : mat) {
			sb = new StringBuilder();
			sb.append(mm[0]).append("$").append(mm[1]);
			houses.add(sb.toString());
		}
		//System.out.println(houses.size());
		int initialSize = houses.size();
		for (Doubles move : seq) {
			char ch = move.ch;
			long howMuch = move.move;
			long temp1 = sRow;
			long temp2 = sCol;
			switch (ch) {
			case 'L':
				sRow -= howMuch;
				if (sRow < Long.MIN_VALUE || sCol < Long.MIN_VALUE || sRow > Long.MAX_VALUE
						|| sCol > Long.MAX_VALUE) {
					sRow = temp1;
					continue;
				}
				
				sb = new StringBuilder();
				sb.append(sRow).append("$").append(sCol);
				String s1 = sb.toString();
				if (houses.contains(s1)) {
					houses.remove(s1);
				}
				break;
			case 'R':
				sRow += howMuch;
				if (sRow < Long.MIN_VALUE || sCol < Long.MIN_VALUE || sRow > Long.MAX_VALUE
						|| sCol > Long.MAX_VALUE) {
					sRow = temp1;
					continue;
				}
				sb = new StringBuilder();
				sb.append(sRow).append("$").append(sCol);
				String s2 = sb.toString();
				if (houses.contains(s2)) {
					houses.remove(s2);
				}
				break;
			case 'U':
				sCol -= howMuch;
				if (sRow < Long.MIN_VALUE || sCol < Long.MIN_VALUE || sRow > Long.MAX_VALUE
						|| sCol > Long.MAX_VALUE) {
					sCol = temp2;
					continue;
				}
				sb = new StringBuilder();
				sb.append(sRow).append("$").append(sCol);
				String s3 = sb.toString();
				if (houses.contains(s3)) {
					houses.remove(s3);
				}
				break;
			case 'D':
				sCol += howMuch;
				if (sRow < Long.MIN_VALUE || sCol < Long.MIN_VALUE || sRow > Long.MAX_VALUE
						|| sCol > Long.MAX_VALUE) {
					sRow = temp2;
					continue;
				}
				sb = new StringBuilder();
				sb.append(sRow).append("$").append(sCol);
				String s4 = sb.toString();
				if (houses.contains(s4)) {
					houses.remove(s4);
				}
				break;
			}
		}
		System.out.println(sRow + " " + sCol + " " + (initialSize - houses.size()));

	}

}

class Doubles {
	char ch;
	long move;

	Doubles(char ch, long move) {
		this.ch = ch;
		this.move = move;
	}
}
