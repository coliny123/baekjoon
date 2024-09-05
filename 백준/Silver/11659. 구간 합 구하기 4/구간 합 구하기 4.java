import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM[] = br.readLine().split(" ");
        int n = Integer.valueOf(NM[0]);
        int m = Integer.valueOf(NM[1]);
        
        int nums[] = new int[n+1];
        String input[] = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            nums[i+1] = Integer.valueOf(input[i]);
        }
        
        int dp[] = new int[n+1];
        for(int i=1; i<=n; i++){
            dp[i] += dp[i-1] + nums[i];
        }
        
        StringBuilder sb = new StringBuilder();
        while(m-- > 0){
            String row[] = br.readLine().split(" ");
            int start = Integer.valueOf(row[0]);
            int end = Integer.valueOf(row[1]);
            
            sb.append(dp[end]-dp[start-1]).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
