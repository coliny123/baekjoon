import java.util.*;
import java.io.*;

public class Main {
    public static int N,C;
    public static int[] houses;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        C = Integer.valueOf(input[1]);
        
        houses = new int[N];
        for(int i=0; i<N; i++){
            houses[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(houses);
        
        
        System.out.println(parametricSearch(1, houses[N - 1]-houses[0]+1, C));
    }
    
    
    
    public static int parametricSearch(int st, int ed, int count){
        int max = 0;
        while(st <= ed){
            int mid = (st + ed + 1) / 2;
            if(counting(mid) >= C){
                st = mid + 1;
                max = Math.max(max, mid);
            }else{
                ed = mid - 1;
            }
        }
        
        return max;
    }
    
    public static int counting(int distance){
        int cnt=1;
        int before = houses[0];
        for(int i=1; i<N; i++){
            if(houses[i] - before >= distance){
                before = houses[i];
                cnt++;
            }
        }
        
        return cnt;
    }
}

