import java.util.*;

class Node{
    int idx, w;

    public Node(int idx, int w){
        this.idx=idx;
        this.w=w;
    }
}

public class Main {
    public static Queue<Node> q = new LinkedList<>();
    public static ArrayList<Node>[] graph;
    public static int[] weights;
    public static int N, M;

    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList[N];
        for(int i=0; i<N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++){
            int s = sc.nextInt()-1;
            int e = sc.nextInt()-1;
            int w = sc.nextInt();

            graph[s].add(new Node(e, w));
            graph[e].add(new Node(s, w));
        }

        while(M-- > 0){
            weights = new int[N];
            Arrays.fill(weights, 100000001);
            int st = sc.nextInt()-1;
            int ed = sc.nextInt()-1;

            weights[st] = 0;
            q.add(new Node(st, 0));
            dajkstra();

            System.out.println(weights[ed]);
        }


    }

    public static void dajkstra(){
        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<graph[cur.idx].size(); i++){
                Node nx = graph[cur.idx].get(i);
                if(weights[nx.idx] > weights[cur.idx] + nx.w){
                    q.add(nx);
                    weights[nx.idx] = Math.min(weights[nx.idx], weights[cur.idx] + nx.w);
                }
            }
        }
    }
}
