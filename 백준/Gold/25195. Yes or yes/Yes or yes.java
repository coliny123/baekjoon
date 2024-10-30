import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static boolean answer=false;
    
     
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
        
        while(M-- > 0 ){
            input = br.readLine().split(" ");
            int a = Integer.valueOf(input[0])-1;
            int b = Integer.valueOf(input[1])-1;
            
            graph[a].add(b);
        }
        
        int S = Integer.valueOf(br.readLine());
        input = br.readLine().split(" ");
        for(String a : input){
            visited[Integer.valueOf(a)-1] = true;
        }
        
        if(!visited[0]){
            DFS(0);
        }
        
        if(answer) System.out.println("yes");
        else System.out.println("Yes");
        
    }
    
    public static void DFS(int cur){
        if(graph[cur].size() == 0){
            answer = true;
            return;
        }
        
        
        for(int nx : graph[cur]){
            if(!visited[nx]){
                DFS(nx);
            }
        }
    }
}
