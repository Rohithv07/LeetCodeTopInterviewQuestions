// https://practice.geeksforgeeks.org/contest/interview-series-60/problems/

// https://www.youtube.com/watch?v=8VfnEAQfx08

class Solution {
    public static ArrayList<Integer> makeBeautiful(int[] arr) {
        // code here
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        int length = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            if (stack.isEmpty()) {
                stack.push(num);
            }
            else {
                if (num >= 0 && stack.peek() >= 0) {
                    stack.push(num);
                }
                else if (num < 0 && stack.peek() < 0) {
                    stack.push(num);
                }
                else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        Collections.reverse(result);
        return result;
    }
}


// || (stack.peek() >= 0 && current < 0) || (stack.peek() <= 0 && current > 0)
