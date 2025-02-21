import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        
        int[][] grid = new int[N+1][N+1];
        
        for(int i=1; i<=N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=1; j<=input.length; j++){
                grid[i][j] = Integer.valueOf(input[j-1]);
            }
        }
        
        int[][] dp = new int[N+1][N+1];
        
        int max = grid[1][1];
        dp[1][1] = grid[1][1];
        for(int i=2; i<=N; i++){
            for(int j=1; j<=i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + grid[i][j];
                max = Math.max(max, dp[i][j]);
            }
        }
        
        System.out.println(max);
    }
}
