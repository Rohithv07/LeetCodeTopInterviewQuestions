Given a singly linked list of 0s and 1s, the task is to find its decimal equivalent. Decimal Value of an empty linked list is considered as 0.

Since the answer can be very large, answer modulo 1000000007 should be printed.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains 

Output:
The function should return should decimal equivalent modulo 1000000007.

User Task:
The task is to complete the function decimalValue() which should find the decimal value of the given binary value in the linked list.

Constraints:
1 <= T <= 200
0 <= N <= 100
Data of Node is either 0 or 1

Example:
Input:
2
3
0 1 1    
4
1 1 1 0

Output:
3
14

Explanation:
Testcase 1: 1*20 + 1*21 + 0*22 =  1 + 2 + 0 = 3.


class gfg
{
   long DecimalValue(Node head)
   {
 	if (head == null)
 	    return 0;
 	long mod = (long) 1e9 + 7;
 	long value = 0;
 	while (head != null) {
 	    value = ((value << 1) | head.data) % mod;
 	    head = head.next;
 	}
 	return value;
   }
}
