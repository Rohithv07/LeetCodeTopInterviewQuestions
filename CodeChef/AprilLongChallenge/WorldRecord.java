import java.util.*;

public class WorldRecord {

	public final static  double USAIN = 9.58;

	public static double roundDouble(double n) {
		n *= 100;
		n = Math.round(n);
		n /= 100;
		return n;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			double k1 = sc.nextDouble();
			double k2 = sc.nextDouble();
			double k3 = sc.nextDouble();
			double v = sc.nextDouble();
			double integrated = k1 * k2 * k3 * v;
			//System.out.println(integrated);
			double myRecord = 100.0 / integrated;
			myRecord = roundDouble(myRecord);
			//System.out.println(myRecord);
			if (myRecord < USAIN)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}