import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        while(true){
            String[] input = br.readLine().split(" ");
            int N = Integer.valueOf(input[0]);
            int M = Integer.valueOf(input[1]);
            if(N == 0 && M == 0){
                break;
            }
            
            Set<Integer> set = new HashSet<>();
            for(int i=0; i<N; i++){
                set.add(Integer.valueOf(br.readLine()));
            }
            
            int cnt = 0;
            for(int i=0; i<M; i++){
                if(set.contains(Integer.valueOf(br.readLine()))){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
