Sort the given Linked List using quicksort. which takes O(n^2) time in worst case and O(nLogn) in average and best cases, otherwise you may get TLE.

Input:
In this problem, method takes 1 argument: address of the head of the linked list. The function should not read any input from stdin/console.
The struct Node has a data part which stores the data and a next pointer which points to the next element of the linked list.
There are multiple test cases. For each test case, this method will be called individually.

Output:
Set *headRef to head of resultant linked list.

User Task:
The task is to complete the function quickSort() which should set the *headRef to head of the resultant linked list.

Constraints:
1<=T<=100
1<=N<=200

Note: If you use "Test" or "Expected Output Button" use below example format

Example:
Input:
2
3
1 6 2
4
1 9 3 8

Output:
1 2 6
1 3 8 9

Explanation:
Testcase 1: After sorting the nodes, we have 1, 2 and 6.
Testcase 2: After sorting the nodes, we have 1, 3, 8 and 9.


node* quicksort(node* head,int n){
    // n = count of nodes in the current range
    if(n<=1){
        return head;
    }
    node* curr = head;
    node* prev = nullptr;
    for(int i=1;i<n;i++){
        prev = curr;
        curr = curr->next;
    }
    prev->next = nullptr;
    node* pivot = curr; // pivot as the last element of the range
    node* left = new node(-1); // dummy left node
    node* right = new node(-1); // dummy right node
    curr = head;
    node* leftHead = left;
    node* rightHead = right;
    int l = 0,r = 0;
    while(curr!=nullptr){ // place nodes at correct position
        if(curr->data<=pivot->data){
            l++;
            left->next = curr;
            left = left->next;
        }
        else{
            r++;
            right->next = curr;
            right = right->next;
        }
        curr = curr->next;
    }
    left->next = right->next = nullptr;
    node* l_node = quicksort(leftHead->next,l); // sort the linked list before pivot point
    node* r_node = quicksort(rightHead->next,r); // sort the linked list after pivot point
    pivot->next = r_node;
    
    // merge the linked list
    if(l_node==nullptr){
        head = pivot;
    }
    else{
        head = l_node;
        while(l_node and l_node->next!=nullptr){
            l_node = l_node->next;
        }
        l_node->next = pivot;
    }
    return head;
}

//you have to complete this function
void quickSort(struct node **headRef) {
    node* head = *headRef;
    int n = 0;
    node* curr = head;
    while(curr!=nullptr){
        curr = curr->next;
        n++;
    }
    *headRef = quicksort(head,n);
}