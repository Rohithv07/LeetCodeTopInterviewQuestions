/**
 * 
 */
package problemsolving;

import java.util.Scanner;
 
public class AncientCivilization {
	
	public static void main(String args[]) {
	   Scanner sc=new Scanner(System.in);
	   int t=sc.nextInt();
	   while(t-->0) {
		 int n=sc.nextInt();
		 int l=sc.nextInt();
		 int c[]=new int[l];
		 for(int i=0;i<n;i++) {
			 int x=sc.nextInt();
			 for(int j=0;j<l;j++)
				 c[j]+=(x>>j)&1;
		 }
		 int ans=0;
		 for(int i=0;i<l;i++)
			 if(c[i]>n-c[i]) ans|=1<<i;
		 
		 System.out.println(ans);
	   }
	}}
	
