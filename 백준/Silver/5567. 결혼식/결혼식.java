import java.util.*;

public class Main {
    public static int N, M;
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        visited = new boolean[N];
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        M = sc.nextInt();
        while(M-- > 0){
            int st = sc.nextInt()-1;
            int ed = sc.nextInt()-1;
            
            graph[st].add(ed);
            graph[ed].add(st);
        }
        
        visited[0] = true;
        q.add(new int[]{0, 0});
        
        System.out.println(BFS());
        
    }
    
    public static int BFS(){
        int cnt=0;
        while(!q.isEmpty()){
            int[] cur = q.poll(); // 0, 0
            
            for(int i=0; i<graph[cur[0]].size(); i++){
                int nx = graph[cur[0]].get(i);
                if(!visited[nx] && cur[1] <2){
                    cnt++;
                    visited[nx] = true;
                    q.add(new int[]{nx, cur[1]+1});
                }
            }
        }
        
        return cnt;
    }
}
