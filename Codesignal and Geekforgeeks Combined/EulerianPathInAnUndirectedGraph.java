class Solution{
    static int eulerPath(int n, int graph[][]){
        // code here
        int count = 0;
        for (int [] g : graph) {
            int sum = 0;
            for (int vertices : g) {
                sum += vertices;
            }
            if (sum % 2 != 0) {
                count++;
            }
            if (count > 2) {
                return 0;
            }
        }
        return 1 - count % 2;
    }
}