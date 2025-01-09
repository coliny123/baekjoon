import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        
        String[] input = br.readLine().split(" ");
        
        int lt = 0;
        int rt = input.length-1;
        
        int max = 0;
        while(lt < rt){
            int left = Integer.valueOf(input[lt]);
            int right = Integer.valueOf(input[rt]);
            
            int min = Math.min(left, right);
            
            int num = rt - lt - 1;
            
            max = Math.max(max, num*min);
            if(min == left){
                lt++;
            }else{
                rt--;
            }
        }
        
        System.out.println(max);
        
    }
}
