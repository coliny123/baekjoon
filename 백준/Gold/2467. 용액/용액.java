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
        
        
        int lt = 0;
        int rt = N-1;
        int answer = Integer.MAX_VALUE;
        int a=0;
        int b=0;
        while(lt < rt){
            int sum = nums[lt] + nums[rt];
            
            if(answer > Math.abs(sum)){
                a = nums[lt];
                b = nums[rt];
                answer = Math.abs(sum);
            }
            
            if(sum < 0){
                lt++;
            }else{
                rt--;
            }
        }
        
        System.out.println(a + " " + b);
        
    }
}
