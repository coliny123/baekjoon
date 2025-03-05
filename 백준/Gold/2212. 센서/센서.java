import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        int K = Integer.valueOf(br.readLine());
        int[] sensors = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            sensors[i] = Integer.valueOf(input[i]);
        }
        
        Arrays.sort(sensors);
        
        int[] diff = new int[N-1];
        for(int i=1; i<N; i++){
            diff[i-1] = sensors[i] - sensors[i-1];
        }
        
        Arrays.sort(diff);
        
        int sum = 0;
        for(int i=0; i<N-K; i++){
            sum += diff[i];
        }
        
        System.out.println(sum);
        // System.out.println(Arrays.toString(sensors));
        // System.out.println(Arrays.toString(diff));
    }
}
