import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String first = br.readLine();
        String second = br.readLine();
        
        
        int[][] dp = new int[first.length()+1][second.length()+1];
        
        for(int i=1; i<=first.length(); i++){
            for(int j=1; j<=second.length(); j++){
                if(first.charAt(i-1) == second.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // for(int i=0; i<=first.length(); i++){
            // for(int j=0; j<=second.length(); j++){
                // System.out.print(dp[i][j] + " ");
            // }
            // System.out.println();
        // }
        
        System.out.println(dp[first.length()][second.length()]);
        
    }
}
