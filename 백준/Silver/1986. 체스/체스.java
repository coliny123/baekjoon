import java.util.*;


public class Main {
    public static int N, M;
    public static int[][] board;
    public static ArrayList<int[]> list = new ArrayList<>();
    
    
    public static int[] dxQ = {-1, 1, -1, 1, 1, 0, -1, 0};
    public static int[] dyQ = {-1, 1, 1, -1, 0, 1, 0, -1};
    public static int[] dxK = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int[] dyK = {-2, -1, 1, 2, 2, 1, -1, -2};
    
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        board = new int[N][M];
        
        
        for(int i=1; i<=3; i++){
            int cnt = sc.nextInt();
            for(int j=0; j<cnt; j++){
                int x = sc.nextInt()-1;
                int y = sc.nextInt()-1;

                board[x][y] = i;
                list.add(new int[]{x, y, i});
            }
        }
        // simulate();
        System.out.println(getSafeZone());
    }
    
    public static void simulate(){
        for(int[] node : list){
            // Queen
            if(node[2] == 1){
                for(int i=0; i<8; i++){
                  int x = node[0];
                  int y = node[1];
                  while(true){
                      int nx = x + dxQ[i];
                      int ny = y + dyQ[i];
                      if(!canGo(nx, ny)) break;
                      
                      board[nx][ny] = -1;
                      x=nx;
                      y=ny;
                  }
                }
            }
            // Knight
            if(node[2] == 2){
                for(int i=0; i<8; i++){
                    int nx = node[0] + dxK[i];
                    int ny = node[1] + dyK[i];
                    if(canGo(nx, ny)){
                        board[nx][ny] = -1;
                    }
                }
            }
        }
    }
    
    public static int getSafeZone(){
        simulate();
        int cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 0){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    public static boolean canGo(int x, int y){
        if(0>x || x>=N || 0>y || y>=M) return false;
        if(board[x][y] == 1 || board[x][y] == 2 || board[x][y] == 3 ) return false;
        return true;
    }
}
