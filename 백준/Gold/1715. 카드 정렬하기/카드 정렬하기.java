import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        while(N-- > 0){
            pq.add(Integer.valueOf(br.readLine()));
        }
        
        
        int sum = 0;
        while(!pq.isEmpty()){
            int first = pq.poll();
            if(pq.isEmpty()) {
                break;
            }
            
            int second = pq.poll();
            
            
            sum += (first + second);
            
            
            pq.add(first + second);
        }
        
        System.out.println(sum);
        
    }
}
