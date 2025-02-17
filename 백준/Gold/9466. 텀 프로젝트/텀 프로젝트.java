import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int count = 0;
    static int[] picked;
    static boolean[] visited;
    static boolean[] checked;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0){
            N = Integer.valueOf(br.readLine());
            picked = new int[N];
            visited = new boolean[N];
            checked = new boolean[N];
            count = 0;
            
            String[] input = br.readLine().split(" ");
            for(int i=0; i<N; i++){
                picked[i] = Integer.valueOf(input[i])-1;
            }
            
            for(int i=0; i<N; i++){
                if(!checked[i]){
                    dfs(i);
                }
            }
            
            System.out.println(N - count);
        }
    }
    
    static void dfs(int idx){
        if(checked[idx]){
            return;
        }
        
        if(visited[idx]){
            checked[idx] = true;
            count++;
        }
        
        visited[idx] = true;
        dfs(picked[idx]);
        visited[idx] = false;
        checked[idx] = true;
    }
}
