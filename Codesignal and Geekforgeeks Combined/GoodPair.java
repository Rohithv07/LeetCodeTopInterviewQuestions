
// https://practice.geeksforgeeks.org/contest/interview-series-63/problems/#

// https://www.youtube.com/watch?v=zg43_5GU03w&t=2158s



// 0 or 1 in the mask represents whether we have odd or even number of characters

class Solution {
    public static long getNumGoodPair(int n, String[] a) {
        // code here
        long answer = 0;
        Map<Integer, Integer> maskTrack = new HashMap<>();
        for (String s : a) {
            int mask = generateMask(s);
            answer += maskTrack.getOrDefault(mask, 0);
            for (int i = 0; i < 26; i++) {
                // flipping the bit
                int newMask = mask ^ (1 << i);
                answer += maskTrack.getOrDefault(newMask, 0);
            }
            maskTrack.put(mask, maskTrack.getOrDefault(mask, 0) + 1);
        }
        return answer;
    }
    
    
    private static int generateMask(String s) {
        int mask = 0;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            mask ^= (1 << index);
        }
        return mask;
    }
}
        
