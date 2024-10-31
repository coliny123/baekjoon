import java.util.*;

public class Main {
    public static int N, M;
    public static ArrayList<Integer>[] graph;
    public static int[] neighbor;
    public static int[] times;
    public static boolean[] beileve;
    public static Queue<Integer> q = new LinkedList<>();
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        neighbor = new int[N+1];
        times = new int[N+1];
        beileve = new boolean[N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=1; i<=N; i++){
            while(true){
                int who = sc.nextInt();
                if(who == 0) break;
                graph[i].add(who);
            }
        }
        
        Arrays.fill(times, -1);
        
        M = sc.nextInt();
        while(M-- > 0){
            int who = sc.nextInt();
            beileve[who] = true;
            times[who] = 0;
            q.add(who);
        }
        
        BFS();
        
        for(int i=1; i<=N; i++){
            System.out.print(times[i] + " ");
        }
    }
    
    
    public static void BFS(){
        while(!q.isEmpty()){
            int cur = q.poll();
            
            // 주변 사람들에게 전파
            for(int nx : graph[cur]){
                neighbor[nx]++;
                // 절반이상 믿으면 
                if(!beileve[nx] && neighbor[nx] >= (graph[nx].size()+1) / 2){
                    beileve[nx] = true;
                    q.add(nx);
                    times[nx] = times[cur]+1;
                }
            }
            
        }
    }
}
