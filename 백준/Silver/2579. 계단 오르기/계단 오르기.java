import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        
        int arr[] = new int[n+1];
        
        for(int i=1; i<=n; i++){
            arr[i] = Integer.valueOf(br.readLine());
        }
        
        int dp[] = new int[n+1];
        
        dp[1] = arr[1];
        if(n >= 2){
            dp[2] = arr[1] + arr[2];
            if(n >= 3){
                dp[3] = Math.max(arr[1], arr[2]) + arr[3];
                
                // 3번 연속된 칸 가면 안되니까 2칸+1칸, 2칸 두 가지 경우로 판단
                for(int i=4; i<=n; i++){
                    dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
                }
            }
        }
        System.out.println(dp[n]);
        
    }
}
