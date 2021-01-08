


Given an adjacency matrix representation of a graph g having 0 based index your task is to complete the function isBipartite which returns true if the graph is a bipartite graph else returns false.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer v denoting the no of vertices of the graph then in the next line are v*v space separated values of the adjacency matrix representation of the graph g.

Output:
For each test case in a new line output will be 1 if the graph is bipartite else 0.

Constraints:
1<=T<=100
1<=v<=15
0<=g[][]<=1

Example(To be used only for expected output):
Input:
2
4
0 1 0 1 1 0 1 0 0 1 0 1 1 0 1 0
3
0 1 0 0 0 1 1 0 0
Output:
1
0


def isBipertite(arr, n):
    graph = [[j for j in range(n) if arr[i][j]==1 ] for i in range(n)]

    def dfs(pos):

        for i in graph[pos]:
            if i in color:
                if color[i] == color[pos]:
                    return False

            else:
                color[i] = 1 - color[pos]
                if not dfs(i):
                    return False

        return True

    color = {}

    for i in range(n):
      if i not in color:
        color[i]=0

        if not dfs(i):
          return 0

    return 1
