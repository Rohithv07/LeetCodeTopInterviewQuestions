// https://www.youtube.com/watch?v=xRkM3vuqGko&t=2521s
 
 
 // } Driver Code Ends
/*
 
Definition for singly Link List Node
struct Node
{
    int data;
    Node* next;
    Node(int x) {  data = x;  next = NULL; }
};
 
You can also use the following for printing the link list.
printList(Node* node);
*/
 
class Solution {
    /*
        Case 0: Different char
        Case 1: Exceeds count
        Case 2: Not matched yet
        Case 3: Matched
    */
    int findCase(int *freq, int *window_freq) {
        for(int i=0; i<26; i++) {
            if(freq[i] == 0 and window_freq[i] > 0) return 0;
        }
        
        for(int i=0; i<26; i++) {
            if(window_freq[i] > freq[i]) return 1;
        }
        
        for(int i=0; i<26; i++) {
            if(window_freq[i] < freq[i]) return 2;
        }
        return 3;
    }
    
    Node *generateAnagram(Node *left, Node *right) {
        Node *curr = new Node(left->data);
        Node *head = curr;
        while(left != right) {
            left = left->next;
            curr->next = new Node(left->data);
            curr = curr->next;
        }
        
        return head;    
    }
  public:
    vector<Node*> findAnagrams(struct Node* head, string s) {
        // code here
        int freq[26] = {0};
        int window_freq[26] = {0};
        
        for(char x: s) {
            freq[(int)(x-'a')]++;
        }
        
        Node *right = head, *left = head;
        
        vector<Node *> ans;
        
        Node *listEnd = head;
        window_freq[right->data - 97]++;
        
        if(findCase(freq, window_freq) == 3) ans.push_back(generateAnagram(left, right));
        
        while(listEnd->next != NULL) listEnd = listEnd -> next;
        
        while(right < listEnd) {
            right = right->next;
            window_freq[right->data - 97]++;
            
            int caseNo = findCase(freq, window_freq);
            
            if(caseNo == 0) {
                left = right->next;
                fill(window_freq, window_freq + 26, 0);
            } else if(caseNo == 1) {
                while(left != right && findCase(freq, window_freq) == 1) {
                    window_freq[left->data - 97]--;
                    left = left->next;
                }
                
                if(findCase(freq, window_freq) == 3) {
                    ans.push_back(generateAnagram(left, right));
                }
            } else if(caseNo == 2) {
                continue;
            } else {
                ans.push_back(generateAnagram(left, right));
                left = right->next;
                fill(window_freq, window_freq + 26, 0);
            }
        }
        if(ans.size() == 0) {
            Node *newNode = new Node(-1);
            ans.push_back(newNode);
        }
        return ans;
    }
};
 
 
// { Driver Code Starts.
 
int main() {
    int t;
    cin >> t;
    while (t--) {
 
        struct Node *head = inputList();
 
        string s;
        cin >> s;
 
        Solution obj;
        vector<Node *> res = obj.findAnagrams(head, s);
 
        for (int i = 0; i < res.size(); i++) {
            printList(res[i]);
        }
 
        if (res.size() == 0) cout << "-1\n";
    }
}
  // } Driver Code Ends