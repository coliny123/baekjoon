# [Gold III] 벽 부수고 이동하기 - 2206 

[문제 링크](https://www.acmicpc.net/problem/2206) 

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 문제 설명

<p>N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.</p>

<p>만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.</p>

<p>한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.</p>

<p>맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.</p>

### 출력 

 <p>첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

+class Node{
+    int x, y, step;
+    boolean destroy;
+    
+    public Node(int x, int y, int step, boolean destroy){
+        this.x=x;
+        this.y=y;
+        this.step=step;
+        this.destroy=destroy;
+    }
+}
+
public class Main {
    public static int N, M;
    public static int[][] grid;
-    public static int[][] step;
+    public static boolean[][][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
-    public static Queue<int[]> q = new LinkedList<>();
+    public static Queue<Node> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
-        step = new int[N][M];
+        visited = new boolean[N][M][2];
        grid = new int[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
-        for(int i=0; i<N; i++){
-            Arrays.fill(step[i], Integer.MAX_VALUE-10000);
-        }
-        step[0][0] = 1;
-        q.add(new int[]{0, 0, 1});
+        
+        q.add(new Node(0, 0, 1, false));
        BFS();
-        
-        System.out.println(step[N-1][M-1] == Integer.MAX_VALUE-10000 ? -1 : step[N-1][M-1]);
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
-            int[] cur = q.poll();
+            Node cur = q.poll();
            
+            if(cur.x == N-1 && cur.y == M-1){
+                System.out.println(cur.step);
+                return;
+            }
+            
            for(int i=0; i<4; i++){
-                int nx = cur[0] + dx[i];
-                int ny = cur[1] + dy[i];
-                if(canGo(nx, ny, cur[2]) && step[nx][ny] >= step[cur[0]][cur[1]]+1){
-                    if(grid[nx][ny] == 1){
-                        q.add(new int[]{nx, ny, cur[2]-1});
-                    }else{
-                        q.add(new int[]{nx, ny, cur[2]});
+                int nx = cur.x + dx[i];
+                int ny = cur.y + dy[i];
+                
+                if(!inRange(nx, ny)) continue;
+                // 벽 안만났을 때
+                if(grid[nx][ny] == 0){
+                    if(!cur.destroy && !visited[nx][ny][0]){
+                        visited[nx][ny][0] = true;
+                        q.add(new Node(nx, ny, cur.step+1, false));
+                    }else if(cur.destroy && !visited[nx][ny][1]){
+                        visited[nx][ny][1] = true;
+                        q.add(new Node(nx, ny, cur.step+1, true));
                    }
-                    step[nx][ny] = step[cur[0]][cur[1]]+1;
+                }else{
+                // 벽 만났을 때
+                    if(!cur.destroy){ // 부순적 없을 때만 이동 가능
+                        visited[nx][ny][1] = true;
+                        q.add(new Node(nx, ny, cur.step+1, true));
+                    }
                }
            }
        }
+        
+        System.out.println(-1);
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
-    
-    public static boolean canGo(int x, int y, int t){
-        if(!inRange(x, y)) return false;
-        if((grid[x][y] == 1 && t == 0)) return false;
-        return true;
-    }
}

```


 ## 🏆 전체 코멘트 

1. 나는 visited배열을 step으로 하여 Math.min으로 최솟값을 찾으려고 했다.
한번도 벽을 부순적이 없다면 -> 벽을 부수고 이동한다.
한번이라도 벽을 부순적이 있으면 -> 갈 수 없다.
위 조건만 생각해서 처리하면 된다고 생각했다. 하지만 벽을 부수고 간 경우가 특정 위치에서 먼저 도달하지만 최종적으로 부수지 않고 간 경우가 더 빠를 수 있다는 반례가 존재하기 때문에 일반적인 이중배열 visit 처리로는 풀이가 불가했다.

2. 그래서 visited를 3중 배열로 만들어서, 벽을 부수고 탐색하는 경우와 부수지 않고 탐색하는 경우를 따로 처리해주었다. visited[n][m][0]은 벽을 한번도 안부순 애들이 탐색한 경우, visited[n][m][1]은 벽을 한번 부수고 탐색한 경우이다.

3. BFS 탐색 조건은 다음과 같다.

벽이 아니면
부신 벽이 여태까지 없었으면 -> visited[?][?][0] 방문 처리 + queue에 넣음
벽을 한번 부신 적이 있으면 -> visited[?][?][1] 방문 처리 + queue에 넣음
벽이면
한번도 벽을 부신 적이 없으면 부수고 -> visited[?][?][1] 방문 처리 + queue에 넣음