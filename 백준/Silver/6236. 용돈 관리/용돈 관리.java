import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[] pay;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        int max = 0;
        pay = new int[N];
        for(int i=0; i<N; i++){
            pay[i] = Integer.valueOf(br.readLine());
            max = Math.max(max, pay[i]);
        }
        
        System.out.println(parametricSearch(max, 100000*10000));
    }
    
    public static int parametricSearch(int st, int ed){
        int answer = ed;
        while(st <= ed){
            int mid = (st + ed) / 2;
            
            // 몇 번 꺼내는지 로직
            int cnt = 1;
            int tmp = mid;
            for(int i=0; i<N; i++){
                tmp -= pay[i];
                if(tmp < 0){
                    cnt++;
                    tmp = mid - pay[i];
                }
            }
            
            if(cnt <= M){
                ed = mid - 1;
                answer = Math.min(answer, mid);
            }else{
                st = mid + 1;
            }
        }
        
        return answer;
    }
}
