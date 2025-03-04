import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.valueOf(br.readLine());
        
        while(t-- > 0){
            int N = Integer.valueOf(br.readLine());
            
            int[] coinArr = new int[N];
            String[] input = br.readLine().split(" ");
            for(int i=0; i<N; i++){
                coinArr[i] = Integer.valueOf(input[i]);
            }
            
            int M = Integer.valueOf(br.readLine());
            
            int[] dp = new int[M+1];
            dp[0] = 1;
            for(int i=0; i< N; i++){
                for(int j=coinArr[i]; j <= M; j++){
                    dp[j] = dp[j] + dp[j - coinArr[i]];
                }
            }
            
            System.out.println(dp[M]);
            
        }
    }
}
