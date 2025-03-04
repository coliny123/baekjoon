import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static Set<Integer> set = new HashSet<>();
    static int[] parents;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        parents = new int[N];
        for(int i=0; i<N; i++){
            parents[i] = i;
        }
        graph = new ArrayList[M];
        for(int i=0; i<M; i++){
            graph[i] = new ArrayList<>();
        }
        
        input = br.readLine().split(" ");
        for(int i=1; i<=Integer.valueOf(input[0]); i++){
            set.add(Integer.valueOf(input[i]) - 1);
        }
        
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int len = Integer.valueOf(input[0]);
            int firstMan = Integer.valueOf(input[1]) - 1;
            for(int j=1; j<=len; j++){
                int x = Integer.valueOf(input[j]) - 1;
                union(firstMan, x);
                graph[i].add(x);
            }
        }
        
        int cnt = 0;
        for(int i=0; i<M; i++){
            int leader = graph[i].get(0);
            boolean flag = true;
            for (int know : set) {
                if (find(leader) == find(know)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
         
        System.out.println(cnt);
    }
    
    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y) return;
        
        parents[y] = x;
    }
    
    
}
