import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static char[][] grid;
    static boolean[][] total;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean cicle = false;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        grid = new char[N][M];
        total = new boolean[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                grid[i][j] = input[j].charAt(0);
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!total[i][j] && !cicle){
                    total[i][j] = true;
                    visited[i][j] = true;
                    DFS(i, j, -1, -1);
                    visited[i][j] = false;
                }
            }
        }
        
        
        System.out.println(cicle ? "Yes" : "No");
    }
    
    
    public static void DFS(int x, int y, int b_x, int b_y){
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(!inRange(nx, ny)) continue;
            if(grid[x][y] != grid[nx][ny]) continue;
            if(nx == b_x && ny == b_y) continue;
            
            if(visited[nx][ny]){
                cicle = true;
                return;
            }

            total[nx][ny] = true;
            visited[nx][ny] = true;
            DFS(nx, ny, x, y);
            visited[nx][ny] = false;            
        }
    }
    
    
    public static boolean inRange(int x, int y){
        return( 0 <= x && x < N && 0 <= y && y < M);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        if(visited[x][y]) return false;
        return true;
    }
}
