# [Silver I] 지름길 - 1446 

[문제 링크](https://www.acmicpc.net/problem/1446) 

### 분류

데이크스트라, 다이나믹 프로그래밍, 그래프 이론, 최단 경로

### 문제 설명

<p>매일 아침, 세준이는 학교에 가기 위해서 차를 타고 D킬로미터 길이의 고속도로를 지난다. 이 고속도로는 심각하게 커브가 많아서 정말 운전하기도 힘들다. 어느 날, 세준이는 이 고속도로에 지름길이 존재한다는 것을 알게 되었다. 모든 지름길은 일방통행이고, 고속도로를 역주행할 수는 없다.</p>

<p>세준이가 운전해야 하는 거리의 최솟값을 출력하시오.</p>

### 입력 

 <p>첫째 줄에 지름길의 개수 N과 고속도로의 길이 D가 주어진다. N은 12 이하인 양의 정수이고, D는 10,000보다 작거나 같은 자연수이다. 다음 N개의 줄에 지름길의 시작 위치, 도착 위치, 지름길의 길이가 주어진다. 모든 위치와 길이는 10,000보다 작거나 같은 음이 아닌 정수이다. 지름길의 시작 위치는 도착 위치보다 작다.</p>

### 출력 

 <p>세준이가 운전해야하는 거리의 최솟값을 출력하시오.</p>



#  🚀  오답노트 

```diff
+import java.util.*;
+
+class Node {
+    int ed, w;
+    
+    public Node(int ed, int w){
+        this.ed=ed;
+        this.w=w;
+    }
+}
+
public class Main {
+    public static int N, D;
+    public static ArrayList<Node> roads[];
+    public static int dist[];
+    
    public static void main(String[] args) {
        // 코드를 작성해주세요
+        Scanner sc = new Scanner(System.in);
+        
+        
+        N = sc.nextInt();
+        D = sc.nextInt();
+        
+        roads = new ArrayList[D+1];
+        for(int i=0; i<=D; i++){
+            roads[i] = new ArrayList<>();
+        }
+        dist = new int[D+1];
+        for(int i=0; i<=D; i++) dist[i] = i;
+        
+        for(int i=0; i<N; i++){
+            int st = sc.nextInt();
+            int ed = sc.nextInt();
+            int w = sc.nextInt();
+            if(ed > D){
+                continue;
+            }
+            roads[st].add(new Node(ed, w));
+        }
+        
+        dijkstra(0);
+        
+        System.out.println(dist[D]);
+        
    }
+    
+    public static void dijkstra(int st){
+        if(st >= D) return;
+        
+        if(dist[st+1] > dist[st] + 1){
+            dist[st+1] = dist[st]+1;
+        }
+        
+        for(int i=0; i<roads[st].size(); i++){
+            Node shc = roads[st].get(i);
+            if(dist[st] + shc.w < dist[shc.ed]){
+                dist[shc.ed] = dist[st] + shc.w;
+            }
+        }
+        
+        dijkstra(st+1);
+    }
}

```


 ## 🏆 전체 코멘트 

1. dp와 dijkstra 를 사용하면 된다.