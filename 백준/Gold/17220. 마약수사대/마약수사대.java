import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        visited = new boolean[N+1];
        graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int st = input[0].charAt(0) - 'A';
            int ed = input[1].charAt(0) - 'A';
            graph[st].add(ed);
            set.add(ed);
        }
        
        List<Integer> origin = new ArrayList<>();
        for(int i=0; i<=N; i++){
            if(!set.contains(i)){
                origin.add(i);
            }
        }
        
        input = br.readLine().split(" ");
        int catched = Integer.valueOf(input[0]);
        for(int i=1; i<=catched; i++){
            int who = input[i].charAt(0) - 'A';
            graph[who].clear();
            visited[who] = true;
        }
        
        int ans = 0;
        for(int i=0; i<origin.size(); i++){
            ans += bfs(origin.get(i));
        }
        
        System.out.println(ans);
    }
    
    public static int bfs(int st){
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        visited[st] = true;
        
        int cnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i=0; i<graph[cur].size(); i++){
                int nx = graph[cur].get(i);
                if(!visited[nx]){
                    cnt++;
                    q.add(nx);
                    visited[nx] = true;
                }
            }
        }
        
        return cnt;
    }
}
