// https://www.youtube.com/watch?v=RS4sj2gQY6A
class Solution{
    public int minMoves(int N, int[][]matrix){
        // code here
        // all possible p's will be i * (i + 1) / 2 where 0 <= i <= 50
        List<Integer> pValues = new ArrayList<>();
        int result = Integer.MAX_VALUE;
        for (int i=0; i<=50; i++) {
            pValues.add(((i) * (i + 1)) / 2); 
        }
        // now check row wise and column wise
        for (int i=0; i<N; i++) {
            int moves = 0;
            for (int j=0; j<N; j++) {
                int value = matrix[i][j];
                int leastValue = Integer.MAX_VALUE; // least value closest to value
                // optimal approach is by doing a binary search to find the closes value
                for (int number : pValues) {
                    leastValue = Math.min(leastValue, Math.abs(number - value));
                }
                moves += leastValue;
            }
            result = Math.min(result, moves);
        }
        for (int i=0; i<N; i++) {
            int moves = 0;
            for (int j=0; j<N; j++) {
                int value = matrix[j][i];
                int leastValue = Integer.MAX_VALUE;
                for (int number : pValues) {
                    leastValue = Math.min(leastValue, Math.abs(number - value));
                }
                moves += leastValue;
            }
            result = Math.min(result, moves);
        }
        return result;
    }
}
