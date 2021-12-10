import java.util.*;

public class SquareOfANumberWithoutAnyOperator {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		int temp = n;
		while (temp > 0) {
			if ((temp & 1) == 1) {
				result += n;
			}
			n <<= 1;
			temp >>= 1;
		}
		System.out.println(result);
	}
}