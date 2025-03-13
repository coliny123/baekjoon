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
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.valueOf(br.readLine());
        int M = Integer.valueOf(br.readLine());
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        while(M-- > 0){
            String[] input = br.readLine().split(" ");
            int st = Integer.valueOf(input[0])-1;
            int ed = Integer.valueOf(input[1])-1;
            int w = Integer.valueOf(input[2]);
            
            graph[st].add(new Node(ed, w));
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            floyd(i);
            for(int j=0; j<N; j++){
                if(dist[j] == 1000000000){
                    sb.append(0).append(" ");
                }else{
                    sb.append(dist[j]).append(" ");
                }
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
    
    static void floyd(int st){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N];
        Arrays.fill(dist, 1000000000);
        dist[st] = 0;
        pq.add(new Node(st, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(dist[cur.idx] == cur.weight){
                for(Node nx : graph[cur.idx]){
                    if(dist[nx.idx] > dist[cur.idx] + nx.weight){
                        dist[nx.idx] = dist[cur.idx] + nx.weight;
                        pq.add(new Node(nx.idx, dist[nx.idx]));
                    }
                }
            }
        }
        
    }
}
