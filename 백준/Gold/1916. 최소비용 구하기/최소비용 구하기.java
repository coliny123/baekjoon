import java.util.*;

class Node {
    int idx, value;
    
    public Node(int idx, int value){
        this.idx=idx;
        this.value=value;
    }
}

public class Main {
    public static int N;
    public static int M;
    public static int dp[];
    public static ArrayList<Node> graph[];
    public static PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
        @Override
        public int compare(Node o1, Node o2){
            return (o1.value - o2.value);
        }
    });
     
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        dp = new int[N];
        for(int i=0; i<N; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        sc.nextLine();
        while(M-- > 0){
            String input[] = sc.nextLine().split(" ");
            int st = Integer.valueOf(input[0])-1; 
            int ed = Integer.valueOf(input[1])-1; 
            int val = Integer.valueOf(input[2]);
            graph[st].add(new Node(ed, val));
        }
        
        int startN = sc.nextInt() - 1;
        int endN = sc.nextInt() - 1;
        
        pq.add(new Node(startN, 0));
        dp[startN] = 0;
    
        dijkstra();
        
        System.out.println(dp[endN]);
    }
    
    public static void push(int idx){
        for(int i=0; i<graph[idx].size(); i++){
            Node nx = graph[idx].get(i);
            if(dp[nx.idx] > dp[idx] + nx.value){
                dp[nx.idx] = dp[idx] + nx.value;
                pq.add(new Node(nx.idx, dp[idx] + nx.value));
            }
        }
    }
    
    public static void dijkstra(){
        while(!pq.isEmpty()){
            if(dp[pq.peek().idx] == pq.peek().value){
                push(pq.peek().idx);
            }
            pq.poll();
        }
    }
    

}
