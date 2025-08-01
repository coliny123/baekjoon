import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static int root = -1;
    static int removed = -1;
    static int answer = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.valueOf(br.readLine());
        
        graph = new ArrayList[N];
        
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }
        
        String[] input = br.readLine().split(" ");
        
        for(int i = 0; i < N; i++){
            int parent = Integer.valueOf(input[i]);
            if(parent == -1) {
                root = i;
            } else {
                graph[parent].add(i);
            }
        }
        
        removed = Integer.valueOf(br.readLine());
        
        if(removed == root) {
            System.out.println(0);
            return;
        }
        
        dfs(root);
        
        System.out.println(answer);
    }
    
    public static void dfs(int cur){
        if(cur == removed) return;
        
        int childCount = 0;
        
        for(int child : graph[cur]) {
            if(child != removed) {
                childCount++;
                dfs(child);
            }
        }
        
        // 자식이 없으면 리프 노드
        if(childCount == 0) {
            answer++;
        }
    }
}