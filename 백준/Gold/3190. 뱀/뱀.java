import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int[][] grid;
    public static int[][] dirct;
    
    
    public static char[] time = new char[10001];
    public static int[] dx = {-1, 0, 1, 0};   
    public static int[] dy = {0, 1, 0, -1};   // 위, 오, 아, 왼
    
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.valueOf(br.readLine());
        grid = new int[N][N];
        dirct = new int[N][N];
        
        int K = Integer.valueOf(br.readLine());
        while(K-- > 0){
            String[] input = br.readLine().split(" ");
            int x = Integer.valueOf(input[0]) - 1;
            int y = Integer.valueOf(input[1]) - 1;
            
            grid[x][y] = 2;
        }
        
        int L = Integer.valueOf(br.readLine());
        while(L-- > 0){
            String[] input = br.readLine().split(" ");
            time[Integer.valueOf(input[0])] = input[1].charAt(0);
        }
        
        
        for(int i=0; i<N; i++){
            Arrays.fill(dirct[i], -1);
        }
        dirct[0][0] = 1;
        
        int headX = 0;
        int headY = 0;
        int tailX = 0;
        int tailY = 0;
        
        
        int dir = 1;        // 0:위, 1:오, 2:아, 3:왼
        int sec = 0;
        while(true){
            sec++;
            
            int nx = headX + dx[dir];
            int ny = headY + dy[dir];
            
            if(!canGo(nx, ny)) break;
            
            // System.out.println(nx + " " + ny);
            
            
            // 사과를 먹었을 때
            if(grid[nx][ny] == 2){
                grid[nx][ny] = 0;
            }else{
                int tailDir = dirct[tailX][tailY];
                
                dirct[tailX][tailY] = -1;
                
                tailX += dx[tailDir];
                tailY += dy[tailDir];
            }
            
            if(time[sec] == 'D'){
                dir = (dir + 1) % 4;
            }else if(time[sec] == 'L'){
                dir = (dir + 3) % 4;
            }            
            
            dirct[nx][ny] = dir;
            
            headX = nx;
            headY = ny;
        }
        
        
        System.out.println(sec);
    }
    
    
    
    public static boolean inRange(int x, int y){
        return( 0 <= x && x < N && 0 <= y && y < N);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;  // 벽에 부딪히면
        if(dirct[x][y] != -1) return false; // 자기 몸통이면
        return true;
    }
}
