import java.util.*;

public class Main {
    public static int N;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        grid = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        
        q.add(new int[]{0,0});
        visited[0][0] = true;
        BFS();
        if(visited[N-1][N-1]) System.out.println("HaruHaru");
        else System.out.println("Hing");
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int i=0; i<4; i++){
                int nx = x + (dx[i]*grid[x][y]);
                int ny = y + (dy[i]*grid[x][y]);
                if(canGo(nx, ny)){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<N);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        if(visited[x][y]) return false;
        return true;
    }
}
