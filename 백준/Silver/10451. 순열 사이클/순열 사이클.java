import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] picked;
    static boolean[] visited;
    static boolean[] done;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.valueOf(br.readLine());
        while(T-- > 0){
            N = Integer.valueOf(br.readLine());
            picked = new int[N];
            visited = new boolean[N];
            done = new boolean[N];
            String[] input = br.readLine().split(" ");
            for(int i=0; i<N; i++){
                picked[i] = Integer.valueOf(input[i]) - 1;
            }
            
            int count = 0;
            for(int i=0; i<N; i++){
                if(!done[i]){
                    dfs(i);
                    if(done[i]) count++;
                }
            }
            System.out.println(count);
        }
    }
    
    static void dfs(int idx){
        if(done[idx]){
            return;
        }
        
        if(visited[idx]){
            done[idx] = true;
        }
        
        visited[idx] = true;
        dfs(picked[idx]);
        visited[idx] = false;
    }
}
