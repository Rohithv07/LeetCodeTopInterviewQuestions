Implement a Queue using two stack s1 and s2.

Example 1:

Input:
enqueue(2)
enqueue(3)
dequeue()
enqueue(4)
dequeue()
Output: 2 3
Explanation:
enqueue(2) the queue will be {2}
enqueue(3) the queue will be {3 2}
dequeue() the poped element will be 2 
the stack will be {3}
enqueue(4) the stack will be {4 3}
dequeue() the poped element will be 3.  
Example 2:

Input:
enqueue(2)
dequeue()
enqueue(3)
dequeue()
Output: 2 -1
Your Task:

Since this is a function problem, you don't need to take inputs. You are required to complete the two methods enqueue() which takes an integer 'x' as input denoting the element to be pushed into the queue and dequeue() which returns the integer poped out from the queue.

Expected Time Complexity: O(1) for enqueue() and O(n) for dequeue()
Expected Auxiliary Space: O(1) for both enqueue() and dequeue()

Constraints:
1 <= Number of queries <= 100
1 <= values of the stack <= 100




Implement a Queue using two stack s1 and s2.

Example 1:

Input:
enqueue(2)
enqueue(3)
dequeue()
enqueue(4)
dequeue()
Output: 2 3
Explanation:
enqueue(2) the queue will be {2}
enqueue(3) the queue will be {3 2}
dequeue() the poped element will be 2 
the stack will be {3}
enqueue(4) the stack will be {4 3}
dequeue() the poped element will be 3.  
Example 2:

Input:
enqueue(2)
dequeue()
enqueue(3)
dequeue()
Output: 2 -1
Your Task:

Since this is a function problem, you don't need to take inputs. You are required to complete the two methods enqueue() which takes an integer 'x' as input denoting the element to be pushed into the queue and dequeue() which returns the integer poped out from the queue.

Expected Time Complexity: O(1) for enqueue() and O(n) for dequeue()
Expected Auxiliary Space: O(1) for both enqueue() and dequeue()

Constraints:
1 <= Number of queries <= 100
1 <= values of the stack <= 100
