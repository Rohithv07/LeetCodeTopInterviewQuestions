//https://www.geeksforgeeks.org/minimize-cash-flow-among-given-set-friends-borrowed-money/


/*
You and your friends went on a vacation. During this vacation you and your friends paid for one another for various things like food and entertainment. For example, Kevin might have paid $20 for Alex’s food. Now that the vacation is over, it’s time to settle your debts. Given a list of transactions representing the payments between people ([0, 1, 20] representing person 0 paid for person 1 $10), return the minimum number of transactions to settle all debts.

Ex: Given the following transactions…

transactions = [[0, 1, 20]], return 1 (person 1 must pay person 0 $10 back).
Ex: Given the following transactions…

transactions = [[0, 1, 5], [0, 2, 10], [2, 1, 15]], return 2.
*/


// this is giving stack overflow error
import java.util.*;

public class SettleDebts {

	private static int counter = 0;

	public static void minNumberOfTransaction(int [][] graph) {
		int [] amount = new int [graph.length];
		for (int i=0; i<graph.length; i++) {
			for (int j=0; j<graph.length; j++) {
				amount[i] += (graph[i][j] - graph[j][i]);
			}
		}
		minCashFlowRecursion(amount);
		System.out.println(counter);
	}

	public static void minCashFlowRecursion(int [] amount) {
		int maxCredit = getMaxIndex(amount);
		int maxDebt = getMinIndex(amount);
		if (amount[maxCredit] == 0 && amount[maxDebt] == 0) {
			return;
		}
		int minFrom2 = getMinOfTwo(-amount[maxCredit], amount[maxDebt]);
		amount[maxCredit] -= minFrom2;
		amount[maxDebt] += minFrom2;
		counter += 1;
		minCashFlowRecursion(amount);
	}

	public static int getMaxIndex(int [] arr) {
		int max = 0;
		for (int i=1; i<arr.length; i++) {
			if (arr[i] > arr[max]) {
				max = i;
			}
		}
		return max;
	}

	public static int getMinIndex(int [] arr) {
		int min = 0;
		for (int i=1; i<arr.length; i++) {
			if (arr[i] < arr[min]) {
				min = i;
			}
		}
		return min;
	}

	public static int getMinOfTwo(int n1, int n2) {
		return n1 > n2 ? n2 : n1;
	}



	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] graph = new int [n][3];
		for (int i=0; i<n; i++) {
			graph[i][0] = sc.nextInt();
			graph[i][1] = sc.nextInt();
			graph[i][2] = sc.nextInt();
		}
		minNumberOfTransaction(graph);
	}
}