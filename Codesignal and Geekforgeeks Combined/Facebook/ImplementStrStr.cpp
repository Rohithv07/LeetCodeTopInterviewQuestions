Your task is to implement the function strstr. The function takes two strings as arguments (s,x) and  locates the occurrence of the string x in the string s. The function returns and integer denoting the first occurrence of the string x in s (0 based indexing).

Note: You are not allowed to use inbuilt function.

 

Example 1:

Input:
s = GeeksForGeeks, x = Fr
Output: -1
Explanation: Fr is not present in the
string GeeksForGeeks as substring.
 

Example 2:

Input:
s = GeeksForGeeks, x = For
Output: 5
Explanation: For is present as substring
in GeeksForGeeks from index 5 (0 based
indexing).
 

Your Task:
You don't have to take any input. Just complete the strstr() function which takes two strings str, target as an input parameter. The function returns -1 if no match if found else it returns an integer denoting the first occurrence of the x in the string s.

 

Expected Time Complexity: O(|s|*|x|)
Expected Auxiliary Space: O(1)

Note : Try to solve the question in constant space complexity.

string substr(string s, int st, int len){
    string res;
    for(int i = 0; i < len; i++)
        res += s[st + i];
    
    return res;
}

int strstr(string s, string x){
    int xle = x.length();
    int sle = s.length();
    
    if(s == x || xle == 0)
        return 0;
        
    for(int i = 0; i < sle; i++){
        if(s[i] == x[0]){
            if(substr(s, i, xle) == x)
                return i;
        }
    }
        return -1;
