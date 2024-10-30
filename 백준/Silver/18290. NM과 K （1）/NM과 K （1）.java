import java.util.*;

public class Main {
    public static int N, M, K;
    public static int MAX = Integer.MIN_VALUE;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[]dx = {0,0,-1,1};
    public static int[]dy = {-1,1,0,0};
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        
        grid = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                BT(1, i, j, grid[i][j]);
                visited[i][j] = false;
            }
        }
        
        System.out.println(MAX);
        
    }
    
    public static void BT(int depth, int x, int y, int sum){
        if(depth == K){
            MAX = Math.max(MAX, sum);
            return;
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && checkFourSide(i, j)){
                    visited[i][j] = true;
                    BT(depth+1, i, j, sum + grid[i][j]);
                    visited[i][j] = false;
                }
            }
        }
    }
    
    public static boolean checkFourSide(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx, ny) && visited[nx][ny]){
                return false;
            }
        }
        return true;
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
}
