import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            pq.add(Integer.valueOf(input[i]));
        }
        
        int answer = 0;
        int day = 1;
        while(!pq.isEmpty()){
            answer = Math.max(answer, day + pq.poll());
            day++;
        }
        
        
        System.out.println(answer + 1);
    }
}
