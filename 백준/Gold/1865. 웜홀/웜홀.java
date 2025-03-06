import java.util.*;
import java.io.*;

class Node {
    int idx;
    int w;
    
    public Node(int idx, int w){
        this.idx=idx;
        this.w=w;
    }
}

public class Main {
    static int N;
    static ArrayList<Node>[] graph;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.valueOf(br.readLine());
        
        while(tc-- > 0){
            String[] input = br.readLine().split(" ");
            N = Integer.valueOf(input[0]);
            int M = Integer.valueOf(input[1]);
            int W = Integer.valueOf(input[2]);
            
            graph = new ArrayList[N];
            for(int i=0; i<N; i++){
                graph[i] = new ArrayList<>();
            }
            
            while(M-- > 0){
                input = br.readLine().split(" ");
                int st = Integer.valueOf(input[0]) - 1;
                int ed = Integer.valueOf(input[1]) - 1;
                int weight = Integer.valueOf(input[2]);
                
                graph[st].add(new Node(ed, weight));
                graph[ed].add(new Node(st, weight));
            }
            
            while(W-- > 0){
                input = br.readLine().split(" ");
                int st = Integer.valueOf(input[0]) - 1;
                int ed = Integer.valueOf(input[1]) - 1;
                int weight = Integer.valueOf(input[2]);
                
                graph[st].add(new Node(ed, -weight));
            }
            
            boolean flag = false;
            for(int i=0; i<N; i++){
                if(ballmanFord(i)){
                   flag = true;
                    break;
                }
            }
            
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            
        }
        
    }
    
    static boolean ballmanFord(int st){
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[st] = 0;
        // N-1 번 업데이트
        boolean update = false;
        for(int i=1; i<N; i++){
            update = false;
            
            for(int j=0; j<N; j++){
                for(Node road : graph[j]){
                    if(distance[j] != Integer.MAX_VALUE && distance[road.idx] > distance[j] + road.w){
                        distance[road.idx] = distance[j] + road.w;
                        update = true;
                    }
                }
            }
            
            if(!update){
                break;
            }
        }
        
        if(update){
            for (int i = 0; i < N; i++) {
                for (Node road : graph[i]) {
                    if (distance[i] != Integer.MAX_VALUE && distance[road.idx] > distance[i] + road.w) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}
