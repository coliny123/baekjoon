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
    static int[] parents;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        int M = Integer.valueOf(br.readLine());
        
        parents = new int[N];
        dist = new int[N];
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        while(M-- > 0){
            String[] input = br.readLine().split(" ");
            int st = Integer.valueOf(input[0]) - 1;
            int ed = Integer.valueOf(input[1]) - 1;
            int w = Integer.valueOf(input[2]);
            
            graph[st].add(new Node(ed, w));
        }
        
        String[] input = br.readLine().split(" ");
        int st = Integer.valueOf(input[0]) - 1;
        int ed = Integer.valueOf(input[1]) - 1;
        
        dijkstra(st);
        
        Stack<Integer> stack = new Stack<>();
        stack.push(ed + 1);
        int history = ed;
        while(history != st){
            stack.push(parents[history] + 1);
            history = parents[history];
        }
        
        System.out.println(dist[ed]);
        System.out.println(stack.size());
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
    
    static void dijkstra(int st){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, 1000000000);
        dist[st] = 0;
        pq.add(new Node(st, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.peek();
            
            if(dist[cur.idx] == cur.weight){
                for(Node nx : graph[cur.idx]){
                    if(dist[nx.idx] > dist[cur.idx] + nx.weight){
                        dist[nx.idx] = dist[cur.idx] + nx.weight;
                        pq.add(new Node(nx.idx, dist[nx.idx]));
                        parents[nx.idx] = cur.idx;
                    }
                }
            }
            
            pq.poll();
        }
    }
}
