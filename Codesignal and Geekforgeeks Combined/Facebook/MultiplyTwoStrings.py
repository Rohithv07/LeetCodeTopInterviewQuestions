'''
Given two numbers as stings s1 and s2. Calculate their Product.


Example 1:

Input:
s1 = "33"
s2 = "2"
Output:
66
Example 2:

Input:
s1 = "11"
s2 = "23"
Output:
253

Your Task:

You don't need to read input or print anything. Your task is to complete the function multiplyStrings() which takes two strings s1 and s2 as input and returns their product as a string.


Expected Time Complexity: O(n1* n2)
Expected Auxiliary Space: O(n1 + n2) ; where n1 and n2 are sizes of strings s1 and s2 respectively.

 

Constraints:
1 <= length of s1 and s2 <= 103


'''

class Solution:
    def multiplyStrings(self,s1,s2):
        # code here
        # return the product string
        num1 = int(s1)
        num2 = int(s2)
        result = num1 * num2
        return str(result)
