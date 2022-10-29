Given a list of contacts contact[] of length n where each contact is a string which exist in a phone directory and a query string s. The task is to implement a search query for the phone directory. Run a search query for each prefix p of the query string s (i.e. from  index 1 to |s|) that prints all the distinct contacts which have the same prefix as p in lexicographical increasing order. Please refer the explanation part for better understanding.
Note: If there is no match between query and contacts, print "0".

Example 1:

Input: 
n = 3
contact[] = {"geeikistest", "geeksforgeeks", 
"geeksfortest"}
s = "geeips"
Output:
geeikistest geeksforgeeks geeksfortest
geeikistest geeksforgeeks geeksfortest
geeikistest geeksforgeeks geeksfortest
geeikistest
0
0
Explaination: By running the search query on 
contact list for "g" we get: "geeikistest", 
"geeksforgeeks" and "geeksfortest".
By running the search query on contact list 
for "ge" we get: "geeikistest" "geeksforgeeks"
and "geeksfortest".
By running the search query on contact list 
for "gee" we get: "geeikistest" "geeksforgeeks"
and "geeksfortest".
By running the search query on contact list 
for "geei" we get: "geeikistest".
No results found for "geeip", so print "0". 
No results found for "geeips", so print "0".
Your Task:
Youd do not need to read input or print anything. Your task is to complete the function displayContacts() which takes n, contact[ ] and s as input parameters and returns a list of list of strings for required prefixes. If some prefix has no matching contact return "0" on that list.

Expected Time Complexity: O(|s| * n * max|contact[i]|)
Expected Auxiliary Space: O(n * max|contact[i]|)

Constraints:
1 ≤ T ≤ 100, T = number of test cases
1 ≤ n ≤ 50
1 ≤ |contact[i]| ≤ 50
1 ≤ |s| ≤ 6 


class Node{

public:

    char c;

    int count=0;

    set<string> words;

    map<char, Node*> children;

    Node(char &c){

        this->c=c;

    }

};



class Trie{

public:  

    Node* root;

    Trie(char c){

        root=new Node(c);

    }

    void insert(string &s){

        Node* temp=root;

        for(char &c: s){

            if(temp->children.count(c)==0){

                temp->children[c]=new Node(c);

            }

            temp=temp->children[c];

            temp->count++;

            temp->words.insert(s);

        }

    }

};



class Solution{

public:

    vector<vector<string>> displayContacts(int N, string contact[], string s)

    {

        // code here

        Trie* trie=new Trie('\0');

        for(int i=0;i<N;i++){

            trie->insert(contact[i]);

        }

       

        vector<vector<string>> ans;

        Node* temp=trie->root;

        int i=0, n=s.length();

        for(i=0;i<n;i++){

            if(temp->children.count(s[i])==0){

                break;

            }

            temp=temp->children[s[i]];

            vector<string> v;

            for(string word:temp->words)

                v.push_back(word);

            ans.push_back(v);

        }

        while(i++<n){

            ans.push_back({"0"});

        }

       

        return ans;

    }

};