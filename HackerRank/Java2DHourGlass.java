https://www.hackerrank.com/challenges/java-2d-array/problem



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static int maxSumHourGlass(int [][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int result = Integer.MIN_VALUE;
        for (int i=0; i<row - 2; i++) {
            for (int j=0; j<col - 2; j++) {
                result = Math.max(result, computeSum(arr, i, j));
            }
        }
        return result;
    }
    
    public static int computeSum(int [][] arr, int i, int j) {
        return arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        System.out.println(maxSumHourGlass(arr));

        scanner.close();
    }
}

