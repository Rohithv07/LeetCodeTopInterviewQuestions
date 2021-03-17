/*
Given a paragraph and a list of banned words, return the most frequently occurring word that is not banned. Treat words case insensitively and ignore punctuation.

Ex: Given the following paragraph and list of banned words...

paragraph = "The daily, the byte Daily.", banned = [“the”], return “daily”.
*/


class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String lower = paragraph.toLowerCase();
        String normalised = lower.replaceAll("\\W+", " ");
        String [] split = normalised.split("\\s+");
        Set<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : split) {
            if (!set.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}

// String[] terms = input.split("[\\s@&.?$+-]+");
