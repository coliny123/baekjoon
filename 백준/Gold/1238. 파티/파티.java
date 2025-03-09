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
    static int N, M, X;
    static ArrayList<Node>[] graph;
    static ArrayList<Node>[] reverseGraph;
    static int[] dist;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        X = Integer.valueOf(input[2]) - 1;
        
        graph = new ArrayList[N];
        reverseGraph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        
        while(M-- > 0){
            input = br.readLine().split(" ");
            int st = Integer.valueOf(input[0]) - 1;
            int ed = Integer.valueOf(input[1]) - 1;
            int w = Integer.valueOf(input[2]);
            
            graph[st].add(new Node(ed, w));
            reverseGraph[ed].add(new Node(st, w));
        }
        
        // X 에서 집으로 돌아가는 그래프
        int[] sum = new int[N];
        dist = new int[N];
        Arrays.fill(dist, 1000000000);
        dijkstra(X, graph);
        
        for(int i=0; i<N; i++){
            sum[i] += dist[i];
        }
        
        // 반대로 바꾼 그래프(X로 오는 가중치 찾기 위함)
        dist = new int[N];
        Arrays.fill(dist, 1000000000);
        dijkstra(X, reverseGraph);
        
        int max = 0;
        for(int i=0; i<N; i++){
            sum[i] += dist[i];
            max = Math.max(max, sum[i]);
        }
        
        System.out.println(max);
    }
    
    static void dijkstra(int st, ArrayList<Node>[] graph){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[st] = 0;
        pq.add(new Node(st, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            for(int i=0; i<graph[cur.idx].size(); i++){
                Node nx = graph[cur.idx].get(i);
                if(dist[nx.idx] > dist[cur.idx] + nx.weight){
                    dist[nx.idx] = dist[cur.idx] + nx.weight;
                    pq.add(new Node(nx.idx, dist[nx.idx]));
                }
            }
        }
    }
}
