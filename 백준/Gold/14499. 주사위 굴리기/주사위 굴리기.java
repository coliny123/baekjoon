import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int M;
    public static int dice[][];
    public static int grid[][];
    
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        int X = Integer.valueOf(input[2]);
        int Y = Integer.valueOf(input[3]);
        int K = Integer.valueOf(input[4]);
        
        dice = new int[4][3];
        grid = new int[N][M];
        
        for(int i=0; i<N; i++){
            String row[] = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(row[j]);
            }
        }
        int dx[] = {0, 0, 0, -1, 1};
        int dy[] = {0, 1, -1, 0, 0};
        
        int up = dice[1][1];
        StringBuilder sb = new StringBuilder(); 
        String commend[] = br.readLine().split(" ");
        for(int j=0; j<K; j++){
            int dir = Integer.valueOf(commend[j]);
            int nx = X + dx[dir];
            int ny = Y + dy[dir];
            if(inRange(nx, ny)){
                simulation(dir);
                if(grid[nx][ny]==0){
                    grid[nx][ny] = dice[3][1];
                }else{
                    dice[3][1] = grid[nx][ny];
                    grid[nx][ny] = 0;
                }
                sb.append(dice[1][1]).append("\n");
                X=nx;
                Y=ny;
                
            }
        }
        
        System.out.print(sb.toString());
            
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
    
    public static void simulation(int dir){
        if(dir==1){
            int temp = dice[1][2];
            for(int i=2; i>0; i--){
                dice[1][i] = dice[1][i-1];
            }
            dice[1][0] = dice[3][1];
            dice[3][1] = temp;
        }else if(dir==2){
            int temp = dice[1][0];
            for(int i=0; i<2; i++){
                dice[1][i] = dice[1][i+1];
            }
            dice[1][2] = dice[3][1];
            dice[3][1] = temp;
        }else if(dir==3){
            int temp = dice[0][1];
            for(int i=0; i<3; i++){
                dice[i][1] = dice[i+1][1];
            }
            dice[3][1] = temp;
        }else{
            int temp = dice[3][1];
            for(int i=3; i>0; i--){
                dice[i][1] = dice[i-1][1];
            }
            dice[0][1] = temp;
        }
    }
}
