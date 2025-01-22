import java.util.*;
import java.io.*;

class Node{
    int x, y;
    
    public Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    public static int N, M;
    public static int answer=0;
    public static int[][] grid;
    public static int[][] dp;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};   
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        grid = new int[N][M];
        dp= new int[N][M];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
                dp[i][j] = -1;
            }
        }
        
        System.out.println(DFS(0, 0));
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
    
    public static int DFS(int x, int y){
        if(x == N-1 && y == M-1){
            return 1;
        }
        
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        
        dp[x][y] = 0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(inRange(nx, ny) && grid[x][y] > grid[nx][ny]){
                dp[x][y] += DFS(nx, ny);
            }
        }
        
        return dp[x][y];
    }
}
