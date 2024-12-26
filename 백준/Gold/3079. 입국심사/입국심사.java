import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int N = Integer.valueOf(input[0]);
        int M = Integer.valueOf(input[1]);
        
        long[] times = new long[N];
        for(int i=0; i<N; i++){
            times[i] = Long.valueOf(br.readLine());
        }
        
        
        long st = 1;
        long ed = 1000000000L * 1000000000L;
        long answer = ed;
        
        while(st <= ed){
            long mid = (st + ed) / 2;
            // System.out.println("st : " + st + " / ed : " + ed);
            long sum = 0;
            for(long time : times){
                sum += mid / time; // long * int => int로 계산되어 overflow 발생
                if(sum > M){
                    break;
                }
            }
            
            if(sum < M){
                st = mid + 1;
            }else{
                ed = mid - 1;
                answer = mid;
            }
        }
        
        System.out.println(answer);
        
    }
}
