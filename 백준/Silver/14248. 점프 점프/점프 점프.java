import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] rocks;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        
        rocks = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            rocks[i] = Integer.valueOf(input[i]);
        }
        int st = Integer.valueOf(br.readLine())-1;
        System.out.println(bfs(st));
        
    }
    
    static int bfs(int st){
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        
        visited[st] = true;
        q.add(st);
        
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            
            count++;
            
            int left = cur - rocks[cur];
            int right = cur + rocks[cur];
            
            // 왼쪽
            if(left >= 0 && !visited[left]){
                visited[left] = true;
                q.add(left);
            }
            
            // 왼쪽
            if(right < N && !visited[right]){
                visited[right] = true;
                q.add(right);
            }        
        }
        
        return count;
    }
}
