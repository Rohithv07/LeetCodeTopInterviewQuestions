Recently a new building with a new layout was constructed in Monocarp's hometown. According to this new layout, the building consists of three types of apartments: three-room, five-room, and seven-room apartments. It's also known that each room of each apartment has exactly one window. In other words, a three-room apartment has three windows, a five-room — five windows, and a seven-room — seven windows.

Monocarp went around the building and counted n windows. Now he is wondering, how many apartments of each type the building may have.

Unfortunately, Monocarp only recently has learned to count, so he is asking you to help him to calculate the possible quantities of three-room, five-room, and seven-room apartments in the building that has n windows. If there are multiple answers, you can print any of them.

Here are some examples:

if Monocarp has counted 30 windows, there could have been 2 three-room apartments, 2 five-room apartments and 2 seven-room apartments, since 2⋅3+2⋅5+2⋅7=30;
if Monocarp has counted 67 windows, there could have been 7 three-room apartments, 5 five-room apartments and 3 seven-room apartments, since 7⋅3+5⋅5+3⋅7=67;
if Monocarp has counted 4 windows, he should have mistaken since no building with the aforementioned layout can have 4 windows.
Input
Th first line contains one integer t (1≤t≤1000) — the number of test cases.

The only line of each test case contains one integer n (1≤n≤1000) — the number of windows in the building.

Output
For each test case, if a building with the new layout and the given number of windows just can't exist, print −1.

Otherwise, print three non-negative integers — the possible number of three-room, five-room, and seven-room apartments. If there are multiple answers, print any of them.



Example
inputCopy
4
30
67
4
14
outputCopy
2 2 2
7 5 3
-1
0 0 2





import java.util.*;

public class NumberOfApartments {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        flag:while (test -- > 0) {
            int window = sc.nextInt();
                for (int i=0; i<window; i++) {
                    for (int j=0; j<window; j++) {
                        for (int k=0; k<window; k++) {
                            if ((i*3 + j*5 + k*7) == window) {
                                System.out.println(i + " " + j + " " + k);
                                continue flag;
                        }
                    }
                }
            }
            System.out.println("-1");
        }
    }
}
