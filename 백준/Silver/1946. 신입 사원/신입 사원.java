import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.valueOf(br.readLine());
        while(t-- > 0){
            int N = Integer.valueOf(br.readLine());
            int[] interview = new int[N];
            for(int j=0; j<N; j++){
                String[] input = br.readLine().split(" ");
                int p = Integer.valueOf(input[0]) - 1;
                int i = Integer.valueOf(input[1]) - 1;
                interview[p] = i; 
            }
            
            int count = 1;
            int rating = interview[0];
            for(int i=1; i<N; i++){
                if(rating > interview[i]){
                    rating = interview[i];
                    count++;
                }
            }
            
            System.out.println(count);
        }
    }
}
