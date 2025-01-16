import java.util.*;
import java.io.*;

public class Main {
    public static int[][] grid = new int[9][9];
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0; i<9; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<9; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        
        DFS(0, 0);
        
        
    }
    
    
    public static void DFS(int x, int y){
        if(y == 9){
            DFS(x+1, 0);
            return;
        }
        
        if(x == 9){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(grid[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }
        
        if(grid[x][y] == 0){            
            for(int i=1; i<=9; i++){
                if(check(x, y, i)){
                    grid[x][y] = i;
                    DFS(x, y+1);
                }
            }
            grid[x][y] = 0;
            return;
        }
        
        DFS(x, y+1);
    }
    
    public static boolean check(int row, int col, int value){
        // 가로
        for(int i=0; i<9; i++){
            if(grid[row][i] == value){
                return false;
            }
        }
        
        // 세로
        for(int i=0; i<9; i++){
            if(grid[i][col] == value){
                return false;
            }
        }
        
        // 3x3
        int st_row = (row / 3) * 3;
        int st_col = (col / 3) * 3;
        for(int i=st_row; i<st_row+3; i++){
            for(int j=st_col; j<st_col+3; j++){
                if(grid[i][j] == value){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
}
