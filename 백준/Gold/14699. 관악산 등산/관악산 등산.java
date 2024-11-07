import java.util.*;
import java.io.*;

public class Main {
    public static int N,M, maxHight;
    public static ArrayList<Integer>[] graph;
    public static int[] hight;
    public static int[] count;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        count = new int[N];
        hight = new int[N];
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            hight[i] = Integer.valueOf(input[i]);
        }
        
        while(M-- > 0){
            input = br.readLine().split(" ");
            int st = Integer.valueOf(input[0])-1;
            int ed = Integer.valueOf(input[1])-1;
            
            if(hight[st] > hight[ed]){
                graph[ed].add(st);
            }else if(hight[st] < hight[ed]){
                graph[st].add(ed);
            }
        }
        
        // 0~N까지 완탐
        for(int i=0; i<N; i++){
            DFS(i);
            System.out.println(count[i]);
        }
        
        // for(int i=0; i<N; i++){
            // System.out.println(count[i]);
        // }
    }
    
    public static int DFS(int cur){
        if(graph[cur].size() == 0){
            count[cur] = 1;
            return count[cur];
        }
        
        if(count[cur] != 0){
            return count[cur];
        }else{
            for(int i=0; i<graph[cur].size(); i++){
                int nx = graph[cur].get(i);
                if(hight[cur] < hight[nx]){
                    count[cur] = Math.max(count[cur], DFS(nx)+1);
                }
            }
        }
        
        return count[cur];
    }
    
    
}
