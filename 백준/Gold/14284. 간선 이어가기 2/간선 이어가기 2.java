import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int idx, w;
    
    public Node(int idx, int w){
        this.idx=idx;
        this.w=w;
    }
    
    @Override
    public int compareTo(Node o){
        return w - o.w;
    }
}

public class Main {
    public static int N, M;
    public static ArrayList<Node>[] graph;
    public static int[] dist;
    public static PriorityQueue<Node> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        dist = new int[N];
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        while(M-- > 0){
            input = br.readLine().split(" ");
            int s = Integer.valueOf(input[0])-1;
            int e = Integer.valueOf(input[1])-1;
            int w = Integer.valueOf(input[2]);
            
            graph[s].add(new Node(e, w));
            graph[e].add(new Node(s, w));
        }
        
        input = br.readLine().split(" ");
        int S = Integer.valueOf(input[0])-1;
        int E = Integer.valueOf(input[1])-1;
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Node(S, 0));
        dist[S] = 0;
        
        dijkstra();
        
        System.out.println(dist[E]);
    }
    
    
    public static void dijkstra(){
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.idx] < cur.w){
                continue;
            }
            
            for(Node nx : graph[cur.idx]){
                int cost = cur.w + nx.w;
                if(cost < dist[nx.idx]){
                    dist[nx.idx] = cost;
                    pq.add(new Node(nx.idx, cost));
                }
            }
        }
    }
}
