# [Gold V] 평범한 배낭 - 12865 

[문제 링크](https://www.acmicpc.net/problem/12865) 

### 분류

다이나믹 프로그래밍, 배낭 문제

### 문제 설명

<p>이 문제는 아주 평범한 배낭에 관한 문제이다.</p>

<p><span style="line-height:1.6em">한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다. 세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.</span></p>

<p><span style="line-height:1.6em">준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.</span></p>

### 입력 

 <p>첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다. 두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.</p>

<p>입력으로 주어지는 모든 수는 정수이다.</p>

### 출력 

 <p>한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

+class Node implements Comparable<Node>{
+    int w, v;
+    
+    public Node(int w, int v){
+        this.w=w;
+        this.v=v;
+    }
+    
+    @Override
+    public int compareTo(Node o){
+        if(w == o.w) return v-o.v;
+        else return w-o.w;
+    }
+}
+
public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
-        
        int N = Integer.valueOf(input[0]);
        int K = Integer.valueOf(input[1]);
        
-        int[] bag = new int[K];
+        int[] bags = new int[K+1];
        
+        Node[] things = new Node[N];
+        for(int i=0; i<N; i++){
+            input = br.readLine().split(" ");
+            things[i] = new Node(Integer.valueOf(input[0]), Integer.valueOf(input[1]));
+        }
+        
+        Arrays.sort(things);
+        
+        for(int i=0; i<N; i++){
+            for(int weight=K; weight>=0; weight--){
+                Node cur = things[i];
+                if(weight < cur.w) break;
+                bags[weight] = Math.max(bags[weight], bags[weight-cur.w] + cur.v);
+            }
+        }
+        
+        int max = 0;
+        for(int i=0; i<=K; i++){
+            max = Math.max(max, bags[i]);
+        }
+        System.out.println(max);
    }
}

```


 ## 🏆 전체 코멘트 

1. 냅색
2. 가방의 무게에 따른 가치를 업데이트할 1차원 배열 선언 / 물건들을 정렬함
3. 무게가 적은 순서, 그리고 가방 배열은 뒤에서 부터 값을 갱신