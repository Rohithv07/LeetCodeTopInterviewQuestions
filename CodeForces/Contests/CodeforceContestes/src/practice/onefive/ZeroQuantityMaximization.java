/**
 * @author rohithvazhathody
 * @date 10 Nov 2026
 * Project: CodeforceContestes
 * File: ZeroQuantityMaximization.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 
 */
public class ZeroQuantityMaximization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = 1;
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long[] a = new long[n];
			long[] b = new long[n];
			for (int index = 0; index < n; index++) {
				a[index] = fastReader.nextLong();
			}
			for (int index = 0; index < n; index++) {
				b[index] = fastReader.nextLong();
			}
			long c = findArrayZero(a, b);
			out.println(c);
		}
		out.flush();
		out.close();
	}
	
	
	private static long findArrayZero(long[] a, long[] b) {
	    Map<String, Long> freqMap = new HashMap<>();
	    long bothZero = 0;
	    long maxOccurring = 0;
	    
	    for (int index = 0; index < a.length; index++) {
	        if (a[index] == 0 && b[index] == 0) {
	            bothZero++;
	            continue;
	        }
	        if (a[index] == 0) {
	            continue;
	        }
	        
	        long num = b[index];
	        long den = a[index];
	        
	        long g = gcd(Math.abs(num), Math.abs(den));
	        
	        num /= g;
	        den /= g;
	        
	        if (den < 0) {
	            num = -num;
	            den = -den;
	        }
	        
	        String key = num + "/" + den;
	        long count = freqMap.getOrDefault(key, 0L) + 1;
	        freqMap.put(key, count);
	        
	        if (count > maxOccurring) {
	            maxOccurring = count;
	        }
	    }
	    
	    return maxOccurring + bothZero;
	}
	
	// this is correct only, but will have trouble with fractions

//	private static long findArrayZero(long[] a, long[] b) {
//		Map<Double, Long> freqMap = new HashMap<>();
//		long bothZero = 0;
//		for (int index = 0; index < a.length; index++) {
//			if (a[index] == 0 && b[index] == 0) {
//				bothZero++;
//				continue;
//			}
//			if (a[index] == 0) {
//				continue;
//			}
//			double division = (double) b[index] / a[index];
//			freqMap.put(division, freqMap.getOrDefault(division, 0L) + 1);
//		}
//		long maxOccuring = 0;
//		for (Double key : freqMap.keySet()) {
//			long val = freqMap.get(key);
//			if (val > maxOccuring) {
//				maxOccuring = val;
//			}
//		}
//		return maxOccuring == Long.MIN_VALUE ? 0 : maxOccuring + bothZero;
//	}
	
	private static long gcd(long a, long b) {
	    while (b != 0) {
	        long temp = b;
	        b = a % b;
	        a = temp;
	    }
	    return a;
	}

	/*
	 * 
	 * c = d * a + b 0 = d*a + b -b = d * a d = -b/a
	 * 
	 * 
	 * 5 1 2 3 4 5 2 4 7 11 3
	 * 
	 * 
	 * d = -2
	 * 
	 * c0 = -2 * 1 + 2 c1 = -2 * 2 + 4
	 * 
	 * 
	 * c2 = -2 * 3 + 7 c3 = -2 * 4 + 11 c4 = -2 * 5 + 3
	 * 
	 */

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			try {
				while (st == null || !st.hasMoreTokens()) {
					st = new StringTokenizer(br.readLine());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

}
