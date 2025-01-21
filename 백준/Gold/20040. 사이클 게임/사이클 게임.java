import java.util.*;
import java.io.*;

public class Main {
    public static int[] parents;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int N = Integer.valueOf(input[0]);
        int M = Integer.valueOf(input[1]);
        
        parents = new int[N];
        for(int i=0; i<N; i++){
            parents[i] = i;
        }
        
        boolean flag = false;
        int cnt = 0;
        while(M-- > 0){
            input = br.readLine().split(" ");
            int a = Integer.valueOf(input[0]);
            int b = Integer.valueOf(input[1]);
            
            cnt++;
            if(find(a) != find(b)){
                union(a, b);
            }else{
                flag = true;
                System.out.println(cnt);
                break;
            }
        }
        
        if(!flag) System.out.println(0);
    }
    
    public static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y) return;
        parents[y] = x;
    }
}
