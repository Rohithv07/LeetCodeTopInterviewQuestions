https://www.hackerrank.com/challenges/luck-balance/problem


#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the luckBalance function below.
def luckBalance(k, contests):
    contests.sort(reverse=True)
    luck = 0
    for c in contests:
        if c[1] == 0:
            luck += c[0]
        elif k > 0:
            luck += c[0]
            k -= 1
        else:
            luck -= c[0]
    return luck
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    contests = []

    for _ in range(n):
        contests.append(list(map(int, input().rstrip().split())))

    result = luckBalance(k, contests)

    fptr.write(str(result) + '\n')

    fptr.close()




