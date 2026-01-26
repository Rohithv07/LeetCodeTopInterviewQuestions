import java.util.*;

public class Aparment {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int [] applicant = new int [n];
		int [] apartment = new int [m];
		for (int index = 0; index < n; index++) {
			applicant[index] = sc.nextInt();
		}
		for (int index = 0; index < m; index++) {
			apartment[index] = sc.nextInt();
		}
		System.out.println(findTotalApartment(applicant, apartment, k));
	}

	private static int findTotalApartment(int [] applicant, int [] apartment, int k) {
		Arrays.sort(applicant);
		Arrays.sort(apartment);
		int p1 = 0;
		int p2 = 0;
		int count = 0;
		while (p1 < applicant.length && p2 < apartment.length) {
			int applicantSize = applicant[p1];
			int apartmentSize = apartment[p2];
			int minSize = applicantSize - k;
            int maxSize = applicantSize + k;
			if (minSize <= apartmentSize && apartmentSize <= maxSize) {
				p1++;
				p2++;
				count++;
			}
			else if (apartmentSize < minSize) {
				p2++;
			}
			else {
				p1++;
			}
		}
		return count;
	}
}