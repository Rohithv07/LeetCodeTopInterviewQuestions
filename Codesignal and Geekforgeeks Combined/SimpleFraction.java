Given a fraction. Convert it into a decimal. 
If the fractional part is repeating, enclose the repeating part in parentheses.
 

Example 1:

Input: numerator = 1, denominator = 3
Output: "0.(3)"
Explanation: 1/3 = 0.3333... So here 3 is 
recurring.
Example 2:

Input: numerator = 5, denominator = 2
Output: "2.5"
Explanation: 5/2 = 2.5
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function fractionToDecimal() which takes numerator and denominator as input parameter and returns its decimal form in string format.
 

Expected Time Compelxity: O(k) where k is constant.
Expected Space Complexity: O(k)
 

Constraints:
1 ≤ numerator, denominator ≤ 2000


class Solution
{
    public String  fractionToDecimal(int numerator, int denominator)
    {
        // code here
        if (numerator == 0)
            return "0";
        // positive or negative
        StringBuilder sb = new StringBuilder();
        sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        // decimal part
        long num = (long) numerator;
        long den = (long) denominator;
        sb.append(num / den);
        long rem = num % den;
        if (rem == 0)
            return sb.toString();
        Map<Long, Integer> map = new HashMap<>();
        sb.append(".");
        map.put(rem, sb.length());
        while (rem != 0) {
            rem *= 10;
            sb.append(rem / den);
            rem %= den;
            if (map.containsKey(rem)) {
                int index = map.get(rem);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            else {
                map.put(rem, sb.length());
            }
        }
        return sb.toString();
    }
}
