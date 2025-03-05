import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.valueOf(br.readLine());
        
        while(T-- > 0){
            int N = Integer.valueOf(br.readLine());
            String[] input = br.readLine().split(" ");
            int M = Integer.valueOf(br.readLine());
            int[] dp = new int[M+1];
            dp[0] = 1;
            for(int i=0; i<N; i++){
                int coin = Integer.valueOf(input[i]);
                for(int j=coin; j<=M; j++){
                    dp[j] = dp[j] + dp[j-coin];
                }
            }
            
            System.out.println(dp[M]);
        }
    }
}
