import java.util.*;

class Node{
    int x, y;
    
    public Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    public static int N, M;
    public static int MAX = 0;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static Queue<Node> q;
    public static ArrayList<Node> init = new ArrayList<>();
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        grid = new int[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 2){
                    init.add(new Node(i, j));
                }
            }
        }
        
        DFS(0);
        
        System.out.println(MAX);
        
    }
    
    public static void DFS(int wallCnt){
        if(wallCnt == 3){
            q = new LinkedList<>();
            visited = new boolean[N][M];
            for(int i=0; i<init.size(); i++){
                Node cur = init.get(i);
                push(cur.x, cur.y);
            }
            BFS();
            MAX = Math.max(MAX, count());
            return;
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(grid[i][j] == 0){
                    grid[i][j] = 1;
                    DFS(wallCnt+1);
                    grid[i][j] = 0;
                }
            }
        }
    }

    public static int count(){
        int cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        
        if(visited[x][y] || grid[x][y] == 1) return false;
        
        return true;
    }
    
    public static void push(int x, int y){
        if(canGo(x, y)){
            visited[x][y] = true;
            q.add(new Node(x, y));
        }
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                push(nx, ny);
            }
        }
    }
}
