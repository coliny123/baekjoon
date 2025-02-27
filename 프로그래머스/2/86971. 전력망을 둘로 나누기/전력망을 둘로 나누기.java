import java.util.*;

class Solution {
    public static ArrayList<Integer>[] graph;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0] - 1;
            int v2 = wires[i][1] - 1;
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        int min = n;
        for (int i = 0; i < wires.length; i++) {
            boolean[] visited = new boolean[n];
            int v1 = wires[i][0] - 1;
            int v2 = wires[i][1] - 1;
            
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            int cnt = bfs(0, visited);
            
            graph[v1].add(v2);
            graph[v2].add(v1);
            
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);
        }
        
        return min;
    }
    
    public static int bfs(int st, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        visited[st] = true;
        
        int cnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            cnt++;
            for(int i=0; i<graph[cur].size(); i++){
                int nx = graph[cur].get(i);
                if(!visited[nx]){
                    q.add(nx);
                    visited[nx] = true;
                }
            }
        }
        
        return cnt;
    }
}