# [Silver II] A → B - 16953 

[문제 링크](https://www.acmicpc.net/problem/16953) 

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색, 그리디 알고리즘

### 문제 설명

<p>정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.</p>

<ul>
	<li>2를 곱한다.</li>
	<li>1을 수의 가장 오른쪽에 추가한다. </li>
</ul>

<p>A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.</p>

### 입력 

 <p>첫째 줄에 A, B (1 ≤ A < B ≤ 10<sup>9</sup>)가 주어진다.</p>

### 출력 

 <p>A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;

class Node{
-    int idx, cnt;
+    long idx;
+    int cnt;
    
-    public Node(int idx, int cnt){
+    public Node(long idx, int cnt){
        this.idx=idx;
        this.cnt=cnt;
    }
}

public class Main {
-    public static int A;
-    public static int B;
+    public static long A;
+    public static long B;
    public static int answer=Integer.MAX_VALUE;
    public static Queue<Node> q = new LinkedList<>();
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
-        A = sc.nextInt();
-        B = sc.nextInt();
+        A = sc.nextLong();
+        B = sc.nextLong();
        
        q.add(new Node(A, 0));
        BFS();
        
        if(answer==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer+1);
        }
        
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            Node curN = q.poll();
            if(curN.idx == B){
                answer = Math.min(answer, curN.cnt);
            }
            
            String curStr = String.valueOf(curN.idx);
            if((curN.idx*10+1) <= B){
                q.add(new Node(curN.idx*10+1, curN.cnt+1));
            }
            if((curN.idx*2) <= B){
                q.add(new Node(curN.idx*2, curN.cnt+1));
            }
        }
    }
}
```


 ## 🏆 전체 코멘트 

1. A,B가 10의9승이라 배열을 선언하면 공간 제한을 초과할 것이라고 생각하여 최솟값 카운팅하는 변수만 사용했다.
2. 10의 9승이기 때문에 INT형으로 해도 무리 없을 줄 알았지만 Queue에 넣기 전 판별 과정에서 (cur*2, cur*10+1) overflow가 발생하였다.