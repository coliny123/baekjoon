import java.util.*;

class Node{
    int x, w;
    
    public Node(int x, int w){
        this.x=x;
        this.w=w;
    }
}

public class Main {
    public static ArrayList<Node>[] graph;
    public static Queue<Node> q;
    public static boolean[] visited;
    public static long maxLen = 0;
    public static int node=0;
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<N; i++){
            int st = sc.nextInt();
            while(true){
                int ed = sc.nextInt();
                if(ed == -1) break;
                int w = sc.nextInt();
                graph[st-1].add(new Node(ed-1, w));
            }
        }
        
        visited = new boolean[N];
        DFS(0, 0);
        
        visited = new boolean[N];
        DFS(node, 0);
       
        System.out.println(maxLen);
        
        
        
    }
    
    public static void DFS(int x, int len){
        visited[x] = true;
        if(len > maxLen){
            maxLen = len;
            node = x;
        }
        
        for(int i=0; i<graph[x].size(); i++){
            Node nx = graph[x].get(i);
            if(!visited[nx.x]){
                DFS(nx.x, nx.w+len);
            }
        }
    }
}
