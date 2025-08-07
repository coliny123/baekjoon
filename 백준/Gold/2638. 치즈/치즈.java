import java.util.*;
import java.io.*;

class Node {
    int x, y;
    
    public Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    public static int N, M;
    public static int[][] grid;
    public static int[][] contact;
    public static boolean[][] isAir;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static Queue<Node> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        grid = new int[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        int time = 0;
        
        while(true){
            contact = new int[N][M];
            isAir = new boolean[N][M];
            
            bfs(0, 0);
            
            boolean notMelted = false;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(grid[i][j] == 1 && contact[i][j] >= 2){
                        grid[i][j] = 0;
                        notMelted = true;
                    }
                }
            }
            if(!notMelted) break;
            time++;
        }
        
        
        System.out.println(time);
    }
    
    
    static void bfs(int x, int y){
        q = new LinkedList<>();
        q.add(new Node(x, y));
        isAir[x][y] = true;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(0 <= nx && nx < N && 0 <= ny && ny < M){
                    if(isAir[nx][ny]) continue;
                    if(grid[nx][ny] == 1){
                        contact[nx][ny]++;
                    }else{
                        q.add(new Node(nx, ny));
                        isAir[nx][ny] = true;
                    }
                }
            }
        }
    }
}
