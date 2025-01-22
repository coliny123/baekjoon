# [Gold III] 성곽 - 2234 

[문제 링크](https://www.acmicpc.net/problem/2234) 

### 분류

너비 우선 탐색, 비트마스킹, 그래프 이론, 그래프 탐색

### 문제 설명

<p style="text-align: center;"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/JudgeOnline/upload/201008/cas.PNG" style="height:189px; width:307px"></p>

<p>대략 위의 그림과 같이 생긴 성곽이 있다. 굵은 선은 벽을 나타내고, 점선은 벽이 없어서 지나다닐 수 있는 통로를 나타낸다. 이러한 형태의 성의 지도를 입력받아서 다음을 계산하는 프로그램을 작성하시오.</p>

<ol>
	<li>이 성에 있는 방의 개수</li>
	<li>가장 넓은 방의 넓이</li>
	<li>하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기</li>
</ol>

<p>위의 예에서는 방은 5개고, 가장 큰 방은 9개의 칸으로 이루어져 있으며, 위의 그림에서 화살표가 가리키는 벽을 제거하면 16인 크기의 방을 얻을 수 있다.</p>

<p>성은 M × N(1 ≤ M, N ≤ 50)개의 정사각형 칸으로 이루어진다. 성에는 최소 두 개의 방이 있어서, 항상 하나의 벽을 제거하여 두 방을 합치는 경우가 있다.</p>

### 입력 

 <p>첫째 줄에 두 정수 N, M이 주어진다. 다음 M개의 줄에는 N개의 정수로 벽에 대한 정보가 주어진다. 벽에 대한 정보는 한 정수로 주어지는데, 서쪽에 벽이 있을 때는 1을, 북쪽에 벽이 있을 때는 2를, 동쪽에 벽이 있을 때는 4를, 남쪽에 벽이 있을 때는 8을 더한 값이 주어진다. 참고로 이진수의 각 비트를 생각하면 쉽다. 따라서 이 값은 0부터 15까지의 범위 안에 있다.</p>

### 출력 

 <p>첫째 줄에 1의 답을, 둘째 줄에 2의 답을, 셋째 줄에 3의 답을 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

+class Node{
+    int x, y;
+    
+    public Node(int x, int y){
+        this.x=x;
+        this.y=y;
+    }
+}
+
public class Main {
-    public static int N, M;
-    public static int[][] grid;
-    public static boolean[][] visited;
-    public static Queue<int[]> q = new LinkedList<>();
-    
-    public static int[] dx = {0,0,-1,1};
-    public static int[] dy = {-1,1,0,0};
-    
-    public static void main(String[] args) throw IOException{
-        // 코드를 작성해주세요
+    static int N,M;
+    //서: 1, 북: 2, 동:4 ,남:8
+    static int[] dx = {0,-1,0,1};
+    static int[] dy = {-1, 0, 1, 0};
+    static int[] dz = {1, 2, 4, 8};
+    static int[][] grid;
+    static int[][] roomNum;
+    static HashMap<Integer,Integer> map = new HashMap<>();
+    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
-        
        String[] input = br.readLine().split(" ");
-        N = Integer.valueOf(input[0]);
-        M = Integer.valueOf(input[1]);
+        M = Integer.valueOf(input[0]);
+        N = Integer.valueOf(input[1]);
        
        grid = new int[N][M];
-        visited = new boolean[N][M];
+        roomNum = new int[N][M];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
-        int roomCnt = 0;
-        int maxRoomSize = 0;
+        int num = 1;
+        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
-                if(!visited[i][j]){
-                    q.add(new int[]{nx, ny});
-                    BFS();
-                    roomCnt++;
+                if(roomNum[i][j] == 0){
+                    map.put(num, BFS(i, j, num));
+                    max = Math.max(max, map.get(num));
+                    num++;
                }
            }
        }
        
-        System.out.println(roomCnt);
-        System.out.println(maxRoomSize);
-        System.out.println(roomCnt);
+        int maxSum=0;
+        for(int x=0; x<N; x++){
+            for(int y=0; y<M; y++){
+                for(int k=0; k<4; k++){
+                    int nx = x + dx[k];
+                    int ny = y + dy[k];
+                    if(inRange(nx, ny) && roomNum[x][y] != roomNum[nx][ny]){
+                        maxSum = Math.max(maxSum, map.get(roomNum[x][y]) + map.get(roomNum[nx][ny]));
+                    }
+                }
+            }
+        }
        
-        
-        
+        System.out.println(num-1);
+        System.out.println(max);
+        System.out.println(maxSum);
    }
    
-    public static void BFS(int x, int y){
-        
-        
+    public static int BFS(int x, int y, int num){
+        Queue<Node> q = new LinkedList<>();
+        roomNum[x][y] = num;
+        q.add(new Node(x, y));
+        // System.out.println(x + " " + y + " " + roomNum[x][y]);
+        int size = 0;
        while(!q.isEmpty()){
+            Node cur = q.poll();
            
+            size++;
+            for(int i=0; i<4; i++){
+                int nx = cur.x + dx[i];
+                int ny = cur.y + dy[i];
+                if(canGo(nx, ny) && (grid[cur.x][cur.y] & dz[i]) != dz[i]){
+                    roomNum[nx][ny] = num;
+                    q.add(new Node(nx, ny));
+                }
+            }
        }
        
-        
-        for(int i=0; i<4; i++){
-            int nx = x + dx[i];
-            int ny = y + dy[i];
-            if(canGo(nx , ny)){
-                q.add(new int[]{nx, ny});
-            }
-        }
+        return size;
    }
    
    public static boolean inRange(int x, int y){
-        return(0<=x && x<N && 0<=y && y<M);
+        return (0<=x && x<N && 0<=y && y<M);
    }
    
-    public static boolean canGo(int x, int y, int nx, int ny){
-        if(!inRange(nx, ny)) return false;
-        if(visited[nx][ny]) return false;
+    public static boolean canGo(int x, int y){
+        if(!inRange(x, y)) return false;
+        if(roomNum[x][y] != 0) return false;
+        return true;
    }
}

```


 ## 🏆 전체 코멘트 

1. 비트마스킹을 통해 상하좌우 어디에 벽이 있는지 체크 ex) 11 -> 1011 / 1011 & 0010 -> 0010 -> 2 -> 2 == 2면 벽이 있다.
2. bfs를 순회하며 visited대신 roomNum을 저장해둠
3. 벽을 부술 때 가장 큰 값은 roomNum의 상하좌우에서 roomNum이 다를 때 map.get()으로 두 방의 크기를 더해서 정답을 찾는다.