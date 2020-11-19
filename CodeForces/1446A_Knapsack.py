
import math
for i in range(int(input())):
    n,w=map(int,input().split())
    d=list(map(int,input().split()))
    index=[]
    bagw=0
    for i in range(n):
        if d[i] <=w and d[i]>=math.ceil(w/2) :
            index=[i+1] 
            bagw=d[i]
            break
        elif bagw+d[i]<=w:
            index.append(i+1)
            bagw+=d[i]
    if bagw >= math.ceil(w/2):
        print(len(index))
        print(*index)
    else:
        print("-1")



