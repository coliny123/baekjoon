import java.util.*;

class Node implements Comparable<Node>{
    int x, y, step;
    
    public Node(int x, int y, int step){
        this.x=x;
        this.y=y;
        this.step=step;
    }
    
    @Override
    public int compareTo(Node o){
        if(step == o.step){
            if(x == o.x){
                return y - o.y;
            }else{
                return x - o.x;
            }
        }else{
            return step - o.step;
        }
    }
}

public class Main {
    public static int N;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static int time=0;
    public static int size=2;
    public static int eatCnt=0;
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        grid = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 9){
                    grid[i][j] = 0;
                    visited[i][j] = true;
                    pq.add(new Node(i, j, 0));
                }
            }
        }
        
        BFS();
        
        
        System.out.println(time);
        
    }
    
    public static void BFS(){
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(0 < grid[cur.x][cur.y] && grid[cur.x][cur.y] < size){
                eatCnt++;
                
                // System.out.println(cur.x + " " + cur.y + " " + cur.step);
                grid[cur.x][cur.y] = 0;
                time = cur.step;
                if(size == eatCnt){
                    size++;
                    eatCnt=0;
                }
                
                // 초기화
                pq.clear();
                visited = new boolean[N][N];

                pq.add(new Node(cur.x, cur.y, 0));
                visited[cur.x][cur.y] = true;
            }
            
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(canGo(nx, ny)){
                    pq.add(new Node(nx, ny, cur.step+1));
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    
    
    public static boolean check(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(0 < grid[i][j] && grid[i][j] < size) return true;
            }
        }
        return false;
    }
    
    
    public static boolean canGo(int x, int y){
        if(0>x || x>=N || 0>y || y>=N) return false;
        if(size < grid[x][y] || visited[x][y]) return false;
        return true;
    }
}
