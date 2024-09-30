import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int nums[] = new int[N];
        
        
        // int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
            // min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        int M = sc.nextInt();
        
        System.out.println(qarametricSearch(nums, 1, max, M));
    }
    
    public static int qarametricSearch(int arr[], int min, int max, int T){
        while(min <= max){
            int mid = (min+max)/2;
            
            int sum=0;
            for(int i=0; i<arr.length; i++){
                if(arr[i] > mid) sum += mid;
                else sum += arr[i];
            }
            
            if(sum <= T){
                min = mid+1;
            }else{
                max = mid-1;
            }
        }
        
        return min-1;
    }
}
