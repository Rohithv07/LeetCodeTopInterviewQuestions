Write a function to convert a given number into words.

Example 1:

Input:
N = 438237764
Output: forty three crore eighty two lakh 
thirty seven thousand seven hundred and 
sixty four
 

Example 2:

Input:
N = 1000
Output: one thousand

Your Task:
You don't need to read input or print anything. Your task is to complete the function convertToWords() which takes the integer n as input parameters and returns a string containing n in words.


Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 109 - 1



string one[] = { "", "one ", "two ", "three ", "four ",
"five ", "six ", "seven ", "eight ",
"nine ", "ten ", "eleven ", "twelve ",
"thirteen ", "fourteen ", "fifteen ",
"sixteen ", "seventeen ", "eighteen ",
"nineteen " };

string ten[] = { "", "", "twenty ", "thirty ", "forty ",
"fifty ", "sixty ", "seventy ", "eighty ",
"ninety " };
class Solution{
public:

string convertToWords(long n) {
string out;

out += numToWords((n / 10000000), "crore ");

out += numToWords(((n / 100000) % 100), "lakh ");

out += numToWords(((n / 1000) % 100), "thousand ");

out += numToWords(((n / 100) % 10), "hundred ");

if (n > 100 && n % 100)
out += "and ";

out += numToWords((n % 100), "");

return out;
}
string numToWords(int n, string s)
{
string str = "";
if (n > 19)
str += ten[n / 10] + one[n % 10];
else
str += one[n];

if (n)
str += s;

return str;
}
};