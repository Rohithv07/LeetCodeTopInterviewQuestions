/*
Given an integer array, salaries, salaries[i] represents the salary of the ith employee. Return the average employee salary not considering the largest or the smallest salary.

Ex: Given the following salaries…

salaries = [5000, 2000, 3000, 4000], return 3500.00000 ((3000 + 4000) / 2).
*/

import java.util.*;

public class AverageEmployeeSalary {

	public static double avgWithoutMinMax(int [] salary) {
		if (salary == null || salary.length == 0)
			return 0.0;
		int sum = salary[0];
		int length = salary.length - 2;
		int min = salary[0];
		int max = salary[0];
		for (int i=1; i<length + 2; i++) {
			if (salary[i] < min) {
				min = salary[i];
			}
			else if (salary[i] > max) {
				max = salary[i];
			}
			sum += salary[i];
		}
		int requiredSalary = sum - (max + min);
		return (double)(requiredSalary / length);
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] salary = new int [n];
		for (int i=0; i<n; i++) {
			salary[i] = sc.nextInt();
		}
		System.out.println(avgWithoutMinMax(salary));
	}
}