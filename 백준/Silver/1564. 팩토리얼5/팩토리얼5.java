import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long dp[] = new long [N+1];
        
        dp[1] = 1;
        for(int i=2; i<=N; i++){
            long temp = dp[i-1] * i;
            if(temp%10 == 0){
                while(temp%10==0){
                    temp /= 10;
                }
            }
            
            temp %= (long)1e12;
            dp[i] = temp;
        }
        
        String answer = "";
        long num = dp[N]%100000;
        if(num < 10000) answer += "0";
        if(num < 1000) answer += "0";
        if(num < 100) answer += "0";
        if(num < 10) answer += "0";
        
        answer += num + "";
        
        System.out.println(answer);

        
        
    }
    
    
    
}
