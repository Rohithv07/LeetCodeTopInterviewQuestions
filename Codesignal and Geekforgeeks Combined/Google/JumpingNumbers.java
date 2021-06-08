Given a positive number X. Find the largest Jumping Number smaller than or equal to X. 
Jumping Number: A number is called Jumping Number if all adjacent digits in it differ by only 1. All single digit numbers are considered as Jumping Numbers. For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.

 

Example 1:

Input:
X = 10
Output:
10
Explanation:
10 is the largest Jumping Number
possible for X = 10.
Example 2:

Input:
X = 50
Output:
45
Explanation:
45 is the largest Jumping Number
possible for X = 50.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function jumpingNums() which takes an Integer X as input and returns the largest Jumping Number less than or equal to X.

 

Expected Time Complexity: O(k), where k is no of jumping numbers
Expected Auxiliary Space: O(k), where k is no of jumping numbers

 

Constraints:
1 <= X <= 109



class Solution {
    
    
    // can also be done using dfs
    static void bfs(long n, int i, List<Integer> results) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            i = queue.poll();
            if (i <= n) {
                results.add(i);
                int lastDigit = i % 10;
                if (lastDigit == 0) {
                    queue.add((i * 10) + (lastDigit + 1));
                }
                else if (lastDigit == 9) {
                    queue.add((i * 10) + (lastDigit - 1));
                }
                else {
                    queue.add((i * 10) + (lastDigit + 1));
                    queue.add((i * 10) + (lastDigit - 1));
                }
            }
        }
    }
    
    static long jumpingNums(long n) {
        // code here
        if (n <= 10)
            return n;
        List<Integer> results = new ArrayList<>();
        for (int i=0; i<10 && i <= n; i++) {
            bfs(n, i, results);
        }
        int max = Integer.MIN_VALUE;
        for (int number : results) {
            max = Math.max(number, max);
        }
        return max;
    }
};



// dfs possible solution and not tested

public static void main(String[] args) {
	int num = 104;
	Set<Integer> set = new HashSet<>();
	for(int i=0;i<10;i++) {
		dfs(num, set, i);
	}
	List<Integer> res = new ArrayList<>(set);
	Collections.sort(res);
	System.out.println(res);
}

static void dfs(int num, Set<Integer> res, int tmp) {
	if(tmp > num)
		return;
	if(!res.add(tmp))
		return;
	if( tmp%10 == 0) {
		dfs(num, res, tmp * 10 + 1);
	}else if(tmp%10 == 9) {
		dfs(num, res, tmp * 10 + 8);
	}else {
		dfs(num, res, tmp * 10 + tmp%10 - 1);
		dfs(num, res, tmp * 10 + tmp%10 + 1);
	}
}

// find the max of the list



