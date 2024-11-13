import java.util.*;
import java.io.*;

public class Main {
    public static int N, K;
    public static int[] planet;
    public static int[] parents;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        K = Integer.valueOf(input[1]);
        
        planet = new int[N];
        parents = new int[N];
        for(int i=0; i<N; i++){
            planet[i] = Integer.valueOf(br.readLine());
            parents[i] = i;
        }
        
        StringBuilder sb = new StringBuilder();
        while(K-- > 0){
            input = br.readLine().split(" ");
            int s = Integer.valueOf(input[0])-1;
            int e = Integer.valueOf(input[1])-1;
            
            if(find(s) != find(e)){
                union(s, e);
                // System.out.println(planet[find(s)]);
                // for(int i=0; i<N; i++){
                    // System.out.print(planet[i] + " ");
                // }
                // System.out.println();
            }
            
            sb.append(planet[find(s)]).append("\n");
        }
        System.out.println(sb);
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
        planet[x] += planet[y];
    }
}
