# [Gold IV] 은하철도 - 17250 

[문제 링크](https://www.acmicpc.net/problem/17250) 

### 분류

자료 구조, 분리 집합

### 문제 설명

<p>하나의 은하 안에는 여러 행성들이 존재한다. 문명의 기술 발전으로 은하 내의 모든 행성들은 서로 여행할 수 있게 되었다.</p>

<p>드디어 오늘, 80,000 광년 떨어진 다른 은하와 우리 은하를 연결하는 은하 철도가 개통된다.</p>

<p>은하 철도가 개통되면 더 많은 행성을 여행할 수 있다는 사실에 은하 내 모든 행성의 주민들은 들떠있는 분위기이다.</p>

<p>우주철도공사 G-Express는 앞으로의 은하 철도 계획을 발표하였다.</p>

<p>우주는 너무 넓기 때문에, G-Express사는 은하가 연결될 때마다 몇 개의 행성들이 서로 여행할 수 있게 되었는 지를 알려주고자 한다.</p>

<p>G-Express사 기술개발팀의 직원인 당신에게 이 프로그램의 업무 요청이 들어왔다. 각 은하들의 행성 수와 철도 계획이 주어지면 해당 철도를 이용할 수 있는 행성들의 수를 실시간으로 안내하는 프로그램을 만들자.</p>

### 입력 

 <p>첫 번째 줄에 은하의 수 N과 철도의 개수 M이 주어진다.</p>

<p>두 번째 줄부터 N개의 줄에 N개의 각 은하 내에 존재하는 행성들의 수가 1번 은하부터 차례대로 주어진다. (행성을 세는 단위는 조(10<sup>12</sup>) 단위이다.)</p>

<p>그리고 N+2 번째 줄부터 M개의 줄에 걸쳐 은하와 은하 사이를 잇는 철도가 주어진다. 같은 은하 사이에 여러 개의 철도가 건설될 수 있다.</p>

<p>입력되는 N은 2 ≤ N ≤ 100,000, M은 1 ≤ M ≤ 100,000이고, 각 은하의 행성 수는 100(조)개를 넘지 않으며 아무 행성도 없는 경우는 없다.</p>

### 출력 

 <p>철도가 연결될 때마다 해당 철도를 이용할 수 있는 행성들의 수를 한 줄씩 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

public class Main {
    public static int N, K;
    public static int[] planet;
-    public static boolean[] visited;
-    public static ArrayList<Integer>[] graph;
-    public static Queue<Integer> q = new LinkedList<>();
+    public static int[] parents;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        K = Integer.valueOf(input[1]);
        
-        graph = new ArrayList[N];
        planet = new int[N];
+        parents = new int[N];
        for(int i=0; i<N; i++){
            planet[i] = Integer.valueOf(br.readLine());
-            graph[i] = new ArrayList<>();
+            parents[i] = i;
        }
        
        StringBuilder sb = new StringBuilder();
        while(K-- > 0){
            input = br.readLine().split(" ");
            int s = Integer.valueOf(input[0])-1;
            int e = Integer.valueOf(input[1])-1;
            
-            graph[s].add(e);
-            graph[e].add(s);
+            if(find(s) != find(e)){
+                union(s, e);
+                // System.out.println(planet[find(s)]);
+                // for(int i=0; i<N; i++){
+                    // System.out.print(planet[i] + " ");
+                // }
+                // System.out.println();
+            }
            
-            visited = new boolean[N];
-            visited[s]=true;
-            q.add(s);
-            sb.append(BFS()).append("\n");
+            sb.append(planet[find(s)]).append("\n");
        }
        System.out.println(sb);
    }
    
-    public static int BFS(){
-        int sum=0;
-        while(!q.isEmpty()){
-            int cur = q.poll();
-            
-            sum += planet[cur];
-            
-            for(int nx : graph[cur]){
-                if(!visited[nx]){
-                    visited[nx] = true;
-                    q.add(nx);
-                }
-            }
-        }
-        return sum;
+    public static int find(int x){
+        if(parents[x] == x) return x;
+        return parents[x] = find(parents[x]);
    }
+    
+    public static void union(int x, int y){
+        x = find(x);
+        y = find(y);
+        
+        if(x == y) return;
+        parents[y] = x;
+        planet[x] += planet[y];
+    }
}

```


 ## 🏆 전체 코멘트 

1. 실시간으로 주어지는 간선들에서 이동할 수 있는 행성의 수를 구해야하므로 BFS를 매번 돌리면 시간초과가 난다.
 그리고 나중에 나오는 간선은 이전에 나온 간선의 결과들을 반영하므로 되므로 Union find를 사용하면 된다.
root에 집합의 행성들의 합을 저장해두고 union할 때마다 갱신해준다.