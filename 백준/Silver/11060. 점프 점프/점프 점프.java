import java.util.*;

public class Main {
    public static int N;
    public static int[] grid;
    public static int[] steps;
    
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        
        Scanner sc = new Scanner(System.in);
        N = Integer.valueOf(sc.nextInt());
        
        grid = new int[N];
        steps = new int[N];
        Arrays.fill(steps, 1000000);
        
        sc.nextLine();
        for(int i=0; i<N; i++){
            grid[i] = sc.nextInt();
        }
        
        bfs(0);
        
        System.out.println(steps[N-1] == 1000000 ? -1 : steps[N-1]);
    }
    
    public static void bfs(int st){
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        steps[st] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            int limit = grid[cur];
            for(int i = 1; i <= limit; i++){
                int nx = cur + i;
                if(nx < 0 || nx >= N) break;
                
                if(steps[nx] > steps[cur]+1){
                    steps[nx] = steps[cur]+1;
                    q.add(nx);
                }
            }
        }
    }
}
