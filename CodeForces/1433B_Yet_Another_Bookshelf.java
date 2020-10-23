import java.util.*;

public class Solution {
    public static int bookShelf(int [] array) {
        int n = array.length;
        // find the first occurance of 1
        int start = 0;
        for (int i=0; i<n; i++) {
            if (array[i] == 1) {
                start = i;
                break;
            }
        }
        if (start == n - 1)
            return 0;
        int end = start + 1;
        int moves = 0;
        while (end < n) {
            if (array[end] == 1) {
                moves += end - start - 1;
                start = end;
            }
            end += 1;
        }
        return moves;
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int [] array = new int [n];
            for (int i=0; i<n; i++)
                array[i] = sc.nextInt();
            System.out.println(bookShelf(array));
        }
    }
}
