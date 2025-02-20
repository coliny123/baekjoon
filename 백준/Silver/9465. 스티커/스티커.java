import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.valueOf(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            int N = Integer.valueOf(br.readLine());
            int[][] sticker = new int[2][N];
            for(int i=0; i<2; i++){
                String[] input = br.readLine().split(" ");
                for(int j=0; j<N; j++){
                    sticker[i][j] = Integer.valueOf(input[j]);
                }
            }
                 
            int[][] dp = new int[2][N+1];
            
            dp[0][1] = sticker[0][0];
            dp[1][1] = sticker[1][0];
            
            for(int i=2; i<=N; i++){
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i - 1];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i - 1];
            }
            
            sb.append(dp[0][N] >= dp[1][N] ? dp[0][N] : dp[1][N]).append("\n");
        }
        
        System.out.print(sb);
    }
}
