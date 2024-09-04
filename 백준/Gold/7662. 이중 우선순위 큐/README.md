# [Gold IV] 이중 우선순위 큐 - 7662 

[문제 링크](https://www.acmicpc.net/problem/7662) 

### 분류

자료 구조, 우선순위 큐, 트리를 사용한 집합과 맵

### 문제 설명

<p>이중 우선순위 큐(dual priority queue)는 전형적인 우선순위 큐처럼 데이터를 삽입, 삭제할 수 있는 자료 구조이다. 전형적인 큐와의 차이점은 데이터를 삭제할 때 연산(operation) 명령에 따라 우선순위가 가장 높은 데이터 또는 가장 낮은 데이터 중 하나를 삭제하는 점이다. 이중 우선순위 큐를 위해선 두 가지 연산이 사용되는데, 하나는 데이터를 삽입하는 연산이고 다른 하나는 데이터를 삭제하는 연산이다. 데이터를 삭제하는 연산은 또 두 가지로 구분되는데 하나는 우선순위가 가장 높은 것을 삭제하기 위한 것이고 다른 하나는 우선순위가 가장 낮은 것을 삭제하기 위한 것이다. </p>

<p>정수만 저장하는 이중 우선순위 큐 Q가 있다고 가정하자. Q에 저장된 각 정수의 값 자체를 우선순위라고 간주하자. </p>

<p>Q에 적용될 일련의 연산이 주어질 때 이를 처리한 후 최종적으로 Q에 저장된 데이터 중 최댓값과 최솟값을 출력하는 프로그램을 작성하라.</p>

### 입력 

 <p>입력 데이터는 표준입력을 사용한다. 입력은 T개의 테스트 데이터로 구성된다. 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다. 각 테스트 데이터의 첫째 줄에는 Q에 적용할 연산의 개수를 나타내는 정수 k (k ≤ 1,000,000)가 주어진다. 이어지는 k 줄 각각엔 연산을 나타내는 문자(‘D’ 또는 ‘I’)와 정수 n이 주어진다. ‘I n’은 정수 n을 Q에 삽입하는 연산을 의미한다. 동일한 정수가 삽입될 수 있음을 참고하기 바란다. ‘D 1’는 Q에서 최댓값을 삭제하는 연산을 의미하며, ‘D -1’는 Q 에서 최솟값을 삭제하는 연산을 의미한다. 최댓값(최솟값)을 삭제하는 연산에서 최댓값(최솟값)이 둘 이상인 경우, 하나만 삭제됨을 유념하기 바란다.</p>

<p>만약 Q가 비어있는데 적용할 연산이 ‘D’라면 이 연산은 무시해도 좋다. Q에 저장될 모든 정수는 -2<sup>31</sup> 이상 2<sup>31</sup> 미만인 정수이다. </p>

### 출력 

 <p>출력은 표준출력을 사용한다. 각 테스트 데이터에 대해, 모든 연산을 처리한 후 Q에 남아 있는 값 중 최댓값과 최솟값을 출력하라. 두 값은 한 줄에 출력하되 하나의 공백으로 구분하라. 만약 Q가 비어있다면 ‘EMPTY’를 출력하라.</p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
        int t = Integer.valueOf(br.readLine());
        
        // 오름차순
        StringBuilder sb = new StringBuilder();
        
        while(t-- > 0){
-            PriorityQueue<Integer> uq = new PriorityQueue<>();
-            // 내림차순
-            PriorityQueue<Integer> dq = new PriorityQueue<>(Collections.reverseOrder());
-            Map<Integer, Integer> map = new HashMap<>();
+            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.valueOf(br.readLine());
            while(k-- > 0){
                String input[] = br.readLine().split(" ");
                String com = input[0];
                int what = Integer.valueOf(input[1]);
                
                if(com.equals("I")){
                    map.put(what, map.getOrDefault(what, 0)+1);
-                    uq.add(what);
-                    dq.add(what);
                }else{
-                    if(map.size()==0){
-                        continue;
-                    }
-                    PriorityQueue<Integer> q;
+                    if(map.size()==0) continue;
+                    
+                    int key;
+                    // Entry<Integer, Integer> entry;
                    if(what == -1){
-                        q = uq;
+                        key = map.firstKey();
+                        // entry = map.firstEntry();
                    }else{
-                        q = dq;
+                        key = map.lastKey();
+                        // entry = map.lastEntry();
                    }
                    
-                    removeTarget(map, q);
-                    
-                    // if(map.size() != 0){
-                        // if(what == -1){
-                            // int uq.poll();
-                            // dq.remove(uq.poll());
-                        // }else{
-                            // uq.remove(dq.poll());
-                        // }
-                    // }
+                    if(map.get(key) == 1){
+                        map.remove(key);
+                    }else{
+                        map.put(key, map.get(key)-1);
+                        // map.replace(entry.getKey(), entry.getValue(), entry.getValue()-1);
+                    }
                }
            }
            
-            if(map.size()==0){
+            
+            if(map.size() == 0){
                System.out.println("EMPTY");
            }else{
-                int n = removeTarget(map, dq);
-                System.out.println(n + " " + (map.size() > 0 ? removeTarget(map, uq) : n));
-            }   
-        }
-    }
-    
-    public static int removeTarget(Map<Integer, Integer> map, PriorityQueue<Integer> q){
-        int num;
-        while(true){ // 하나의 q에서만 삭제하니까 다른 쪽에서는 남아있을 수 있으므로 반복문으로 맞춰주는 과정
-            num = q.poll();
-            int cnt = map.getOrDefault(num, 0);
-            if(cnt == 0){
-                continue;
+                System.out.println(map.lastKey() + " " + map.firstKey());
            }
-            
-            if(cnt == 1){
-                map.remove(num);
-            }else{
-                map.put(num, map.get(num)-1);
-            }
-            
-            break;
        }
        
-        return num;
+        
+        
    }
}

```


 ## 🏆 전체 코멘트 

1. 우선순위 큐 + HashMap
1-1)이중 우선순위 큐라서 처음에는 우선순위 큐 두 개를 만들어서 dq.remove(uq.poll());로 풀려고 했다. 그러나 remove 함수의 경우 순차적으로 접근하여 equals == true일 경우 제거하기 때문에 O(N) 이기 때문에 시간초과가 발생한다.
1-2)그래서 찾아보았더니 map을 사용해서 전체적으로 숫자와 갯수를 관리하는 방법이 있었다. + TreeMap도 있음 
1-3) removeTarget을 할 때 해당하는 큐에서 poll한뒤 map에서도 처리하면 될 것이라고 생각했지만 하나의 큐에서만 제거되기 때문에 만약 map에 존재하지 않을 경우 {5, 5, 5} 가 들어간 경우 uq와 dq 모두 동일하게 가지고 있지만 map에서 삭제시 반대 큐와 동기화 할 수 없으므로 sync를 맞추기 위해 계속 제거해주는 과정이 필요하므로 반복문이 필요했다.

2. TreeMap
TreeMap이란 TreeMap은 이진트리를 기반으로 한 Map 컬렉션이다. TreeMap에 객체를 저장하면 자동으로 정렬되는데, 키는 저장과 동시에 자동 오름차순으로 정렬된다.
이를 이용해서 fistKey()와 lastKey() 메서드를 사용하면 쉽게 풀 수 있다.