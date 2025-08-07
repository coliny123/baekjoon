import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] cheese;
    static int[][] contact;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        cheese = new int[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                cheese[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        int answer = 0;
        int time = 0;
        while(true){
            contact = new int[N][M];
            visited = new boolean[N][M];
            
            bfs(0, 0);
            
            boolean notMelt = false;
            int cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(cheese[i][j] == 1 && contact[i][j] >= 1){
                        cheese[i][j] = 0;
                        notMelt = true;
                        cnt++;
                    }
                }
            }
            
            if(!notMelt) break;
            answer = cnt;
            time++;
        }
        
        System.out.println(time);
        System.out.println(answer);
    }
    
    
    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(0 <= nx && nx < N && 0 <= ny && ny < M){
                    if(visited[nx][ny]) continue;
                    if(cheese[nx][ny] == 1){
                        contact[nx][ny]++;
                    }else{
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
