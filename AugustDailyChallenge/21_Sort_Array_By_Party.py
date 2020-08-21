class Solution:
    def sortArrayByParity(self, A: List[int]) -> List[int]:
        """
        evenList = []
        oddList = []
        for element in A:
            if element % 2 == 0:
                evenList.append(element)
            else:
                oddList.append(element)
        
        combinedList = [i for i in evenList] + [j for j in oddList]
        return combinedList
        """
        a_pointer = 0
        b_pointer = len(A) - 1
        while (a_pointer <= b_pointer):
            if A[a_pointer] % 2 != 0:
                A[a_pointer], A[b_pointer] = A[b_pointer], A[a_pointer]
                a_pointer -= 1
                b_pointer -= 1
            a_pointer += 1
        return A
        
