import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, R;
    public static int min;
    public static int[][] grid;
    public static int[] dx = {0, 1, 0, -1}; 
    public static int[] dy = {1, 0, -1, 0};
    
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        R = Integer.valueOf(input[2]);
        
        grid = new int[N][M];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        
        min = Math.min(N, M);
        for(int i=0; i<R; i++){
            rotate();
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
    
    
    public static void rotate(){
        
        for(int i=0; i < min / 2; i++){
            int x = i;
            int y = i;
            
            int temp = grid[x][y];
            
            int idx = 0;
            while(idx < 4){
                
                int nx = x + dx[idx];
                int ny = y + dy[idx];
                if(i <= nx && nx < N-i && i <= ny && ny < M-i){
                    grid[x][y] = grid[nx][ny];
                    x = nx;
                    y = ny;
                }else{
                    idx++;
                }
            }
            
            grid[i+1][i] = temp;
            
        }
        
        
    }
}
