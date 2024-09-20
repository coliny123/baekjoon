import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] KN = br.readLine().split(" ");
        
        int k = Integer.valueOf(KN[0]);
        int n = Integer.valueOf(KN[1]);
        
        int[] nums = new int[k];
        
        long max = 0;
        
        for (int i = 0; i < k; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, nums[i]);
        }
        System.out.println(upperBound(nums, 1, max, n));
    }
    
    public static long upperBound(int nums[], long min, long max, int n){
        
        while(min <= max){
            long mid = (min + max)/2;
            long count=0;
            
            for(int num:nums){
                count += (num/mid);
            }
            
            if(count < n){
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        
        return min-1;
    }
}
