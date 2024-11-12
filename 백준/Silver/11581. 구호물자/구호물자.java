import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static boolean flag = false;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.valueOf(br.readLine());
        
        visited = new boolean[N];
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<N-1; i++){
            int roadCnt = Integer.valueOf(br.readLine());
            String[] input = br.readLine().split(" ");
            for(int j=0; j<roadCnt; j++){
                graph[i].add(Integer.valueOf(input[j])-1);
            }
        }
        
        DFS(0);
        
        if(flag) System.out.println("CYCLE");
        else System.out.println("NO CYCLE");
    }
    
    
    public static void DFS(int cur){
        visited[cur] = true;
        for(int nx : graph[cur]){
            if(visited[nx]){
                flag = true;
                return;
            }else{
                DFS(nx);
            }
        }
        visited[cur] = false;
    }
}
