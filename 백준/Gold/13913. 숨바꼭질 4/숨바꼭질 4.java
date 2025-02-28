import java.util.*;

public class Main {
    static  int[] parents = new int[200001];
    static  int[] steps = new int[200001];
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        if(N == K){
            System.out.println(0);
            System.out.println(N);
            return;
        }
        
        bfs(N, K);
        Stack<Integer> st = new Stack<>();
        st.push(K);
        int index = K;
        while (index!=N){
            st.push(parents[index]);
            index = parents[index];
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop()).append(" ");
        }
        
        System.out.println(steps[K]);
        System.out.println(sb);
    }
    
    static void bfs(int st, int ed){
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        steps[st] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            if(cur == ed) return;
            
            for(int i=0; i<3; i++){
                int nx = cur;
                if(i == 0) nx = cur + 1;
                if(i == 1) nx = cur - 1;
                if(i == 2) nx = cur * 2;
                
                if(nx < 0 || nx > 200000) continue;
                if(steps[nx] != 0) continue;
                
                q.add(nx);
                steps[nx] = steps[cur] + 1;
                parents[nx] = cur; 
            }
            
        }
    }
}
