import java.util.*;
import java.io.*;

public class Main {
    public static int V, E;
    public static ArrayList<Integer>[] graph;
    public static Queue<Integer> q;
    public static int[] color;
    public static boolean flag;
    
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.valueOf(br.readLine());
        
        while(T-- > 0){
            flag = false;
            String[] input = br.readLine().split(" ");
            int V = Integer.valueOf(input[0]);
            int E = Integer.valueOf(input[1]);
            
            q = new LinkedList<>();
            color = new int[V];
            graph = new ArrayList[V];
            for(int i=0; i<V; i++){
                graph[i] = new ArrayList<>();
            }
            
            for(int i=0; i<E; i++){
                input = br.readLine().split(" ");
                int st = Integer.valueOf(input[0])-1;
                int ed = Integer.valueOf(input[1])-1;
                
                graph[st].add(ed);
                graph[ed].add(st);
            }
            
            for(int i=0; i<V; i++){
                if(color[i] == 0){
                    q.add(i);
                    color[i] = 1;
                    BFS();
                }
            }
            System.out.println(flag ? "NO" : "YES");
            
        }
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i=0; i<graph[cur].size(); i++){
                int nx = graph[cur].get(i);
                if(color[nx] == 0){
                    q.add(nx);
                    color[nx] = -color[cur];
                }else if(color[nx] == color[cur]){
                    flag = true;
                    return;
                }
            }
        }
    }
}
