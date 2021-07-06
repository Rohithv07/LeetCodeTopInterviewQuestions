/*
You are given a two-dimensional matrix that represents the grades of a class of students. Each grade is represented as an array where the first index is the student’s ID and the second student is a grade (0 - 100) that the student has received. Given these grades, calculate the average of each student’s top five scores and return the result.
Note: Each student is guaranteed to have at least 5 scores. Student IDs start from zero and increase by one. Your return variable should be sorted according to student ID.

Ex: Given the following grades…

grades = [[1, 100], [1, 50], [2, 100], [2, 93], [1, 39], [2, 87], [1, 89], [1, 87], [1, 90], [2, 100], [2, 76]], return [[1, 83], [2, 91]] (Student one's average is an 83 and student two's average is a 91).
*/



import java.util.*;

public class StudentAverages {

	public static int[][] findAverage(int [][] grades) {
		int length = grades.length;
		Arrays.sort(grades, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
		int total = grades[0][1];
		int count = 1;
		List<Integer> trackTotal = new ArrayList<>();
		for (int i=1; i<length; i++) {
			if (grades[i - 1][0] == grades[i][0] && count != 5) {
				total += grades[i][1];
				count += 1;
			}
			else if (grades[i - 1][0] != grades[i][0]) {
				trackTotal.add(total);
				total = grades[i][1];
				count = 0;
			}
			else if (grades[i - 1][0] == grades[i][0] && count == 5) {
				continue;
			}
		}
		trackTotal.add(total);
		int [][] result = new int [trackTotal.size()][2];
		for (int i=0; i<trackTotal.size(); i++) {
			result[i][1] = trackTotal.get(i) / 5;
			result[i][0] = i + 1;
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		int [][] grades = new int [total][2];
		for (int i=0; i<total; i++) {
			grades[i][0] = sc.nextInt();
			grades[i][1] = sc.nextInt();
		}
		int [][] result = findAverage(grades);
		for (int [] number : result) {
			System.out.println(number[0] + " " + number[1]);
		}
	}
}