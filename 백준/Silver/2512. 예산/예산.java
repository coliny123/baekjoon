import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        
        int[] nums = new int[N];
        String[] input = br.readLine().split(" ");
        int max = 0;
        for(int i=0; i<N; i++){
            nums[i] = Integer.valueOf(input[i]);
            max = Math.max(max, nums[i]);
        }
        
        Arrays.sort(nums);
        
        int M = Integer.valueOf(br.readLine());
        
        System.out.println(parametricSearch(1, max, M, nums));
    }
    
    public static int parametricSearch(int st, int ed, int maximum, int[] nums){
        int answer = 0;
        while(st <= ed){
            int mid = (st + ed) / 2;
            long sum = 0;
            for(int req : nums){
                if(req <= mid) sum += req;
                else sum += mid;
            }
            
            // System.out.println(mid + " " + sum);
            if(sum <= maximum){
                st = mid + 1;
                answer = Math.max(answer, mid);
            }else{
                ed = mid - 1;
            }
        }
        
        return answer;
    }
}
