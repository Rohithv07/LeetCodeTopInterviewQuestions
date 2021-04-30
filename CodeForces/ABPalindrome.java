import java.util.*;
public class Main {
    static Scanner in =new Scanner(System.in);
    public static void main(String[] args) {
    int tt=in.nextInt();//in.nextLine();
           outer:while(tt-->0) {
               int a=in.nextInt();int b=in.nextInt();in.nextLine();
               char c[]=in.nextLine().toCharArray();int n=a+b;
               for(int i=0;i<n/2;i++){
                   if(c[i]!=c[n-i-1]){
                       if(c[i]=='?')c[i]=c[n-i-1];
                       else if(c[n-i-1]=='?')c[n-i-1]=c[i];
                       else{
                           System.out.println(-1);continue outer;
                       }
                   }
               }
               for(char x:c){
                   if(x=='1')b--;
                   if(x=='0')a--;
               }
               if(a<0 || b<0){System.out.println(-1);continue outer;}
               for(int i=0;i<n/2;i++){
                   if(c[i]=='?'){
                       if(a>=b){
                           c[i]='0';c[n-i-1]='0';a-=2;
                       }
                       else{
                           c[i]='1';c[n-i-1]='1';b-=2;
                       }
                   }
               }
               if(n%2==1 && c[n/2]=='?'){
                   if(a==1){c[n/2]='0';a--;}
                   else {c[n/2]='1';b--;}
               }
               if(a==0 && b==0){
                   System.out.println(new String(c));
               }
              else  System.out.println(-1);
       }
    }
}