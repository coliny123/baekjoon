# [Gold III] 불! - 4179 

[문제 링크](https://www.acmicpc.net/problem/4179) 

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 문제 설명

<p>지훈이는 미로에서 일을 한다. 지훈이를 미로에서 탈출하도록 도와주자!</p>

<p>미로에서의 지훈이의 위치와 불이 붙은 위치를 감안해서 지훈이가 불에 타기전에 탈출할 수 있는지의 여부, 그리고 얼마나 빨리 탈출할 수 있는지를 결정해야한다.</p>

<p>지훈이와 불은 매 분마다 한칸씩 수평또는 수직으로(비스듬하게 이동하지 않는다)  이동한다. </p>

<p>불은 각 지점에서 네 방향으로 확산된다. </p>

<p>지훈이는 미로의 가장자리에 접한 공간에서 탈출할 수 있다. </p>

<p>지훈이와 불은 벽이 있는 공간은 통과하지 못한다.</p>

### 입력 

 <p>입력의 첫째 줄에는 공백으로 구분된 두 정수 R과 C가 주어진다. 단, 1 ≤ R, C ≤ 1000 이다. R은 미로 행의 개수, C는 열의 개수이다.</p>

<p>다음 입력으로 R줄동안 각각의 미로 행이 주어진다.</p>

<p> 각각의 문자들은 다음을 뜻한다.</p>

<ul>
	<li>#: 벽</li>
	<li>.: 지나갈 수 있는 공간</li>
	<li>J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)</li>
	<li>F: 불이 난 공간</li>
</ul>

<p>J는 입력에서 하나만 주어진다.</p>

### 출력 

 <p>지훈이가 불이 도달하기 전에 미로를 탈출 할 수 없는 경우 IMPOSSIBLE 을 출력한다.</p>

<p>지훈이가 미로를 탈출할 수 있는 경우에는 가장 빠른 탈출시간을 출력한다. </p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

class Node{
    int x, y, step;
    
    public Node(int x, int y, int step){
        this.x=x;
        this.y=y;
        this.step=step;
    }
}

public class Main {
    public static int N, M;
    public static int answer = 0;
    public static char[][] grid;
    public static int[][] steps;
    public static int[][] jsteps;
    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static Queue<Node> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        grid = new char[N][M];
        steps = new int[N][M];
        visited = new boolean[N][M];
        
+        for(int i=0; i<N; i++){
+            Arrays.fill(steps[i], 1000000);
+        }
+        
        int j_x = 0;
        int j_y = 0;
        
        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                grid[i][j] = input[j].charAt(0);
                
                if(grid[i][j] == 'J'){
                    j_x = i;
                    j_y = j;
                }
                
                if(grid[i][j] == 'F'){
                    visited[i][j] = true;
+                    steps[i][j] = 0;
                    q.add(new Node(i, j, 0));
                }
            }
        }
        
        // 불 먼저 bfs
        BFS();
        
        // for(int i=0; i<N; i++){
            // for(int j=0; j<M; j++){
                // System.out.print(steps[i][j] + " ");
            // }
            // System.out.println();
        // }
        // System.out.println();
        
        // 지훈이 bfs
        JBFS(j_x, j_y);
        
        // for(int i=0; i<N; i++){
            // for(int j=0; j<M; j++){
                // System.out.print(jsteps[i][j] + " ");
            // }
            // System.out.println();
        // }
        
        System.out.println(answer == 0 ? "IMPOSSIBLE" : answer);
        
    }
    
    
    public static void JBFS(int x, int y){
        q = new LinkedList<>();
        visited = new boolean[N][M];
        visited[x][y] = true;
        q.add(new Node(x, y, 0));
        
        jsteps = new int[N][M];
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                // 탈출 체크
                if(escape(nx, ny)){
                    answer = cur.step+1;
                    return;
                }
                
                if(JcanGO(nx, ny, cur.step+1)){
                    visited[nx][ny] = true;
                    jsteps[nx][ny] = cur.step+1;
                    q.add(new Node(nx, ny, cur.step+1));
                }
                
            }
        }
        
    }
    
    // 0>nx || nx <=N || 0>ny || ny<=M
    public static boolean escape(int x, int y){
        if(inRange(x, y)) return false;
        return true;
    }
    
    public static boolean JcanGO(int x, int y, int step){
        if(!inRange(x, y)) return false;
        if(grid[x][y] == '#' || visited[x][y]) return false;
        if(steps[x][y] <= step) return false;
        return true; 
    }
    
    
    // 불
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<M);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y)) return false;
        if(grid[x][y] == '#' || visited[x][y]) return false;
        return true;
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(canGo(nx, ny)){
                    visited[nx][ny] = true;
-                    steps[nx][ny] = steps[cur.x][cur.y] + 1;
+                    steps[nx][ny] = cur.step+1;
                    q.add(new Node(nx, ny, cur.step+1));
                }
            }
        }
    }
}

```


 ## 🏆 전체 코멘트 

1. 일단 불 먼저 이동 시키고 그 steps를 저장해둔다 (벽 때문에 step들이 0으로 되는 경우 JcanGo에서 "이하" 조건에 위배됨으로 전부 큰 값으로 초기화해야한다!)
2. 지훈이를 이동시키는데 불이 이동한 step보다 이하이면 이미 불이 퍼진 상태이므로 이동 x,
그리고 다음 step이 grid 밖이면 탈출이다.
