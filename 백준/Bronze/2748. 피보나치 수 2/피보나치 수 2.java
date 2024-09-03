import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        long dp[] = new long [n+1];
        
        dp[1]=1;
        if(n>=2){
            dp[2]=1;
            for(int i=3; i<=n; i++){
                dp[i] = dp[i-2] + dp[i-1];
            }
        }
        
        System.out.println(dp[n]);
    }
}
