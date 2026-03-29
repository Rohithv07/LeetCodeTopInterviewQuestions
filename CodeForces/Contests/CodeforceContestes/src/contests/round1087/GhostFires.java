package contests.round1087;

import java.io.*;
import java.util.*;

public class GhostFires {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int r = sc.nextInt();
			int g = sc.nextInt();
			int b = sc.nextInt();
			String ans = findAnswer(r, g, b);
			System.out.println(ans);
		}
		sc.close();
	}

	private static String findAnswer(int r, int g, int b) {
		Color[] colors = new Color[] { new Color('R', r), new Color('G', g), new Color('B', b) };
		Arrays.sort(colors);
		char X = colors[0].ch;
		int cx = colors[0].count;
		char Y = colors[1].ch;
		int cy = colors[1].count;
		char Z = colors[2].ch;
		int cz = colors[2].count;
		StringBuilder out = new StringBuilder();
		int S = cy + cz;
		if (cx > S) {
			for (int i = 0; i < S; i++) {
				out.append(X);
				if (i < cy)
					out.append(Y);
				else
					out.append(Z);
			}
			out.append(X);
		} else {
			if (cx == cy) {
				int pairs = cx - cz;
				for (int i = 0; i < pairs; i++) {
					out.append(X).append(Y);
				}
				appendCyclicBlocks(out, cz, Z, Y, X);
			} else {
				int k = cy + cz - cx + 1;
				int a = cx - k;
				int bCount = cy - k;

				for (int i = 0; i < a - 1; i++) {
					out.append(X);
					if (i < bCount)
						out.append(Y);
					else
						out.append(Z);
				}
				out.append(X);

				appendCyclicBlocks(out, k, Y, X, Z);
			}
		}
		return out.toString();
	}

	private static void appendCyclicBlocks(StringBuilder out, int k, char c1, char c2, char c3) {
		for (int i = 0; i < k; i++) {
			if (i % 3 == 0) {
				out.append(c1).append(c2).append(c3);
			} else if (i % 3 == 1) {
				out.append(c2).append(c3).append(c1);
			} else {
				out.append(c3).append(c1).append(c2);
			}
		}
	}
}

class Color implements Comparable<Color> {
	char ch;
	int count;

	public Color(char ch, int count) {
		this.ch = ch;
		this.count = count;
	}

	@Override
	public int compareTo(Color other) {
		return Integer.compare(other.count, this.count);
	}
}