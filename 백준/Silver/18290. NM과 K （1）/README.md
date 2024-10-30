# [Silver I] NM과 K (1) - 18290 

[문제 링크](https://www.acmicpc.net/problem/18290) 

### 분류

백트래킹, 브루트포스 알고리즘

### 문제 설명

<p>크기가 N×M인 격자판의 각 칸에 정수가 하나씩 들어있다. 이 격자판에서 칸 K개를 선택할 것이고, 선택한 칸에 들어있는 수를 모두 더한 값의 최댓값을 구하려고 한다. 단, 선택한 두 칸이 인접하면 안된다. r행 c열에 있는 칸을 (r, c)라고 했을 때, (r-1, c), (r+1, c), (r, c-1), (r, c+1)에 있는 칸이 인접한 칸이다.</p>

### 입력 

 <p>첫째 줄에 N, M, K가 주어진다. 둘째 줄부터 N개의 줄에 격자판에 들어있는 수가 주어진다.</p>

### 출력 

 <p>선택한 칸에 들어있는 수를 모두 더한 값의 최댓값을 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;

public class Main {
    public static int N, M, K;
+    public static int MAX = Integer.MIN_VALUE;
    public static int[][] grid;
    public static boolean[][] visited;
-    public static long max=Long.MIN_VALUE;
-    public static int[] dx = {0,0,-1,1};
-    public static int[] dy = {-1,1,0,0};
+    public static int[]dx = {0,0,-1,1};
+    public static int[]dy = {-1,1,0,0};
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
+        
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        
        grid = new int[N][M];
+        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
-                visited = new boolean[N][M];
-                // 상하좌우 처리
                visited[i][j] = true;
-                for(int k=0; k<4; k++){
-                    int nx = i + dx[k];
-                    int ny = j + dy[k];
-                    if(canGo(nx, ny)){
-                        visited[nx][ny] = true;
-                    }
-                }
                BT(1, i, j, grid[i][j]);
+                visited[i][j] = false;
            }
        }
        
+        System.out.println(MAX);
        
-        System.out.println(max);
    }
    
-    public static void BT(int depth, int x, int y, long sum){
-        // K개 고르면 종료
+    public static void BT(int depth, int x, int y, int sum){
        if(depth == K){
-            max = Math.max(max, sum);
+            MAX = Math.max(MAX, sum);
            return;
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
-                if(!visited[i][j]){
-                    // 상하좌우 처리
+                if(!visited[i][j] && checkFourSide(i, j)){
                    visited[i][j] = true;
-                    for(int k=0; k<4; k++){
-                        int nx = i + dx[k];
-                        int ny = j + dy[k];
-                        if(canGo(nx, ny)){
-                            visited[nx][ny] = true;
-                        }
-                    }
-                    
                    BT(depth+1, i, j, sum + grid[i][j]);
-                    
-                    // 상하좌우 처리
                    visited[i][j] = false;
-                    for(int k=0; k<4; k++){
-                        int nx = i + dx[k];
-                        int ny = j + dy[k];
-                        if(canGo(nx, ny)){
-                            visited[nx][ny] = false;
-                        }
-                    }
                }
            }
        }
    }
    
-    
-    public static boolean canGo(int x, int y){
-        if(0>x || x>=N || 0>y || y>=M) return false;
-        if(visited[x][y]) return false;
+    public static boolean checkFourSide(int x, int y){
+        for(int i=0; i<4; i++){
+            int nx = x + dx[i];
+            int ny = y + dy[i];
+            if(inRange(nx, ny) && visited[nx][ny]){
+                return false;
+            }
+        }
        return true;
    }
+    
+    public static boolean inRange(int x, int y){
+        return (0<=x && x<N && 0<=y && y<M);
+    }
}

```


 ## 🏆 전체 코멘트 

1. 첫번째 코드는 하나를 방문할 때 4 방향의 인접 칸들을 visited하고 재귀가 끝날 때 다시 4방향을 VISITED를 제거했는데 비효율적이라서 그 칸이 갈 수 있는지 확인할 때 1)해당칸을 먼저 확인 2) 4방향 확인 으로 바꿔서 코드를 깔끔하게 다