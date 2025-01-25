import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        
        int[] nums = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.valueOf(input[i]);
        }
        
        Arrays.sort(nums);
        
        int lt = 0;
        int rt = N-1;
        
        
        int[] answer = new int[2];
        int min=2000000001;
        while(lt < rt){
            int sum = nums[lt] + nums[rt];
            
            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                answer[0] = nums[lt];
                answer[1] = nums[rt];
            }
            
            if(sum < 0){
                lt++;
            }else{
                rt--;
            }   
        }
        
        
        System.out.println(answer[0] + " " + answer[1]);
    }
}
