class Solution {
    public boolean buddyStrings(String A, String B) {
        // if the lengths are not equal
        if (A.length() != B.length())
            return false;
        // if both strings are equal
        if (A.equals(B)) {
            Set<Character> set = new HashSet<>();
            for (char c: A.toCharArray())
                set.add(c);
            if (set.size() < A.length())
                // now we can make the swap
                return true;
            return false;
        }
        List<Integer> diff = new ArrayList<>();
        for (int i=0; i<A.length(); i++) {
            if (A.charAt(i) != B.charAt(i))
                diff.add(i);
        }
        if (diff.size()==2 && A.charAt(diff.get(0)) == B.charAt(diff.get(1)) && A.charAt(diff.get(1)) == B.charAt(diff.get(0)))
            return true;
        return false;
    }
}
