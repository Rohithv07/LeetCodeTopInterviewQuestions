import java.util.*;

public class ShortestPathWithObstacle {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int xf = sc.nextInt();
			int yf = sc.nextInt();
			// if there is no block
			int answer = Math.abs(x1 - x2) + Math.abs(y1 - y2);
			// if there is block, then answer + 2
			if ((x1 == x2 && x1 == xf && Math.min(y1, y2) < yf && yf < Math.max(y1, y2)) || (y1 == y2 && y1 == yf && Math.min(x1, x2) < xf && xf < Math.max(x1, x2)))
				answer += 2;
			System.out.println(answer);

		}
	}
}

