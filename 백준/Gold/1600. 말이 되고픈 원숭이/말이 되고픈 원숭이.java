import java.util.*;
import java.io.*;

public class Main {
      public static int W, H, K;
      public static int answer = -1;
      public static int[][] grid;
      public static boolean[][][] visited;
      public static Queue<int[]> q = new LinkedList<>();
      public static int[] hdx = {-2, -1, 1, 2, 2, 1, -1, -2};
      public static int[] hdy = {1, 2, 2, 1, -1, -2, -2, -1};
      public static int[] dx = {0,0,-1,1};
      public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.valueOf(br.readLine());
        String[] input = br.readLine().split(" ");
        H =Integer.valueOf(input[0]);
        W =Integer.valueOf(input[1]);
        
        grid = new int[W][H];
        visited = new boolean[W][H][K+1];
        for(int i=0; i<W; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<H; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        visited[0][0][K] = true;
        q.add(new int[]{0,0,K,0});
        BFS();
        
        System.out.println(answer);
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<W && 0<=y && y<H);
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == W-1 && cur[1] == H-1){
                answer = cur[3];
                return;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(inRange(nx, ny) && grid[nx][ny] != 1 && !visited[nx][ny][cur[2]]){
                    visited[nx][ny][cur[2]] = true;
                    q.add(new int[]{nx, ny, cur[2], cur[3]+1});
                }
            }
            if(cur[2] > 0){
                for(int i=0; i<8; i++){
                    int nx = cur[0] + hdx[i];
                    int ny = cur[1] + hdy[i];
                    if(inRange(nx, ny) && grid[nx][ny] != 1 && !visited[nx][ny][cur[2]-1]){
                        visited[nx][ny][cur[2]-1] = true;
                        q.add(new int[]{nx, ny, cur[2]-1, cur[3]+1});
                    }
                }
            }
        }
    }
}
