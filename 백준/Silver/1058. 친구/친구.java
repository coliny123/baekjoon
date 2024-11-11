import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        
        int[][] friends = new int[N][N];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<N; j++){
                friends[i][j] = input.charAt(j) == 'Y' ? 1 : 100000000;
            }
        }
        
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(i==j) continue;
                    friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
                }
            }
        }
        
        int max=0;
        for(int i=0; i<N; i++){
            int cnt = 0;
            for(int j=0; j<N; j++){
                if(friends[i][j] <= 2) cnt++;
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
