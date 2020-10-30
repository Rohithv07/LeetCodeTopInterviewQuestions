https://www.hackerrank.com/challenges/crush/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the arrayManipulation function below.
def arrayManipulation(n, queries):
    # Create a new array
    array = [0] * (n + 1)
    for query in queries:
        a = query[0] - 1
        b = query[1]
        k = query[2]
        array[a] += k
        array[b] -= k
    maxValue = 0
    cumulativeCount = 0
    for number in array:
        cumulativeCount += number
        if cumulativeCount > maxValue:
            maxValue = cumulativeCount

    return maxValue

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nm = input().split()

    n = int(nm[0])

    m = int(nm[1])

    queries = []

    for _ in range(m):
        queries.append(list(map(int, input().rstrip().split())))

    result = arrayManipulation(n, queries)

    fptr.write(str(result) + '\n')

    fptr.close()

