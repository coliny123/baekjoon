import java.util.*;
import java.io.*;

class Node{
    int x, y;
    
    public Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    public static int N;
    public static int[][] grid;
    public static int[][] steps;
    public static boolean[][] visited;
    public static Queue<Node> q = new LinkedList<>();
    public static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.valueOf(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            N = Integer.valueOf(br.readLine());
            grid = new int[N][N];
            steps = new int[N][N];
            visited = new boolean[N][N];
            
            String[] input = br.readLine().split(" ");
            int st_x = Integer.valueOf(input[0]);
            int st_y = Integer.valueOf(input[1]);
            
            input = br.readLine().split(" ");
            int ed_x = Integer.valueOf(input[0]);
            int ed_y = Integer.valueOf(input[1]);
            
            q.add(new Node(st_x, st_y));
            steps[st_x][st_y] = 0;
            visited[st_x][st_y] = true;
            
            BFS(ed_x, ed_y);
            
            sb.append(steps[ed_x][ed_y]).append("\n");
        }
        
        System.out.print(sb);
    }
    
    public static void BFS(int x, int y){
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            // if(cur.x == x && cur.y == y){
                // return;
            // }
            
            for(int i=0; i<8; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(canGo(nx, ny)){
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    steps[nx][ny] = steps[cur.x][cur.y] + 1;
                }
            }
        }
    }
    
    public static boolean inRange(int x, int y){
        return(0<=x && x<N && 0<=y && y<N);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        if(visited[x][y]) return false;
        return true;
    }
}
