# [Gold IV] 루머 - 19538 

[문제 링크](https://www.acmicpc.net/problem/19538) 

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 문제 설명

<p>당신은 루머를 믿는가?</p>

<p>한 유명 심리학 실험에서는 사람들에게 두 개의 줄을 보여주고, 어떤 줄이 더 긴지 말하라 했다. 사실 한 사람을 제외하고 나머지는 실험자에 의해 사전에 조작된 사람들이었다. 조작된 사람들은 사실상 더 짧은 줄을 더 길다고 말했다. 주변 모두가 같은 답변을 하자, 진짜 피실험자 또한 짧은 줄이 더 길다고 말했다. 이 실험은 사람들이 주변인의 영향을 강하게 받는다는 것을 보여주었는데, 루머도 이와 같다.</p>

<p>루머는 최초 유포자로부터 시작한다. 최초 유포자는 여러 명일 수 있고, 최초 유포자를 제외하고 스스로 루머를 만들어 믿는 사람은 없다.</p>

<p>매분 루머를 믿는 사람은 모든 주변인에게 루머를 동시에 퍼트리며, 군중 속 사람은 주변인의 절반 이상이 루머를 믿을 때 본인도 루머를 믿는다.</p>

<p>루머를 믿는 순간부터 다른 말은 듣지 않기 때문에, 한번 믿은 루머는 계속 믿는다.</p>

<p>이때, 사람들이 루머를 처음 믿기 시작하는 시간을 알아내 보자.</p>

### 입력 

 <p>첫째 줄에 사람의 수 $N$이 주어진다. ($1 \leq N \leq 200\ 000$) 이는 $1$번 사람부터 $N$번 사람까지 있음을 의미한다.</p>

<p>둘째 줄부터 $N$개의 줄이 주어진다. 이 중 $i(1 \leq i \leq N)$번째 줄에는 $i$번 사람의 주변인들의 번호와 입력의 마지막을 나타내는 <span style="color:#e74c3c;"><code>0</code></span>이 공백으로 구분되어 주어진다. 번호는 $1$ 이상 $N$ 이하의 자연수이고, 같은 줄에 중복된 번호는 없다. 자기 자신이 주변인이거나 일방적으로 주변인인 경우는 없으며, 전체 양방향 주변인 관계는 $1\ 000\ 000$개를 넘지 않는다.</p>

<p>다음 줄에는 루머를 퍼뜨리는 최초 유포자의 수 $M$이 주어진다. $(1 \leq M \leq N)$</p>

<p>마지막 줄에는 최초 유포자의 번호가 공백으로 구분되어 주어진다. 최초 유포자의 번호는 중복되지 않는다.</p>

### 출력 

 <p>$N$개의 정수 $t_1,t_2,\cdots,t_N$을 공백 단위로 출력한다. $t_i$는 $i$번 사람이 루머를 처음 믿기 시작한 시간(분)이며, 충분히 많은 시간이 지나도 루머를 믿지 않을 경우 $-1$이다. 최초 유포자는 루머를 $0$분부터 믿기 시작했다고 생각한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;

-
-class Node{
-    int idx, time;
-    
-    public Node(int idx, int time){
-        this.idx=idx;
-        this.time=time;
-    }
-}
-
public class Main {
    public static int N, M;
    public static ArrayList<Integer>[] graph;
-    public static boolean[] believe;
+    public static int[] neighbor;
    public static int[] times;
-    public static Queue<Node> q = new LinkedList<>();
+    public static boolean[] beileve;
+    public static Queue<Integer> q = new LinkedList<>();
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
+        
        N = sc.nextInt();
        
-        believe = new boolean[N+1];
+        neighbor = new int[N+1];
+        times = new int[N+1];
+        beileve = new boolean[N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        
-        // 주변 관계 입력 받기
        for(int i=1; i<=N; i++){
            while(true){
                int who = sc.nextInt();
-                if(who==0) break;
+                if(who == 0) break;
                graph[i].add(who);
            }
        }
        
-        // 최초 유포자
+        Arrays.fill(times, -1);
+        
        M = sc.nextInt();
        while(M-- > 0){
-            int first = sc.nextInt();
-            believe[first] = true;
-            times[first] = 0;
-            q.add(new Node(first, 0));
+            int who = sc.nextInt();
+            beileve[who] = true;
+            times[who] = 0;
+            q.add(who);
        }
        
-        // 주변인 중 절반 이상 믿으면 본인도 믿음
+        BFS();
        
+        for(int i=1; i<=N; i++){
+            System.out.print(times[i] + " ");
+        }
    }
    
+    
    public static void BFS(){
        while(!q.isEmpty()){
-            Node cur = q.poll();
+            int cur = q.poll();
            
-            int cnt=0;
-            for(int man : graph[cur.idx]){
-                if(believe[man]) cnt++;
+            // 주변 사람들에게 전파
+            for(int nx : graph[cur]){
+                neighbor[nx]++;
+                // 절반이상 믿으면 
+                if(!beileve[nx] && neighbor[nx] >= (graph[nx].size()+1) / 2){
+                    beileve[nx] = true;
+                    q.add(nx);
+                    times[nx] = times[cur]+1;
+                }
            }
-            if(cnt >= (graph[cur.idx].size()/2 + graph[cur.idx].size()%2)){
-                believe[cur.idx] = true;
-                time
-            }
            
        }
    }
}

```


 ## 🏆 전체 코멘트 

1. 루머를 알고 있는 사람의 수를 각각 시기에 따라 다르게 처리해줘야했다.
ex) 1번에게 2번, 3번 처리 시 3번이 들었을 때는 동시에 들었기 때문에 3번은 절반 이상 안넘음
그리고 루머를 퍼트릴 때 지인의 neighbor를 증가시키고 그 때 절반 이상 믿고있으면 루머를 전파한다..(for문이 핵심)
2. 지인 중 루머를 알고있는 사람의 수를 neighbor 배열을 통해 처리
