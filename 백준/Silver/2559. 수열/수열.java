import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[] nums = new int[N+1];
        int[] sum = new int[N+1];
        
        for(int i=1; i<=N; i++){
            nums[i] = sc.nextInt();
        }
        
        for(int i=1; i<=N; i++){
            sum[i] = sum[i-1] + nums[i];
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=K; i<=N; i++){
            max = Math.max(max, sum[i] - sum[i-K]);
        }
        
        System.out.println(max);
    }
}
