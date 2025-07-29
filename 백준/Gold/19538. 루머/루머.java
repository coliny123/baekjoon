import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] neighbor;
    static int[] times;
    static boolean[] believe;
    static Queue<Integer> q = new LinkedList<>();
    
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        
        neighbor = new int[N];
        times = new int[N];
        believe = new boolean[N];
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < input.length - 1; j++){
                int who = Integer.valueOf(input[j]) - 1;
                graph[i].add(who);
            }
        }
        
        Arrays.fill(times, -1);
        
        
        input = br.readLine().split(" ");
        int M = Integer.valueOf(input[0]);
        
        input = br.readLine().split(" ");
        for(int i=0; i<M; i++){
            int who = Integer.valueOf(input[i]) - 1;
            believe[who] = true;
            times[who] = 0;
            q.add(who);
        }
        
        BFS();
        
        
        for(int i=0; i<N; i++){
            System.out.print(times[i] + " ");
        }
        
    }
    
    
    static void BFS(){
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int nx : graph[cur]){
                neighbor[nx]++;
                if(!believe[nx] && neighbor[nx] >= (graph[nx].size() + 1) / 2){
                    believe[nx] = true;
                    q.add(nx);
                    times[nx] = times[cur]+1;
                }
            }
        }
    }
}
