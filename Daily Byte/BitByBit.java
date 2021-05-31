/*
Given an array of integers, nums, return an array that contains nums sorted in ascending order according to their number of one bits.
Note: If two values have the same number of one bits, they should be sorted in ascending order.

Ex: Given the following nums…

nums = [5, 2, 8], return [2, 8, 5] (2 has 1 one bit, 8 has 1 one bit, 5 has 2 one bits).
Ex: Given the following nums…

nums = [4, 5, 5, 1, 3, 9], return [1, 4, 3, 5, 5, 9].
*/


import java.util.*;

public class BitByBit {

	public static int [] sortByBit(int [] nums) {
		if (nums.length == 1)
			return nums;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		for (int number : nums) {
			pq.offer(new int [] {getBit(number), number});
		}
		int index = 0;
		int [] result = new int [nums.length];
		while (!pq.isEmpty()) {
			result[index++] = pq.poll()[1];
		}
		return result;
	}

	public static int getBit(int number) {
		int count = 0;
		while (number > 0) {
			number &= (number - 1);
			count += 1;
		}
		return count;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int [] result = sortByBit(nums);
		for (int number : result) {
			System.out.print(number + " ");
		}
	}
}


// using counting sort - descending order


// Java program to sort an
// array according to count
// of set bits using std::sort()
import java.util.*;
class GFG{
 
// a utility function that
// returns total set bits
// count in an integer
static int countBits(int a)
{
  int count = 0;
  while (a > 0)
  {
    if ((a & 1) > 0 )
      count += 1;
    a = a >> 1;
  }
  return count;
}
 
// Function to sort according to
// bit count. This function assumes
// that there are 32 bits in an integer.
static void sortBySetBitCount(int arr[],
                              int n)
{
  Vector<Integer> []count =
         new Vector[32];
   
  for (int i = 0;
           i < count.length; i++)
    count[i] = new Vector<Integer>();
   
  int setbitcount = 0;
   
  for (int i = 0; i < n; i++)
  {
    setbitcount = countBits(arr[i]);
    count[setbitcount].add(arr[i]);
  }
 
  // Used as an index in
  // final sorted array
  int j = 0; 
 
  // Traverse through all bit
  // counts (Note that we sort
  // array in decreasing order)
  for (int i = 31; i >= 0; i--)
  {
    Vector<Integer> v1 = count[i];
     
    for (int p = 0; p < v1.size(); p++)
      arr[j++] = v1.get(p);
  }
}
 
// Utility function to print
// an array
static void printArr(int arr[],
                     int n)
{
  for (int i = 0; i < n; i++)
    System.out.print(arr[i] + " ");
}
 
// Driver Code
public static void main(String[] args)
{
  int arr[] = {1, 2, 3, 4, 5, 6};
  int n = arr.length;
  sortBySetBitCount(arr, n);
  printArr(arr, n);
}
}
 