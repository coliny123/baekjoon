# [Gold III] 내리막 길 - 1520 

[문제 링크](https://www.acmicpc.net/problem/1520) 

### 분류

깊이 우선 탐색, 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색

### 문제 설명

<p>여행을 떠난 세준이는 지도를 하나 구하였다. 이 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다. 한 칸은 한 지점을 나타내는데 각 칸에는 그 지점의 높이가 쓰여 있으며, 각 지점 사이의 이동은 지도에서 상하좌우 이웃한 곳끼리만 가능하다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/0e11f3db-35d2-4b01-9aa0-9a39252f05be/-/preview/" style="width: 151px; height: 122px;"></p>

<p>현재 제일 왼쪽 위 칸이 나타내는 지점에 있는 세준이는 제일 오른쪽 아래 칸이 나타내는 지점으로 가려고 한다. 그런데 가능한 힘을 적게 들이고 싶어 항상 높이가 더 낮은 지점으로만 이동하여 목표 지점까지 가고자 한다. 위와 같은 지도에서는 다음과 같은 세 가지 경로가 가능하다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/917d0418-35db-4081-9f62-69a2cc78721e/-/preview/" style="width: 151px; height: 123px;"> <img alt="" src="https://upload.acmicpc.net/1ed5b78d-a4a1-49c0-8c23-12a12e2937e1/-/preview/" style="width: 151px; height: 121px;"> <img alt="" src="https://upload.acmicpc.net/e57e7ef0-cc56-4340-ba5f-b22af1789f63/-/preview/" style="width: 151px; height: 121px;"></p>

<p>지도가 주어질 때 이와 같이 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽 아래 지점까지 항상 내리막길로만 이동하는 경로의 개수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에는 지도의 세로의 크기 M과 가로의 크기 N이 빈칸을 사이에 두고 주어진다. 이어 다음 M개 줄에 걸쳐 한 줄에 N개씩 위에서부터 차례로 각 지점의 높이가 빈 칸을 사이에 두고 주어진다. M과 N은 각각 500이하의 자연수이고, 각 지점의 높이는 10000이하의 자연수이다.</p>

### 출력 

 <p>첫째 줄에 이동 가능한 경로의 수 H를 출력한다. 모든 입력에 대하여 H는 10억 이하의 음이 아닌 정수이다.</p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

class Node{
    int x, y;
    
    public Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    public static int N, M;
    public static int answer=0;
    public static int[][] grid;
-    public static int[][] step;
+    public static int[][] dp;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};   
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        grid = new int[N][M];
-        step = new int[N][M];
+        dp= new int[N][M];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
+                dp[i][j] = -1;
            }
        }
        
-        step[0][0]=1;
-        DFS(0, 0);
-        // for(int i=0; i<N; i++){
-            // for(int j=0; j<M; j++){
-                // System.out.print(step[i][j] + " ");
-            // }
-            // System.out.println();
-        // }
-        
-        
-        System.out.println(step[N-1][M-1]);
+        System.out.println(DFS(0, 0));
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
    
-    public static void DFS(int x, int y){
+    public static int DFS(int x, int y){
+        if(x == N-1 && y == M-1){
+            return 1;
+        }
+        
+        if(dp[x][y] != -1){
+            return dp[x][y];
+        }
+        
+        dp[x][y] = 0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
-            if(inRange(nx, ny) && grid[nx][ny] < grid[x][y]){
-                int cnt = 0;
-                for(int j=0; j<4; j++){
-                    int nnx = nx + dx[j];
-                    int nny = ny + dy[j];
-                    if(inRange(nnx, nny) && grid[nx][ny] < grid[nnx][nny]){
-                        cnt += step[nnx][nny];
-                    }
-                }
-                if(cnt != step[nx][ny]){
-                    step[nx][ny] = cnt;
-                    DFS(nx, ny);
-                }
+            if(inRange(nx, ny) && grid[x][y] > grid[nx][ny]){
+                dp[x][y] += DFS(nx, ny);
            }
        }
+        
+        return dp[x][y];
    }
}

```


 ## 🏆 전체 코멘트 

1. dp + dfs 모든 경우의 수를 다 봐야하기 때문에 dfs만 하면 시간초과 생김
2. dp 적용은 dfs에서 가지치기를 사용해서 이미 방문했으면 그 뒤에는 굳이 방문할 필요가 없음을 이용
2-1) dp를 -1로 초기화, dp[x][y]가 초기값이 아니면 이미 방문했으므로 더 진행할 필요 없이 dp[x][y]의 값을 리턴 += 를 수행함
2-2) 목표 지점을 도착했을 때만턴