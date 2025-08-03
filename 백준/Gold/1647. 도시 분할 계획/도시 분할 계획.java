import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] parents;
    
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        return a[2] -b[2];
    });
    
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        parents = new int[N];
        
        for(int i=0; i<N; i++) {
            parents[i] = i;
        }
        
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            
            int st = Integer.valueOf(input[0]) - 1;
            int ed = Integer.valueOf(input[1]) - 1;
            int dist = Integer.valueOf(input[2]);
            
            pq.add(new int[]{st, ed, dist});
        }
        
        int max = 0;
        long sum = 0;
        while(!pq.isEmpty()){
            int[] load = pq.poll();
            int a = load[0];
            int b = load[1];
            int dist = load[2];
            
            if(find(a) != find(b)){
                union(a, b);
                sum += dist;
                
                max = Math.max(max, dist);
            }
        }
        
        
        System.out.println(sum - max);
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
