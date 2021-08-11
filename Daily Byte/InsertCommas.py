"""
Given an integer, N, return its string representation including the necessary commas.

Ex: Given the following N…

N = 200000000, return "200,000,000".
Ex: Given the following N…

N = 5000, return "5,000".
Ex: Given the following N…

N = 100, return "100".
"""

def placeValue(number):
	return ("{:,}".format(number))

print(placeValue(10000000))