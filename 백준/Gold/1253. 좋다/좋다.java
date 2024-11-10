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
        int cnt = 0;
        for(int i=0; i<N; i++){
            int lt=0;
            int rt=N-1;
            while(true){
                if(lt == i) lt++;
                else if(rt == i) rt--;
                
                if(lt >= rt) break;
                
                if(nums[lt] + nums[rt] > nums[i]) rt--;
                else if(nums[lt] + nums[rt] < nums[i]) lt++;
                else{
                    cnt++;
                    break;
                }
            }
        }
        
        System.out.println(cnt);
    }
}
