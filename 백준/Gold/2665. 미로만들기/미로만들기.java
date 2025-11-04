import java.util.*;
import java.io.*;


class Node {
    int x, y;
    
    public Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    static int N;
    static int[][] grid;
    static int[][] change;
    
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.valueOf(br.readLine());
        grid = new int[N][N];
        change = new int[N][N];
        
        for(int i=0; i<N; i++){
            String input = br.readLine();
            Arrays.fill(change[i], 100000000);
            for(int j=0; j<N; j++){
                grid[i][j] = input.charAt(j) - '0';
                
            }
        }
        
        
        
        bfs();
        
        System.out.println(change[N-1][N-1]);
    }
    
    
    static void bfs(){
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        change[0][0] = 0;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(!inRange(nx, ny)) continue;
                
                int add = (grid[nx][ny] == 1) ? 0 : 1;
        
                if (change[cur.x][cur.y] + add >= change[nx][ny]) continue;
                
                if(grid[nx][ny] == 1){
                    change[nx][ny] = change[cur.x][cur.y];
                }else{
                    change[nx][ny] = change[cur.x][cur.y] + 1;
                }
                
                q.add(new Node(nx, ny));
            }
            
        }
    }
    
    
    
    static boolean inRange(int x, int y){
        return ( 0 <= x && x < N && 0 <= y && y < N);
    }
}
