import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] grid;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        visited = new boolean[N][M];
        grid = new int[N][M];
        
        input = br.readLine().split(" ");
        int r = Integer.valueOf(input[0]);
        int c = Integer.valueOf(input[1]);
        int direct = Integer.valueOf(input[2]);
        
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c, direct});
        visited[r][c] = true;
        
        int cnt = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dir = cur[2];
            // System.out.println(x + " " + y + " " + dir);
            
            // 반시계 방향으로 빈칸 있는지 체크
            boolean flag = false;
            for(int i = dir+3; i >= dir; i--){
                int k = i % 4;
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(grid[nx][ny] == 1 || visited[nx][ny]) continue;
                flag = true;
                x = nx;
                y = ny;
                dir = k;
                cnt++;
                break;
            }
            
            if(!flag){
                int k = (dir+2) % 4;
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(grid[nx][ny] == 1){
                    break;
                }
                x = nx;
                y = ny;
            }
            
            q.add(new int[]{x, y, dir});
            visited[x][y] = true;
        }
        
        System.out.println(cnt);
    }
}
