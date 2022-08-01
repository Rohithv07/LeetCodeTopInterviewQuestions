// https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=10


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n){
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        backtrack(arr, 0, 0, n, result);
        Collections.sort(result);
        return result;
    }
    
    private void backtrack(ArrayList<Integer> arr, int index, int sum, int n, ArrayList<Integer> result) {
        if (index >= n) {
            result.add(sum);
            return;
        }
        //pick the element
        backtrack(arr, index + 1, sum + arr.get(index), n, result);
        // not picking
        backtrack(arr, index + 1, sum, n, result);
    }
}