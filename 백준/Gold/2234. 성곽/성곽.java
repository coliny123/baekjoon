import java.util.*;
import java.io.*;

class Node{
    int x, y;
    
    public Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    static int N,M;
    //서: 1, 북: 2, 동:4 ,남:8
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] dz = {1, 2, 4, 8};
    static int[][] grid;
    static int[][] roomNum;
    static HashMap<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.valueOf(input[0]);
        N = Integer.valueOf(input[1]);
        
        grid = new int[N][M];
        roomNum = new int[N][M];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        int num = 1;
        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(roomNum[i][j] == 0){
                    map.put(num, BFS(i, j, num));
                    max = Math.max(max, map.get(num));
                    num++;
                }
            }
        }
        
        int maxSum=0;
        for(int x=0; x<N; x++){
            for(int y=0; y<M; y++){
                for(int k=0; k<4; k++){
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(inRange(nx, ny) && roomNum[x][y] != roomNum[nx][ny]){
                        maxSum = Math.max(maxSum, map.get(roomNum[x][y]) + map.get(roomNum[nx][ny]));
                    }
                }
            }
        }
        
        System.out.println(num-1);
        System.out.println(max);
        System.out.println(maxSum);
    }
    
    public static int BFS(int x, int y, int num){
        Queue<Node> q = new LinkedList<>();
        roomNum[x][y] = num;
        q.add(new Node(x, y));
        // System.out.println(x + " " + y + " " + roomNum[x][y]);
        int size = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            size++;
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(canGo(nx, ny) && (grid[cur.x][cur.y] & dz[i]) != dz[i]){
                    roomNum[nx][ny] = num;
                    q.add(new Node(nx, ny));
                }
            }
        }
        
        return size;
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        if(roomNum[x][y] != 0) return false;
        return true;
    }
}
