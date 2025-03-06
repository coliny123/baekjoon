import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int x, y, w;
    
    public Node(int x, int y, int w){
        this.x=x;
        this.y=y;
        this.w=w;
    }
    
    @Override
    public int compareTo(Node o){
        return w - o.w;
    }
}

public class Main {
    static int N, M;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parents;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            String[] input = br.readLine().split(" ");
            N = Integer.valueOf(input[0]);
            M = Integer.valueOf(input[1]);
            if(N == 0 && M == 0) return;
            
            parents = new int[N];
            for(int i=0; i<N; i++){
                parents[i] = i;
            }
            
            int sum = 0;
            while(M-- > 0){
                input = br.readLine().split(" ");
                int st = Integer.valueOf(input[0]);
                int ed = Integer.valueOf(input[1]);
                int weight = Integer.valueOf(input[2]);
                
                pq.add(new Node(st, ed, weight));
                sum += weight;
            }
            
            System.out.println(sum - kruskal());
            
        }
    }
    
    static int kruskal(){
        int sum = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(find(cur.x) != find(cur.y)){
                sum += cur.w;
                union(cur.x, cur.y);
            }
        }
        
        return sum;        
    }
    
    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y) return;
        parents[y] = x;
    }
}
