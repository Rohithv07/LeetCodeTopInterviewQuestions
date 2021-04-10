test = int(input())
for t in range(test):
    n = int(input())
    nums = list(map(int, input().split()))
    answer = 0
    for i in range(1, n):
        left = nums[i]
        right = nums[i]
        while right <= nums[i - 1]:
            left = left * 10 + 0
            right = right * 10 + 9
            answer += 1
        nums[i] = max(left, nums[i - 1] + 1)
    print('Case #' + str(t + 1) + ':', answer)
