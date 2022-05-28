Given a positive integer n that represents dimensions of a 4n x 4n matrix with values from 1 to 4*n*4*n filled from left to right and top to bottom. Your task is to form two coils from matrix and print the coils.

Follow the given examples for better understanding.

 

Example 1:

Input:
n = 1
Output:
10 6 2 3 4 8 12 16
7 11 15 14 13 9 5 1 
Explanation:
The matrix is 
1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16
So, the two coils are as given in the Ouput.
Example 2:

Input:
n = 2
Output:
36 28 20 21 22 30 38 46
54 53 52 51 50 42 34 26
18 10 2 3 4 5 6 7 8
16 24 32 40 48 56 64

29 37 45 44 43 35 27 19
11 12 13 14 15 23 31 39
47 55 63 62 61 60 59 58
57 49 41 33 25 17 9 1  
Explanation:


Your Task:
You don't need to read input or print anything. Your task is to complete the function formCoils() which takes an Integer n as input and returns a vector of two vectors representing coil1 and coil2.

 

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n2)

 

Constraints:
1 <= n <= 20


vector<vector<int>> formCoils(int n) {
       vector<vector<int>> temp;
       vector<vector<int>> v;
       int k=1;
       for(int i=0;i<4*n;++i)
       {
           vector<int> v1;
           for(int j=0;j<4*n;++j)
           {
              v1.push_back(k++);
           }
           v.push_back(v1);
       }
       int top=0,left=0;
       n=4*n;
       int bottom=n-1,right=n-1;
       vector<int> t1;
       vector<int> t2;
       k=0;
       while(left<=right)
       {
           for(int i=top;i<=bottom;++i)
           {
               if(k%2==0)
               t1.push_back(v[i][left]);
               else
               t2.push_back(v[i][left]);
           }
           left++;
           for(int i=bottom;i>=top;--i)
           {
               if(k%2==0)
               t2.push_back(v[i][right]);
               else
               t1.push_back(v[i][right]);
           }
           right--;
           for(int i=left;i<=right;++i)
           {
               if(k%2==0)
               t1.push_back(v[bottom][i]);
               else
               t2.push_back(v[bottom][i]);
           }
           bottom--;
           for(int i=right;i>=left;--i)
           {
               if(k%2==0)
               t2.push_back(v[top][i]);
               else
               t1.push_back(v[top][i]);
           }
           top++;
           k++;
       }
       reverse(t1.begin(),t1.end());
       reverse(t2.begin(),t2.end());
       temp.push_back(t2);
       temp.push_back(t1);
       return temp;
   }