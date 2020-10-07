This question is asked by Amazon. Given a string s consisting of only letters and digits, where we are allowed to transform any letter to uppercase or lowercase, return a list containing all possible permutations of the string.

Ex: Given the following string…

S = "c7w2", return ["c7w2", "c7W2", "C7w2", "C7W2"]

// c7w2 -> C7w2, c7W2, c7w2, C7W2

// so here, we can take each of the permutation c can be of 2 type, we dont want to change the numbers, w can be of 2 type. So the total complexity will be exponential.
// so the way is we can do a backtrack for this problem
// if we see a letter, we can just make it upper and continue with the other.
// if we see a number, then we dont want to do anything, we can continue with the other letter.
// we need to consider both the lower and upper case.

public class Solution {
	public List<String> stringPermute(String s) {
		// initialise the result varible;
		List<String> result = new ArrayList<>();
		// a character array of each of the string character.
		char [] stringToChar = s.toCharArray();
		// now call our backtracking helper function passing result, array, pos = 0
		backtrack(result, stringToChar, 0);
		return result;
	}
	public void backtrack(List<String> result, char [] current, int pos) {
		// check if we reach the end of the string, the last character
		if (pos == current.length) {
			result.add(new String(current));
			return;		
		}
		// if we encounter a number, just skip and move on with the next one	
		if (current[pos] >= '0' && current[pos] <= '9')
			backtrack(result, current, pos+1);
		// here we change the upper one to lower to take the next permutation possible
		current[pos] = Character.toLowercase(current[pos]);
		backtrack(result, current, pos+1);
		// here we change the lower one to upper and take the next permutation possible
		current[pos] = Character.toUpperCase(current[pos]);
		backtrack(result, current, pos+1);
	}
}
