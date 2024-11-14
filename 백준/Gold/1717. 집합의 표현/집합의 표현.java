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
        
        parents = new int[N+1];
        for(int i=1; i<=N; i++){
            parents[i] = i;
        }
        
        
        StringBuilder sb = new StringBuilder();
        while(M-- > 0){
            input = br.readLine().split(" ");
            int commend = Integer.valueOf(input[0]);
            int a = Integer.valueOf(input[1]);
            int b = Integer.valueOf(input[2]);
            
            if(commend == 0){
                union(a, b);
            }else{
                if(find(a) == find(b)){
                    sb.append("YES").append("\n");
                }else{
                    sb.append("NO").append("\n");
                }
            }
        }
        
        System.out.print(sb);
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
