import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int C = Integer.valueOf(input[0]);        
        int N = Integer.valueOf(input[1]);
        
        int[] dp = new int[C+101];
        Arrays.fill(dp, 10000000);
        dp[0] = 0;
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            int cost = Integer.valueOf(input[0]);
            int people = Integer.valueOf(input[1]);
            
            for(int j=people; j <= C+100; j++){
                dp[j] = Math.min(dp[j], dp[j-people] + cost);
            }
        }
        
        int result=Integer.MAX_VALUE;
        for(int i=C; i <= C+100; i++){
            result=Math.min(result, dp[i]);
        }
        System.out.println(result);
    }
}
