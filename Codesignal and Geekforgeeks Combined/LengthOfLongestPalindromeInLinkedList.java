Given a linked list, the task is to complete the function maxPalindrome() which returns an integer denoting  the length of the longest palindrome list that exist in the given linked list.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains an integer N denoting the size of the linked list . Then in the next line are N space separated values of the given linked list.

Output:
For each test case output will be the required max length of the palindrome present in the given linked list.

User Task:
The task is to complete the function maxPalindrome() which should count the length of longest palindrome in the given list and return it.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
7
2 3 7 3 2 12 24
5
12 4 4 3 14

Output:
5
2

Explanation:
Testcase 1: 2 -> 3 -> 7 -> 3 -> 2 is the linked list whose nodes leads to a palindrome as 2 3 7 3 2.



/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}*/
class GfG
{
    public static int maxPalindrome(Node head)
    {
      //add code here.
      if (head == null) {
          return 0;
      }
      if (head.next == null) {
          return 1;
      }
      Node previous = null;
      Node current = head;
      int maxLength = 0;
      while (current != null) {
          Node next = current.next;
          current.next = previous;
          maxLength = Math.max(maxLength, 2 * countCommonLetter(next, current)); // odd length
          maxLength = Math.max(maxLength, 2 * countCommonLetter(next, previous) + 1); // even length
          previous = current;
          current = next;
      }
      return maxLength;
    }
    
    private static int countCommonLetter(Node rightMost, Node leftMost) {
        Node left = leftMost;
        Node right = rightMost;
        int count = 0;
        while (left != null && right != null) {
            if (left.data == right.data) {
                count++;
                left = left.next;
                right = right.next;
            }
            else {
                return count;
            }
        }
        return count;
    }
}