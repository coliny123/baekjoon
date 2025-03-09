import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int idx, weight;
    
    public Node(int idx, int weight){
        this.idx=idx;
        this.weight=weight;
    }
    
    @Override
    public int compareTo(Node o){
        return weight - o.weight;
    }
}

public class Main {
    static int N;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static int node = 0;
    
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
        
        dist = new int[N];
        Arrays.fill(dist, 1000000000);
        dijkstra(0);
        
        dist = new int[N];
        Arrays.fill(dist, 1000000000);
        System.out.println(dijkstra(node));
    }
    
    static int dijkstra(int st){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[st] = 0;
        pq.add(new Node(st, 0));
        
        int max = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(max < dist[cur.idx]){
                max = cur.weight;
                node = cur.idx;
            }
            
            for(int i=0; i<graph[cur.idx].size(); i++){
                Node nx = graph[cur.idx].get(i);
                if(dist[nx.idx] > dist[cur.idx] + nx.weight){
                    dist[nx.idx] = dist[cur.idx] + nx.weight;
                    pq.add(new Node(nx.idx, dist[nx.idx]));
                }
            }
        }
        
        return max;
    }
}
