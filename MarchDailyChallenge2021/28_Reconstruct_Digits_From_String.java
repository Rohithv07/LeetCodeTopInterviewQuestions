Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:
Input: "owoztneoer"

Output: "012"
Example 2:
Input: "fviefuro"

Output: "45"





// ref video : https://www.youtube.com/watch?v=mkfxBsvGMco&feature=youtu.be


class Solution {
    public String originalDigits(String s) {
        if (s.length() < 3)
            return "";
        int length = s.length();
        int [] map = new int [26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a'] += 1;
        }
        int [] count = new int [10];
        count[0] = map['z' - 'a']; // maps to zero(count of z)
        count[2] = map['w' - 'a']; // maps to two(count of w)
        count[4] = map['u' - 'a']; // maps to four(count of u)
        count[6] = map['x' - 'a']; // maps to six(count of x)
        count[8] = map['g' - 'a']; // maps to eight(count of g)
        // now for odd numbers
        // four and five have f in it so f(4 + 5)
        // one, two, zero and four have o so o(1 + 2 + 0 + 4)
        // three, eight, two have t as common so t(3 + 8 + 2)
        // seven, six have s as common so t(7 + 6)
        // five, six, eight, nine have i as common i(5 + 6 + 8 + 9)
        // count of 5 = map of f - count of 4
        count[5] = map['f' - 'a'] - count[4];
        // count[1] = map[o] - count[2] - count[0] - count[4]
        count[1] = map['o' - 'a'] - count[2] - count[0] - count[4];
        // count[3] = map[t] - count[8] - count[2]
        count[3] = map['t' - 'a'] - count[8] - count[2];
        // count[7] = map[s] - count[6]
        count[7] = map['s' - 'a'] - count[6];
        // count[9] = map[i] - count[5] - count[6] - count[8]
        count[9] = map['i' - 'a'] - count[5] - count[6] - count[8];
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<10; i++) {
            for (int j=0; j<count[i]; j++)
                sb.append(i);
        }
        return sb.toString();
    }
}
