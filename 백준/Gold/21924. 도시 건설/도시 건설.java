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
    public static int N, M, W;
    public static long TOTAL, MINI;
    public static int[] buildings;
    public static PriorityQueue<Node> pq = new PriorityQueue<>();
        
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] NM = br.readLine().split(" ");
        N = Integer.valueOf(NM[0]);
        M = Integer.valueOf(NM[1]);
        
        buildings = new int[N];
        for (int i = 0; i < N; i++) {
            buildings[i] = i;
        }
        
        for(int i=0; i<M; i++){
            String[] input = br.readLine().split(" ");
            int X = Integer.valueOf(input[0])-1;
            int Y = Integer.valueOf(input[1])-1;
            int W = Integer.valueOf(input[2]);
            pq.add(new Node(X, Y, W));
            TOTAL += W;
        }
        
        
        if(kruskal()){
            System.out.println(TOTAL - MINI);
        }else{
            System.out.println(-1);
        }
        
        
    }
    
    public static boolean kruskal() {
        int cnt = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            if (find(n.x) != find(n.y)) {
                union(n.x, n.y);
                MINI += n.w;
                cnt++;
            }
            if (cnt == N-1)
                return true;
        }
        return false;
    }
    
    public static int find(int x){
        if(buildings[x] == x) return x;
        return buildings[x] = find(buildings[x]);
    }
    
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x==y) return;
        buildings[y] = x;
    }
    
}