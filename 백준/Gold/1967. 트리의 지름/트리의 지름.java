import java.util.*;
import java.io.*;

class Node {
    int idx, weight;
    
    public Node(int idx, int weight){
        this.idx=idx;
        this.weight=weight;
    }
}

public class Main {
    static int N;
    static ArrayList<Node>[] graph;
    static int node = 0;
    static int max = 0;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.valueOf(br.readLine());
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=1; i<N; i++){
            String[] input = br.readLine().split(" ");
            int st = Integer.valueOf(input[0]) - 1;
            int ed = Integer.valueOf(input[1]) - 1;
            int w = Integer.valueOf(input[2]);
            
            graph[st].add(new Node(ed, w));
            graph[ed].add(new Node(st, w));
        }
        
        visited = new boolean[N];
        visited[0] = true;
        dfs(0, 0);
        visited[0] = false;
        
        visited[node] = true;
        dfs(node, 0);
        visited[node] = false;
        
        System.out.println(max);
    }
    
    static void dfs(int cur, int dist){
        if(max < dist){
            max = dist;
            node = cur;
        }
        
        for(int i=0; i<graph[cur].size(); i++){
            Node nx = graph[cur].get(i);
            if(!visited[nx.idx]){
                visited[nx.idx] = true;
                dfs(nx.idx, dist + nx.weight);
                visited[nx.idx] = false;
            }
            
        }
    }
}
