import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int Q = Integer.valueOf(input[1]);
        
        int[] nums = new int[N];
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.valueOf(input[i]);
        }
        
        Arrays.sort(nums);
        
        int[] sum = new int[N];
        sum[0] = nums[0];
        for(int i=1; i<N; i++){
            sum[i] = sum[i-1] + nums[i];
        }
        
        StringBuilder sb = new StringBuilder();
        while(Q-- > 0){
            input = br.readLine().split(" ");
            int a = Integer.valueOf(input[0])-1;
            int b = Integer.valueOf(input[1])-1;
            
            sb.append(sum[b]-sum[a]+nums[a]).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
