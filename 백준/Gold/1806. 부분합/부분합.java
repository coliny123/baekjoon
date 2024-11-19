import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int N = Integer.valueOf(input[0]);
        int S = Integer.valueOf(input[1]);
        
        int[] nums = new int[N+1];
        
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.valueOf(input[i]);
        }
        
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while(left <= right && right <= N){
            if(sum >= S){
                minLen = Math.min(minLen, right - left);
                sum -= nums[left];
                left++;                
            }else{
                sum += nums[right];
                right++;
            }
        }
        
        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}
