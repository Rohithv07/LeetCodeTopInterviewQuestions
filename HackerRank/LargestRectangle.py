# Complete the largestRectangle function below.
def largestRectangle(h):
    h.append(0)
    stack = [-1]
    answer = 0
    for i in range(len(h)):
        while h[i] < h[stack[-1]]:
            height = h[stack.pop()]
            width = i - 1 - stack[-1]
            answer = max(answer, height * width)
        stack.append(i)
    h.pop()
    return answer
