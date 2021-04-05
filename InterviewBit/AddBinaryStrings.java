public class Solution {
    public String addBinary(String A, String B) {
        int length1 = A.length();
        int length2 = B.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = length1 - 1;
        int j = length2 - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0)
                sum += A.charAt(i) - '0';
            if (j >= 0)
                sum += B.charAt(j) - '0';
            carry = sum / 2;
            sb.append(sum % 2);
            i -= 1;
            j -= 1;
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}

