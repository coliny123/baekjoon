import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static char[][] grid;
    static int[][] water;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        R = Integer.valueOf(input[0]);
        C = Integer.valueOf(input[1]);
        
        grid = new char[R][C];
        water = new int[R][C];
        
        int[] st = {0,0,0};
        for(int i=0; i<R; i++){
            Arrays.fill(water[i], 1000000);
            input = br.readLine().split("");
            for(int j=0; j<C; j++){
                grid[i][j] = input[j].charAt(0);
                
                if(grid[i][j] == '*'){
                    q.add(new int[]{i, j, 0});
                    water[i][j] = 0;
                }else if(grid[i][j] == 'S'){
                    st[0] = i;
                    st[1] = j;
                }
            }
        }
        
        
        // 물 차는 시간
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(!canGo(nx, ny)) continue;
                if(grid[nx][ny] == 'D') continue;
                if(water[nx][ny] <= cur[2] + 1) continue;
                
                q.add(new int[]{nx, ny, cur[2]+1});
                water[nx][ny] = cur[2] + 1;
            }
        }
        
        int result = BFS(st);
        System.out.println(result == -1 ? "KAKTUS" : result);
    }
    
    
    
    static boolean inRange(int x, int y){
        return (0 <= x && x < R && 0 <= y && y < C);
    }
    
    static boolean canGo(int x, int y){
        if(!inRange(x , y)) return false;
        if(grid[x][y] == 'X') return false;
        return true;
    }
    
    
    static int BFS(int[] st){
        q = new LinkedList<>();
        q.add(st);
        
        int answer = -1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(grid[cur[0]][cur[1]] == 'D'){
                answer = cur[2];
                break;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(!canGo(nx, ny)) continue;
                if(water[nx][ny] <= cur[2] + 1) continue;
                
                q.add(new int[]{nx, ny, cur[2] + 1});
                water[nx][ny] = cur[2] + 1;
            }
        }
        
        return answer;
    }
}
