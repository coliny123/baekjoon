import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int N = Integer.valueOf(input[0]);
        int M = Integer.valueOf(input[1]);
        
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.valueOf(br.readLine());
        }
        
        Arrays.sort(nums);
        
        int rt = 0;
        int min = Integer.MAX_VALUE;
        
        for(int lt=0; lt<N; lt++){
            while(rt<N){
                int diff = nums[rt] - nums[lt];
                if(diff < M){
                    rt++;
                }else{
                    min = Math.min(min, diff);
                    break;
                }
            }
        }
        
        System.out.println(min);
    }
}
