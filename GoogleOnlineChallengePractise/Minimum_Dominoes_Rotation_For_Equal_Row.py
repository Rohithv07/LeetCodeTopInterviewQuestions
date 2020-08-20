class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        if len(A) != len(B):
            return -1
        changes = float('INF')
        for i in range(1, 7):
            validCondition = True
            a_count = 0
            b_count = 0
            for j in range(len(A)):
                if A[j] == i:
                    a_count += 1
                if B[j] == i:
                    b_count += 1
                if A[j] != i and B[j] != i:
                    validCondition = False
                    break
            if validCondition:
                changes = min(len(A) - a_count, len(A) - b_count, changes)
            
        if changes != float('INF'):
            return changes
        return -1
                
        
