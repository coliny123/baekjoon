import java.util.*;
import java.io.*;


public class Main {
    public static int N, M;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        grid = new int[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }

        int year = 0;
        while(true){
            // 덩어리 카운트
            int count = 0;
            q = new LinkedList<>();
            visited = new boolean[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(grid[i][j] != 0 && !visited[i][j]){
                        visited[i][j] = true;
                        q.add(new int[]{i, j});
                        BFS();
                        count++;
                    }
                }
            }
            
            if(count > 1){
                System.out.println(year);
                return;
            }else if(count == 0){
                System.out.println(0);
                return;
            }
            
            
            // 녹이기
            grid = malting();
            year++;
        }
                
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        if(visited[x][y] || grid[x][y] == 0) return false;
        return true;
    }
    
    public static int[][] malting(){
        int[][] temp = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                temp[i][j] = grid[i][j];  // 깊은 복사(deep copy)
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int count = 0;
                if(grid[i][j] != 0){
                    for(int k=0; k<4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(inRange(nx, ny) && grid[nx][ny] == 0){
                            count++;
                        }
                    }
                }
                temp[i][j] -= count;
                if(temp[i][j] < 0) temp[i][j] = 0;
            }
        }
        
        return temp;
    }

    public static void BFS(){
      while (!q.isEmpty()) {
        int[] cur = q.poll();

        for(int i=0; i<4; i++){
          int nx = cur[0] + dx[i];
          int ny = cur[1] + dy[i];
          if(canGo(nx, ny)){
            visited[nx][ny] = true;
            q.add(new int[]{nx, ny});
          }
        }
      }
    }
}
