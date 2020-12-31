def getMaxArea(histogram):
    #code here
    histogram.append(0)
    answer = 0
    stack = [-1]
    for i in range(len(histogram)):
        while histogram[i] < histogram[stack[-1]]:
            h = histogram[stack.pop()]
            w = i - stack[-1] - 1
            answer = max(answer, h * w)
        stack.append(i)
    histogram.pop()
    return answer

