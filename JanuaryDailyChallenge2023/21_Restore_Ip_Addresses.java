class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        store(s, result, 0, "");
        return result;
    }

    private void store(String s, List<String> result, int index, String current) {
        if (s.isEmpty() || index == 4) {
            if (s.isEmpty() && index == 4) {
                result.add(current.substring(1));
            }
            return;
        }
        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) { // Avoid leading 0
            String part = s.substring(0, i);
            if (Integer.valueOf(part) <= 255)
                store(s.substring(i), result, index + 1, current + "." + part);
        }
    }
}