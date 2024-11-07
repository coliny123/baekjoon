import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, A, B, K, sX, sY, eX, eY;
    public static int[][] grid;
    public static int[][] step;
    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        A = Integer.valueOf(input[2]);
        B = Integer.valueOf(input[3]);
        K = Integer.valueOf(input[4]);
        
        step = new int[N][M];
        grid = new int[N][M];
        visited = new boolean[N][M];
        
        while(K-- > 0){
            input = br.readLine().split(" ");
            int x = Integer.valueOf(input[0])-1;
            int y = Integer.valueOf(input[1])-1;
            
            grid[x][y] = 1;
        }
        
        input = br.readLine().split(" ");
        sX = Integer.valueOf(input[0])-1;
        sY = Integer.valueOf(input[1])-1;
        
        input = br.readLine().split(" ");
        eX = Integer.valueOf(input[0])-1;
        eY = Integer.valueOf(input[1])-1;
        
        visited[sX][sY] = true;
        q.add(new int[]{sX, sY});
        BFS();
        
        
        // for(int i=0; i<N; i++){
            // for(int j=0; j<M; j++){
                // System.out.print(step[i][j] + " ");
            // }
            // System.out.println();
        // }
        
        if(step[eX][eY] == 0){
            System.out.println(-1);
        }else{
            System.out.println(step[eX][eY]);
        }
        
    }
    
    
    public static void BFS(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(canGo(nx, ny)){
                    q.add(new int[]{nx, ny});
                    step[nx][ny] = step[cur[0]][cur[1]]+1;
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x+A-1<N && 0<=y && y+B-1<M);
    }
    
    public static boolean canGo(int x, int y){
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
