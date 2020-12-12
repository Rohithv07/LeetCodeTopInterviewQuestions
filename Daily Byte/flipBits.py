
Given a positive integer N, return whether or not it has alternating bit values.

Ex: Given the following value for N…

N = 5, return true.
5 in binary is 101 which alternates bit values between 0 and 1.
Ex: Given the following value for N…

N = 8, return false
8 in binary is 1000 which does not alternate bit values between 0 and 1.

def getBinary(n : int) -> str:
	return bin(n).replace("0b", "")


def flipBits(n : int) -> bool:
	count = 0 # -1, 0, 1 else false
	respectiveBinary = getBinary(n)
	for i in range(len(respectiveBinary) - 1):
		if respectiveBinary[i] == respectiveBinary[i+1]:
			return False
	return True

n = int(input())
print(flipBits(n))

"""
Simple Java Code

boolean hasAlternatingBits2(int n) {
        /*
        n =         1 0 1 0 1 0 1 0
        n >> 1      0 1 0 1 0 1 0 1
        n ^ n>>1    1 1 1 1 1 1 1 1
        n           1 1 1 1 1 1 1 1
        n + 1     1 0 0 0 0 0 0 0 0
        n & (n+1)   0 0 0 0 0 0 0 0
        */

        n = n ^ (n>>1);
        return (n & n+1) == 0;
    }
"""