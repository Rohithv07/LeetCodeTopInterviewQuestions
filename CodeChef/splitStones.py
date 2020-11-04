There are three piles of stones. The first pile contains a stones, the second pile contains b stones and the third pile contains c stones. You must choose one of the piles and split the stones from it to the other two piles; specifically, if the chosen pile initially contained s stones, you should choose an integer k (0≤k≤s), move k stones from the chosen pile onto one of the remaining two piles and s−k stones onto the other remaining pile. Determine if it is possible for the two remaining piles (in any order) to contain x stones and y stones respectively after performing this action.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first and only line of each test case contains five space-separated integers a, b, c, x and y.
Output
For each test case, print a single line containing the string "YES" if it is possible to obtain piles of the given sizes or "NO" if it is impossible.

Constraints
1≤T≤100
1≤a,b,c,x,y≤109
Subtasks
Subtask #1 (20 points): 1≤a,b,c,x,y≤100
Subtask #2 (80 points): original constraints

Example Input
4
1 2 3 2 4
3 2 5 6 5
2 4 2 6 2
6 5 2 12 1
Example Output
YES
NO
YES
NO
Explanation
Example case 1: You can take the two stones on the second pile, put one of them on the first pile and the other one on the third pile.

Example case 2: You do not have enough stones.

Example case 3: You can choose the first pile and put all stones from it on the second pile.



test = int(input())
for i in range(test):
    allNumber = list(map(int, input().split()))
    a = allNumber[0]
    b = allNumber[1]
    c = allNumber[2]
    x = allNumber[3]
    y = allNumber[4]
    
    if (x > y):
        x, y = y, x
    
    if (a > b):
        a, b = b, a
    if (a > c):
        a, c = c, a
    if (b > c):
        b, c = c, b
    
    if (a>x or b>y or a+b+c != x+y):
        print("NO\n")
    else:
        print("YES\n")
