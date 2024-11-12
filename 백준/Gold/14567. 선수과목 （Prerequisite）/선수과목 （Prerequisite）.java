import java.util.*;
import java.io.*;

class Subject{
    int num, time;
    
    public Subject(int num, int time){
        this.num=num;
        this.time=time;
    }
}

public class Main {
    public static int N, M;
    public static ArrayList<Integer>[] graph;
    public static int[] times;
    public static Queue<Integer> q = new LinkedList<>();
    // public static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        times = new int[N];
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        while(M-- > 0){
            input = br.readLine().split(" ");
            int pre = Integer.valueOf(input[0])-1;
            int next = Integer.valueOf(input[1])-1;
            
            graph[pre].add(next);
        }
        
        Arrays.fill(times, 1);
        
        for(int i=0; i<N; i++){
            q.add(i);
            dijkstra();
        }
        
        
        for(int time : times){
            System.out.print(time + " ");
        }
    }
    
    public static void dijkstra(){
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int nx : graph[cur]){
                if(times[nx] < times[cur]+1){
                    times[nx] = times[cur]+1;
                    q.add(nx);
                }
            }
        }
    }
}
