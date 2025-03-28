import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] grid;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        grid = new int[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }     
        
        int[][] dp = new int[N+1][M+1];
        
        int max = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(grid[i-1][j-1] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }           
        
        System.out.println(max*max);
    }
}
