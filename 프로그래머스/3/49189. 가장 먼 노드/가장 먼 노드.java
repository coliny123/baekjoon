import java.util.*;

class Solution {
    public static ArrayList<Integer>[] graph;
    public static Queue<Integer> q = new LinkedList<>();
    public static boolean[] visited;
    public static int[] step;
    public static int max = 0;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        graph = new ArrayList[n];
        visited = new boolean[n];
        step = new int[n];
        
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] line : edge){
            int st = line[0]-1;
            int ed = line[1]-1;
            
            graph[st].add(ed);
            graph[ed].add(st);
        }
        
        visited[0] = true;
        q.add(0);
        BFS();
        
        for(int i=0; i<n; i++){
            if(step[i] == max) answer++;
        }
        
        return answer;
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i=0; i<graph[cur].size(); i++){
                int nx = graph[cur].get(i);
                if(!visited[nx]){
                    visited[nx] = true;
                    q.add(nx);
                    step[nx] = step[cur] + 1;
                    max = Math.max(max, step[nx]);
                }
            }
            
            
        }
    }
}