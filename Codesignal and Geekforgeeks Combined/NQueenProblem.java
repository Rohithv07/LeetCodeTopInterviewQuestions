class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        backtrack(result, current, n, 0);
        return result;
    }
    
    static void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int n, int pos) {
        if (pos == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=0; i<n; i++) {
            current.add(i + 1);
            if (isValid(current)) {
                backtrack(result, current, n, pos + 1);
            }
            current.remove(current.size() - 1);
        }
    }
    
    static boolean isValid(ArrayList<Integer> current) {
        int rowId = current.size() - 1;
        for (int i=0; i<rowId; i++) {
            int diff = Math.abs(current.get(i) - current.get(rowId));
            if (diff == 0 || diff == rowId - i)
                return false;
        }
        return true;
    }
}
