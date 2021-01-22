/*
Given an integer n, return whether or not it is a power of three.

Ex: Given the following value for n...

n = 9, return true
Ex: Given the following value for n...

n = 50, return false
*/
import java.util.*;

public class PowerOfThree {

	public static boolean isPowerOfThree(int number) {
		if (number == 1)
			return true;
		return (int)(Math.ceil(Math.log(number) / Math.log(3))) == (int)(Math.floor(Math.log(number) / Math.log(3)));
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println(isPowerOfThree(number));
	}
}