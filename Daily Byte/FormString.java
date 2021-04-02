/*
Given two strings, source and target, return the minimum number of subsequences of source that can be used to form target.
Note: If it is impossible to use subsequences of source to form target, return -1.
Ex: Given the following source and target…

source = "abc", target = "def", return -1.
Ex: Given the following source and target…

source = "abcdef", target = "abcadaef", return 3.
*/



// Java implementation for minimum
// number of subsequences required
// to convert one String to another
class GFG
{

// Function to find the minimum number
// of subsequences required to connvert
// one String to another
// S2 == A and S1 == B
static int findMinimumSubsequences(String A, String B)
{
	
	// At least 1 subsequence is required
	// Even in best case, when A is same as B
	int numberOfSubsequences = 1;
	
	// size of B
	int sizeOfB = B.length();
	
	// size of A
	int sizeOfA = A.length();
	int inf = 1000000;

	// Create an 2D array next[][]
	// of size 26 * sizeOfB to store
	// the next occurrence of a character
	// ('a' to 'z') as an index [0, sizeOfA - 1]
	int [][]next = new int[26][sizeOfB];

	// Array Initialization with infinite
	for (int i = 0; i < 26; i++) {
		for (int j = 0; j < sizeOfB; j++) {
			next[i][j] = inf;
		}
	}

	// Loop to Store the values of index
	for (int i = 0; i < sizeOfB; i++) {
		next[B.charAt(i) - 'a'][i] = i;
	}
	
	// If the value of next[i][j]
	// is infinite then update it with
	// next[i][j + 1]
	for (int i = 0; i < 26; i++) {
		for (int j = sizeOfB - 2; j >= 0; j--) {
			if (next[i][j] == inf) {
				next[i][j] = next[i][j + 1];
			}
		}
	}

	// Greedy algorithm to obtain the maximum
	// possible subsequence of B to cover the
	// remaining String of A using next subsequence
	int pos = 0;
	int i = 0;
	
	// Loop to iterate over the String A
	while (i < sizeOfA) {
		
		// Condition to check if the character is
		// not present in the String B
		if (pos == 0 &&
		next[A.charAt(i)- 'a'][pos] == inf) {
			numberOfSubsequences = -1;
			break;
		}
		
		// Condition to check if there
		// is an element in B matching with
		// character A[i] on or next to B[pos]
		// given by next[A[i] - 'a'][pos]
		else if (pos < sizeOfB &&
				next[A.charAt(i) - 'a'][pos] < inf) {
			int nextIndex = next[A.charAt(i) - 'a'][pos] + 1;
			pos = nextIndex;
			i++;
		}
		
		// Condition to check if reached at the end
		// of B or no such element exists on
		// or next to A[pos], thus increment number
		// by one and reinitialise pos to zero
		else {
			numberOfSubsequences++;
			pos = 0;
		}
	}
	return numberOfSubsequences;
}

// Driver Code
public static void main(String[] args)
{
	String A = "aacbe";
	String B = "aceab";

	System.out.print(findMinimumSubsequences(A, B));
}
}

// This code is contributed by Rajput-Ji




