import java.util.*;
import java.io.*;

public class Main {
    public static int N,M;
    public static char[][] grid;
    public static boolean[][] visited;
    public static Queue<int[]> q = new LinkedList<>();
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        grid = new char[M][N];
        visited = new boolean[M][N];
        for(int i=0; i<M; i++){
            String row = br.readLine();
            for(int j=0; j<N; j++){
                grid[i][j] = row.charAt(j);
            }
        }
        
        int wPower = 0;
        int bPower = 0;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                int power = 0;
                if(canGo(i, j)){
                    push(i, j);
                    power = BFS();
                }
                if(grid[i][j] == 'W') wPower += power;
                else bPower += power;
            }
        }
        
        System.out.println(wPower + " " + bPower);
        
    }
    
    public static int BFS(){
        int cnt=0;
        while(!q.isEmpty()){
            cnt++;
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(canGo(nx, ny) && grid[cur[0]][cur[1]] == grid[nx][ny]){
                    push(nx, ny);
                }
            }
        }
        
        return (int)Math.pow(cnt, 2);
    }
    
    public static void push(int x, int y){
        visited[x][y] = true;
        q.add(new int[]{x, y});
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<M && 0<=y && y<N);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        if(visited[x][y]) return false;
        return true;
    }
}
