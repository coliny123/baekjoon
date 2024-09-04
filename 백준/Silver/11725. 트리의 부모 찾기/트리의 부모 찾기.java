import java.util.*;

public class Main {
    public static int N;
    public static ArrayList<Integer> graph[];
    public static Queue<Integer> q = new LinkedList<>();
    public static int parents[];
    public static boolean visited[];
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        parents = new int[N];
        visited= new boolean[N];
        
        for(int i=1; i<N; i++){
            int st = sc.nextInt()-1;
            int ed = sc.nextInt()-1;
            
            graph[st].add(ed);
            graph[ed].add(st);
        }
        
        parents[0]=0;
        visited[0]=true;
        q.add(0);
        
        BFS();
        
        for(int i=1; i<N; i++){
            System.out.println(parents[i]);
        }
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            int p = q.poll();
            
            for(int i=0; i<graph[p].size(); i++){
                int child = graph[p].get(i);
                if(!visited[child]){
                    parents[child] = p+1;
                    visited[child] = true;
                    q.add(child);
                }
            }
        }
    }
}
