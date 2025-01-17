# [Gold V] 공주님을 구해라! - 17836 

[문제 링크](https://www.acmicpc.net/problem/17836) 

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 문제 설명

<p>용사는 마왕이 숨겨놓은 공주님을 구하기 위해 (<em>N</em>, <em>M</em>) 크기의 성 입구 (1,1)으로 들어왔다. 마왕은 용사가 공주를 찾지 못하도록 성의 여러 군데 마법 벽을 세워놓았다. 용사는 현재의 가지고 있는 무기로는 마법 벽을 통과할 수 없으며, 마법 벽을 피해 (<em>N</em>, <em>M</em>) 위치에 있는 공주님을 구출해야만 한다.</p>

<p>마왕은 용사를 괴롭히기 위해 공주에게 저주를 걸었다. 저주에 걸린 공주는 <em>T</em>시간 이내로 용사를 만나지 못한다면 영원히 돌로 변하게 된다. 공주님을 구출하고 프러포즈 하고 싶은 용사는 반드시 <em>T</em>시간 내에 공주님이 있는 곳에 도달해야 한다. 용사는 한 칸을 이동하는 데 한 시간이 걸린다. 공주님이 있는 곳에 정확히 <em>T</em>시간만에 도달한 경우에도 구출할 수 있다. 용사는 상하좌우로 이동할 수 있다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/62b6063d-4d01-4836-9793-94ab99f032f2/" style="width: 300px; height: 261px;"></p>

<p>성에는 이전 용사가 사용하던 전설의 명검 "그람"이 숨겨져 있다. 용사가 그람을 구하면 마법의 벽이 있는 칸일지라도, 단숨에 벽을 부수고 그 공간으로 갈 수 있다. "그람"은 성의 어딘가에 반드시 한 개 존재하고, 용사는 그람이 있는 곳에 도착하면 바로 사용할 수 있다. 그람이 부술 수 있는 벽의 개수는 제한이 없다.</p>

<p>우리 모두 용사가 공주님을 안전하게 구출 할 수 있는지, 있다면 얼마나 빨리 구할 수 있는지 알아보자.</p>

### 입력 

 <p>첫 번째 줄에는 성의 크기인 <em>N</em>, <em>M</em> 그리고 공주에게 걸린 저주의 제한 시간인 정수 <em>T</em>가 주어진다. 첫 줄의 세 개의 수는 띄어쓰기로 구분된다. (3 ≤ <em>N</em>, <em>M</em> ≤ 100, 1 ≤ <em>T</em> ≤ 10000)</p>

<p>두 번째 줄부터 <em>N</em>+1번째 줄까지 성의 구조를 나타내는 <em>M</em>개의 수가 띄어쓰기로 구분되어 주어진다. 0은 빈 공간, 1은 마법의 벽, 2는 그람이 놓여있는 공간을 의미한다. (1,1)과 (<em>N</em>,<em>M</em>)은 0이다.</p>

### 출력 

 <p>용사가 제한 시간 <em>T</em>시간 이내에 공주에게 도달할 수 있다면, 공주에게 도달할 수 있는 최단 시간을 출력한다.</p>

<p>만약 용사가 공주를 <em>T</em>시간 이내에 구출할 수 없다면, "<code>Fail</code>"을 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

class Node {
    int x, y, step;
    boolean get;
    
    public Node(int x, int y, int step, boolean get){
        this.x=x;
        this.y=y;
        this.step=step;
        this.get=get;
    }
}

public class Main {
    public static int N, M, T;
    public static int answer=0;
    public static int[][] grid;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
-    public static boolean[][] visited;
+    public static boolean[][][] visited;
    public static Queue<Node> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        T = Integer.valueOf(input[2]);
        
        grid = new int[N][M];
-        visited = new boolean[N][M];
+        visited = new boolean[N][M][2];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        
-        visited[0][0] = true;
+        visited[0][0][0] = true;
+        visited[0][0][1] = true;
        if(grid[0][0]==2){
            q.add(new Node(0, 0, 0, true));
        }else{
            q.add(new Node(0, 0, 0, false));
        }
        
        BFS();
        
        System.out.println(answer > T || answer == 0 ? "Fail" : answer);
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.x == N-1 && cur.y == M-1){
                answer = cur.step;
                return;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
-                if(canGo(nx, ny, cur.get)){
-                    visited[nx][ny] = true;
-                    if(grid[nx][ny] == 2){
-                        q.add(new Node(nx, ny, cur.step+1, true));
-                    }else{
-                        q.add(new Node(nx, ny, cur.step+1, cur.get));
+                if(inRange(nx, ny)){
+                    // 그람 없음
+                    if(!cur.get){
+                        if(!visited[nx][ny][0] && grid[nx][ny] == 0){
+                            visited[nx][ny][0] = true;
+                            q.add(new Node(nx, ny, cur.step+1, false));
+                        }else if(!visited[nx][ny][0] && grid[nx][ny] == 2){
+                            visited[nx][ny][0] = true;
+                            q.add(new Node(nx, ny, cur.step+1, true));
+                        }
+                    } // 그람 있음
+                    else{
+                        if(!visited[nx][ny][1]){
+                            visited[nx][ny][1] = true;
+                            q.add(new Node(nx, ny, cur.step+1, true));
+                        }
                    }
                }
            }
        }
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
-    
-    public static boolean canGo(int x, int y, boolean get){
-        if(!inRange(x, y)) return false;
-        if(visited[x][y]) return false;
-        if(!get && grid[x][y] == 1) return false;
-        return true;
-    }
}

```


 ## 🏆 전체 코멘트 

1. 그람을 갖고 있을 때와 없을 때 visited를 나누어서 처리해줘야 하므로 visited를 3차원 배열로 선언
2. canGo 함수도 inRange만 남기고 bfs 함수 내에서 리