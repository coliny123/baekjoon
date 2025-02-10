import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static char[][] grid;
    public static boolean[][] dp;
    public static boolean[][] visited;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        grid = new char[N][M];
        dp = new boolean[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                grid[i][j] = input[j].charAt(0);
            }
        }
        // DFS(0,0);
        
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!dp[i][j] && !visited[i][j]){
                    DFS(i, j);
                }
                
                if(dp[i][j]){
                    cnt++;
                }
                
                // System.out.println(i + " " + j);
                // System.out.println("dp");
                // for(int k=0; k<N; k++){
                    // for(int q=0; q<M; q++){
                        // System.out.print(dp[k][q]);
                    // }
                    // System.out.println();
                // }
                // System.out.println();
                // System.out.println("visited");
                // for(int k=0; k<N; k++){
                    // for(int q=0; q<M; q++){
                        // System.out.print(dp[k][q]);
                    // }
                    // System.out.println();
                // }
                // System.out.println();
            }
        }

        System.out.println(cnt);
        
    }
    
    public static boolean DFS(int x, int y){
        int nx = x;
        int ny = y;
        if(grid[x][y] == 'D'){
            nx = x + 1;
        }else if(grid[x][y] == 'U'){
            nx = x - 1;
        }else if(grid[x][y] == 'L'){
            ny = y - 1;
        }else if(grid[x][y] == 'R'){
            ny = y + 1;
        }
        
        // 다음 스텝이 grid 밖이면 탈출, true 리턴
        if(nx < 0 || nx >=N || ny < 0 || ny >= M){
            return dp[x][y] = true;
        }
        
        // 방문했던 곳이라면 방문기록 리턴
        if(visited[nx][ny]){
            return dp[x][y] = dp[nx][ny];
        }
        
        visited[nx][ny] = true;
        dp[x][y] = DFS(nx, ny);
        // System.out.println(x + " " + y + " " + dp[x][y] + " // " + nx + " " + ny + " " + dp[nx][ny]);
        
        return dp[x][y];
    }
}
