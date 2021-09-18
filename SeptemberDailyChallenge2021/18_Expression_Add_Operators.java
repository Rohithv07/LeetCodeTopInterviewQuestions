Given a string num that contains only digits and an integer target, return all possibilities to add the binary operators '+', '-', or '*' between the digits of num so that the resultant expression evaluates to the target value.

 

Example 1:

Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0*0","0+0","0-0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []
 

Constraints:

1 <= num.length <= 10
num consists of only digits.
-231 <= target <= 231 - 1



class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, num, 0, target, 0, 0);
        return res;

    }
    public void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi) { 
        if(pos == num.length()) {
            if(target == prev) res.add(sb.toString());
            return;
        }
        for(int i = pos; i < num.length(); i++) {
            if(num.charAt(pos) == '0' && i != pos) break;
            long curr = Long.parseLong(num.substring(pos, i + 1));
            int len = sb.length();
            if(pos == 0) {
                dfs(res, sb.append(curr), num, i + 1, target, curr, curr); 
                sb.setLength(len);
            } else {
                dfs(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr); 
                sb.setLength(len);
                dfs(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr); 
                sb.setLength(len);
                dfs(res, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr); 
                sb.setLength(len);
            }
        }
    }
}