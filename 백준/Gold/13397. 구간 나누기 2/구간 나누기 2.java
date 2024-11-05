import java.util.*;

public class Main {
    public static int N, M;
    public static int[] nums;
    
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        
        int max = 0;
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
            max = Math.max(max, nums[i]);
        }
        
        
        System.out.println(parametricSearch(0, max));
    }
    
    
    public static int parametricSearch(int st, int ed){
        int min = ed - st;
        while(st <= ed){
            int mid = (st + ed) / 2;
            if(count(mid) <= M){
                ed = mid - 1;
                min = Math.min(min, mid);
            }else{
                st = mid + 1;
            }
        }
        return min;
    }
    
    public static int count(int mid){
        int cnt = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<N; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            if(max - min > mid){
                cnt++;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                i--;
            }
        }
        
        return cnt;
    }
}
