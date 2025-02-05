import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static ArrayList<Integer>[] graph;
    public static ArrayList<Integer>[] reverse;
    public static boolean[] visited;
    public static Queue<Integer> q = new LinkedList<>();
     
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.valueOf(br.readLine());
        
        visited = new boolean[N];
        graph = new ArrayList[N];
        reverse = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        
        int root = 0;
        String[] input = br.readLine().split(" ");
        for(int i=0; i<input.length; i++){
            int parents = Integer.valueOf(input[i]);
            if(parents == -1){
                root = i;
            }else{
                graph[parents].add(i);
                reverse[i].add(parents);
            }
        }
        int remove = Integer.valueOf(br.readLine());
        graph[remove] = new ArrayList<>();
        for(int i=0; i<reverse[remove].size(); i++){
            int parent = reverse[remove].get(i);
            graph[parent].remove(Integer.valueOf(remove));
        }
        
        
        visited[root] = true;
        q.add(root);
        
        int leefCnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(graph[cur].size() == 0 && cur != remove) leefCnt++;
            // System.out.println("cur = " + cur + " / size = " + graph[cur].size() + " / root = " + root + " / leefCnt = " + leefCnt);
            
            for(int i=0; i<graph[cur].size(); i++){
                int nx = graph[cur].get(i);
                if(!visited[nx]){
                    visited[nx] = true;
                    q.add(nx);
                }
            }
        }
        
        System.out.println(leefCnt);
        
    }
}
