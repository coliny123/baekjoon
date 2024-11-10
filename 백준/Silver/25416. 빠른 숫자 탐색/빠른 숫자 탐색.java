import java.util.*;
import java.io.*;

public class Main {
    public static int[][] grid = new int[5][5];
    public static boolean[][] visited = new boolean[5][5];
    public static int[][] step = new int[5][5];
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
        String[] input;
        for(int i=0; i<5; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<5; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        input = br.readLine().split(" ");
        int r = Integer.valueOf(input[0]);
        int c = Integer.valueOf(input[1]);
        
        q.add(new int[]{r,c});
        visited[r][c]=true;
        BFS();
    }
    
    
    public static void BFS(){
        boolean find = false;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(grid[cur[0]][cur[1]] == 1){
                find = true;
                System.out.println(step[cur[0]][cur[1]]);
                break;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(canGo(nx, ny)){
                    step[nx][ny] = step[cur[0]][cur[1]]+1;
                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        if(!find){
            System.out.println(-1);
        }
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<5 && 0<=y && y<5);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        if(visited[x][y] || grid[x][y] == -1) return false;
        return true;
    }
}
