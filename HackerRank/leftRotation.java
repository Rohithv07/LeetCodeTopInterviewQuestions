https://www.hackerrank.com/challenges/array-left-rotation/problem

import java.util.*;
class Solution {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] array = new int [n];
        int mod = k % n;
        for (int i=0; i<n; i++) {
            array[(i+n-mod) % n] = sc.nextInt();
        }
        for (int i=0; i<n; i++)
            System.out.print(array[i] + " ");
    }
}
