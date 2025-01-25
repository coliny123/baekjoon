import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;
        
        while(true) {
            String[] input = br.readLine().split(" ");
            N = Integer.valueOf(input[0]);
            M = Integer.valueOf(input[1]);
            
            if(N == 0 && M == 0) break;
            
            parents = new int[N];
            for(int i = 0; i < N; i++) {
                parents[i] = i;
            }
            
            Set<Integer> cycledChild = new HashSet<>();
            
            for(int i = 0; i < M; i++) {
                input = br.readLine().split(" ");
                int x = Integer.valueOf(input[0]) - 1;
                int y = Integer.valueOf(input[1]) - 1;
                
                if(!union(x, y)) {
                    cycledChild.add(x);
                    cycledChild.add(y);
                }
            }
            
            Set<Integer> cycledRoots = new HashSet<>();
            for(int child : cycledChild) {
                cycledRoots.add(find(child));
            }
            
            Set<Integer> roots = new HashSet<>();
            for(int i = 0; i < N; i++) {
                roots.add(find(i));
            }
            
            int treeCount = roots.size() - cycledRoots.size();
            
            sb.append("Case ").append(caseNum).append(": ");
            if(treeCount == 0) sb.append("No trees.").append("\n");
            else if(treeCount == 1) sb.append("There is one tree.").append("\n");
            else sb.append("A forest of ").append(treeCount).append(" trees.").append("\n");
            
            caseNum++;
        }
        
        System.out.print(sb);
    }
    
    public static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    
    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if(x == y) return false;
        
        parents[y] = x;
        return true;
    }
}