class Solution{
    boolean isSubSequence(String a, String b){
        if (a == null || a.length() == 0)
            return true;
        if (b == null || b.length() == 0)
            return false;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i=0; i<b.length(); i++) {
            char ch = b.charAt(i);
            List<Integer> index = map.getOrDefault(ch, new ArrayList<>());
            index.add(i);
            map.put(ch, index);
        }
        int lastFound = -1;
        for (char ch : a.toCharArray()) {
            if (!map.containsKey(ch))
                return false;
            List<Integer> index = map.get(ch);
            int foundNextPosition = binarySearch(index, lastFound);
            if (foundNextPosition == -1)
                return false;
            lastFound = foundNextPosition;
        }
        return true;
    }
    
    public int binarySearch(List<Integer> index, int lastFound) {
        int left = 0;
        int right = index.size() - 1;
        int result = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (index.get(middle) > lastFound) {
                result = index.get(middle);
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return result;
    }
}