import java.util.*;
public class Solution {
    public static long findBadNumber(long l, long r)  {
        long count = 0;
        for (long j=l; j<=r; j++) {
            long length = 0;
            long temp = j;
            while (temp > 0) {
                length += 1;
                temp = temp / 10;
            }
            boolean flag = false;
            temp = j;
            while (temp > 0) {
                long rem = temp % 10;
                if (length % 2 == 0 && rem % 2 == 0) {
                    length -= 1;
                    flag = true;
                    temp /= 10;
                }
                else if (length % 2 !=0 && rem % 2 != 0) {
                    length -= 1;
                    flag = true;
                    temp /= 10;
                }
                else {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count += 1;
        }  
        return count;
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i=1; i<=test; i++) {
            long L = sc.nextInt();
            long R = sc.nextInt();
            long count = findBadNumber(L, R);
            System.out.println("Case #" + i + ": " + count);
        }
    }
}
