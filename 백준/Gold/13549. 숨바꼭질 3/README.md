# [Gold V] 숨바꼭질 3 - 13549 

[문제 링크](https://www.acmicpc.net/problem/13549) 

### 분류

0-1 너비 우선 탐색, 너비 우선 탐색, 데이크스트라, 그래프 이론, 그래프 탐색, 최단 경로

### 문제 설명

<p>수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.</p>

<p>수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.</p>

### 출력 

 <p>수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.</p>



#  🚀  오답노트 

```diff
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
-        Queue<Integer> q = new LinkedList<>();
-        int[] step = new int[200000];
-        Arrays.fill(step, 100000);
-        step[N] = 0;
-        q.add(N);
+        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
+        boolean[] visited = new boolean[100001];
+        pq.add(new int[]{N, 0});
        
-        int answer = 0;
+        int answer = K-N;
        
-        while(!q.isEmpty()){
-            int cur = q.poll();
+        while(!pq.isEmpty()){
+            int[] cur = pq.poll();
+            int pos = cur[0];
+            int time = cur[1];
            
-            if(cur == K){
-                answer = step[K];
-                break;
-            }
+            if(pos == K) return time;
            
-            if(cur+1 < 200000 && step[cur+1] > step[cur] + 1){
-                step[cur+1] = step[cur]+1;
-                q.add(cur+1);
+            if(pos < 0 || pos > 100000 || visited[pos]) continue;
+            visited[pos] = true;
+            
+            if(pos * 2 <= 100000 && !visited[pos * 2]){
+                pq.add(new int[]{pos * 2, time});
            }
+                
+            if(pos-1 >= 0 && !visited[pos-1]){
+                pq.add(new int[]{pos-1, time+1});
+            }
            
-            if(cur-1 >= 0 && step[cur-1] > step[cur] + 1){
-                step[cur-1] = step[cur]+1;
-                q.add(cur-1);
+            if(pos+1 < 100000 && !visited[pos+1]){
+                pq.add(new int[]{pos+1, time+1});
            }
            
-            if(2*cur < 200000 && step[2*cur] > step[cur]){
-                step[2*cur] = step[cur];
-                q.add(2*cur);
-            }
+            
        }
        
        return answer;
    }
}

```


 ## 🏆 전체 코멘트 

1. 이 문제에서는 x-1, x+1은 이동에 1초가 걸리고 x*2는 0초가 걸리므로 일반적인 BFS를 수행하게 된다면 cur == K일 때가 최소 시간임을 보장할 수 없다.
2. 이 때 PriorityQueue 혹은 Deque를 사용해서  x*2의 경우를 먼저 수행하고, x+1, x-1의 경우는 x*2보다 늦게 수행하도록 하면 cur==K일 때가 최소이다. 
3. 0-1 BFS에 대해 학습해야겠다.
3-1)
0-1 BFS를 사용해야 하는 이유:
                가중치가 0 또는 1인 그래프 최단 경로 문제
                순간이동(2*x)은 0초 비용
                걷기(+1, -1)는 1초 비용
0-1 BFS 핵심 특징:
                일반 BFS보다 효율적
                0 비용 간선은 큐 앞에 추가
                1 비용 간선은 큐 뒤에 추가
                시간 복잡도: O(V+E)
                최소 시간 경로 보장