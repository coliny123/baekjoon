# [Gold IV] 관악산 등산 - 14699 

[문제 링크](https://www.acmicpc.net/problem/14699) 

### 분류

다이나믹 프로그래밍, 그래프 이론

### 문제 설명

<p>서울대학교에는 “누가 조국의 미래를 묻거든 고개를 들어 관악을 보게 하라”라는 유명한 문구가 있다. 어느 날 Unused는 Corea에게 조국의 미래를 물었고, Corea는 직접 관악산에 올라가 조국의 미래를 보고 답해 주기로 했다.</p>

<p>관악산의 등산로는 1부터 N까지의 서로 다른 번호가 붙어 있는 N개의 쉼터와 두 쉼터 사이를 오갈 수 있는 M개의 길들로 이루어져 있다. Corea는 지면에서부터 산을 오르는 것은 너무 귀찮다고 생각했기 때문에, 케이블카를 타고 임의의 쉼터에서 내린 다음 등산을 시작하기로 했다. Corea는 항상 더 높은 곳을 지향하기 때문에, 쉼터에 도착하면 그 쉼터와 직접 연결된 더 높은 쉼터로 향하는 길들 중 하나를 골라서 그 길을 따라 이동한다. 만약 그런 길이 없다면 등산을 마친다.</p>

<p>관악산의 쉼터들에는 조국의 미래를 볼 수 있는 전망대가 하나씩 설치되어 있다. Corea는 최대한 많은 쉼터를 방문해서 조국의 미래를 많이 보고 Unused에게 전해 주기로 했다. 관악산의 지도가 주어질 때, Corea가 각각의 쉼터에서 출발해서 산을 오를 때 최대 몇 개의 쉼터를 방문할 수 있는지 구하여라.</p>

### 입력 

 <p>첫 번째 줄에 등산로에 있는 쉼터의 수 N(2 ≤ N ≤ 5, 000)과 두 쉼터 사이를 연결하는 길의 수 M(1 ≤ M ≤ 100, 000)이 주어진다.</p>

<p>두 번째 줄에는 각 쉼터의 높이를 나타내는 N개의 정수가 번호 순서대로 주어진다. 각 쉼터의 높이는 1 이상 1, 000, 000 이하이며 서로 다르다.</p>

<p>세 번째 줄부터 M개의 줄에 걸쳐 각각의 길이 연결하는 두 쉼터의 번호가 공백으로 구분되어 주어진다. 쉼터의 번호는 1 이상 N 이하의 정수이다. 양 끝점이 같은 쉼터인 길은 없으며, 임의의 두 쉼터를 연결하는 길이 여러 개 존재할 수 있다.</p>

### 출력 

 <p>N개의 줄에 걸쳐 n번째 줄에 Corea가 n번 쉼터에서 출발해서 산을 오를 때 최대로 방문할 수 있는 쉼터의 개수를 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

public class Main {
-    public static int N,M,Max;
+    public static int N,M, maxHight;
    public static ArrayList<Integer>[] graph;
-    public static boolean[] visited;
    public static int[] hight;
+    public static int[] count;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
+        count = new int[N];
        hight = new int[N];
-        visited = new boolean[N];
        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            hight[i] = Integer.valueOf(input[i]);
        }
        
        while(M-- > 0){
            input = br.readLine().split(" ");
            int st = Integer.valueOf(input[0])-1;
            int ed = Integer.valueOf(input[1])-1;
            
-            graph[st].add(ed);
-            graph[ed].add(st);
+            if(hight[st] > hight[ed]){
+                graph[ed].add(st);
+            }else if(hight[st] < hight[ed]){
+                graph[st].add(ed);
+            }
        }
        
        // 0~N까지 완탐
        for(int i=0; i<N; i++){
-            Max=1;
-            visited[i]=true;
-            DFS(i, 1);
-            visited[i]=false;
-            System.out.println(Max);
+            DFS(i);
+            System.out.println(count[i]);
        }
+        
+        // for(int i=0; i<N; i++){
+            // System.out.println(count[i]);
+        // }
    }
    
-    public static void DFS(int cur, int cnt){
-        if(Max < cnt){
-            Max = cnt;
+    public static int DFS(int cur){
+        if(graph[cur].size() == 0){
+            count[cur] = 1;
+            return count[cur];
        }
        
-        for(int i=0; i<graph[cur].size(); i++){
-            int nx = graph[cur].get(i);
-            if(!visited[nx] && hight[cur] < hight[nx]){
-                visited[nx] = true;
-                DFS(nx, cnt+1);
-                visited[nx] = false;
+        if(count[cur] != 0){
+            return count[cur];
+        }else{
+            for(int i=0; i<graph[cur].size(); i++){
+                int nx = graph[cur].get(i);
+                if(hight[cur] < hight[nx]){
+                    count[cur] = Math.max(count[cur], DFS(nx)+1);
+                }
            }
        }
+        
+        return count[cur];
    }
+    
+    
}

```


 ## 🏆 전체 코멘트 

1. 5000이므로 전부 완탐하게되면 시간초과됨 -> 메모리제이션을 사용해보자
2. 메모리제이션 + DFS를 사용해야함
3. 종료조건을 위해 양방향 그래프에서 크기를 기준으로 작->큰으로 방향그래프로 변경
노드없는 경우 = 갈 수 있는 가장 높은 전망대 -> count[cur] = 1;
메모리제이션을 통해 count[cur]이 0이 아닌경우 이미 탐색했으므로 그 값 리턴
갈 수 있는 여러개의 경우의 수 중 가장 큰 값을 찾아야하므로 Math.max()를 통해 큰 값을 저장
