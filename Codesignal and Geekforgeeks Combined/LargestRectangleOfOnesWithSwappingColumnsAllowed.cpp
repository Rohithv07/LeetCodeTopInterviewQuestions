Given a matrix mat of size R*C with 0 and 1’s, find the largest rectangle of all 1’s in the matrix. The rectangle can be formed by swapping any pair of columns of given matrix.

Example 1:

Input: 
R = 3, C = 5
mat[][] = {{0, 1, 0, 1, 0},
           {0, 1, 0, 1, 1},
           {1, 1, 0, 1, 0}};
Output: 6
Explanation: The largest rectangle's area
is 6. The rectangle can be formed by
swapping column  2 with 3. The matrix
after swapping will be
     0 0 1 1 0
     0 0 1 1 1
     1 0 1 1 0
Example 2:

Input:
R = 4, C = 5
mat[][] = {{0, 1, 0, 1, 0},
           {0, 1, 1, 1, 1},
           {1, 1, 1, 0, 1},
           {1, 1, 1, 1, 1}};
Output: 9
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxArea() which takes the 2D array of booleans mat, r and c as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(R*(R + C))
Expected Auxiliary Space: O(R*C)

Constraints:
1<= R,C <=103
0 <= mat[i][j] <= 1


class Solution{
public:	
	// Returns area of the largest rectangle of 1's
	int getMaxArea(vector<int>& a,int n){
	    sort(a.begin(),a.end());
	    int ans = 0;
	    for(int i=0;i<n;i++){
	        ans = max(ans, a[i]*(n-i));
	    }
	    return ans;
	}
	int maxArea(vector<bool> mat[], int r, int c) {
	    // code here
	    vector<vector<int>>aux (r,vector<int>(c,0));
	    for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
	            aux[i][j] = (mat[i][j]==true ? 1 : 0);
	            
	            if(i>0){
	                if(aux[i][j]) aux[i][j]+=aux[i-1][j];
	            }
	        }
	    }
	    
	    int ans = 0;
	    for(auto& x:aux){
	        ans=max(ans,getMaxArea(x,c));
	    }
	    
	    return ans;
	}

};