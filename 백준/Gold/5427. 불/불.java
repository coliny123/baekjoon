import java.util.*;
import java.io.*;

public class Main {
    public static int W, H;
    public static char[][] grid;
    public static int[][] step;
    public static boolean[][] visited;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.valueOf(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            String[] input = br.readLine().split(" ");
            W = Integer.valueOf(input[0]);
            H = Integer.valueOf(input[1]);
            
            q = new LinkedList<>();
            grid = new char[H][W];
            step = new int[H][W];
            
            int[] st = new int[]{0,0,0};
            for(int i=0; i<H; i++){
                String str = br.readLine();
                Arrays.fill(step[i] , 1000000);
                for(int j=0; j<W; j++){
                    grid[i][j] = str.charAt(j);
                    if(grid[i][j] == '*'){
                        q.add(new int[]{i, j, 0});
                        step[i][j] = 0;
                    }
                    if(grid[i][j] == '@'){
                        st[0] = i;
                        st[1] = j;
                    }                
                }
            }
            
            
            BFS();
            
            int result = SangGun(st);
            System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        }
    }
    
    
    public static int SangGun(int[] st){
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        q = new LinkedList<>();
        q.add(st);
        int answer = -1;
        visited = new boolean[H][W];
        visited[st[0]][st[1]] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            // System.out.println(Arrays.toString(cur));
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];      
                
                if( 0 <= nx && nx < H && 0 <= ny && ny < W){
                    if(grid[nx][ny] == '#') continue;
                    if(step[nx][ny] <= cur[2] + 1) continue;
                    if(visited[nx][ny]) continue;
                    
                    q.add(new int[]{nx, ny, cur[2] + 1});
                    visited[nx][ny] = true;
                }else{
                    answer = cur[2] + 1;
                    return answer;
                }         
            }
        }
        
        return answer;
    }
    
    
    public static void BFS(){
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            // System.out.println(Arrays.toString(cur));
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if( 0 <= nx && nx < H && 0 <= ny && ny < W){
                    if(grid[nx][ny] == '#') continue;
                    if(step[nx][ny] <= cur[2] + 1) continue;
                    
                    step[nx][ny] = cur[2] + 1;
                    q.add(new int[]{nx, ny, cur[2] + 1});
                };
            }
        }
    }
}
