import java.util.*;
public class BabyEhabPartitionsAgain {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int n=sc.nextInt();
        int[] num = new int[n];
        int odd=-1;
        int sum = 0;
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
            sum += num[i];
            if(num[i]%2!=0){
                odd=i+1;
            }
        }
 
        if(sum % 2 != 0) {
            System.out.println(0);
            return;
        }
 
        sum /= 2;
        boolean[][] dp = new boolean[n][sum + 1];
 
        for(int i=0; i < n; i++){
            dp[i][0] = true;
        }
        for(int s=1; s <= sum ; s++) {
            dp[0][s] = (num[0] == s ? true : false);
        }
        for(int i=1; i < n; i++) {
            for(int s=1; s <= sum; s++) {
                if(dp[i-1][s]) {
                    dp[i][s] = dp[i-1][s];
                } else if (s >= num[i]) {
                    dp[i][s] = dp[i-1][s-num[i]];
                }
            }
        }
        if(!dp[n-1][sum]){
            System.out.println(0);
        }else{
            int pt=-1;
            while (true){
                int f=0;
                for(int i=0;i<n;i++){
                    if(num[i]%2!=0){
                        f=1;
                        pt=i+1;
                        break;
                    }
                }
                if(f==1)break;
                for(int i=0;i<n;i++){
                    num[i]/=2;
                }
            }
            System.out.println(1);
            System.out.println(pt);
        }
 
    }
 
}