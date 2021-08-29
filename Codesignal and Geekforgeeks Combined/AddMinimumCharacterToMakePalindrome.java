class Solution
{
	public static int addMinChar(String s){
		//code here
		if (s == null || s.length() == 0 || isPalindrome(s))
		    return 0;
		int length = s.length();
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		StringBuilder reverse = new StringBuilder(s);
		String reversedS = reverse.reverse().toString();
		sb.append('#').append(reversedS);
		int longestPalindromicSubstringLength= findLPS(sb.toString());
		return length - longestPalindromicSubstringLength;
	}
	
	public static int findLPS(String s) {
	    int n = s.length();
	    int [] longeslongestPalindromicSubstringLength = new int [n];
	    int i = 1;
	    int length = 0;
	    longeslongestPalindromicSubstringLength[0] = 0;
	    while (i < n) {
	        if (s.charAt(i) == s.charAt(length)) {
	            length += 1;
	            longeslongestPalindromicSubstringLength[i++] = length;
	        }
	        else {
	            if (length != 0) {
	                length = longeslongestPalindromicSubstringLength[length - 1];
	            }
	            else {
	                longeslongestPalindromicSubstringLength[i++] = 0;
	            }
	        }
	    }
	    return longeslongestPalindromicSubstringLength[n - 1];
	}
	
	public static boolean isPalindrome(String s) {
	    int i = 0;
	    int j = s.length() - 1;
	    while (i <= j) {
	        if (s.charAt(i++) != s.charAt(j--)) {
	            return false;
	        }
	    }
	    return true;
	}
}