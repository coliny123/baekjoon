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
    public static int N, M;
    public static int[][] grid;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static Node[] route;
    public static int answer = Integer.MAX_VALUE;
    public static ArrayList<Node> virus = new ArrayList<>();
    
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        grid = new int[N][N];
        route = new Node[M];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                grid[i][j] = Integer.valueOf(input[j]);
                if(grid[i][j] == 2){
                    virus.add(new Node(i, j));
                }
            }
        }
        
        peeking(0, 0);
        
        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
        
    }
    
    public static void peeking(int count, int start){
        if(count == M){
            BFS();
            return;
        }
        
        for(int i=start; i<virus.size(); i++){
            route[count] = virus.get(i);
            peeking(count+1, i+1);
        }
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<N);
    }
    
    public static boolean canGo(int x, int y, boolean[][] visited){
        if(!inRange(x, y)) return false;
        if(visited[x][y] || grid[x][y] == 1) return false;
        return true;
    }
    
    public static void BFS(){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int[][] steps = new int[N][N];
        
        for(int i=0; i<M; i++){
            visited[route[i].x][route[i].y] = true;
            q.add(route[i]);
        }
        
        int max = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(canGo(nx, ny, visited)){
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                    steps[nx][ny] = steps[cur.x][cur.y] + 1;
                    max = Math.max(max, steps[nx][ny]);
                }
            }
        }
        
        if(check(visited)){
            answer = Math.min(answer, max);
        }
    }
    
    
    public static boolean check(boolean[][] visited){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(grid[i][j] != 1 && !visited[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
