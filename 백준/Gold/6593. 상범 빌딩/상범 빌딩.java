import java.util.*;
import java.io.*;

class Node{
    int z, x, y, step;
    
    public Node(int z, int x, int y, int step){
        this.z=z;
        this.x=x;
        this.y=y;
        this.step=step;
    }
}

public class Main {
    static int L, R, C;
    static char[][][] grid;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        while(true){
            String[] input = br.readLine().split(" ");
            L = Integer.valueOf(input[0]);
            R = Integer.valueOf(input[1]);
            C = Integer.valueOf(input[2]);
            
            if(L == 0 && R == 0 && C == 0){
                break;
            }
            
            grid = new char[L][R][C];
            
            Node start = new Node(0,0,0,0);
            Node end = new Node(0,0,0,0);
            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    input = br.readLine().split("");
                    for(int k=0; k<C; k++){
                        grid[i][j][k] = input[k].charAt(0);
                        if(grid[i][j][k] == 'S') {
                            start = new Node(i, j, k, 0);
                        }
                        if(grid[i][j][k] == 'E') {
                            end = new Node(i, j, k, 0);
                        }
                    }
                }
                br.readLine();
            }
            
            int answer = bfs(start, end);
            if(answer == -1){
                sb.append("Trapped!").append("\n");
            }else{
                sb.append("Escaped in ").append(answer).append(" minute(s).").append("\n");
            }
        }
        
        System.out.print(sb);
    }
    
    
    static int bfs(Node start, Node end){
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[L][R][C];
        int[] dx = {0,0,-1,1,0,0};
        int[] dy = {-1,1,0,0,0,0};
        int[] dz = {0,0,0,0,-1,1};
        
        q.add(start);
        visited[start.z][start.x][start.y] = true;
        
        int answer = -1;
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.z == end.z && cur.x == end.x && cur.y == end.y){
                answer = cur.step;
                break;
            }
            
            for(int i=0; i<6; i++){
                int nz = cur.z + dz[i];
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(canGo(nz, nx, ny, visited)){
                    q.add(new Node(nz, nx, ny, cur.step+1));
                    visited[nz][nx][ny] = true;
                }
            }
        }
        
        return answer;
    }
    
    static boolean inRange(int z, int x, int y){
        return(0 <= z && z < L && 0 <= x && x < R && 0 <= y && y < C);
    }
    
    static boolean canGo(int z, int x, int y, boolean[][][] visited){
        if(!inRange(z, x, y)) return false;
        if(visited[z][x][y] || grid[z][x][y] == '#') return false;
        return true;
    }
}
