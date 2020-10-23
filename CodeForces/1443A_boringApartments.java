SOlution 1)
import java.util.Scanner;
public class A{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int t=sc.nextInt();t-->0;) {
            String x = sc.next();
            int n=x.length();
            System.out.println((x.charAt(0)-'1')*10 + n*(n+1)/2);
}   }   }



Solution 2)
import java.util.*;

public class Solution {
    public static int boring(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(11, 3);
        map.put(111, 6);
        map.put(1111, 10);
        map.put(2, 11);
        map.put(22, 13);
        map.put(222, 16);
        map.put(2222, 20);
        map.put(3, 21);
        map.put(33, 23);
        map.put(333, 26);
        map.put(3333, 30);
        map.put(4, 31);
        map.put(44, 33);
        map.put(444, 36);
        map.put(4444, 40);
        map.put(5, 41);
        map.put(55, 43);
        map.put(555, 46);
        map.put(5555, 50);
        map.put(6, 51);
        map.put(66, 53);
        map.put(666, 56);
        map.put(6666, 60);
        map.put(7, 61);
        map.put(77, 63);
        map.put(777, 66);
        map.put(7777, 70);
        map.put(8, 71);
        map.put(88, 73);
        map.put(888, 76);
        map.put(8888, 80);
        map.put(9, 81);
        map.put(99, 83);
        map.put(999, 86);
        map.put(9999, 90);
        
        return map.get(n);
        
        
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            System.out.println(boring(n));
        }
    }
}
