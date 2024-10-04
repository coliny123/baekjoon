import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                set.add(nums[i] + nums[j]);
            }
        }
        
        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                if(set.contains(nums[j] - nums[i])){
                    max = Math.max(max, nums[j]);
                }
            }
        }
        
        System.out.println(max);
        
    }
}
