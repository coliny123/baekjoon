import java.util.*;
import java.io.*;


class Node{
    int x, y, step, breakingCnt;
    
    public Node(int x, int y, int step, int breakingCnt){
        this.x=x;
        this.y=y;
        this.step=step;
        this.breakingCnt=breakingCnt;
    }
}

public class Main {
    public static int N, M, K;
    public static int[][] grid;
    public static boolean[][][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static int answer = -1;
    public static Queue<Node> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        K = Integer.valueOf(input[2]);
        
        grid = new int[N][M];
        visited = new boolean[N][M][K+1];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        q.add(new Node(0,0,1,0));
        visited[0][0][0] = true;
        BFS();
        
        System.out.println(answer);
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
                    if(grid[nx][ny] == 1 && cur.breakingCnt < K && !visited[nx][ny][cur.breakingCnt+1]){
                        q.add(new Node(nx, ny, cur.step+1, cur.breakingCnt+1));
                        visited[nx][ny][cur.breakingCnt+1] = true;
                    }
                    
                    if(grid[nx][ny] == 0 && !visited[nx][ny][cur.breakingCnt]){
                        q.add(new Node(nx, ny, cur.step+1, cur.breakingCnt));
                        visited[nx][ny][cur.breakingCnt] = true;
                    }
                }
            }
        }
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
}
