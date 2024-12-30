import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, K;
    public static int answer = 0;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {-1,1,0,0};
    public static char[][] grid;
    public static boolean[][] visited;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        K = Integer.valueOf(input[2]);
        
        grid = new char[N][M];
        visited = new boolean[N][M];
                
        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                grid[i][j] = input[j].charAt(0);
            }
        }
        
        visited[N-1][0] = true;
        DFS(N-1, 0, 1);
        
        System.out.println(answer);
    }
    
    public static void DFS(int x, int y, int step){
        if(x == 0 && y == M-1){
            if(step == K) answer += 1;
            return;
        }
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(canGo(nx, ny)){
                visited[nx][ny] = true;
                DFS(nx, ny, step+1);
                visited[nx][ny] = false;
            }
        }
        
    }
    
    public static boolean inRange(int x, int y){
        return (0<= x && x<N && 0<=y && y<M);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        if(visited[x][y] || grid[x][y] == 'T') return false;
        return true;
    }
}
