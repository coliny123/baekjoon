import java.util.*;
import java.io.*;

public class Main {
    public static int N, S, E;
    public static ArrayList<int[]>[] graph;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        S = Integer.valueOf(input[1])-1;
        E = Integer.valueOf(input[2])-1;
        
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<N-1; i++){
            input = br.readLine().split(" ");
            int st = Integer.valueOf(input[0])-1;
            int ed = Integer.valueOf(input[1])-1;
            int dist = Integer.valueOf(input[2]);
            
            graph[st].add(new int[]{ed, dist});
            graph[ed].add(new int[]{st, dist});
        }
        System.out.println(bfs(S, E));
        
    }
    
    public static int bfs(int st, int ed){
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.add(new int[]{st, 0, 0});   // 인덱스, 합, 최댓값
        visited[st] = true;
        
        int answer = -1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == ed){
                answer = cur[1] - cur[2];
                break;
            }
            
            for(int i=0; i<graph[cur[0]].size(); i++){
                int[] next = graph[cur[0]].get(i);
                int nx = next[0];
                int dist = next[1];
                if(!visited[nx]){
                    visited[nx] = true;
                    q.add(new int[]{nx, cur[1] + dist, Math.max(cur[2], dist)});
                }
            }
        }
        
        return answer;
    }
}
