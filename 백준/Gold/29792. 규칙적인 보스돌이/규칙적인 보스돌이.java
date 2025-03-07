import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        K = Integer.valueOf(input[2]);
        
        long[] damages = new long[N];
        for(int i=0; i<N; i++){
            damages[i] = Long.valueOf(br.readLine());
        }
        
        Arrays.sort(damages);
        
        long[] hps = new long[K];
        long[] mesos = new long[K];
        for(int i=0; i<K; i++){
            input = br.readLine().split(" ");
            hps[i] = Long.valueOf(input[0]);
            mesos[i] = Long.valueOf(input[1]);
        }
        
        int answer = 0;
        for(int i=N-1; i>=N-M; i--){
            long[] dp = new long[901];
            long damage = damages[i];
            for(int k=0; k<K; k++){
                long hp = hps[k];
                long meso = mesos[k];
                
                long time = hp / damage;
                if(hp % damage != 0) time++;
                
                if(time > 900) continue;
                
                for(int j=900; j >= (int)time; j--){
                    dp[j] = Math.max(dp[j], dp[j-(int)time] + meso);
                }
            }
            answer += dp[900];
        }
        
        System.out.println(answer);
    }
}
