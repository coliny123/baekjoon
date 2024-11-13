import java.util.*;

public class Main {
    public static int N, K;
    public static int Count=0;
    public static int[] steps = new int[200001];
    public static int[] dx = {-1,1,0};
    public static Queue<Integer> q = new LinkedList<>();
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        K = sc.nextInt();
        
        Arrays.fill(steps, 1000000);
        
        steps[N] = 0;
        q.add(N);
        BFS();
        System.out.println(steps[K]);
        System.out.println(Count);
        
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            int cur = q.poll();
            
            if(steps[K] < steps[cur]) continue;
            
            if(K == cur){
                if(steps[K] > steps[cur]) Count=1;
                if(steps[K] == steps[cur]) Count++;
            }
            
            for(int i=0; i<3; i++){
                int tmp = dx[i];
                if(tmp == 0) tmp = cur;
                int nx = cur + tmp;
                
                if(nx < 0 || nx >= 200000) continue;
                if(steps[nx] < steps[cur]+1) continue;
                
                steps[nx] = steps[cur]+1;
                q.add(nx);
            }
            
        }
    }
}
