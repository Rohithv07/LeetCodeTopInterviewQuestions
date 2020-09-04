class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int [] lastIndexFound = new int [26];
        for (int i=0; i<S.length(); i++) 
            lastIndexFound[S.charAt(i)-'a'] = i;
        int starting = 0;
        while (starting < S.length()) {
            int lastIndex = lastIndexFound[S.charAt(starting) - 'a'];
            int ending = starting;
            while (ending != lastIndex)
                lastIndex = Math.max(lastIndex, lastIndexFound[S.charAt(ending++) - 'a']);
            result.add(ending - starting + 1);
            starting = ending + 1; 
        }
        return result;
    }
}
