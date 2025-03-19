import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] nums;
    static int[] arr;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        nums = new int[N];
        arr = new int[M];
        
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.valueOf(input[i]);
        }
        
        Arrays.sort(nums);
        
        for(int i=0; i<N; i++){
            bt(0, i);
        }
        
    }
    
    static void bt(int depth, int start){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            if(!set.contains(sb.toString())){
                set.add(sb.toString());
                System.out.println(sb.toString());
            }
            return;
        }
        
        for(int i=start; i<N; i++){
            arr[depth] = nums[i];
            bt(depth+1, i);
        }
    }
}
