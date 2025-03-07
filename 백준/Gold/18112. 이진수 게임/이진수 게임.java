import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int start = Integer.parseInt(br.readLine(), 2);
        int target = Integer.parseInt(br.readLine(), 2);
        
        
        int result = bfs(start, target);
        
        System.out.println(result);
    }
    
    static int bfs(int start, int end){
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        q.add(new int[]{start, 0});
        visited.add(start);
        
        int answer = -1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int num = cur[0];
            int step = cur[1];
            
            if(num == end){
                answer = step;
                break;
            }
            
            String binary = Integer.toBinaryString(num);
            int len = binary.length();
            for (int i = 1; i < len; ++i) {
                int pos = len - 1 - i;
                int mask = 1 << pos;
                int flipped = num ^ mask;
                
                if(!visited.contains(flipped)) {
                    visited.add(flipped);
                    q.add(new int[]{flipped, step + 1});
                }
            }
            
            int plus = num + 1;
            if(plus < 1024 && !visited.contains(plus)){
                visited.add(plus);
                q.add(new int[]{plus, step + 1});
            }
            
            int minus = num - 1;
            if(minus > 0 && !visited.contains(minus)){
                visited.add(minus);
                q.add(new int[]{minus, step + 1});
            }
            
        }
        
        return answer;
    }
}