We are given a list of (axis-aligned) rectangles. Each rectangle[i] = [xi1, yi1, xi2, yi2] , where (xi1, yi1) are the coordinates of the bottom-left corner, and (xi2, yi2) are the coordinates of the top-right corner of the ith rectangle.

Find the total area covered by all rectangles in the plane. Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:


Input: rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
Output: 6
Explanation: As illustrated in the picture.
Example 2:

Input: rectangles = [[0,0,1000000000,1000000000]]
Output: 49
Explanation: The answer is 1018 modulo (109 + 7), which is (109)2 = (-7)2 = 49.
 

Constraints:

1 <= rectangles.length <= 200
rectanges[i].length = 4
0 <= rectangles[i][j] <= 109
The total area covered by all rectangles will never exceed 263 - 1 and thus will fit in a 64-bit signed integer.



class Solution {
    public int rectangleArea(int[][] rectangles) {
        
        int mod = (int)Math.pow(10,9)+7;
        long res = 0;
        List<int[]> recList = new ArrayList<>();
        for(int[] rec : rectangles)
            addRectangle(recList, rec, 0);
        
        for(int[] rec: recList)
            res = (res+((long)(rec[2]-rec[0])*(long)(rec[3]-rec[1])))%mod;

        return (int) res%mod;
    }
    
    // Add new rectangle to the list. In case of overlap break up new rectangle into 
    // non-overlapping rectangles. Compare the new rectanlges with the rest of the list.
    public void addRectangle(List<int[]> recList, int[] curRec, int start){
        if(start>=recList.size()){
            recList.add(curRec);
            return;
        }
        
        int[] r = recList.get(start);
        
        // No overlap
        if(curRec[2]<=r[0] || curRec[3]<=r[1] || curRec[0]>=r[2] || curRec[1]>=r[3]){
            addRectangle(recList, curRec, start+1);
            return;
        }

        if( curRec[0]<r[0])
            addRectangle(recList, new int[]{curRec[0],curRec[1],r[0],curRec[3]},start+1);

        if(curRec[2]>r[2])
            addRectangle(recList, new int[]{r[2],curRec[1],curRec[2],curRec[3]},start+1);
        
        if(curRec[1]<r[1])
            addRectangle(recList, new int[]{Math.max(r[0],curRec[0]),curRec[1],Math.min(r[2],curRec[2]),r[1]},start+1);
        
        if(curRec[3]>r[3])
            addRectangle(recList, new int[]{Math.max(r[0],curRec[0]),r[3],Math.min(r[2],curRec[2]),curRec[3]},start+1);
    }
}