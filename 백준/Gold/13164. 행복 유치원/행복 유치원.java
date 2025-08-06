import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int N = Integer.valueOf(input[0]);
        int K = Integer.valueOf(input[1]);
        
        int[] arr = new int[N];
        
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(input[i]);
        }
        
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=1; i < N; i++){
            list.add(arr[i] - arr[i-1]);
        }
        
        Collections.sort(list);
        
        // System.out.println(list);
        
        long sum = 0;
        for(int i=0; i < N-K; i++){
            sum += list.get(i);
        }
        
        System.out.println(sum);
    }
}
