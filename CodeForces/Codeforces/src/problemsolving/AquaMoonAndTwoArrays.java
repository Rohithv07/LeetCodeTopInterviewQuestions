/**
 * 
 */
package problemsolving;

import java.util.ArrayList;
import java.util.Scanner;

public class AquaMoonAndTwoArrays {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- > 0){
	        int n = sc.nextInt();
	        int sum = 0;
	        int[] a = new int[n];
	        int[] b = new int[n];
	        for(int i=0;i<n;i++)
	        a[i] = sc.nextInt();
	        for(int i=0;i<n;i++)
	        {
	        b[i] = sc.nextInt();
	        sum +=(a[i]-b[i]);
	        }
	        if(sum!=0){
	            System.out.println("-1");
	            continue;
	        }
	        ArrayList<Integer> pos = new ArrayList<Integer>();
	        ArrayList<Integer> neg = new ArrayList<Integer>();
	        for(int i=0;i<n;i++){
	            if(a[i]-b[i]>0){
	                for(int j=1;j<=a[i]-b[i];j++)
	                pos.add(i+1);
	            }
	            else if(a[i]-b[i]<0){
	                for(int j=1;j<=b[i]-a[i];j++)
	                neg.add(i+1);
	            }
	        }
	        System.out.println(neg.size());
	        for(int i=0;i<neg.size();i++){
	            System.out.print(pos.get(i)+" "+neg.get(i));
	            System.out.println();
	        }
	    }
	}
}
