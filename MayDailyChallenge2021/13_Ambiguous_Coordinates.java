class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0 || s == null)
            return result;
        s = s.substring(1, s.length() - 1);
        for (int i=0; i<s.length() - 1; i++) {
            List<String> left = findOnePoint(s.substring(0, i + 1));
            List<String> right = findOnePoint(s.substring(i + 1));
            for (String l : left) {
                for (String r : right) {
                    result.add("(" + l + ", " + r + ")"); 
                }
            }
        }
        return result;
    }
    
    public boolean isValidLeft(String s) {
        return (s.length() == 1 || !(s.length() > 1 && s.startsWith("0")));
    }
    
    public boolean isValidRight(String s) {
        return !s.endsWith("0");
    }
    
    public List<String> findOnePoint(String s) {
        List<String> current = new ArrayList<>();
        if (s.length() == 1) {
            current.add(s);
            return current;
        }
        for (int i=0; i<s.length(); i++) {
            String left = s.substring(0, i+1);
            String right = s.substring(i+1);
            if (isValidLeft(left) && isValidRight(right)) {
                current.add(left + "" + (right.length() != 0 ? "." + right : ""));
            }
        }
        return current;
        
    }
}
