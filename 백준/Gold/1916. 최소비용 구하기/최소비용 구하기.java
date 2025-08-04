import java.util.*;
import java.io.*;


class Node{
    int idx, w;
    
    public Node(int idx, int w){
        this.idx=idx;
        this.w=w;
    }
}

public class Main {
    public static int N, M;
    public static List<Node>[] graph;
    public static int[] distance;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.valueOf(br.readLine());
        M = Integer.valueOf(br.readLine());
        
        distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++){
            String[] input = br.readLine().split(" ");
            int st = Integer.valueOf(input[0]) - 1;
            int ed = Integer.valueOf(input[1]) - 1;
            int w = Integer.valueOf(input[2]);
            
            graph[st].add(new Node(ed, w));
        }
        
        
        String[] input = br.readLine().split(" ");
        int st = Integer.valueOf(input[0]) - 1;
        int ed = Integer.valueOf(input[1]) - 1;
        
        System.out.println(Dijkstra(st, ed));
    }
    
    
    public static int Dijkstra(int st, int ed){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            return a.w - b.w;
        });
        pq.add(new Node(st, 0));
        distance[st] = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(distance[cur.idx] < cur.w) continue;
            
            // push
            for(int i = 0; i < graph[cur.idx].size(); i++){
                Node nx = graph[cur.idx].get(i);
                
                if(distance[nx.idx] > distance[cur.idx] + nx.w){
                    distance[nx.idx] = distance[cur.idx] + nx.w;
                    pq.add(new Node(nx.idx, distance[nx.idx]));
                }
            }
        }
        
        return distance[ed];
    }
}
