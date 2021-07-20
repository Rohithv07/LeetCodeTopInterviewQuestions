Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
Example 1:

Input:
K = 3
arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation:Above test case has 3 sorted
arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],[4, 5, 6], 
[7, 8, 9]]
The merged list will be 
[1, 2, 3, 4, 5, 6, 7, 8, 9].
Example 2:

Input:
K = 4
arr[][]={{1,2,3,4}{2,2,3,4},
         {5,5,6,6},{7,8,9,9}}
Output:
1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9 
Explanation: Above test case has 4 sorted
arrays of size 4, 4, 4, 4
arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4],
[5, 5, 6, 6]  [7, 8, 9, 9 ]]
The merged list will be 
[1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 
6, 6, 7, 8, 9, 9 ].
Your Task:
You do not need to read input or print anything. Your task is to complete mergeKArrays() function which takes 2 arguments, an arr[K][K] 2D Matrix containing K sorted arrays and an integer K denoting the number of sorted arrays, as input and returns the merged sorted array ( as a pointer to the merged sorted arrays in cpp, as an ArrayList in java, and list in python)

Expected Time Complexity: O(K2*Log(K))
Expected Auxiliary Space: O(K)

Constraints:
1 <= K <= 100


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        // Write your code here.
        // k^2log(k^2)
        // if (arr == null || arr.length == 0)
        //     return new ArrayList<>();
        // int row = arr.length;
        // int col = arr[0].length;
        // ArrayList<Integer> result = new ArrayList<>();
        // for (int i=0; i<row; i++) {
        //     for (int j=0; j<col; j++) {
        //         result.add(arr[i][j]);
        //     }
        // }
        // Collections.sort(result);
        // return result;
        
        // efficient approach
        if (arr == null || arr.length == 0)
            return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>((m1, m2) -> Integer.compare(m1.value, m2.value));
        for (int i=0; i<k; i++) {
            MinHeapNode minHeapNode = new MinHeapNode(arr[i][0], i, 0);
            minHeap.offer(minHeapNode);
        }
        while (!minHeap.isEmpty()) {
            MinHeapNode minHeapNode = minHeap.poll();
            int value = minHeapNode.value;
            result.add(value);
            int pos1 = minHeapNode.i;
            int pos2 = minHeapNode.j;
            if (pos2 + 1 < k) {
                MinHeapNode minHeapNodeNew = new MinHeapNode(arr[pos1][pos2+1], pos1, pos2 + 1);
                minHeap.offer(minHeapNodeNew);
            }
        }
        return result;
    }
}

class MinHeapNode {
    int value;
    int i;
    int j;
    public MinHeapNode(int value, int i, int j) {
        this.value = value;
        this.i = i;
        this.j = j;
    }
}