import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[] grid = new int[101];
    public static boolean[] visited = new boolean[101];
    public static int[] dx = {1, 2, 3, 4, 5, 6};
    public static HashMap<Integer, Integer> map = new HashMap<>();
    public static Queue<Integer> q = new LinkedList<>();   
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        for(int i = 0; i<N+M; i++){
            input = br.readLine().split(" ");
            int s = Integer.valueOf(input[0]);
            int e = Integer.valueOf(input[1]);
            
            map.put(s, e);
        }
        
        q.add(1);
        grid[1] = 0;
        visited[1] = true;
        BFS();
        
        System.out.println(grid[100]);
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int dice : dx){
                int nx = cur + dice;
                if(map.containsKey(nx)){
                    nx = map.get(nx);
                }
                if(nx <= 100 && !visited[nx]){
                    grid[nx] = grid[cur]+1;
                    visited[nx] = true;
                    q.add(nx);
                }
            }
        }
    }
}
