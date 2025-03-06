import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] parents;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.valueOf(br.readLine());
        M = Integer.valueOf(br.readLine());
        
        parents = new int[N];
        for(int i=0; i<N; i++){
            parents[i] = i;
        }
        
        
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                if(input[j].charAt(0) == '1'){
                    union(i, j);
                    // if(i > j){
                        // union(j, i);
                    // }else{
                    // }
                }
            }
        }
        
        String[] input = br.readLine().split(" ");
        int start = Integer.valueOf(input[0]) - 1;
        for(int i=1; i<M; i++){
            int next = Integer.valueOf(input[i]) - 1;
            
            if(find(start) != find(next)){
                System.out.println("NO");
                return;
            }
        }
        
        System.out.println("YES");
    }
    
    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y) return;
        parents[x] = y;
    }
}
