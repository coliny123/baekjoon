import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int N = Integer.valueOf(input[0]);
        int K = Integer.valueOf(input[1]);
        
        int[] name = new int[21];      
        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
            if(i <= K){
                int len = arr[i].length();
                name[len]++;
            }
        }
        
        long cnt = 0;
        cnt += --name[arr[0].length()];
        
        for(int i=1; i<N; i++){
            if(i+K < N) name[arr[i+K].length()]++;
            cnt += --name[arr[i].length()];
        }
        
        System.out.println(cnt);
    }
}
