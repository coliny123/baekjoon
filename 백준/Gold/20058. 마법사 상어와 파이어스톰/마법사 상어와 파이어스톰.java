import java.util.*;
import java.io.*;

class Node {
    int x, y;

    public Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    public static int N, Q, size;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static Queue<Node> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        Q = Integer.valueOf(input[1]);
        
        size = (int)Math.pow(2, N);
        
        grid = new int[size][size];
        visited = new boolean[size][size];
        
        for(int i=0; i<size; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<size; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        input = br.readLine().split(" ");
        for(int i=0; i<Q; i++){
            int lv = Integer.valueOf(input[i]);
            grid = fireStorm(lv);
            grid = iceBreaking();
        }
        
        int sum = 0;
        int max = 0;
        for(int x=0; x<size; x++){
            for(int y=0; y<size; y++){
                sum += grid[x][y];
                if(!visited[x][y] && grid[x][y] != 0){
                    visited[x][y] = true;
                    q.add(new Node(x, y));
                    max = Math.max(max, BFS());
                }
            }
        }
        
        System.out.println(sum);
        System.out.println(max);
    }

    public static boolean inRange(int x, int y){
        return (0<=x && x<size && 0<=y && y<size);
    }

    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        if(visited[x][y] || grid[x][y] == 0) return false;
        return true;
    }

    public static int BFS(){
        int cnt = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            cnt++;

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(canGo(nx, ny)){
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
        return cnt;
    }

    
    public static int[][] fireStorm(int lv){
        int[][] temp = new int[size][size];
        int len = (int) Math.pow(2,lv);
        
        for(int i=0; i<size; i += len){
            for(int j=0; j<size; j += len){
                turn(i, j, len, temp);
            }
        }
        return temp;
    }

    public static void turn(int x, int y, int len, int[][] temp){
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                temp[x+i][y+j] = grid[x+len-1-j][y+i];
            }
        }
    }

    public static int[][] iceBreaking(){
        int[][] temp = new int[size][size];
		for (int i = 0; i < size; i++) {
			temp[i] = Arrays.copyOf(grid[i], size);
		}
        for(int x=0; x<size; x++){
            for(int y=0; y<size; y++){
                if(grid[x][y] == 0) continue;
                // 사방 체크
                int cnt = 0;
                for(int i=0; i<4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
					if (nx >= 0 && nx < size && ny >= 0 && ny < size) {
						if (grid[nx][ny] > 0) {
							cnt++;
						}
					}
                }
                
                if(cnt<3){
                    temp[x][y]--;
                }
            }
        }

        return temp;
    }
    
}
