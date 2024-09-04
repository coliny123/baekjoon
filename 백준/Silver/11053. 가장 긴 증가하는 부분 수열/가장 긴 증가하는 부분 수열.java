import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        int dp[] = new int[n];
        
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        
        int max = 1;
        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(max);
    }
}
