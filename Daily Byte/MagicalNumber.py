'''
Given a k-digit integer, num, return whether or not the number if magical.
Note: A magical numbers is a number in which the the sum of all its digits raised to the kth power sum to the number itself.

Ex: Given the following num…

num = 153, return true (1^3 + 5^3 + 3^3 = 153).
Ex: Given the following num…

num = 38, return false.
'''


n = int(input())
n_tostring = str(n) # extra space
length = len(n_tostring)
sum = 0
temp = n
while (n > 0):
	rem = n % 10
	sum = sum + (rem ** length)
	n = n // 10

#logn
if (temp == sum):
	print("Magical")
else:
	print("Not Magical")