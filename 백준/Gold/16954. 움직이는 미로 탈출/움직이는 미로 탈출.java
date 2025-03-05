import java.util.*;
import java.io.*;

public class Main {
    static char[][] grid = new char[8][8];
    static boolean[][][] times = new boolean[8][8][8]; 
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0; i<8; i++){
            String input = br.readLine();
            for(int j=0; j<8; j++){
                grid[i][j] = input.charAt(j);
            }
        }
        
        for(int sec=0; sec<8; sec++){
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    if(grid[i][j] == '#'){
                        times[i][j][sec] = true;
                    }
                }
            }
            drop();
        }
        // for(int sec=0; sec<8; sec++){
        //   for(int i=0; i<8; i++){
        //       for(int j=0; j<8; j++){
        //         System.out.print(times[i][j][sec] + " ");
        //       }
        //       System.out.println();
        //   }
        //   System.out.println();
        // }
        System.out.println(bfs());
        
    }
    
    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {0,0,0,-1,1,-1,-1,1,1};
        int[] dy = {0,-1,1,0,0,-1,1,1,-1};
        
        q.add(new int[]{7, 0, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            // System.out.println(cur[0] + " " + cur[1] + " " + cur[2]);
            
            if(cur[0] == 0 && cur[1] == 7 || cur[2] >= 9){
                return 1;
            }
            
            for(int i=0; i<9; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(!inRange(nx, ny)) continue;
                if(cur[2] <= 7 && times[nx][ny][cur[2]]) continue;
                if(cur[2] <= 6 && times[nx][ny][cur[2]+1]) continue;
                
                q.add(new int[]{nx, ny, cur[2]+1});
            }
        }
        
        return 0;
    }
    
    static boolean inRange(int x, int y){
        return (0 <= x && x < 8 && 0 <= y && y < 8);
    }
    
    static void drop(){
        char[] createdRow = {'.', '.', '.', '.', '.', '.', '.', '.'};
        for(int i=6; i>=0; i--){
            grid[i+1] = grid[i]; 
        }
        grid[0] = createdRow;
    }
}
