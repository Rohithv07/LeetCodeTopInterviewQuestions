import java.util.*;
 
public class StrangeTable {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long t=sc.nextLong();
		while(t-->0)
		{
			long n=sc.nextLong(),m=sc.nextLong(),x=sc.nextLong();
			x--;
			long a=x%n,b=x/n;
			System.out.println(1+(a*m)+b);
		}
	}

}