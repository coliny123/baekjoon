import java.util.*;
import java.io.*;

public class Main {
    static int N, M, A, B, K;
    static int[][] grid;
        
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        A = Integer.valueOf(input[2]);
        B = Integer.valueOf(input[3]);
        K = Integer.valueOf(input[4]);
        
        grid = new int[N][M];
        while(K-- > 0){
            input = br.readLine().split(" ");
            int x = Integer.valueOf(input[0]) - 1;
            int y = Integer.valueOf(input[1]) - 1;
            grid[x][y] = 1;
        }
        
        input = br.readLine().split(" ");
        int s_x = Integer.valueOf(input[0]) - 1;
        int s_y = Integer.valueOf(input[1]) - 1;
        input = br.readLine().split(" ");
        int e_x = Integer.valueOf(input[0]) - 1;
        int e_y = Integer.valueOf(input[1]) - 1;
        
        System.out.println(bfs(s_x, s_y, e_x, e_y));
    }
    
    static int bfs(int s_x, int s_y, int e_x, int e_y){
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        
        if(canGo(s_x, s_y, visited)){
            q.add(new int[]{s_x, s_y, 0});
            visited[s_x][s_y] = true;
        }
        
        int answer = -1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == e_x && cur[1] == e_y){
                answer = cur[2];
                break;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(canGo(nx, ny, visited)){
                    q.add(new int[]{nx, ny, cur[2]+1});
                    visited[nx][ny] = true;
                }                
            }
        }
        
        return answer;
    }
    
    static boolean inRange(int x, int y){
        return (0 <= x && x < N-A+1 && 0 <= y && y < M-B+1);
    }
    
   static boolean canGo(int x, int y, boolean[][] visited){
        if(!inRange(x, y)) return false;
        if(visited[x][y]) return false;
        for(int i=x; i<=x+A-1; i++){
            for(int j=y; j<=y+B-1; j++){
                if(grid[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }
}
