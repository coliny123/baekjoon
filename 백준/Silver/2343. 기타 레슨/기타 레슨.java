import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int M = Integer.valueOf(input[1]);
        
        int[] videos = new int[N];
        input = br.readLine().split(" ");
        int max = 0;
        for(int i=0; i<N; i++){
            videos[i] = Integer.valueOf(input[i]);
            max = Math.max(max, videos[i]);
        }
        
        System.out.println(parametricSearch(max, 1000000000, videos, M));
    }
    
    static int parametricSearch(int st, int ed, int[] videos, int target){
        int answer = ed-1;
        while(st <= ed){
            int mid = (st + ed + 1) / 2;
            
            int cnt = 1;
            int chunk = mid;
            for(int i=0; i<videos.length; i++){
                if(chunk - videos[i] < 0){
                    chunk = mid;
                    cnt++;
                }
                chunk -= videos[i];
            }
            
            if(cnt <= target){
                ed = mid - 1;
                answer = Math.min(answer, mid);
            }else{
                st = mid + 1;
            }
        }
        
        return answer;
    }
}
