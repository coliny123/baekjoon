import java.util.*;
import java.io.*;

public class Main {
    public static int N, E;
    public static ArrayList<int[]>[] graph;
    public static int[] distance;
    public static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
        @Override
        public int compare(int[] o1, int[] o2){
            return (o1[1] - o2[1]);
        }
    });
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        E = Integer.valueOf(input[1]);
        
        distance = new int[N];
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        while(E-- > 0){
            input = br.readLine().split(" ");
            int st = Integer.valueOf(input[0])-1;
            int ed = Integer.valueOf(input[1])-1;
            int w = Integer.valueOf(input[2]);
            
            graph[st].add(new int[]{ed, w});
            graph[ed].add(new int[]{st, w});
        }
        
        input = br.readLine().split(" ");
        
        int u = Integer.valueOf(input[0])-1;
        int v = Integer.valueOf(input[1])-1;
        
        Dijkstra(u);
        int u0 = distance[0];
        int uN = distance[N-1];

        Dijkstra(v);
        int v0 = distance[0];
        int vN = distance[N-1];

        int uv = distance[u];
        
        int answer = 0;
        if(u0+vN < v0+uN){
            answer += u0;
            answer += vN;
        }else{
            answer += v0;
            answer += uN;
        }
        answer += uv;
        
        if(u0 == 10000000 || uN == 10000000 || v0 == 10000000 || vN == 10000000){
            answer = -1;
        }
        System.out.println(answer);
    }
    
    public static void Dijkstra(int st){
        Arrays.fill(distance, 10000000);
        distance[st] = 0;
        pq.add(new int[]{st, 0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.peek();
            // System.out.println(cur[0] + " " +  cur[1] + " " + distance[cur[0]]);
            if(distance[cur[0]] == cur[1]){
                for(int i=0; i<graph[cur[0]].size(); i++){
                    int[] nx = graph[cur[0]].get(i);
                    if(distance[nx[0]] > distance[cur[0]] + nx[1]){
                        distance[nx[0]] = distance[cur[0]] + nx[1];
                        pq.add(new int[]{nx[0], distance[nx[0]]});
                    }
                }
            }
            pq.poll();
        }
    }
}
