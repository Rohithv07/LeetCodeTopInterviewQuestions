def getReverse(n, p):
    if n - 1 > p:
        return []
    li = []
    temp = 0
    cost = 1
    for i in range(n - 1, 0, -1):
        cost += 1
        if temp + cost + i - 1 >= p:
            right = p - temp - i + 1
            li.append(right)
            for k in range(i - 1):
                li.append(1)
            temp = p
            break
        temp += cost
        li.append(cost)
    if temp < p:
        return []
    return li

def getList(n):
    li = []
    for i in range(1, n + 1):
        li.append(i)
    return li

def getReverseEngineering(li, finalResult):
    size = len(finalResult)
    for i in range(size):
        temp = len(li) - (i + 2)
        regularity = temp + finalResult[i]
        li = li[:temp] + list(reversed(li[temp:regularity])) + li[regularity:]
    return li
    
    
for i in range(int(input())):
    getInput = input().split()
    n = int(getInput[0])
    p = int(getInput[1])
    li = getList(n)
    finalResult = getReverse(n, p)
    li = getReverseEngineering(li, finalResult)
    output = " "
    if finalResult:
        for item in li:
            output += str(item) + " "
    else:
        output = "IMPOSSIBLE"
    print("Case #" + str(i + 1) + ": " + str(output))