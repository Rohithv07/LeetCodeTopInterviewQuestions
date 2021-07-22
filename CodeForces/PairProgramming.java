// this is not getting accepted
import java.util.*;

public class PairProgramming {

	public static List<Integer> findSeq(int [] mono, int [] poly, int k) {
		int i = 0;
		int j = 0;
		int count = k;
		boolean isOk = true;
		List<Integer> result = new ArrayList<>(mono.length + poly.length);
		int index = 0;
		while (i < mono.length || j < poly.length) {
			if (i != mono.length && mono[i] == 0) {
				result.add(mono[i++]);
				count ++;
			}
			else if (j != poly.length && poly[i] == 0) {
				result.add(poly[j++]);
				count ++;
			}
			else if (i != mono.length && mono[i] <= count) {
				result.add(mono[i++]);
			}
			else if (j != poly.length && poly[i] <= count) {
				result.add(poly[j++]);
			}
			else {
				isOk = false;
				break;
			}
		}
		if (!isOk) {
			result.clear();
			result.add(-1);
			return result;
		} 
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			int [] mono = new int [n];
			int [] poly = new int [m];
			for (int i=0; i<n; i++) {
				mono[i] = sc.nextInt();
			}
			for (int i=0; i<m; i++) {
				poly[i] = sc.nextInt();
			}
			List<Integer> result = findSeq(mono, poly, k);
			System.out.print(result.get(0));
			for (int i=1; i<result.size(); i++) {
					System.out.print(" " + result.get(i));
			}
			System.out.println();
		}
	}
}


// copied accepted solution

import java.util.Scanner;
 
public class pair_program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		while(T-- > 0) {
			int k = Integer.parseInt(sc.next());
			int n = Integer.parseInt(sc.next());
			int m = Integer.parseInt(sc.next());
			
			int[] a = new int[n];
			int[] b = new int[m];
			int a_ind = 0;
			int b_ind = 0;
			int[] result = new int[n+m];
			boolean flag = true;
			
			for(int i = 0; i < n; i++) 
				a[i] = Integer.parseInt(sc.next());
			for(int i = 0; i < m; i++) 
				b[i] = Integer.parseInt(sc.next());
			
			for(int i = 0; i < n + m; i++) {
				if(a_ind < n && a[a_ind] == 0) {
					result[i] = 0;
					k++;
					a_ind++;
				} else if(b_ind < m && b[b_ind] == 0) {
					result[i] = 0;
					k++;
					b_ind++;
				} else if(a_ind < n && a[a_ind] <= k) {
					result[i] = a[a_ind];
					a_ind++;
				} else if(b_ind < m && b[b_ind] <= k) {
					result[i] = b[b_ind];
					b_ind++;
				} else {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.print(result[0]);
				for(int i = 1; i < result.length; i++) {
					System.out.print(" " + result[i]);
				}
			} else {
				System.out.print(-1);
			}
			System.out.println();
		}
	}
}