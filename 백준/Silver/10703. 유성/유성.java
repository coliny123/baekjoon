import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int R = Integer.valueOf(input[0]);
        int S = Integer.valueOf(input[1]);
        
        
        char[][] grid = new char[R][S];
        int[] star = new int[S];
        int[] ground = new int[S];
        
        Arrays.fill(star, -1);
        Arrays.fill(ground, 3000);
        for(int i=0; i<R; i++){
            input = br.readLine().split("");
            for(int j=0; j<S; j++){
                grid[i][j] = input[j].charAt(0);
                if(grid[i][j] == 'X') star[j] = i;
                if(grid[i][j] == '#' && ground[j] >= i) ground[j] = i;
            }
        }
        
        
        int minDist = 3000;
        for(int i=0; i<S; i++){
            if(star[i] < 0) continue;
            minDist = Math.min(minDist, ground[i] - star[i] - 1);
        }
        
        
        for(int i=R-1; i>=0; i--){
            for(int j=0; j<S; j++){
                if(grid[i][j] == 'X'){
                    grid[i + minDist][j] = 'X';
                    grid[i][j] = '.';
                }
            }
        }
        
        // System.out.println(Arrays.toString(star));
        // System.out.println(Arrays.toString(ground));
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<R; i++){
            // System.out.println(Arrays.toString(grid[i]));
            for(int j=0; j<S; j++){
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
