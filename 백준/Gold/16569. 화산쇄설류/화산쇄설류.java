import java.util.*;
import java.io.*;

class Node{
    int x, y, t, what;
}

public class Main {
    public static int N, M, V, X, Y, T, MaxHigh, Time;
    public static int[][] grid;
    public static int[][] volcano;
    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static TreeSet<int[]> set = new TreeSet<>((o1, o2) -> {
        if(o1[0] == o2[0]){
            return o1[1]-o2[1];
        }else{
            return o1[0]-o2[0];
        }
    });
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        V = Integer.valueOf(input[2]);
        
        volcano = new int[N][M];
        for(int i=0; i<N; i++){
            Arrays.fill(volcano[i], Integer.MAX_VALUE);
        }
        
        visited = new boolean[N][M];
        grid = new int[N][M];
        
        input = br.readLine().split(" ");
        X = Integer.valueOf(input[0])-1;
        Y = Integer.valueOf(input[1])-1;
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        
        while(V-- > 0){
            input = br.readLine().split(" ");
            int x = Integer.valueOf(input[0])-1;
            int y = Integer.valueOf(input[1])-1;
            int t = Integer.valueOf(input[2]);
            volcano[x][y] = t;
            q.add(new int[]{x, y});
            set.add(new int[]{x, y});
        }
        volcanoBFS();
        
        visited[X][Y] = true;
        q.add(new int[]{X, Y, 0});
        manBFS();
        
        System.out.println(MaxHigh + " " + Time);
    }
    
    public static void manBFS(){
        MaxHigh=0;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(MaxHigh < grid[cur[0]][cur[1]]){
                MaxHigh = grid[cur[0]][cur[1]];
                Time = cur[2];
            }
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(inRange(nx, ny) && !visited[nx][ny] && volcano[nx][ny] > cur[2]+1 && !set.contains(new int[]{nx, ny})){
                    q.add(new int[]{nx, ny, cur[2]+1});
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    public static void volcanoBFS(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(inRange(nx, ny) && volcano[nx][ny] > volcano[cur[0]][cur[1]]+1){
                    volcano[nx][ny] = volcano[cur[0]][cur[1]]+1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
    
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        return true;
    }
    
    
}
