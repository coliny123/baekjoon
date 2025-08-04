import java.util.*;
import java.io.*;

public class Main {
    public static int[][] grid;
    public static boolean[] visited;
    public static int answer = 0;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int T = Integer.valueOf(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            grid = new int[11][11];
            visited = new boolean[11];
            answer = 0;
            
            for(int i=0; i<11; i++){
                String[] input = br.readLine().split(" ");
                for(int j=0; j<11; j++){
                    grid[i][j] = Integer.valueOf(input[j]);
                }
            }
            
            BT(0, 0);
            
            sb.append(answer).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static void BT(int pos, int sum){
        if(pos == 11){
            answer = Math.max(answer, sum);
            return;
        }
        
        
        for(int i = 0; i < 11; i++) {
            if(!visited[i] && grid[pos][i] != 0) {
                visited[i] = true;
                BT(pos + 1, sum + grid[pos][i]);
                visited[i] = false;
            }
        }        
        
    }
}
