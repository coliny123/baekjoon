import java.io.*;
import java.util.*;


class Node {
    int x, y, dir, step;
    
    public Node(int x, int y, int dir, int step){
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.step=step;
    }
}

public class Main {
    public static int M, N;
    public static int[][] grid;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.valueOf(input[0]);
        N = Integer.valueOf(input[1]);
        
        grid = new int[M][N];
        
        
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        input = br.readLine().split(" ");
        Node start = new Node(Integer.valueOf(input[0])-1, Integer.valueOf(input[1])-1, Integer.valueOf(input[2])-1, 0);
        input = br.readLine().split(" ");
        Node finish = new Node(Integer.valueOf(input[0])-1, Integer.valueOf(input[1])-1, Integer.valueOf(input[2])-1, 0);
        
        System.out.println(BFS(start, finish));
        
    }
    
    
    public static int BFS(Node start, Node finish){
        int answer = 0;
        int[][][] steps = new int[M][N][4];
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                Arrays.fill(steps[i][j], 1000000);
            }
        }
        
        q.add(start);
        steps[start.x][start.y][start.dir] = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.x == finish.x && cur.y == finish.y && cur.dir == finish.dir){
                answer = cur.step;
                break;
            }

            //    3
            // 1 cur 0
            //    2

            // turn 좌우
            for(int i=0; i<2; i++){
                int nd = cur.dir;
                if(cur.dir == 0){
                  if(i == 0) nd = 3;
                  else nd = 2;
                }
                if(cur.dir == 1){
                  if(i == 0) nd = 2;
                  else nd = 3;
                }
                if(cur.dir == 2){
                  if(i == 0) nd = 0;
                  else nd = 1;
                }
                if(cur.dir == 3){
                  if(i == 0) nd = 1;
                  else nd = 0;
                }
                if(steps[cur.x][cur.y][nd] > cur.step + 1){
                    q.add(new Node(cur.x, cur.y, nd, cur.step+1));
                    steps[cur.x][cur.y][nd] = cur.step+1;
                }
            }
            
            // go 1,2,3
            for(int i=1; i<4; i++){
                int nx = cur.x;
                int ny = cur.y;
                if(cur.dir == 0) ny = cur.y + i;
                if(cur.dir == 1) ny = cur.y - i;
                if(cur.dir == 2) nx = cur.x + i;
                if(cur.dir == 3) nx = cur.x - i;
                if(!canGo(nx, ny)) break;
                if(canGo(nx,ny) && steps[nx][ny][cur.dir] > cur.step + 1){
                    q.add(new Node(nx, ny, cur.dir, cur.step+1));
                    steps[nx][ny][cur.dir] = cur.step+1;
                }
            }
        }
        
        
        return answer;
    }
    
    
    public static boolean inRange(int x, int y){
        return (0 <= x && x < M && 0 <= y && y < N);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        if(grid[x][y] == 1) return false;
        return true;
    }
}
