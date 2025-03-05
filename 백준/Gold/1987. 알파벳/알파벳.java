import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static int[][] grid;
    static boolean[][] visited;
    static boolean[] alpha = new boolean[26];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = 0;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.valueOf(input[0]);
        C = Integer.valueOf(input[1]);
        
        visited = new boolean[R][C];
        grid = new int[R][C];
        for(int i=0; i<R; i++){
            input = br.readLine().split("");
            for(int j=0; j<C; j++){
                grid[i][j] = input[j].charAt(0) - 'A';
            }
        }
        
        visited[0][0] = true;
        alpha[grid[0][0]] = true;
        dfs(0, 0, 1);
        
        System.out.println(answer);
    }
    
    static void dfs(int x, int y, int len){
        answer = Math.max(answer, len);
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx, ny) && !visited[nx][ny] && !alpha[grid[nx][ny]]){
                visited[nx][ny] = true;
                alpha[grid[nx][ny]] = true;
                dfs(nx, ny, len+1);
                visited[nx][ny] = false;
                alpha[grid[nx][ny]] = false;
            }
        }
    }
    
    static boolean inRange(int x, int y){
        return (0 <= x && x < R && 0 <= y && y < C);
    }
}
