import java.util.*;
import java.io.*;


class Node{
    int x, y, step, breakingCnt;
    boolean day;
    
    public Node(int x, int y, int step, int breakingCnt, boolean day){
        this.x=x;
        this.y=y;
        this.step=step;
        this.breakingCnt=breakingCnt;
        this.day=day;
    }
}

public class Main {
    public static int N, M, K;
    public static int[][] grid;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        K = Integer.valueOf(input[2]);
        
        grid = new int[N][M];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        int answer = bfs();
        
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        
    }
    
    public static int bfs(){
        Queue<Node> q = new LinkedList<>();
        int[][][] visited = new int[N][M][K+1];
        for(int i = 0; i<N; i++){
            for(int j=0; j<M; j++){
                Arrays.fill(visited[i][j], 10000000);
            }
        }
        Arrays.fill(visited[0][0], 0);
        q.add(new Node(0, 0, 0, 0, true));  // x, y, step, breakingCnt, day
        
        int answer = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            // System.out.println(cur.x + " " + cur.y + " " + cur.day + " " + cur.step + " " + cur.breakingCnt);
            if(cur.x == N-1 && cur.y == M-1){
                answer = Math.min(answer, cur.step+1);
                continue;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(!inRange(nx, ny)) continue;
                
                // 벽일 때 이동 가능한 경우
                if(grid[nx][ny] == 1 && cur.breakingCnt < K && visited[nx][ny][cur.breakingCnt] > cur.step + 1){
                    if(cur.day){ // 낮일 때는 벽 부술수 있음
                        visited[nx][ny][cur.breakingCnt] = cur.step + 1;
                        q.add(new Node(nx, ny, cur.step+1, cur.breakingCnt+1, !cur.day));
                    }else{ // 밤에는 제자리에서 step만 추가
                        q.add(new Node(cur.x, cur.y, cur.step+1, cur.breakingCnt, !cur.day));
                    }
                }else if(grid[nx][ny] == 0 && visited[nx][ny][cur.breakingCnt] > cur.step + 1){
                    visited[nx][ny][cur.breakingCnt] = cur.step + 1;
                    q.add(new Node(nx, ny, cur.step+1, cur.breakingCnt, !cur.day));
                }
                
            }
            
        }
        
        return answer;
    }
    
    public static boolean inRange(int x, int y){
        return (0 <= x && x < N && 0 <= y && y < M);
    }
    
}
