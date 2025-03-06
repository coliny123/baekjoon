import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int C = Integer.valueOf(input[1]);
        
        int[] houses = new int[N];
        for(int i=0; i<N; i++){
            houses[i] = Integer.valueOf(br.readLine());
        }
        
        Arrays.sort(houses);
        
        System.out.println(parametricSearch(1, 1000000000, houses, C));
    }
    
    static int parametricSearch(int st, int ed, int[]arr, int minimum){
        
        int answer = 0;
        while(st <= ed){
            int mid = (st + ed) / 2;
            
            int count=0;
            int loc = arr[0];
            for(int i=0; i<arr.length; i++){
                if(arr[i] >= loc){
                    count++;
                    loc = arr[i]+mid;
                }
            }
            
            if(count >= minimum){
                st = mid + 1;
                answer = Math.max(answer, mid);
            }else{
                ed = mid - 1;
            }
        }
        
        return answer;
    }
}
