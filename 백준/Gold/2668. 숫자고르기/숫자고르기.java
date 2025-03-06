import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] picked;
    static boolean[] visited;
    static boolean[] done;
    static Set<Integer> set = new TreeSet<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.valueOf(br.readLine());
        picked = new int[N];
        visited = new boolean[N];
        done = new boolean[N];
        for(int i=0; i<N; i++){
            picked[i] = Integer.valueOf(br.readLine()) - 1;
        }
        
        for(int i=0; i<N; i++){
            if(!done[i]){
                dfs(i);
            }
        }
        
        System.out.println(set.size());
        for(int a : set){
            System.out.println(a+1);
        }
    }
    
    
    static void dfs(int idx){
        if(done[idx]){
            return;
        }
        
        if(visited[idx]){
            done[idx] = true;
            set.add(idx);
        }
        
        visited[idx] = true;
        dfs(picked[idx]);
        visited[idx] = false;
    }
}
