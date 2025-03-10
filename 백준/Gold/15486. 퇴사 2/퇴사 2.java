import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        
        int[] time = new int[N+2];
        int[] price = new int[N+2];
        for(int i=1; i<=N; i++){
            String[] input = br.readLine().split(" ");
            time[i] = Integer.valueOf(input[0]);
            price[i] = Integer.valueOf(input[1]);
        }
        
        int[] dp = new int[N+2]; // 7일까지인 경우 8일 퇴사니까 
        
        int max = 0;
        for(int i=1; i <= N+1; i++){
            max = Math.max(max, dp[i]);
            int nx = i + time[i];
            if(nx < N+2){
                dp[nx] = Math.max(dp[nx], max + price[i]);
            }
        }
        
        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[N+1]);
        
    }
}
