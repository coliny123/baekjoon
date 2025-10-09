import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int st, ed, w;
    
    public Node(int st, int ed, int w){
        this.st=st;
        this.ed=ed;
        this.w=w;
    }
    
    @Override
    public int compareTo(Node o){
        return this.w - o.w;
    }
    
}

public class Main {
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parents;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        
        parents = new int[N];
        for(int i=0; i<N; i++){
            parents[i] = i;
        }
        
        int M = Integer.valueOf(br.readLine());
        
        while(M-- > 0){
            String[] input = br.readLine().split(" ");
            
            int st = Integer.valueOf(input[0]) - 1;
            int ed = Integer.valueOf(input[1]) - 1;
            int w = Integer.valueOf(input[2]);
            
            pq.add(new Node(st, ed, w));
        }
        
        int sum = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(find(cur.st) != find(cur.ed)){
                sum += cur.w;
                union(cur.st, cur.ed);
            }
        }
        
        
        System.out.println(sum);
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
