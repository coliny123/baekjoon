import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int nums[] = new int[N];
        
        int max = 0;
        for(int i=0; i<N;i++){
            nums[i] = sc.nextInt();
            max = Math.max(max, nums[i]);
        }
        
        System.out.println(upperBound(nums, 1, max, M));
    }
    
    public static int upperBound(int nums[], int min, int max, int M){
        while(min <= max){
            int mid = (min + max) / 2;
            long sum=0;
            for(int tree:nums){
                if(tree-mid > 0){
                    sum += (tree-mid);
                }
            }
            
            if(sum < M){
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        
        return min-1;
    }
}
