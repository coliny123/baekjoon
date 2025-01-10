import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Integer>[] graph;
    public static Queue<Integer> q = new LinkedList<>();
    public static int[] indegree;
    public static int[] cost;
    public static int[] result;
    public static int N;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.valueOf(br.readLine());
        
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        indegree = new int[N];
        cost = new int[N];
        result = new int[N];
        
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            
            cost[i] = Integer.valueOf(input[0]);
            
            for(int j=1; j<input.length-1; j++){
                graph[Integer.valueOf(input[j])-1].add(i);
                indegree[i]++;
            }
        }
        
        topologicalSort();
        StringBuilder sb = new StringBuilder();
        for(int time : result){
            sb.append(time).append("\n");
        }
        
        System.out.print(sb);
    }
    
    public static void topologicalSort(){
        for(int i=0; i<N; i++){
            if(indegree[i] == 0){
                q.add(i);
                result[i] = cost[i];
            }
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<graph[cur].size(); i++){
                int nx = graph[cur].get(i);
                
                result[nx] = Math.max(result[nx], result[cur] + cost[nx]);
                indegree[nx]--;
                
                if(indegree[nx] == 0){
                    list.add(nx);
                }
            }
            
            for(int t : list){
                q.add(t);
            }
        }
    }
}
