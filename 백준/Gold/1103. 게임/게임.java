import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static char[][] grid;
    public static int[][] dp;
    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static int max = 0;
    public static boolean flag = false;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //입력 받기
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        dp = new int[N][M];
        visited = new boolean[N][M];
        grid = new char[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                grid[i][j] = input[j].charAt(0);
            }
        }
        
        //왼쪽위에서 DFS시작
        // DFS에서 사이클이 생기는 기준 : 
        visited[0][0] = true;
        dp[0][0] = 1;
        DFS(0,0);
        
        System.out.println(max);
    }
    
    public static void DFS(int x, int y){
        if(flag) return;
        
        max = Math.max(max, dp[x][y]);
        for(int i=0; i<4; i++){
            int nx = x + Integer.valueOf(grid[x][y] - '0') * dx[i];
            int ny = y + Integer.valueOf(grid[x][y] - '0') * dy[i];
            if(canGo(nx, ny) && dp[nx][ny] < dp[x][y]+1){
                // 이미 방문한 곳이면 사이클 발생
                if(visited[nx][ny]){
                    max = -1;
                    flag = true;
                    return;
                }
                dp[nx][ny] = dp[x][y]+1;
                visited[nx][ny] = true;
                DFS(nx, ny);
                visited[nx][ny] = false;
            }
        }
    }
    
    public static boolean inRange(int x, int y){
        return(0<=x && x<N && 0<=y && y<M);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        if(!Character.isDigit(grid[x][y])) return false;
        return true;
    }
}
