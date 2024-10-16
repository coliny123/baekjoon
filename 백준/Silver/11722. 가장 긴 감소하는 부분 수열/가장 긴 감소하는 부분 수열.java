import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int[] cnt = new int[N];
        
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
            cnt[i] = 1;
        }
        
        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[j] > nums[i]){
                    cnt[i] = Math.max(cnt[i], cnt[j]+1);
                }
            }
            max = Math.max(max, cnt[i]);
        }
        
        System.out.println(max);
    }
}
