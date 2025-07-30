import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[] arr;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        arr = new int[N];
        
        input = br.readLine().split(" ");
        
        // int max = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(input[i]);
            // max = Math.max(max, arr[i]);
        }
        
        System.out.println(parametricSearch(0, 10000));
    }
    
    
    public static int parametricSearch(int st, int ed){
        int min = ed - st;
        
        while(st <= ed){
            int mid = (st + ed) / 2;
            
            if(count(mid) <= M){
                ed = mid - 1;
                min = Math.min(min, mid);
            }else{
                st = mid + 1;
            }
            
        }
        
        return min;
    }
    
    
    public static int count(int mid){
        int cnt = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<N; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if(max - min > mid){
                cnt++;
                min = Integer.MAX_VALUE;;
                max = Integer.MIN_VALUE;
                i--;
            }
        }
        
        return cnt;
    }
}
