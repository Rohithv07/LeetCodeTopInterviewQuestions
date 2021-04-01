/*
Given a number n, return a list containing specific outputs for each value between one and n. For any number, if it is divisible by three and it is divisible by five, append “FizzBuzz” to your list. If it is divisible by only three, append “Fizz” to your list. If it is divisible by only five, append “Buzz” to your list. If the number is not divisible by three or five, simply append the number itself to the list.

Ex: Given the following value n…

n = 3, return ["1","2","Fizz"].
Ex: Given the following value n…

n = 5, return ["1","2","Fizz","4","Buzz"].
*/


import java.util.*;

public class FizzBuzz {

	public static String [] getFizzBuzzDone(int number) {
		String [] result = new String[number];
		int start = 1;
		while (start <= number) {
			if (start % 15 == 0)
				result[start - 1] = "FIZZBUZZ";
			else if (start % 5 == 0)
				result[start - 1] = "BUZZ";
			else if (start % 3 == 0)
				result[start - 1] = "FIZZ";
			else
				result[start - 1] = String.valueOf(start);
			start += 1;
		}
		return result;
	}	

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String [] result = getFizzBuzzDone(n);
		for(String s : result) {
			System.out.print(s + " ");
		}
	}
}
