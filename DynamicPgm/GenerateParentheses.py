class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        answer = []
        def backTrack(s='', left=0, right=0):
            if len(s) == 2 * n:
                answer.append(s)
                return
            if (left < n):
                backTrack(s+'(', left+1, right)
            if (right < left):
                backTrack(s+')', left, right+1)
        backTrack()
        return answer
