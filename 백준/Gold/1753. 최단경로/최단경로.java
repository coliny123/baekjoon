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
    public static int V, E, K;
    public static int[] weight;
    public static ArrayList<Node>[] graph;
    public static PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
        @Override
        public int compare(Node o1, Node o2){
            return (o1.w - o2.w);
        }
    });
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        
        V = Integer.valueOf(input[0]);
        E = Integer.valueOf(input[1]);
        
        graph = new ArrayList[V];
        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
        }
        weight = new int[V];
        Arrays.fill(weight, 1000000);
        
        K = Integer.valueOf(br.readLine())-1;
        
        while(E-- > 0){
            input = br.readLine().split(" ");
            
            int st = Integer.valueOf(input[0]) - 1;
            int ed = Integer.valueOf(input[1]) - 1;              
            int w = Integer.valueOf(input[2]);
            
            graph[st].add(new Node(ed, w));
        }
        
        
        Dijkstra(K);
        
        for(int i=0; i<V; i++){
            System.out.println(weight[i] == 1000000 ? "INF" : weight[i]);
        }
    }
    
    
    public static void Dijkstra(int st){
        weight[st] = 0;
        pq.add(new Node(st, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.peek();
            if(weight[cur.idx] == cur.w){
                for(int i=0; i<graph[cur.idx].size(); i++){
                    Node nx = graph[cur.idx].get(i);
                    if(weight[nx.idx] > weight[cur.idx] + nx.w){
                        weight[nx.idx] = weight[cur.idx] + nx.w;
                        pq.add(new Node(nx.idx, weight[nx.idx]));
                    }
                }
            }
            pq.poll();
        }
    }
    
    
}
