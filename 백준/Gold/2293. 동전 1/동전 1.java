import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int K = Integer.valueOf(input[1]);
        
        int[] dp = new int[K+1];
        dp[0] = 1;
        while(N-- > 0){
            int coin = Integer.valueOf(br.readLine());
            for(int i=coin; i<=K; i++){
                dp[i] = dp[i] + dp[i-coin];
            }
        }
        
        System.out.println(dp[K]);        
        // System.out.println(Arrays.toString(dp));        
    }
}
