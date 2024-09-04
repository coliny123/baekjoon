import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int dp[][] = new int[n+1][k+1];
        
        // 2번 성질 (k==0)
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        
        // 2번 성질 (n==k)
        for(int i=0; i<=k; i++){
            dp[i][i] = 1;
        }
        
        for(int i=2; i<=n; i++){
            for(int j=1; j<=k; j++){
                // 1번 성질
                dp[i][j]=dp[i-1][j-1] + dp[i-1][j];
            }
        }
        
        System.out.println(dp[n][k]);
        
    }
}
