import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();
        
        int[][] dp = new int[first.length()+1][second.length()+1];
        
        for(int i=1; i <= first.length(); i++){
            for(int j=1; j <= second.length(); j++){
                if(first.charAt(i-1) == second.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
		// 부분수열 구하기 시작
		int x = first.length();
		int y = second.length();

        StringBuilder sb = new StringBuilder();
		while (x != 0 && y != 0) {
			if (dp[x - 1][y] == dp[x][y]) { // 왼쪽값과 같다
				x -= 1;
			} else if (dp[x][y - 1] == dp[x][y]) { // 윗쪽값과 같다.
				y -= 1;
			} else { // 왼쪽값과 윗쪽값과 같은 경우가 없다.
                sb.append(first.charAt(x - 1));
				x -= 1;
				y -= 1;
			}
		}
        System.out.println(dp[first.length()][second.length()]);
        if(dp[first.length()][second.length()] != 0){
            System.out.println(sb.reverse());
        }
    }
}
