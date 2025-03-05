import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static char[][] grid;
    static boolean[][] visited;
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
        grid = new char[R][C];
        for(int i=0; i<R; i++){
            input = br.readLine().split("");
            for(int j=0; j<C; j++){
                grid[i][j] = input[j].charAt(0);
            }
        }
        
        visited[0][0] = true;
        dfs(0, 0, String.valueOf(grid[0][0]));
        
        System.out.println(answer);
    }
    
    static void dfs(int x, int y, String cur){
        answer = Math.max(answer, cur.length());
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx, ny) && !visited[nx][ny]){
                boolean flag = false;
                for(int j=0; j < cur.length(); j++){
                    if(cur.charAt(j) == grid[nx][ny]){
                        flag = true;
                        break;
                    }
                }
                
                if(!flag){
                    visited[nx][ny] = true;
                    dfs(nx, ny, cur+grid[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }
    
    static boolean inRange(int x, int y){
        return (0 <= x && x < R && 0 <= y && y < C);
    }
}
