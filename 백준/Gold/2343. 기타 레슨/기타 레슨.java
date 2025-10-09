import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] videos;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        videos = new int[N];
        
        input = br.readLine().split(" ");
        int max = 0;
        for(int i=0; i<N; i++){
            videos[i] = Integer.valueOf(input[i]);
            max = Math.max(max, videos[i]);
        }
        
        
        System.out.println(parametricSearch(max, 1000000000));
        
    }
    
    static int parametricSearch(int st, int ed){
        int answer = ed;
        while(st <= ed){
            int mid = (st + ed) / 2;
            
            int cnt = 1;
            int sum = videos[0];
            for(int i=1; i<N; i++){
                if(sum + videos[i] <= mid){
                    sum += videos[i];
                }else{
                    sum = videos[i];
                    cnt++;
                }
            }
            
            // System.out.println(mid + " : " + cnt);
            
            if(cnt > M){
                st = mid + 1;
            }else{
                ed = mid - 1;
                answer = mid;
            }
            
        }
        
        return answer;
    }
}
