Given an array A[ ] of N of  integers, find the index of values that satisfy A + B = C + D where A,B,C & D are integers values in the array.
Note: As there may be multiple pairs satisfying the equation return lexicographically smallest order of  A, B, C and D and return all as -1 if there are no pairs satisfying the equation.

 

Example 1:

Input:
N = 7
A[] = {3, 4, 7, 1, 2, 9, 8}
Output:
0 2 3 5
Explanation:
A[0] + A[2] = 3+7 = 10
A[3] + A[5] = 1+9 = 10
Example 2:

Input:
N = 4
A[] = {424, 12, 31, 7}
Output:
-1 -1 -1 -1
Explanation:
There are no pairs satisfying the equation.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function satisfyEqn() which takes an Integer N and an array A[] of size N as input and returns a vector of 4 integers denoting A, B, C, and D respectively.

 

Expected Time Complexity: O(N2*logN2)
Expected Auxiliary Space: O(N2)

 

Constraints:
1 <= N <= 500
1 <= A[i] <= 105


class Solution {
    static int[] satisfyEqn(int[] A, int N) {
        
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        int a, b, c, d =0;
        
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++)
            {
                int sum = A[i]+A[j];
                
                if(map.containsKey(sum)) map.get(sum).add(new Pair(i, j));
                else {
                    map.put(sum, new ArrayList<Pair>());
                    map.get(sum).add(new Pair(i, j));
                }
            }
        }
        
        int [] arr = new int[4];
        Arrays.fill(arr, -1);
        
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++)
            {
                int sum = A[i]+A[j];
                if(!map.containsKey(sum)) continue;
                
                ArrayList<Pair> lt = map.get(sum);
                for(Pair p: lt)
                {
                    if(p.a==i || p.b==j || p.a==j || p.b==i) continue;
                    
                    arr[0]=i;
                    arr[1]=j;
                    arr[2]=p.a;
                    arr[3]=p.b;
                    
                    return arr;
                }
            }}
        
        return arr;
    }
};

class Pair implements Comparable<Pair>
{
    int a,  b;
    public Pair(int a, int b)
    {
        this.a=a;
        this.b=b;
    }
    
    @Override
    public int compareTo(Pair p)
    {
        if(this.a > p.a) return 1;
        else if(this.a < p.a) return -1;
        else
        {
            if(this.b > p.b) return 1;
            else return -1;
        }
    }
}
 