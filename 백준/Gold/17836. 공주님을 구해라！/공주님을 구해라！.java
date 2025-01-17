import java.util.*;
import java.io.*;

class Node {
    int x, y, step;
    boolean get;
    
    public Node(int x, int y, int step, boolean get){
        this.x=x;
        this.y=y;
        this.step=step;
        this.get=get;
    }
}

public class Main {
    public static int N, M, T;
    public static int answer=0;
    public static int[][] grid;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static boolean[][][] visited;
    public static Queue<Node> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        T = Integer.valueOf(input[2]);
        
        grid = new int[N][M];
        visited = new boolean[N][M][2];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        if(grid[0][0]==2){
            q.add(new Node(0, 0, 0, true));
        }else{
            q.add(new Node(0, 0, 0, false));
        }
        
        BFS();
        
        System.out.println(answer > T || answer == 0 ? "Fail" : answer);
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.x == N-1 && cur.y == M-1){
                answer = cur.step;
                return;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(inRange(nx, ny)){
                    // 그람 없음
                    if(!cur.get){
                        if(!visited[nx][ny][0] && grid[nx][ny] == 0){
                            visited[nx][ny][0] = true;
                            q.add(new Node(nx, ny, cur.step+1, false));
                        }else if(!visited[nx][ny][0] && grid[nx][ny] == 2){
                            visited[nx][ny][0] = true;
                            q.add(new Node(nx, ny, cur.step+1, true));
                        }
                    } // 그람 있음
                    else{
                        if(!visited[nx][ny][1]){
                            visited[nx][ny][1] = true;
                            q.add(new Node(nx, ny, cur.step+1, true));
                        }
                    }
                }
            }
        }
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
}
