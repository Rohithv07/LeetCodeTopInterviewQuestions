class Solution
{
    public String newIPAdd(String s)
    {
        // your code here
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        String [] split = s.split("[.]", 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length - 1; i++) {
            removeZeroHelper(i, sb, split);
            sb.append(".");
        }
        removeZeroHelper(split.length - 1, sb, split);
        return sb.toString();
    }
    
    public void removeZeroHelper(int index, StringBuilder sb, String [] split) {
        String word = split[index];
        int length = word.length();
        int i = 0;
        while (i < length && word.charAt(i) == '0') {
            i++;
        }
        if (i == length) {
            sb.append(0);
        }
        else
            sb.append(word.substring(i));
    }
    
    
}