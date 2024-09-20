import java.util.*;

class Node {
    int ed, w;
    
    public Node(int ed, int w){
        this.ed=ed;
        this.w=w;
    }
}

public class Main {
    public static int N, D;
    public static ArrayList<Node> roads[];
    public static int dist[];
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        
        N = sc.nextInt();
        D = sc.nextInt();
        
        roads = new ArrayList[D+1];
        for(int i=0; i<=D; i++){
            roads[i] = new ArrayList<>();
        }
        dist = new int[D+1];
        for(int i=0; i<=D; i++) dist[i] = i;
        
        for(int i=0; i<N; i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int w = sc.nextInt();
            if(ed > D){
                continue;
            }
            roads[st].add(new Node(ed, w));
        }
        
        dijkstra(0);
        
        System.out.println(dist[D]);
        
    }
    
    public static void dijkstra(int st){
        if(st >= D) return;
        
        if(dist[st+1] > dist[st] + 1){
            dist[st+1] = dist[st]+1;
        }
        
        for(int i=0; i<roads[st].size(); i++){
            Node shc = roads[st].get(i);
            if(dist[st] + shc.w < dist[shc.ed]){
                dist[shc.ed] = dist[st] + shc.w;
            }
        }
        
        dijkstra(st+1);
    }
}
