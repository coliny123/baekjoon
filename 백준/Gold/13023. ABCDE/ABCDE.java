import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int answer = 0;
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        visited = new boolean[N];
        
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int st = Integer.valueOf(input[0]);
            int ed = Integer.valueOf(input[1]);
            
            graph[st].add(ed);
            graph[ed].add(st);
        }
        
        for(int i=0; i<N; i++){
            visited[i] = true;
            DFS(i, 1);
            if(answer == 1){
                break;
            }
            visited[i]= false;
        }
        
        System.out.println(answer);
    }
    
    public static void DFS(int st, int cnt){
        if(cnt == 5){
            answer = 1;
            return;
        }
        
        for(int i=0; i<graph[st].size(); i++){
            int nx = graph[st].get(i);
            if(!visited[nx]){
                visited[nx] = true;
                DFS(nx, cnt+1);
                visited[nx] = false;
            }
        }
    }
}
