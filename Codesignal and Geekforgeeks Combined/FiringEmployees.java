Geek is the founder of Geek Constructions. He always maintains a black-list of potential employees which can be fired at any moment.

The company has N employees (including Geek), and each employee is assigned a distinct rank (1 <= rank <= N) at the time of joining. The company has a hierarchical  management such that each employee always has one immediate senior. 

Geek has a strange and unfair way of evaluating an employees performance. He sums the employee's rank and the number of seniors the employee has. If it is a prime number, the employee is put up on the black-list.

Given an array arr[] in order of the rank of company employees. For rank i, arr[i] represents the rank of the immediate senior of the employee with the ith rank. If geek's rank is i, then arr[i] is always equal to 0 as there is noone senior to him. Find out the number of Black-Listed employees.

Note: The black-list can not contain Geeks name as he is the founder of the company and he is the one that makes the list.


Example 1:

Input:
N = 4
arr[] = {0, 1, 1, 2}

Output: 1

Explanation:
The hierarchy is as follows

       (Geek)
       Rank 1
        /   \
  Rank 2     Rank 3  
      /
Rank 4

Performance = rank + number of seniors
Performance for rank 1 = not considered.
Performance for rank 2 = 2+1 = 3 (prime)
Performance for rank 3 = 3+1 = 4 (not prime)
Performance for rank 4 = 4+2 = 6 (not prime)
Therefore, only employee 2 is black-listed.

Example 2:

Input:
N = 3
arr[] = {2, 3, 0}

Output: 2

Explanation: 
The hierarchy is as follows

       (Geek)
       Rank 3
        /   
  Rank 2     
      /
Rank 1

Rank 1 and 2 are both black-listed.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function firingEmployees() which takes the array arr[] and its size N as input parameters. It returns the number of black-listed employees. 


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 <= N <= 105
1 <= i <= N
1 <= arr[i] <= 105



//User function Template for Java

class Solution {
    static int firingEmployees(int arr[], int n) { 
        // code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>> ();
        // 1,2... node bcoz ranks are 1 ordering
        for(int i=0; i<=n; ++i){
            adjList.add(new ArrayList<Integer>());
        }
        int source = 0;// founder
        for(int i=0; i<n; ++i){
            int rank1 = i+1;
            int rank2 = arr[i];
            // rank2 is superiot to rank1, so connect them
            adjList.get(rank1).add(rank2);
            adjList.get(rank2).add(rank1);
            if(rank2 == 0){
                // founder
                source = i+1;
            }
        }
        // do bfs from founder and calculate the no of seniors on go and fire accordingly
        int[] visited = new int[n+1];
        int ans = bfs(source,-1,n,visited,adjList);
        return ans;
        
    } 
    static int bfs(int source,int par,int n, int[] visited, ArrayList<ArrayList<Integer>> adjList){
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(source);
        visited[source] = 1;
        int cnt = 1;
        int res = 0;
        int MAXN = 2*n+1;
        int[] prime = new int[MAXN];
        Arrays.fill(prime,1);
        //seive
        prime[1] = prime[0] = 0;
        for(int i=2; i<MAXN; ++i){
            if(prime[i] == 1){
                for(int j=2*i; j<MAXN; j+=i){
                    prime[j] = 0;
                }
            }
        }
        while(!q.isEmpty()){
            int m = q.size();
            for(int i=0; i<m; ++i){
                int u = q.poll();
                for(Integer v:adjList.get(u)){
                    if(visited[v] == 0){
                        q.add(v);
                        visited[v] = 1;
                        int sum = v+cnt;
                        if(prime[sum] == 1){
                            res += 1;
                        }
                    }
                }
            }
            cnt += 1;
        }
        return res;
    }
}