This question is asked by Facebook. In a gym hallway there are N lockers. You walk back and forth down the hallway opening and closing lockers. On your first pass you open all the lockers. On your second pass, you close every other locker. On your third pass you open every third locker. After walking the hallway N times opening/closing lockers in the previously described manner, how many locker are left open?

Ex: Given the following value of N…

N = 1, return 1.
You walk down the hallway once and open the only locker.
Ex: Given the following value of N…

N = 2, return 1.
You walk down the hallway and open both lockers.
You walk back down the hallway and close the last locker.



public class Solution {
    public static int countOpen(int n) {
        int count = 0;
        for (int i=1; i*i <= n; i++)
            count ++;
        return count;
    }
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean [] lock = new boolean[n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j*i <= n; j++) {
                lock[i*j] = !lock[i*j];
            }
        }
        int count = 0;
        for (int i=1; i<=n; i++) {
            if (lock[i])
                count ++;
        }
        System.out.println(count); // O(n * n)
        System.out.println(countOpen(n)); 
    }
}