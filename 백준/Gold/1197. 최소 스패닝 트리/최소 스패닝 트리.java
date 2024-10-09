import java.util.*;

class Node implements Comparable<Node>{
    int x, y;
    int w;
    
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
    public static int N,M;
    public static int[] parents;
    public static PriorityQueue<Node> pq = new PriorityQueue<>();
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        parents = new int[N];
        for(int i=0; i<N; i++){
            parents[i] = i;
        }
        
        while(M-- > 0){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int w = sc.nextInt();
            
            pq.add(new Node(a,b,w));
        }
        
        System.out.println(kruskal());
        
        
    }
    
    public static int kruskal(){
        int mini = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(find(cur.x) != find(cur.y)){
                mini += cur.w;
                union(cur.x, cur.y);
            }
        }
        
        return mini;
    }
    
    public static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x==y) return;
        parents[y] = x;
    }
}
