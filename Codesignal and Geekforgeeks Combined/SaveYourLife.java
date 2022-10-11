Given a string w, integer array b,  character array x and an integer n. n is the size of array b and array x. Find a substring which has the sum of the ASCII values of its every character, as maximum. ASCII values of some characters are redefined.
Note: Uppercase & lowercase both will be present in the string w. Array b and Array x contain corresponding redefined ASCII values. For each i, 0<=ib[i] contain redefined ASCII value of character x[i].

Example 1:

Input:
W = abcde
N = 1
X[] = { 'c' }
B[] = { -1000 }
Output:
de
Explanation:
Substring "de" has the
maximum sum of ascii value,
including c decreases the sum value
Example 2:

Input:
W = dbfbsdbf 
N = 2
X[] = { 'b','s' }
B[] = { -100, 45  }
Output:
dbfbsdbf
Explanation:
Substring "dbfbsdbf" has the maximum
sum of ascii value.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxSum() which takes string W, character array X, integer array B, integer N as length of array X and B as input parameters and returns the substring with the maximum sum of ascii value.
 

Expected Time Complexity: O(|W|)
Expected Auxiliary Space: O(1)


Constraints:

1<=|W|<=100000
1<=|X|<=52
-1000<=Bi<=1000

Each character of W and A will be from a-z, A-Z.


class Solution{
    static String maxSum(String w,char x[],int b[], int n){
        //code here
         int arr[]=new int [26];//for storing the customised ascii values for lowercase charcters
    int arr2[]=new int[26];//for storing the customised ascii values for uppercase charcters
    int finalArr[]=new int[w.length()];
    String str="";
    //loop for populating the ascii values arrays(arr and arr2) with -2000
    for(int i=0;i<arr.length;i++){
      arr[i]=-2000;
    }
    for(int i=0;i<arr2.length;i++){
      arr2[i]=-2000;
    }



    //loop for populating the ascii value arrays (array and array2) with the given values of the ascii character
    for(int i=0;i<n;i++){
      if(Character.isLowerCase(x[i])){//for lowercase character
        arr[x[i]-'a']=b[i];
      }else{                          //for uppercase character
        arr2[x[i]-'A']=b[i];
      }
      
    
    }  

     //loop for populating the ascii values arr with the default ascii character
    int temps='a';
    int templ='A';
    for(int i=0;i<arr.length;i++){
      
      if (arr[i]==-2000){
        arr[i]=temps++;    //for lowercase character
        
      }else temps++;


      if (arr2[i]==-2000){//for uppercase character
        arr2[i]=templ++;
        
      }else templ++;


    }
    
    //loop for creating the final array using the ascii value array
    for(int i=0;i<w.length();i++){
      if(Character.isLowerCase(w.charAt(i))){//for lowercase character
        finalArr[i]=arr[w.charAt(i)-'a'];
      }
      else{
        finalArr[i]=arr2[w.charAt(i)-'A'];   //for uppercase character
      }
      
      
    }

    //using kadens algo on the final list
    int max=finalArr[0];
    int count=0;
    int startInd=0;
    int endInd=0;
    int tempInd=0;
    for(int i=0;i<finalArr.length;i++){
      if(count==0)tempInd=i;
      count=count+finalArr[i];
      if(max<count){
        max=count;
        endInd=i;
        startInd=tempInd;
      }
      if(count<1){
        count=0;
      }
    }

    //forming the final string
    for(int i=startInd;i<=endInd;i++){
      str=str+w.charAt(i);
    }


   return str;
    
    }
  }