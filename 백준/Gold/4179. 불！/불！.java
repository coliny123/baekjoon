import java.util.*;
import java.io.*;

class Node{
    int x, y, step;
    
    public Node(int x, int y, int step){
        this.x=x;
        this.y=y;
        this.step=step;
    }
}

public class Main {
    public static int N, M;
    public static int answer = 0;
    public static char[][] grid;
    public static int[][] steps;
    public static int[][] jsteps;
    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static Queue<Node> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        grid = new char[N][M];
        steps = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            Arrays.fill(steps[i], 1000000);
        }
        
        int j_x = 0;
        int j_y = 0;
        
        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                grid[i][j] = input[j].charAt(0);
                
                if(grid[i][j] == 'J'){
                    j_x = i;
                    j_y = j;
                }
                
                if(grid[i][j] == 'F'){
                    visited[i][j] = true;
                    steps[i][j] = 0;
                    q.add(new Node(i, j, 0));
                }
            }
        }
        
        // 불 먼저 bfs
        BFS();
        
        // for(int i=0; i<N; i++){
            // for(int j=0; j<M; j++){
                // System.out.print(steps[i][j] + " ");
            // }
            // System.out.println();
        // }
        // System.out.println();
        
        // 지훈이 bfs
        JBFS(j_x, j_y);
        
        // for(int i=0; i<N; i++){
            // for(int j=0; j<M; j++){
                // System.out.print(jsteps[i][j] + " ");
            // }
            // System.out.println();
        // }
        
        System.out.println(answer == 0 ? "IMPOSSIBLE" : answer);
        
    }
    
    
    public static void JBFS(int x, int y){
        q = new LinkedList<>();
        visited = new boolean[N][M];
        visited[x][y] = true;
        q.add(new Node(x, y, 0));
        
        jsteps = new int[N][M];
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                // 탈출 체크
                if(escape(nx, ny)){
                    answer = cur.step+1;
                    return;
                }
                
                if(JcanGO(nx, ny, cur.step+1)){
                    visited[nx][ny] = true;
                    jsteps[nx][ny] = cur.step+1;
                    q.add(new Node(nx, ny, cur.step+1));
                }
                
            }
        }
        
    }
    
    // 0>nx || nx <=N || 0>ny || ny<=M
    public static boolean escape(int x, int y){
        if(inRange(x, y)) return false;
        return true;
    }
    
    public static boolean JcanGO(int x, int y, int step){
        if(!inRange(x, y)) return false;
        if(grid[x][y] == '#' || visited[x][y]) return false;
        if(steps[x][y] <= step) return false;
        return true; 
    }
    
    
    // 불
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        if(grid[x][y] == '#' || visited[x][y]) return false;
        return true;
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(canGo(nx, ny)){
                    visited[nx][ny] = true;
                    steps[nx][ny] = cur.step+1;
                    q.add(new Node(nx, ny, cur.step+1));
                }
            }
        }
    }
}
