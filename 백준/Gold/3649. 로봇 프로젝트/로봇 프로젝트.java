import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = null;
        
        while((X=br.readLine()) != null){
            int size = Integer.valueOf(X) * 10000000;
            int N = Integer.valueOf(br.readLine());
            int[] nums = new int[N];
            
            for(int i=0; i<N; i++){
                nums[i] = Integer.valueOf(br.readLine());
            }
            Arrays.sort(nums);
            
            int lt = 0;
            int rt = N-1;
            boolean flag = false;
            
            while(lt < rt){
                int sum = nums[lt] + nums[rt];
                
                if(sum == size){
                    System.out.println("yes " + nums[lt] + " " + nums[rt]);
   					flag = true;
   					break;
                }else if(sum > size){
                    rt--;
                }else{
                    lt++;
                }
            }
            
            if(!flag){
                System.out.println("danger");
            }
            
            X = null;
        }
        
        
    }
}
