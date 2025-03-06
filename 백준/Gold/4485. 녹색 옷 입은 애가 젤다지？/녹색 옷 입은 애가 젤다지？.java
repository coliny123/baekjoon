import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] grid;
    static int[][] sum;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int count = 1;
        while(true){
            N = Integer.valueOf(br.readLine());
            if(N == 0) return;
            
            grid = new int[N][N];
            sum = new int[N][N];
            for(int i=0; i<N; i++){
                String[] input = br.readLine().split(" ");
                for(int j=0; j<N; j++){
                    grid[i][j] = Integer.valueOf(input[j]);
                }
                Arrays.fill(sum[i], 1000000); 
            }
            
            dfs();
            
            System.out.println("Problem " + count++ + ": " + sum[N-1][N-1]);
        }
            
    }
    
    static void dfs(){
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        sum[0][0] = grid[0][0];
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(!inRange(nx, ny)) continue;
                if(sum[nx][ny] <= sum[cur[0]][cur[1]] + grid[nx][ny]) continue;
                
                q.add(new int[]{nx, ny});
                sum[nx][ny] = sum[cur[0]][cur[1]] + grid[nx][ny];
            }
        }
    }
    
    static boolean inRange(int x, int y){
        return (0 <= x && x < N && 0 <= y && y < N);
    }
}
