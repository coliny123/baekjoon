import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int D = Integer.valueOf(input[0]);
        int P = Integer.valueOf(input[1]);
        
        int[] dp = new int[D+1];
        
        dp[0] = 1000000000;
        
        while(P-- > 0){
            input = br.readLine().split(" ");
            int L = Integer.valueOf(input[0]);
            int C = Integer.valueOf(input[1]);
            
            for(int i=D; i >= L; i--){
                dp[i] = Math.max(dp[i], Math.min(dp[i-L], C));
            }
        }
        
        System.out.println(dp[D]);
    }
}
