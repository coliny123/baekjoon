import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        
        int[] nums = new int[N];
        int[] LDS = new int[N];
        
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.valueOf(input[i]);
        }
        
        Arrays.fill(LDS, 10000001);
        int length = 1;
        LDS[0] = nums[0];
        
        for(int i=1; i<N; i++){
            if(LDS[length-1] > nums[i]){
                LDS[length] = nums[i];
                length++;
            }else{
                int loc = binarySearch(0, length-1, LDS, nums[i]);
                LDS[loc] = nums[i];
            }
            
            // for(int a : LDS){
                // System.out.print(a + " ");
            // }
            // System.out.println();
        }
        
        
        System.out.println(N-length);
    }
    
    public static int binarySearch(int st, int ed, int[] LDS, int key){
        int answer = ed;
        while(st <= ed){
            int mid = (st + ed + 1) / 2;
            
            if(LDS[mid] <= key){
                ed = mid - 1;
                answer = mid;
            }else{
                st = mid + 1;
            }
        }
        return answer;
    }
}
