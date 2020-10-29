You like playing chess tournaments online.

In your last tournament you played n games. For the sake of this problem, each chess game is either won or lost (no draws). When you lose a game you get 0 points. When you win you get 1 or 2 points: if you have won also the previous game you get 2 points, otherwise you get 1 point. If you win the very first game of the tournament you get 1 point (since there is not a "previous game").

The outcomes of the n games are represented by a string s of length n: the i-th character of s is W if you have won the i-th game, while it is L if you have lost the i-th game.

After the tournament, you notice a bug on the website that allows you to change the outcome of at most k of your games (meaning that at most k times you can change some symbol L to W, or W to L). Since your only goal is to improve your chess rating, you decide to cheat and use the bug.

Compute the maximum score you can get by cheating in the optimal way.

Input
Each test contains multiple test cases. The first line contains an integer t (1≤t≤20,000) — the number of test cases. The description of the test cases follows.

The first line of each testcase contains two integers n,k (1≤n≤100,000, 0≤k≤n) – the number of games played and the number of outcomes that you can change.

The second line contains a string s of length n containing only the characters W and L. If you have won the i-th game then si=W, if you have lost the i-th game then si=L.

It is guaranteed that the sum of n over all testcases does not exceed 200,000.


import java.util.*;
public class con3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
		for (int z = 0; z < t; ++z) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.next();
			
			int cs = 0;
			int los = 0;
			for (int i = 0; i < n; ++i) {
				if (s.charAt(i)=='W') {
					++cs;
					if (i>0&&s.charAt(i-1)=='W')
						++cs;
				} else {
					++los;
				}
			}
			if (k==0) {
				System.out.println(cs);
				continue;
			}
			if (cs==0) {
				System.out.println(k*2-1);
				continue;
			}
			if (k>=los) {
				System.out.println(n*2-1);
				continue;
			}
			int bet = -10000000;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 0; i < n; ++i) {
				if (s.charAt(i)=='W') {
					if (bet>0)
						pq.add(bet);
					bet = 0;
				} else {
					++bet;
				}
			}
			cs += 2*k;
			while (!pq.isEmpty()) {
				int np = pq.poll();
				if (np>k)
					break;
				k-=np;
				++cs;
			}
			System.out.println(cs);
        }
    }
}
