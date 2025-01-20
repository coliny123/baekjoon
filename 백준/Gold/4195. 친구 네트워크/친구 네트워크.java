import java.util.*;
import java.io.*;

public class Main {
    public static int[] parents;
    public static int[] level;
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        
        while(T-- > 0){
            int F = Integer.valueOf(br.readLine());
            
            parents = new int[F*2];
            level = new int[F*2];
            for(int i=0; i<F*2; i++){
                parents[i] = i;
                level[i] = 1;
            }
            
            StringBuilder sb = new StringBuilder();
            int idx=0;
            Map<String, Integer> map = new HashMap<>();
            for(int i=0; i<F; i++){
                String[] input = br.readLine().split(" ");
                if (!map.containsKey(input[0])) {
                    map.put(input[0], idx++);
                }
 
                if (!map.containsKey(input[1])) {
                    map.put(input[1], idx++);
                }
                sb.append(union(map.get(input[0]), map.get(input[1]))).append("\n");
            }
            
            
            System.out.print(sb);
        }
    }
    
    public static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    
    public static int union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x != y){
            parents[y] = x;
            level[x] += level[y];
            level[y] = 1; 
        }
        return level[x];
    }
}
