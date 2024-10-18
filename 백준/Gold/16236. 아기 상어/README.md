# [Gold III] 아기 상어 - 16236 

[문제 링크](https://www.acmicpc.net/problem/16236) 

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색, 구현, 시뮬레이션

### 문제 설명

<p>N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 물고기가 최대 1마리 존재한다.</p>

<p>아기 상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다. 가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.</p>

<p>아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다. 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.</p>

<p>아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.</p>

<ul>
	<li>더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.</li>
	<li>먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.</li>
	<li>먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
	<ul>
		<li>거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.</li>
		<li>거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.</li>
	</ul>
	</li>
</ul>

<p>아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다. 즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 이동과 동시에 물고기를 먹는다. 물고기를 먹으면, 그 칸은 빈 칸이 된다.</p>

<p>아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.</p>

<p>공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 공간의 크기 N(2 ≤ N ≤ 20)이 주어진다.</p>

<p>둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은 의미를 가진다.</p>

<ul>
	<li>0: 빈 칸</li>
	<li>1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기</li>
	<li>9: 아기 상어의 위치</li>
</ul>

<p>아기 상어는 공간에 한 마리 있다.</p>

### 출력 

 <p>첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;

+class Node implements Comparable<Node>{
+    int x, y, step;
+    
+    public Node(int x, int y, int step){
+        this.x=x;
+        this.y=y;
+        this.step=step;
+    }
+    
+    @Override
+    public int compareTo(Node o){
+        if(step == o.step){
+            if(x == o.x){
+                return y - o.y;
+            }else{
+                return x - o.x;
+            }
+        }else{
+            return step - o.step;
+        }
+    }
+}
+
public class Main {
    public static int N;
    public static int[][] grid;
-    public static int[][] step;
+    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
-    public static Queue<int[]> q = new LinkedList<>();
+    public static PriorityQueue<Node> pq = new PriorityQueue<>();
+    public static int time=0;
    public static int size=2;
    public static int eatCnt=0;
-    public static int stepCnt=0;
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        grid = new int[N][N];
-        step = new int[N][N];
-        int[] cur = new int[2];
+        visited = new boolean[N][N];
+        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 9){
                    grid[i][j] = 0;
-                    cur[0]=i;
-                    cur[1]=j;
+                    visited[i][j] = true;
+                    pq.add(new Node(i, j, 0));
                }
            }
        }
        
-        push(cur);
        BFS();
        
-        System.out.println(stepCnt);
+        
+        System.out.println(time);
+        
    }
    
-    
    public static void BFS(){
-        while(!q.isEmpty()){
-            int[] cur = q.poll();
+        while(!pq.isEmpty()){
+            Node cur = pq.poll();
            
-            if(0 < grid[cur[0]][cur[1]] && grid[cur[0]][cur[1]] < size){
-                grid[cur[0]][cur[1]] = 0;
+            if(0 < grid[cur.x][cur.y] && grid[cur.x][cur.y] < size){
                eatCnt++;
-                stepCnt += step[cur[0]][cur[1]];
+                
+                // System.out.println(cur.x + " " + cur.y + " " + cur.step);
+                grid[cur.x][cur.y] = 0;
+                time = cur.step;
                if(size == eatCnt){
                    size++;
                    eatCnt=0;
                }
-                reset();
-                push(cur);
+                
+                // 초기화
+                pq.clear();
+                visited = new boolean[N][N];
+
+                pq.add(new Node(cur.x, cur.y, 0));
+                visited[cur.x][cur.y] = true;
            }
            
+            
            for(int i=0; i<4; i++){
-                int nx = cur[0] + dx[i];
-                int ny = cur[1] + dy[i];
+                int nx = cur.x + dx[i];
+                int ny = cur.y + dy[i];
                if(canGo(nx, ny)){
-                    push(new int[]{nx, ny});
-                    step[nx][ny] = step[cur[0]][cur[1]]+1;
+                    pq.add(new Node(nx, ny, cur.step+1));
+                    visited[nx][ny] = true;
                }
            }
        }
    }
    
-    public static void reset(){
-        q = new LinkedList<>();
-        step = new int[N][N];
-    }
    
    
-    public static void push(int[] cur){
-        if(canGo(cur[0], cur[1])){
-            q.add(cur);
+    public static boolean check(){
+        for(int i=0; i<N; i++){
+            for(int j=0; j<N; j++){
+                if(0 < grid[i][j] && grid[i][j] < size) return true;
+            }
        }
+        return false;
    }
    
+    
    public static boolean canGo(int x, int y){
-        if(!inRange(x, y)) return false;
-        if(size < grid[x][y]) return false;
+        if(0>x || x>=N || 0>y || y>=N) return false;
+        if(size < grid[x][y] || visited[x][y]) return false;
        return true;
    }
-    
-    public static boolean inRange(int x, int y){
-        return (0<=x && x<N && 0<=y && y<N);
-    }
}

```


 ## 🏆 전체 코멘트 

1. 최소 거리에 있는 먹이를 찾아가니까 BFS를 생각
2. 최소 거리가 같을 경우 왼쪽 위에 있을수록 우선순위가 높으니까 PriorityQueue를 사용
3. 먹이를 찾을 때마다 queue와 visited 초기화