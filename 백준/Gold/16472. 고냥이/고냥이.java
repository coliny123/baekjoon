import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        char[] arr = br.readLine().toCharArray();
        
        int[] alphabet = new int[26];
        
        int st = 0;
        int ed = 0;
        int max = Integer.MIN_VALUE;
        int cnt = 1;
        
        alphabet[arr[ed] - 'a']++;
        
        while(ed < arr.length){
            
            if(cnt <= N){
                max = Math.max(max, ed-st+1);
            }
            
            
            if(cnt <= N){
                ed++;
                if(ed < arr.length){
                    char curChar = arr[ed];
                    if(alphabet[curChar - 'a'] == 0){
                        cnt++;
                    }
                    alphabet[curChar - 'a']++;
                }
            }else{
                char stChar = arr[st];
                alphabet[stChar - 'a']--;
                if(alphabet[stChar - 'a'] == 0){
                    cnt--;
                }
                st++;
            }
        }
        
        System.out.println(max == Integer.MIN_VALUE ? 0 : max);
    }
}
