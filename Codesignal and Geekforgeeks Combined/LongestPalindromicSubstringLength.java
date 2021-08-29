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