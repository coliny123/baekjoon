import java.util.*;


public class Main {
    static int N;
    static int answer=0;
    static int[] grid;
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new int[N];
        
        dfs(0);
        
        System.out.println(answer);
    }
    
    static void dfs(int row){
        if(row == N){
            answer++;
            return;
        }
        
        for(int i=0; i<N; i++){
            grid[row] = i;
            if(canGo(row)){
                dfs(row+1);
            }
        }
        
        
    }
    
    static boolean canGo(int col){
        for(int i=0; i<col; i++){
            if(grid[col] == grid[i]){
                return false;
            }else if(Math.abs(col - i) == Math.abs(grid[col] - grid[i])){
                return false;
            }
        }
        
        return true;
    }
}
