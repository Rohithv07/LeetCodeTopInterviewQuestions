import java.util.*;

public class Armchairs {

	public static int findMinTime(List<Integer> zeros, List<Integer> ones) {
		if (ones.size() == 0)
			return 0;
		int oneSize = ones.size();
		int zeroSize = zeros.size();
		int [][] time = new int [oneSize + 1][zeroSize + 1];
		for (int i=1; i<=oneSize; i++) {
			time[i][i] = time[i - 1][i - 1] + Math.abs(ones.get(i - 1) - zeros.get(i - 1));
			for (int j=i+1; j<=zeroSize; j++) {
				time[i][j] = Math.min(time[i][j - 1], time[i - 1][j - 1] + 
					Math.abs(ones.get(i - 1) - zeros.get(j - 1)));
			}
		}
		return time[oneSize][zeroSize];
	}

	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> zeros = new ArrayList<>();
		List<Integer> ones = new ArrayList<>();
		for (int i=0; i<n; i++) {
			int number= sc.nextInt();
			if (number == 1)
				ones.add(i);
			else
				zeros.add(i);
		}
		System.out.println(findMinTime(zeros, ones));
	}
}