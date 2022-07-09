Given two polynomial numbers represented by a linked list. The task is to complete the function addPolynomial() that adds these lists meaning adds the coefficients who have the same variable powers.
Note:  Given polynomials are sorted in decreasing order of power.

Example 1:

Input:
LinkedList1:  (1,x2) 
LinkedList2:  (1,x3)
Output:
1x^3 + 1x^2
Explanation: Since, x2 and x3 both have
different powers as 2 and 3. So, their
coefficient can't be added up.
Example 2:

Input:
LinkedList1:  (1,x3) -> (2,x2)
LinkedList2:  (3,x3) -> (4,x2)
Output:
4x^3 + 6x^2
Explanation: Since, x3 has two different
coefficients as 3 and 1. Adding them up
will lead to 4x3. Also, x2 has two
coefficients as 4 and 2. So, adding them
up will give 6x2.
Your Task:
The task is to complete the function addPolynomial() which should add the polynomial with same powers return the required polynomial in decreasing order of the power in the form of a linked list.
Note: Try to solve the question without using any extra space.

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N, M <= 105
1 <= x, y <= 106


/*class Node{
    int coeff;
    int pow;
    Node next;
    Node(int a,int b)
    {
        coeff=a;
        pow=b;
        next=null;
    }
}*/

//Print the polynomial formed by adding both LL in the function itself.
class Solution
{
    public static Node addPolynomial(Node p1,Node p2)
    {
        Node st = new Node(0, 0);
        Node ans = st;
        
        while(p1!=null && p2!=null)
        {
            while(p1!=null && p2!=null && p1.pow > p2.pow)
            {
                ans.next = p1;
                p1 = p1.next;
                ans = ans.next;
            }
            
            while(p1!=null && p2!=null && p1.pow < p2.pow)
            {
                ans.next = p2;
                p2 = p2.next;
                ans = ans.next;
            }
            if(p1!=null && p2!=null && p1.pow == p2.pow)
            {
                p1.coeff += p2.coeff;
                ans.next = p1;
                p1 = p1.next;
                p2 = p2.next;
                ans = ans.next;
            }
        }
        
        if(p1!=null) ans.next = p1;
        if(p2!=null) ans.next = p2;
        
        return st.next;
        
    }
}