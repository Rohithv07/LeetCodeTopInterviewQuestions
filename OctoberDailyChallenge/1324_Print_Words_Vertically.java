class Solution {
    public List<String> printVertically(String s) {
        // returning variable
        List<String> result = new ArrayList<>();
        if (s.length() == 1) {
            result.add(s);
            return result;
        }
        // lets start by splitting the string by space
        String [] splitted = s.split("\\s");
        // now we need to find the largest length from the words
        int maximumLength = 0;
        for (int i=0; i<splitted.length; i++)    // O(splittedLength)
            maximumLength = Math.max(maximumLength, splitted[i].length());
        // now we iterate till the maximumLength and consider evry string from the splitted array
        for (int i=0; i<maximumLength; i++) {    // O(maximumLength) 
            // we make use of StringBuilder rather than a '+' 
            StringBuilder sb = new StringBuilder();
            for (String ss: splitted)            // O(splittedLength)
                sb.append(i<ss.length() ? ss.charAt(i) : " ");
            // now we also need to take care about the trailing spaces as we dont require it.
            while (sb.charAt(sb.length() - 1) == ' ') // to the last we have space, then we can delete it.
                sb.deleteCharAt(sb.length() - 1);
            // now we can add the string into the result list
            result.add(sb.toString());
        }
        return result;
        
    }
}


// Time complexity O(maximumLength * splittedLength)

// please help me to correct the complexity if somehow Iam wrong.
