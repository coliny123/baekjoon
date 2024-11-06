# [Gold IV] 화산쇄설류 - 16569 

[문제 링크](https://www.acmicpc.net/problem/16569) 

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색, 구현

### 문제 설명

<p>화산학자 윤재상은 어느 화산섬을 탐사하러 갔다가 곧 섬에 있는 화산들이 곧 폭발하기 시작할 것이라는 급보와 각 화산의 폭발 시점 정보를 받았다.</p>

<p>섬은 M행 N열의 행렬로 표현된다. 어떤 화산의 위치를 (x, y), 폭발을 시작한 시각을 t 라고 하자. t+δ 시각이 되면 δ ≥ |u-x|+|v-y|인 모든 (u, v)위치의 지대들은 <em>높이 무관하게</em> 화산쇄설류가 덮치게 된다. 재상인 빨리 탈출을 하고싶다.</p>

<ul>
	<li>재상이는 처음에 X행 Y열에 있다.</li>
	<li>재상이는 단위 시간 당 상하좌우 한 칸만 움직일 수 있다.</li>
	<li>재상이는 화산이 있는 위치와 화산쇄설류가 뒤덮인 곳은 갈 수 없다.</li>
</ul>

<p>재상이는 화산쇄설류를 피해서 되도록 가장 높은 곳으로 피하고 싶고, 되도록 가장 빨리 도달하기를 원한다. 재상이가 화산쇄설류를 피해서 도달할 수 있는 가장 높은 고도와, 그 고도까지 도달하는데 걸리는 최소 시간을 구한다.</p>

### 입력 

 <p>첫 번째 줄에 정수 M, N, V이 공백으로 구분되어 주어진다. (1 ≤ M, N ≤ 100, 1 ≤ V ≤ <em>min</em>(5,000, M×N))</p>

<p>그 다음 줄에 X, Y가 공백으로 구분되어 주어진다. (1 ≤ X ≤ M, 1 ≤ Y ≤ N)</p>

<p>그 다음 줄부터 M개의 줄마다 N개의 공백으로 구분된 수들이 주어진다. i행 j열의 값은 (i, j) 지대의 고도 h<sub>ij</sub> 를 나타낸다. (0 ≤ h<sub>ij</sub> ≤ 10,000)</p>

<p>그 다음 줄부터 V개의 줄이 주어진다. i번째 줄에 x<sub>i</sub>, y<sub>i</sub>, t<sub>i</sub>가 공백으로 구분되어 주어진다. 이 수들은 i번째 화산의 위치 (x<sub>i</sub>, y<sub>i</sub>,)와 화산의 분출시각 t<sub>i</sub>를 의미한다. (1 ≤ x<sub>i</sub> ≤ M, 1 ≤ y<sub>i</sub> ≤ N, 0 ≤ t<sub>i</sub> ≤ 200)</p>

<p>위치, 시간, 고도 수치들은 모두 정수이다. X행 Y열에 화산이 있는 입력은 주어지지 않는다.</p>

### 출력 

 <p>재상이가 도달할 수 있는 최고 높이와 그 높이에 도달할 수 있는 최단 시간을 공백을 구분하여 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

class Node{
    int x, y, t, what;
}

public class Main {
-    public static int N, M, V, X, Y, T;
-    // public static PriorityQueue<int[]> volcano = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
+    public static int N, M, V, X, Y, T, MaxHigh, Time;
    public static int[][] grid;
    public static int[][] volcano;
+    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static TreeSet<int[]> set = new TreeSet<>((o1, o2) -> {
        if(o1[0] == o2[0]){
            return o1[1]-o2[1];
        }else{
            return o1[0]-o2[0];
        }
    });
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        V = Integer.valueOf(input[2]);
        
-        step = new int[N][M];
+        volcano = new int[N][M];
        for(int i=0; i<N; i++){
-            Arrays.fill(step[i], Integer.MAX_VALUE);
+            Arrays.fill(volcano[i], Integer.MAX_VALUE);
        }
        
-        
+        visited = new boolean[N][M];
        grid = new int[N][M];
        
        input = br.readLine().split(" ");
        X = Integer.valueOf(input[0])-1;
        Y = Integer.valueOf(input[1])-1;
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        
        while(V-- > 0){
            input = br.readLine().split(" ");
            int x = Integer.valueOf(input[0])-1;
            int y = Integer.valueOf(input[1])-1;
            int t = Integer.valueOf(input[2]);
-            step[x][y] = t;
+            volcano[x][y] = t;
            q.add(new int[]{x, y});
            set.add(new int[]{x, y});
        }
        volcanoBFS();
        
+        visited[X][Y] = true;
        q.add(new int[]{X, Y, 0});
        manBFS();
        
-        
+        System.out.println(MaxHigh + " " + Time);
    }
    
    public static void manBFS(){
+        MaxHigh=0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
+
+            if(MaxHigh < grid[cur[0]][cur[1]]){
+                MaxHigh = grid[cur[0]][cur[1]];
+                Time = cur[2];
+            }
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
-                if(inRange(nx, ny) && volcano[nx][ny] > cur[2]){
-                    q.add(new int[]{nx, ny});
+                if(inRange(nx, ny) && !visited[nx][ny] && volcano[nx][ny] > cur[2]+1 && !set.contains(new int[]{nx, ny})){
+                    q.add(new int[]{nx, ny, cur[2]+1});
+                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    public static void volcanoBFS(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(inRange(nx, ny) && volcano[nx][ny] > volcano[cur[0]][cur[1]]+1){
                    volcano[nx][ny] = volcano[cur[0]][cur[1]]+1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
    
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        return true;
    }
    
    
}

```


 ## 🏆 전체 코멘트 

1. BFS를 수행하면서 시간에 따른 화산 폭발의 추가와 재만이의 이동을 어떻게 처리해야할지 감을 잡지 못했다.
2. 답은 화산의 이동 BFS를 먼저 수행한 다음 재만이의 이동시간과 화산의 이동시간을 비교해서 재만이의 이동시간+1이 더 작은경우에만 이동하는 것이다.
큐 두개를 사용해서 해결할수도 있지만 나는 큐 하나를 가지고 해결했다.
