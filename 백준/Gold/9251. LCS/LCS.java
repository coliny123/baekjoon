import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        String a = sc.nextLine();
        String b = sc.nextLine();
        
        int aLength = a.length();
        int bLength = b.length();
        
        int[][] dp = new int[aLength+1][bLength+1];
        
        for(int i=1; i<=aLength; i++){
            for(int j=1; j<=bLength; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        
        System.out.println(dp[aLength][bLength]);
        
        
    }
}
