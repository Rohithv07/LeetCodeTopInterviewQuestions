import java.util.*;

public class Solution {
    
    public static boolean isValidSudoku(char [][] sudokuBoard, int n) {
        HashSet<String> set = new HashSet<>();
        for (int i=0; i<n*n; i++) {
            for (int j=0; j<n*n; j++) {
                char current = sudokuBoard[i][j];
                if (!set.add(current + "row" + i) || !set.add(current + "col" + j) || !set.add(current + "box" + i / 3 + " " + j / 3))
                    return false;
            }
        }
        return true;
    }
    
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t=1; t<=test; t++) {
            int n = sc.nextInt();
            char [][] sudokuBoard = new char[n*n][n*n];
            for (int i=0; i<n*n; i++) {
                for (int j=0; j<n*n; j++) {
                    sudokuBoard[i][j] = sc.next().charAt(0);
                }
            }
            if (isValidSudoku(sudokuBoard, n))
                System.out.println("Case #" + t + ": Yes");
            else
                System.out.println("Case #" + t + ": No");
        }
    }
}
