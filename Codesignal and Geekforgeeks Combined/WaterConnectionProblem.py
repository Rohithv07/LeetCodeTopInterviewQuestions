Every house in the colony has at most one pipe going into it and at most one pipe going out of it. Tanks and taps are to be installed in a manner such that every house with one outgoing pipe but no incoming pipe gets a tank installed on its roof and every house with only an incoming pipe and no outgoing pipe gets a tap.

Given two integers n and p denoting the number of houses and the number of pipes. The connections of pipe among the houses contain three input values: ai, bi, di denoting the pipe of diameter di from house ai to house bi. Find the efficient way for the construction of the network of pipes.

The output will contain the number of pairs of tanks and taps t installed in first line and the next t lines contain three integers: house number of tank, house number of tap and the minimum diameter of pipe between them.


Example 1:

Input:
n = 9, p = 6
a[] = {7,5,4,2,9,3}
b[] = {4,9,6,8,7,1}
d[] = {98,72,10,22,17,66} 
Output: 
3
2 8 22
3 1 66
5 6 10
Explanation:
Connected components are 
3->1, 5->9->7->4->6 and 2->8.
Therefore, our answer is 3 
followed by 2 8 22, 3 1 66, 5 6 10.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function solve() which takes an integer n(the number of houses), p(the number of pipes),the array a[] , b[] and d[] (where d[i] denoting the diameter of the ith pipe from the house a[i] to house b[i]) as input parameter and returns the array of pairs of tanks and taps installed i.e ith element of the array contains three integers: house number of tank, house number of tap and the minimum diameter of pipe between them.  

 

Expected Time Complexity: O(n+p)
Expected Auxiliary Space: O(n+p)

 

Constraints:
1<=n<=20
1<=p<=50
1<=a[i],b[i]<=20
1<=d[i]<=100


class Solution:
    def solve(self, n, p ,a, b, d): 
        #code here
        bidx,aidx={},{}
        
        for i in range(p):
            aidx[a[i]]=i
            bidx[b[i]]=i

        start=[]
        for i in a:
            if i not in bidx:
                start.append(i)
                
        ans=[]
        for node in start:
            root=node
            mn=d[aidx[node]]
            while True:
                index=aidx[node]
                mn=min(d[index],mn)
                if b[index] not in aidx:
                    ans.append([root,b[index],mn])
                    break
                else:
                    node=b[index]
        
        ans.sort()
        return ans