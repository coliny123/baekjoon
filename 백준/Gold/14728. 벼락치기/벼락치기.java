import java.util.*;
import java.io.*;

class Subject implements Comparable<Subject>{
    int time, score;
    
    public Subject(int time, int score){
        this.time=time;
        this.score=score;
    }
    
    @Override
    public int compareTo(Subject o){
        if(o.time == time){
            return score - o.score;
        }else{
            return time - o.time;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int N = Integer.valueOf(input[0]);
        int T = Integer.valueOf(input[1]);

        Subject[] subjects = new Subject[N]; 
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            subjects[i] = new Subject(Integer.valueOf(input[0]), Integer.valueOf(input[1]));
        }
        
        Arrays.sort(subjects);
        
        int[] dp = new int[T+1];
        for(int i=0; i<N; i++){
            Subject cur = subjects[i];
            for(int j = T; j >= cur.time; j--){
                dp[j] = Math.max(dp[j], dp[j - cur.time] + cur.score);
            }
        }
        
        System.out.println(dp[T]);
    }
}
