import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int answer = 0;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        grid = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                dfs(i, j, 0, grid[i][j], false);
                visited[i][j] = false;
            }
        }
        
        System.out.println(answer);
    }
    
    static void dfs(int x, int y, int depth, int sum, boolean back){
        if(depth == 3){
            answer = Math.max(answer, sum);
            return;
        }
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!inRange(nx, ny)) continue;
            
            if(depth == 2 && visited[nx][ny] && !back){
                // System.out.println(nx + " " + ny + " " + depth + " " + sum);
                dfs(nx, ny, depth, sum, true);
                continue;
            }
            
            if(!visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx, ny, depth+1, sum+grid[nx][ny], back);
                visited[nx][ny] = false;
            }
        }
    }
    
    
    static boolean inRange(int x, int y){
        return (0 <= x && x < N && 0 <= y && y < M);
    }
}
