https://www.hackerrank.com/challenges/components-in-graph/problem


#!/bin/python3

import os
import sys
import collections

#
# Complete the componentsInGraph function below.
#

def parent(parents, i):
    if parents[i] != i:
        parents[i] = parent(parents, parents[i])
    return parents[i]
def componentsInGraph(gb):
    parents = list(range(len(gb) * 2 + 1))
    for a, b in gb:
        p1, p2 = parent(parents, a), parent(parents, b)
        parents[p1] = parents[p2] = parents[a] = parents[b] = min(p1, p2)
    counter = collections.Counter()
    for p in parents:
        counter[parent(parents, p)] += 1
    counts = [c for c in counter.values() if c > 1]
    return min(counts), max(counts)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    gb = []

    for _ in range(n):
        gb.append(list(map(int, input().rstrip().split())))

    result = componentsInGraph(gb)

    fptr.write(' '.join(map(str, result)))
    fptr.write('\n')

    fptr.close()

