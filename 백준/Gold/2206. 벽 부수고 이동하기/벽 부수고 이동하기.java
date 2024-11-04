import java.util.*;
import java.io.*;

class Node{
    int x, y, step;
    boolean destroy;
    
    public Node(int x, int y, int step, boolean destroy){
        this.x=x;
        this.y=y;
        this.step=step;
        this.destroy=destroy;
    }
}

public class Main {
    public static int N, M;
    public static int[][] grid;
    public static boolean[][][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static Queue<Node> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        visited = new boolean[N][M][2];
        grid = new int[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        q.add(new Node(0, 0, 1, false));
        BFS();
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.x == N-1 && cur.y == M-1){
                System.out.println(cur.step);
                return;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(!inRange(nx, ny)) continue;
                // 벽 안만났을 때
                if(grid[nx][ny] == 0){
                    if(!cur.destroy && !visited[nx][ny][0]){
                        visited[nx][ny][0] = true;
                        q.add(new Node(nx, ny, cur.step+1, false));
                    }else if(cur.destroy && !visited[nx][ny][1]){
                        visited[nx][ny][1] = true;
                        q.add(new Node(nx, ny, cur.step+1, true));
                    }
                }else{
                // 벽 만났을 때
                    if(!cur.destroy){ // 부순적 없을 때만 이동 가능
                        visited[nx][ny][1] = true;
                        q.add(new Node(nx, ny, cur.step+1, true));
                    }
                }
            }
        }
        
        System.out.println(-1);
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
}
