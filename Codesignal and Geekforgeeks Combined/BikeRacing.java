Geek is organising a bike race with N bikers. The initial speed of the ith biker is denoted by Hi Km/hr and the acceleration of ith biker as Ai Km/Hr2. A biker whose speed is 'L' or more, is considered be a fast biker. The total speed on the track for every hour is calculated by adding the speed of each fast biker in that hour. When the total speed on the track is 'M' kilometers per hour or more, the safety alarm turns on. 
Find the minimum number of hours after which the safety alarm will start.


Example 1:

Input: 
N = 3, M = 400, L = 120
H = {20, 50, 20}
A = {20, 70, 90}
Output: 3
Explaination: 
Speeds of all the Bikers at ith hour
Biker1= [20  40  60  80 100] 
Biker2= [50 120 190 260 330]
Biker3= [20 110 200 290 380] 

Initial Speed on track  = 0 
because none of the biker's speed is fast enough.
Speed on track after 1st Hour= 120
Speed on track after 2nd Hour= 190+200=390
Speed on track after 3rd Hour= 260+290=550
Alarm will start at 3rd Hour.

Example 2:

Input: 
N = 2, M = 60, L = 120
H = {50, 30}
A = {20, 40}
Output: 3
Explaination: 
Speeds of all the Bikers at ith hour
Biker1= [50 70  90 110 130] 
Biker2= [30 70 110 150 190]

Initial Speed on track = 0 because none of the 
biker's speed is fast enough.
Speed on track at 1st Hour= 0
Speed on track at 2nd Hour= 0
Speed on track at 3rd Hour= 150
Alarm will buzz at 3rd Hour.

Your Task:
You do not need to read input or print anything. Your task is to complete the function buzzTime() which takes N, M, L and array H and array A as input parameters and returns the time when alarm buzzes.


Expected Time Complexity: O(N*log(max(L,M)))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ L, M ≤ 1010
1 ≤ Hi, Ai ≤ 109  



//User function Template for Java

class Solution{
    static long buzzTime(int N, long M, long L, long H[], long A[]){
        // code here
        long start = 1;
        long end = M;
        long answer = -1;
        while (start <= end) {
            long middle = start + (end - start) / 2;
            if (check(H, A, N, L, M, middle)) {
                end = middle - 1;
                answer = middle;
            }
            else {
                start = middle + 1;
            }
        }
        return answer;
    }
    
    static boolean check(long [] H, long [] A, long N, long L, long M, long middle) {
        long totalSpeed = 0;
        for (long i = 0; i < N; i++) {
            if (H[(int)i] + A[(int)i] * middle >= L) {
                totalSpeed += H[(int)i] + A[(int)i] * middle;
            }
        }
        return totalSpeed >= M;
    }
}
