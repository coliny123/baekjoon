import java.util.*;
import java.io.*;

public class Main {
    static int N, A, B;
    static int[] bridge;
    
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.valueOf(br.readLine());
        bridge = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            bridge[i] = Integer.valueOf(input[i]);
        }
        
        input = br.readLine().split(" ");
        A = Integer.valueOf(input[0]) - 1;
        B = Integer.valueOf(input[1]) - 1;
        
        int ans = bfs(A, B);
        
        
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
    
    static int bfs(int a, int b){
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        int[] dx = {1,-1};
        
        q.add(new int[]{a, 0});
        visited[a] = true;
        
        int answer = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int idx = cur[0];
            int step = cur[1];
            int value = bridge[idx];
            
            if(idx == b){
                answer = Math.min(answer, step);
            }
            
            for(int i=0; i<N; i++){
                int jump = i * value;
                for(int j=0; j<2; j++){
                    int nx = idx + (dx[j] * jump);
                    
                    if(0 > nx || nx >= N) continue;
                    if(visited[nx]) continue;
                    
                    q.add(new int[]{nx, step+1});
                    visited[nx] = true;
                }
            }
        }
        
        return answer;
    }
}
