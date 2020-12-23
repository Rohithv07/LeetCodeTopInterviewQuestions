class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        for (int x: A) {
            for (int y: B) {
                map.put(x+y, map.getOrDefault(x+y, 0) + 1);
            }
        }
        for (int x : C) {
            for (int y : D) {
                total += map.getOrDefault(-1 * (x+y), 0);
            }
        } 
        return total;
    }
}
