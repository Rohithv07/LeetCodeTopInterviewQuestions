https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=virtusa

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the countTriplets function below.
def countTriplets(arr, r):
    count = 0
    dict1 = {}
    dict2 = {}
    for v in arr:
        if v in dict1:
            dict1[v] += 1
        else:
            dict1[v] = 1
    for v in arr:
        dict1[v] -= 1
        if v // r in dict2 and  v % r == 0 and v * r in dict1:
            count += dict2[v//r] * dict1[v*r]
        if v in dict2:
            dict2[v] += 1
        else:
            dict2[v] = 1
    return count


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nr = input().rstrip().split()

    n = int(nr[0])

    r = int(nr[1])

    arr = list(map(int, input().rstrip().split()))

    ans = countTriplets(arr, r)

    fptr.write(str(ans) + '\n')

    fptr.close()

