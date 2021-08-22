// https://youtu.be/W7btz7k8820


class Solution {
    
    public int unvisitedLeaves(int n, int leaves, int frogs[]) {
        // Code here
        Arrays.sort(frogs);
        // if (frogs[0] == 1) {
        //     return 0;
        // }
        int count = 0;
        boolean [] visited = new boolean [leaves + 1];
        for (int i=0; i<n; i++) {
            int currentJump = frogs[i];
            if (currentJump <= leaves && !visited[currentJump]) {
                for (int j=currentJump; j<=leaves; j+=currentJump) {
                    visited[j] = true;
                }
            }
        }
        for (int i=1; i<=leaves; i++) {
            if (!visited[i])
                count += 1;
        }
        return count;
    }
}
