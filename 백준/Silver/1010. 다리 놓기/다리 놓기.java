import java.util.*;


public class Main {
    public static int dp[][] = new int[31][31];
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int west = sc.nextInt();
            int east = sc.nextInt();
            
            // M개에서 N개를 선택.. 서로 중복되면 안된다.. -> 조합!!
            // 교차하면 안되는 조건? -> 조합은 순서에 상관없이 1개로 보기 때문에 고려할 필요 없음!!
            BC(east, west);
            
            System.out.println(dp[east][west]);
            
        }
    }
    
    public static int BC(int x, int y){
        // 이미 풀었던 sub문제일 경우 값을 재활용
        if(dp[x][y] > 0){
            return dp[x][y];
        }
        
        // 2번 성질
        if(x==y || y==0){
            return dp[x][y] = 1;
        }
        
        // 1번 성질
        return dp[x][y] = BC(x-1, y-1) + BC(x-1, y);
    }
}



