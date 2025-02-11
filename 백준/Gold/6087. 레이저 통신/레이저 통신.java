import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int x, y, dir, turn;
    
    public Node(int x, int y, int dir, int turn){
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.turn=turn;
    }
    
    @Override
    public int compareTo(Node o){
        return turn - o.turn;
    }
}

public class Main {
    public static int N, M;
    public static char[][] grid;
    public static int[][][] turns;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        M = Integer.valueOf(input[0]);
        N = Integer.valueOf(input[1]);
        
        grid = new char[N][M];
        turns= new int[N][M][4];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                Arrays.fill(turns[i][j], 10000000);
            }
        }
        
        ArrayList<int[]> nodes = new ArrayList<>();
        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                grid[i][j] = input[j].charAt(0);
                if(grid[i][j] == 'C'){
                    nodes.add(new int[]{i, j});
                }
            }
        }
        
        int[] start = nodes.get(0);
        int[] end = nodes.get(1);
        
        System.out.println(bfs(start, end));
    }
    
    public static int bfs(int[] start, int[] end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(turns[start[0]][start[1]], 0);
        pq.add(new Node(start[0], start[1], -1, 0));
        
        int answer = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
        
            if(cur.x == end[0] && cur.y == end[1]){
                answer = Math.min(answer, cur.turn);
                continue;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                // 0:서 / 1:동 / 2:남 / 3:북
                if(!canGo(nx, ny)) continue;
                
                // 처음 시작하거나 /
                if(cur.dir == -1 || i == cur.dir){
                    if(turns[nx][ny][i] > turns[cur.x][cur.y][i]){
                        turns[nx][ny][i] = turns[cur.x][cur.y][i];
                        pq.add(new Node(nx, ny, i, cur.turn));
                    }
                }else if(i != cur.dir){
                    if(turns[nx][ny][i] > turns[cur.x][cur.y][cur.dir] + 1){
                        turns[nx][ny][i] = turns[cur.x][cur.y][cur.dir] + 1;
                        pq.add(new Node(nx, ny, i, cur.turn+1));
                    }
                }
            }
        }
        
        return answer;
    }
    
    
    public static boolean inRange(int x, int y){
        return (0 <= x && x < N && 0 <= y && y < M);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        if(grid[x][y] == '*') return false;
        return true;
    }
}
