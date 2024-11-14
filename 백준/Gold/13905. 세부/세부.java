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
        return o.w - w;
    }
}

public class Main {
    
    public static int[] island;
    public static int[] weight;
    public static PriorityQueue<Node> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int M = Integer.valueOf(input[1]);
        input = br.readLine().split(" ");
        int S = Integer.valueOf(input[0])-1;
        int E = Integer.valueOf(input[1])-1;
        
        
        island = new int[N];
        weight = new int[N];
        for(int i=0; i<N; i++){
            island[i] = i;
        }
        
        while(M-- > 0){
            input = br.readLine().split(" ");
            int a = Integer.valueOf(input[0])-1;
            int b = Integer.valueOf(input[1])-1;
            int w = Integer.valueOf(input[2]);
            
            pq.add(new Node(a,b,w));
        }
        
        System.out.println(kruskal(S, E));
        
    }
    
    
    public static int kruskal(int S, int E){
        int answer = 0;
        int min=1000000;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            min = Math.min(min, cur.w);
            union(cur.x, cur.y);
            
            if(find(S) == find(E)){
                answer = min;
                break;
            }
        }
        return answer;
    }
    
    
    public static int find(int x){
        if(island[x] == x) return x;
        return island[x] = find(island[x]);
    }
    
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x==y) return;
        island[y] = x;
    }
}
