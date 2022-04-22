// approach 1

class Solution
{
    int sum(int a , int b)
    {
        //code here
        int xor = a ^ b;
        int carry = a & b;
        while (carry > 0) {
            a = xor;
            b = (carry << 1);
            xor = a ^ b;
            carry = a & b;
        }
        return xor;
    }
}


// approach 2

class Solution
{
    int sum(int a , int b)
    {
        //code here
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}