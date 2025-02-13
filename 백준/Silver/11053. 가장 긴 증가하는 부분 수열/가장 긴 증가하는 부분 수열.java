import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] LIS;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.valueOf(br.readLine());
        nums = new int[N];
        LIS = new int[N];
        
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.valueOf(input[i]);
        }
        
        int answer = 1;
        int length = 1;
        LIS[0] = nums[0];
        for(int i=1; i<N; i++){
            if(LIS[length-1] < nums[i]){
                LIS[length++] = nums[i];
            }else{
                int loc = binarySearch(0, length, nums[i]);
                // System.out.println(loc);
                LIS[loc] = nums[i];
            }
            
            answer = Math.max(answer, length);
        }
        
        System.out.println(answer);
        
    }
    
    static int binarySearch(int st, int ed, int target){
        int answer = ed;
        
        while(st <= ed){
            int mid = (st + ed) / 2;
            
            if(LIS[mid] >= target){
                ed = mid - 1;
                answer = Math.min(answer, mid);
            }else{
                st = mid + 1;
            }
        }
        
        return answer;
    }
}
