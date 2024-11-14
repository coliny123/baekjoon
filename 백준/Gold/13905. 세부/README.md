# [Gold IV] 세부 - 13905 

[문제 링크](https://www.acmicpc.net/problem/13905) 

### 분류

자료 구조, 분리 집합, 그래프 이론, 그래프 탐색, 최소 스패닝 트리

### 문제 설명

<p>빼빼로 데이를 맞아 혜빈이와 숭이는 세부에 있는 섬에 놀러 갔다. 섬은 바다 위에 떠다니는 집과 집들을 연결하는 오크나무로 되어있는 다리로 이뤄져 있다. 숭이는 혜빈이에게 깜짝 이벤트를 해주기 위해 섬 관리자에게 혜빈이를 이벤트장소에 머물게 해달라고 하였다. 이벤트 당일 날 숭이는 금으로 된 빼빼로들을 들고 이벤트 장소로 이동하려 했다. 하지만 아뿔싸! 각 다리마다 다리 위를 지날 수 있는 무게 제한이 존재했다. 비싼 금빼빼로를 가면서 버리기 아깝던 숭이는 자신이 머물던 집에서 자신이 혜빈이에게 갈 수 있는 최대한의 금빼빼로만을 들고 가려고 한다. 따라서 숭이는 인공위성조차 해킹할 수 있는 당신에게 혜빈이에게 들고 갈 수 있는 최대한의 금빼빼로 개수를 알려달라고 부탁했다. 당신은 인공위성을 해킹하여 집들의 번호와 다리의 무게제한을 알아내었다. 이 정보를 가지고 빨리 숭이를 도와주자.</p>

<p>(금빼빼로 하나의 무게는 1이고, 숭이의 몸무게는 고려하지 않는다.)</p>

### 입력 

 <p>첫 번째 줄에는 섬에 존재하는 집의 수 N(2≤N≤100,000)와 다리의 수 M(1≤M≤300,000)이 주어진다. 두 번째 줄에는 숭이의 출발 위치(s)와 혜빈이의 위치(e)가 주어진다. (1≤s, e≤N, s≠e). 다음 M개의 줄에는 다리의 정보가 주어진다. 각 줄은 “집의 번호 h1(1≤h1≤N), 집의 번호 h2(1≤h2≤N), 다리의 무게제한 k(1≤k≤1,000,000)” 형식으로 주어진다. (h1집과 h2집은 무게제한이 k인 다리로 연결되어 있다.)</p>

### 출력 

 <p>숭이의 출발위치에서 혜빈이의 위치까지 숭이가 들고 갈 수 있는 금빼빼로의 최대 개수를 출력하시오.</p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

-class Node {
-    int x, w;
+class Node implements Comparable<Node>{
+    int x, y, w;
    
-    public Node(int x, int w){
+    public Node(int x, int y, int w){
        this.x=x;
+        this.y=y;
        this.w=w;
    }
+    
+    @Override
+    public int compareTo(Node o){
+        return o.w - w;
+    }
}

public class Main {
-    public static int N, M;
+    
+    public static int[] island;
    public static int[] weight;
-    public static boolean[] visited;
-    public static ArrayList<Node>[] graph;
-    public static Queue<Integer> q = new LinkedList<>();
+    public static PriorityQueue<Node> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
-        N = Integer.valueOf(input[0]);
-        M = Integer.valueOf(input[1]);
-        
-        
+        int N = Integer.valueOf(input[0]);
+        int M = Integer.valueOf(input[1]);
        input = br.readLine().split(" ");
        int S = Integer.valueOf(input[0])-1;
        int E = Integer.valueOf(input[1])-1;
        
-        visited = new boolean[N];
+        
+        island = new int[N];
        weight = new int[N];
-        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
-            graph[i] = new ArrayList<>();
+            island[i] = i;
        }
        
        while(M-- > 0){
            input = br.readLine().split(" ");
            int a = Integer.valueOf(input[0])-1;
            int b = Integer.valueOf(input[1])-1;
            int w = Integer.valueOf(input[2]);
            
-            graph[a].add(new Node(b, w));
-            graph[b].add(new Node(a, w));
+            pq.add(new Node(a,b,w));
        }
        
-        q.add(S);
-        weight[S] = 1000000;
-        BFS(E);
+        System.out.println(kruskal(S, E));
        
-        
-        System.out.println(weight[E]);
    }
    
-    public static void BFS(int E){
-        while(!q.isEmpty()){
-            int cur = q.poll();
+    
+    public static int kruskal(int S, int E){
+        int answer = 0;
+        int min=1000000;
+        while(!pq.isEmpty()){
+            Node cur = pq.poll();
+            min = Math.min(min, cur.w);
+            union(cur.x, cur.y);
            
-            // if(visted[cur]) continue;
-            visited[cur] = true;
-            
-            for(Node nx : graph[cur]){
-                int min = Math.min(nx.w, weight[cur]);
-                if(!visited[nx.x] && weight[nx.x] < min){
-                    weight[nx.x] = min;
-                    if(nx.x != E){
-                        q.add(nx.x);
-                    }
-                }
+            if(find(S) == find(E)){
+                answer = min;
+                break;
            }
        }
+        return answer;
    }
+    
+    
+    public static int find(int x){
+        if(island[x] == x) return x;
+        return island[x] = find(island[x]);
+    }
+    
+    public static void union(int x, int y){
+        x = find(x);
+        y = find(y);
+        
+        if(x==y) return;
+        island[y] = x;
+    }
}

```


 ## 🏆 전체 코멘트 

1. 다엑스트라와 BFS의 변형으로 풀어보려고 했으나 실패
2. 최소스패닝트리를 사용해서 많이 가져갈 수 있는 다리순으로 이어간다. union을 할 때마다 S와 E가 연결되어있는지 확인하며 S와E가 연결되었을 시점의 간선중 최소값을 리턴하면된다.