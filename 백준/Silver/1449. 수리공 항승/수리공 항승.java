import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int L = Integer.valueOf(input[1]);
        
        int[] holes = new int[N];
        
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            holes[i] = Integer.valueOf(input[i]);
        }
        
        Arrays.sort(holes);
        
        int cnt = 1;
        int st = holes[0] - 1;
        for(int i=1; i<N; i++){
            if(st + L < holes[i]){
                st = holes[i] - 1;
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}
