import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        
        int[] nums = new int[N];
        int[] LIS = new int[N];
        
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.valueOf(input[i]);
        }
        
        
        int length = 1;
        LIS[0] = nums[0];
        for(int i=1; i<N; i++){
            if(LIS[length-1] < nums[i]){
                length++;
                LIS[length-1] = nums[i];
            }else {
                int loc = binarySearch(0, length, nums[i], LIS);
                LIS[loc] = nums[i];
            }
        }
        System.out.println(length);
    }
    
    public static int binarySearch(int st, int ed, int key, int[]LIS){
        int answer = 0;
        while(st <= ed){
            int mid = (st + ed) / 2;
            
            if(LIS[mid] < key){
                st = mid + 1;
            }else{
                ed = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}

