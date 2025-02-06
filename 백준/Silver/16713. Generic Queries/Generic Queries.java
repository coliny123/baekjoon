import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int Q = Integer.valueOf(input[1]);
        
        int[] sum = new int[N+1];
        int[] nums = new int[N+1];
        
        input = br.readLine().split(" ");
        for(int i=1; i<=N; i++){
            nums[i] = Integer.valueOf(input[i-1]);
            sum[i] = sum[i-1] ^ nums[i];
        }
        
        int answer = 0;
        while(Q-- > 0){
            input = br.readLine().split(" ");
            int s = Integer.valueOf(input[0]);
            int e = Integer.valueOf(input[1]);
            
            answer = answer ^ sum[e] ^ sum[s-1];
        }
        
        System.out.println(answer);
        
    }
}
