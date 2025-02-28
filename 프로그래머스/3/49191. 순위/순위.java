import java.util.*;

class Solution {
    public static ArrayList<Integer>[] parentGraph;
    public static ArrayList<Integer>[] childGraph;
    public static boolean[] visited;
    public static Queue<Integer> q;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        parentGraph = new ArrayList[n];
        childGraph = new ArrayList[n];
        for(int i=0; i<n; i++){
            parentGraph[i] = new ArrayList<>();
            childGraph[i] = new ArrayList<>();
        }
        
        for(int[] fight : results){
            int p = fight[0]-1;
            int c = fight[1]-1;
            
            parentGraph[c].add(p);
            childGraph[p].add(c);
        }
        
        
        for(int i=0; i<n; i++){
            // 초기화
            q = new LinkedList<>();
            visited = new boolean[n];
            
            q.add(i);
            visited[i] = true;
            int pCnt = BFS(parentGraph);
            
            q = new LinkedList<>();
            visited = new boolean[n];
            
            q.add(i);
            visited[i] = true;
            int cCnt = BFS(childGraph);
            
            
            System.out.println(i + " = 부모 : " + pCnt + " 자식 : " + cCnt);
            if(cCnt + pCnt == n-1) answer++;
        }
        
        
        return answer;
    }
    
    public static int BFS(ArrayList<Integer>[] graph){
        int cnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i=0; i<graph[cur].size(); i++){
                int nx = graph[cur].get(i);
                if(!visited[nx]){
                    visited[nx] = true;
                    q.add(nx);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}