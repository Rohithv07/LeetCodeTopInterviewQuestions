Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The cell itself does not count as an adjacent cell.
The same letter cell may be used more than once.

Example :

Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns 1,
word = "SEE", -> returns 1,
word = "ABCB", -> returns 1,
word = "ABFSAB" -> returns 1
word = "ABCD" -> returns 0
Note that 1 corresponds to true, and 0 corresponds to false.



class Solution:
	# @param A : list of strings
	# @param B : string
	# @return an integer
	def exist(self, A, B):
        
        rows = len(A)
        cols = len(A[0])
        dp = {}
        
        def get(r, c, ind):
            
            if ind == len(B):
                return 1
            elif r < 0 or r >= rows or c < 0 or c >= cols or A[r][c] != B[ind]:
                return 0
            elif dp.get((r,c,ind)) == None:
                dp[(r,c,ind)] = max(get(r+1,c,ind+1),
                                    get(r,c+1,ind+1),
                                    get(r-1,c,ind+1),
                                    get(r,c-1,ind+1),)
            return dp[(r,c,ind)]
        
        for i in range(rows):
            for j in range(cols):
                if get(i,j,0):
                    return 1
        return 0
