import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.valueOf(br.readLine());
        
        while(t-- > 0){
            int N = Integer.valueOf(br.readLine());
            
            int[] coinArr = new int[N+1];
            String[] input = br.readLine().split(" ");
            for(int i=1; i<=N; i++){
                coinArr[i] = Integer.valueOf(input[i-1]);
            }
            
            int M = Integer.valueOf(br.readLine());
            
            int[][] dp = new int[N+1][M+1];
            
            
            for(int i=1; i<= N; i++){
                dp[i][0] = 1;
                for(int j=1; j<=M; j++){
                    if(j - coinArr[i] < 0){
                        dp[i][j] = dp[i-1][j];
                        continue;
                    }
                    dp[i][j] += dp[i-1][j] + dp[i][j - coinArr[i]];
                }
            }
            
            System.out.println(dp[N][M]);
            
        }
    }
}
