class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (int key : map.keySet()) {
            if ((k > 0 && map.containsKey(key + k)) || (k == 0 && map.get(key) > 1)) {
                count += 1;
            }
        }
        return count;
    }
}