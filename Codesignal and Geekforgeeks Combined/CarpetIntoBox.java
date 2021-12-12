// https://practice.geeksforgeeks.org/contest/interview-series-nutanix/problems/

//https://youtu.be/2a7Ikn99zwo



class Solution{
    int carpetBox(int A, int B, int C, int D) { 
        //code here
        // if (A * B <= C * D) {
        //     return 0;
        // }
        int possibleMove1 = 0;
        int possibleMove2 = 0;
        int storeA = A;
        int storeB = B;
        int storeC = C;
        int storeD = D;
        while (A > C || B > D) {
            if (A > C) {
                A /= 2;
            }
            else {
                B /= 2;
            }
            possibleMove1 += 1;
        }
        while (storeA > storeD || storeB > storeC) {
            if (storeA > storeD) {
                storeA /= 2;
            }
            else {
                storeB /= 2;
            }
            possibleMove2 += 1;
        }
        return Math.min(possibleMove1, possibleMove2);
    }
   
}
