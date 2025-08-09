import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int tcnt = 0, gcnt = 0, fcnt = 0, pcnt = 0;
        int ans = 0;
        
        int[][][][] dp = new int[3][3][3][3]; 
        dp[0][0][0][0] = 1;
        
        sc.nextLine();
        String str = sc.nextLine();
        for(int i=0; i<N; i++){
            char load = str.charAt(i);
            
            if(load == 'T'){
                tcnt = (tcnt + 1) % 3;
            }else if(load == 'G'){
                gcnt = (gcnt + 1) % 3;
            }else if(load == 'F'){
                fcnt = (fcnt + 1) % 3;
            }else if(load == 'P'){
                pcnt = (pcnt + 1) % 3;
            }
            
            
            ans += dp[tcnt][gcnt][fcnt][pcnt];
            dp[tcnt][gcnt][fcnt][pcnt] += 1;
        }
        
        System.out.println(ans);
    }
}
