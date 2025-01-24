import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        System.out.println(BFS(N, K));
    }
    
    public static int BFS(int N, int K){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[100001];
        pq.add(new int[]{N, 0});
        
        int answer = K-N;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int pos = cur[0];
            int time = cur[1];
            
            if(pos == K) return time;
            
            if(pos < 0 || pos > 100000 || visited[pos]) continue;
            visited[pos] = true;
            
            if(pos * 2 <= 100000 && !visited[pos * 2]){
                pq.add(new int[]{pos * 2, time});
            }
                
            if(pos-1 >= 0 && !visited[pos-1]){
                pq.add(new int[]{pos-1, time+1});
            }
            
            if(pos+1 < 100000 && !visited[pos+1]){
                pq.add(new int[]{pos+1, time+1});
            }
            
            
        }
        
        return answer;
    }
}
