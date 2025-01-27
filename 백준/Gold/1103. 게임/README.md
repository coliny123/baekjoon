# [Gold II] 게임 - 1103 

[문제 링크](https://www.acmicpc.net/problem/1103) 

### 분류

깊이 우선 탐색, 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색

### 문제 설명

<p>형택이는 1부터 9까지의 숫자와, 구멍이 있는 직사각형 보드에서 재밌는 게임을 한다.</p>

<p>일단 보드의 가장 왼쪽 위에 동전을 하나 올려놓는다. 그다음에 다음과 같이 동전을 움직인다.</p>

<ol>
	<li>동전이 있는 곳에 쓰여 있는 숫자 X를 본다.</li>
	<li>위, 아래, 왼쪽, 오른쪽 방향 중에 한가지를 고른다.</li>
	<li>동전을 위에서 고른 방향으로 X만큼 움직인다. 이때, 중간에 있는 구멍은 무시한다.</li>
</ol>

<p>만약 동전이 구멍에 빠지거나, 보드의 바깥으로 나간다면 게임은 종료된다. 형택이는 이 재밌는 게임을 되도록이면 오래 하고 싶다.</p>

<p>보드의 상태가 주어졌을 때, 형택이가 최대 몇 번 동전을 움직일 수 있는지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>줄에 보드의 세로 크기 N과 가로 크기 M이 주어진다. 이 값은 모두 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 보드의 상태가 주어진다. 쓰여 있는 숫자는 1부터 9까지의 자연수 또는 H이다. 가장 왼쪽 위칸은 H가 아니다. H는 구멍이다.</p>

### 출력 

 <p>첫째 줄에 문제의 정답을 출력한다. 만약 형택이가 동전을 무한번 움직일 수 있다면 -1을 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static char[][] grid;
+    public static int[][] dp;
    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static int max = 0;
    public static boolean flag = false;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //입력 받기
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
+        dp = new int[N][M];
        visited = new boolean[N][M];
        grid = new char[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                grid[i][j] = input[j].charAt(0);
            }
        }
        
        //왼쪽위에서 DFS시작
        // DFS에서 사이클이 생기는 기준 : 
        visited[0][0] = true;
-        DFS(0,0,1);
+        dp[0][0] = 1;
+        DFS(0,0);
        
        System.out.println(max);
    }
    
-    public static void DFS(int x, int y, int step){
+    public static void DFS(int x, int y){
        if(flag) return;
        
-        max = Math.max(max, step);
+        max = Math.max(max, dp[x][y]);
        for(int i=0; i<4; i++){
            int nx = x + Integer.valueOf(grid[x][y] - '0') * dx[i];
            int ny = y + Integer.valueOf(grid[x][y] - '0') * dy[i];
-            if(canGo(nx, ny)){
+            if(canGo(nx, ny) && dp[nx][ny] < dp[x][y]+1){
                // 이미 방문한 곳이면 사이클 발생
                if(visited[nx][ny]){
                    max = -1;
                    flag = true;
                    return;
                }
+                dp[nx][ny] = dp[x][y]+1;
                visited[nx][ny] = true;
-                DFS(nx, ny, step+1);
+                DFS(nx, ny);
                visited[nx][ny] = false;
            }
        }
    }
    
    public static boolean inRange(int x, int y){
        return(0<=x && x<N && 0<=y && y<M);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        if(!Character.isDigit(grid[x][y])) return false;
        return true;
    }
}

```


 ## 🏆 전체 코멘트 

1. steps를 2차원 배열로 저장해서 이미 방문한 곳의 경우 불필요한 dfs를 수행하지 않는다