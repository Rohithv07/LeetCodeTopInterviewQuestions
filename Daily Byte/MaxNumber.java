/*
Given an integer, num, that consists of only two digits, sixes and nines, return the largest number you can create by modifying one digit to be a six or a nine.

Ex: Given the following num…

num = 669, return 969.
Ex: Given the following num…

num = 9969, return 9999.
*/

class Solution {
    public int maximum69Number (int num) {
        char [] digits = Integer.toString(num).toCharArray();
        for (int i=0; i<digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break;
            }
        }
        return Integer.valueOf(new String(digits));
    }
}


// Python solution without converting to String

class Solution:
    def maximum69Number (self, num: int) -> int:
        i = 0 
        tem = num
        sixidx = -1 
        while tem > 0:
            if tem % 10 == 6:
                sixidx = i  #refresh sixidx when found 6 at large digit.
            tem = tem//10
            i += 1
        return (num + 3 *(10**sixidx)) if sixidx != -1 else num
