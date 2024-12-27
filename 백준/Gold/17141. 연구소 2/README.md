# [Gold IV] 연구소 2 - 17141 

[문제 링크](https://www.acmicpc.net/problem/17141) 

### 분류

너비 우선 탐색, 브루트포스 알고리즘, 그래프 이론, 그래프 탐색

### 문제 설명

<p>인체에 치명적인 바이러스를 연구하던 연구소에 승원이가 침입했고, 바이러스를 유출하려고 한다. 승원이는 연구소의 특정 위치에 바이러스 M개를 놓을 것이고, 승원이의 신호와 동시에 바이러스는 퍼지게 된다.</p>

<p>연구소는 크기가 N×N인 정사각형으로 나타낼 수 있으며, 정사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.</p>

<p>일부 빈 칸은 바이러스를 놓을 수 있는 칸이다. 바이러스는 상하좌우로 인접한 모든 빈 칸으로 동시에 복제되며, 1초가 걸린다.</p>

<p>예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자. 0은 빈 칸, 1은 벽, 2는 바이러스를 놓을 수 있는 칸이다.</p>

<pre>2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 2 0 1 1
0 1 0 0 0 0 0
2 1 0 0 0 0 2</pre>

<p>M = 3이고, 바이러스를 아래와 같이 놓은 경우 6초면 모든 칸에 바이러스를 퍼뜨릴 수 있다. 벽은 -, 바이러스를 놓은 위치는 0, 빈 칸은 바이러스가 퍼지는 시간으로 표시했다.</p>

<pre>6 6 5 4 - - 2
5 6 - 3 - 0 1
4 - - 2 - 1 2
3 - 2 1 2 2 3
2 2 1 0 1 - -
1 - 2 1 2 3 4
0 - 3 2 3 4 5</pre>

<p>시간이 최소가 되는 방법은 아래와 같고, 5초만에 모든 칸에 바이러스를 퍼뜨릴 수 있다.</p>

<pre>0 1 2 3 - - 2
1 2 - 3 - 0 1
2 - - 2 - 1 2
3 - 2 1 2 2 3
3 2 1 0 1 - -
4 - 2 1 2 3 4
5 - 3 2 3 4 5</pre>

<p>연구소의 상태가 주어졌을 때, 모든 빈 칸에 바이러스를 퍼뜨리는 최소 시간을 구해보자.</p>

### 입력 

 <p>첫째 줄에 연구소의 크기 N(5 ≤ N ≤ 50), 놓을 수 있는 바이러스의 개수 M(1 ≤ M ≤ 10)이 주어진다.</p>

<p>둘째 줄부터 N개의 줄에 연구소의 상태가 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스를 놓을 수 있는 칸이다. 2의 개수는 M보다 크거나 같고, 10보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>연구소의 모든 빈 칸에 바이러스가 있게 되는 최소 시간을 출력한다. 바이러스를 어떻게 놓아도 모든 빈 칸에 바이러스를 퍼뜨릴 수 없는 경우에는 -1을 출력한다.</p>



#  🚀  오답노트 

```diff
-import java.util.*;
-import java.io.*;
-
-
-class Node {
-    int x, y;
-    
-    public Node(int x, int y){
-        this.x=x;
-        this.y=y;
-    }
-}
-
-public class Main {
-    public static int N, M;
-    public static int[][] grid;
-    public static int[] dx = {0,0,-1,1};
-    public static int[] dy = {-1,1,0,0};
-    public static Node[] route;
-    public static int answer = Integer.MAX_VALUE;
-    public static ArrayList<Node> virus = new ArrayList<>();
-    
-    
-    public static void main(String[] args) throws IOException{
-        // 코드를 작성해주세요
-        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
-        
-        String[] input = br.readLine().split(" ");
-        N = Integer.valueOf(input[0]);
-        M = Integer.valueOf(input[1]);
-        
-        grid = new int[N][N];
-        route = new Node[M];
-        
-        for(int i=0; i<N; i++){
-            input = br.readLine().split(" ");
-            for(int j=0; j<N; j++){
-                grid[i][j] = Integer.valueOf(input[j]);
-                if(grid[i][j] == 2){
-                    virus.add(new Node(i, j));
-                }
-            }
-        }
-        
-        peeking(0, 0);
-        
-        if(answer == Integer.MAX_VALUE){
-            System.out.println(-1);
-        }else{
-            System.out.println(answer);
-        }
-        
-    }
-    
-    public static void peeking(int count, int start){
-        if(count == M){
-            BFS();
-            return;
-        }
-        
-        for(int i=start; i<virus.size(); i++){
-            route[count] = virus.get(i);
-            peeking(count+1, i+1);
-        }
-    }
-    
-    public static boolean inRange(int x, int y){
-        return (0<=x && x<N && 0<=y && y<N);
-    }
-    
-    public static boolean canGo(int x, int y, boolean[][] visited){
-        if(!inRange(x, y)) return false;
-        if(visited[x][y] || grid[x][y] == 1) return false;
-        return true;
-    }
-    
-    public static void BFS(){
-        Queue<Node> q = new LinkedList<>();
-        boolean[][] visited = new boolean[N][N];
-        int[][] steps = new int[N][N];
-        
-        for(int i=0; i<M; i++){
-            visited[route[i].x][route[i].y] = true;
-            q.add(route[i]);
-        }
-        
-        int max = 0;
-        while(!q.isEmpty()){
-            Node cur = q.poll();
-            
-            for(int i=0; i<4; i++){
-                int nx = cur.x + dx[i];
-                int ny = cur.y + dy[i];
-                if(canGo(nx, ny, visited)){
-                    visited[nx][ny] = true;
-                    q.add(new Node(nx, ny));
-                    steps[nx][ny] = steps[cur.x][cur.y] + 1;
-                    max = Math.max(max, steps[nx][ny]);
-                }
-            }
-        }
-        
-        if(check(visited)){
-            answer = Math.min(answer, max);
-        }
-    }
-    
-    
-    public static boolean check(boolean[][] visited){
-        for(int i=0; i<N; i++){
-            for(int j=0; j<N; j++){
-                if(grid[i][j] != 1 && !visited[i][j]){
-                    return false;
-                }
-            }
-        }
-        return true;
-    }
-}

```


 ## 🏆 전체 코멘트 

1. 바이러스 놓을 수 있는 공간 중에 M개 고르는 것 => 재귀함수로 모든 경우의 수 ( xCm 번 함), 재귀함수에서 M개 골랐을 때 BFS 실행
2. 매번 visited, steps 초기화해줘야하므로 BFS내에서 초기화, M개 담을 배열 생성
3. 매 BFS마다 각각의 최대 요일 구하고, 다 방문했으면 answer로 최솟값 구함