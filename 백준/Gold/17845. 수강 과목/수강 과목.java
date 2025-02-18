import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int K = Integer.valueOf(input[1]);
        
        int[] dp = new int[N+1];
        
        while(K-- > 0){
            input = br.readLine().split(" ");
            int I = Integer.valueOf(input[0]);
            int T = Integer.valueOf(input[1]);
            
            
            for(int i=N; i>=T; i--){
                dp[i] = Math.max(dp[i], (dp[i-T] + I));
            }
        }
        
        System.out.println(dp[N]);
    }
}
