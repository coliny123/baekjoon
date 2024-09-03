# [Silver I] IOIOI - 5525 

[문제 링크](https://www.acmicpc.net/problem/5525) 

### 분류

문자열

### 문제 설명

<p>N+1개의 <code>I</code>와 N개의 <code>O</code>로 이루어져 있으면, <code>I</code>와 <code>O</code>이 교대로 나오는 문자열을 P<sub>N</sub>이라고 한다.</p>

<ul>
	<li>P<sub>1</sub> <code>IOI</code></li>
	<li>P<sub>2</sub> <code>IOIOI</code></li>
	<li>P<sub>3</sub> <code>IOIOIOI</code></li>
	<li>P<sub>N</sub> <code>IOIOI...OI</code> (<code>O</code>가 N개)</li>
</ul>

<p><code>I</code>와 <code>O</code>로만 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 P<sub>N</sub>이 몇 군데 포함되어 있는지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다. 둘째 줄에는 S의 길이 M이 주어지며, 셋째 줄에 S가 주어진다.</p>

### 출력 

 <p>S에 P<sub>N</sub>이 몇 군데 포함되어 있는지 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
-        int n = sc.nextInt();
-        StringBuilder sb = new StringBuilder();
-        sb.append("I");
-        for(int i=0; i<n; i++){
-            sb.append("OI");
-        }
-        String p = sb.toString();
-        
-        int s = sc.nextInt();
+        int N = sc.nextInt();
+        int M = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
-        int cnt = 0;
-        for(int i=0; i<=s-p.length(); i++){
-            boolean flag = false;
-            if(str.charAt(i) == 'I'){
-                for(int j=0; j<p.length(); j++){
-                    if(p.charAt(j) != str.charAt(i+j)){
-                        flag = true;
-                        break;
-                    }
+        
+        int answer=0;
+        int count=0;
+        for(int i=1; i<M-1; i++){
+            if(str.charAt(i-1)=='I' && str.charAt(i)=='O' && str.charAt(i+1)=='I'){
+                count++;
+                if(count == N){
+                    count--;
+                    answer++;
                }
-                if(!flag){
-                    cnt++;
-                }
+                i++;
+            }else{
+                count=0;
            }
+            
        }
        
-        System.out.println(cnt);
-        
+        System.out.println(answer);
    }
}

```


 ## 🏆 전체 코멘트 

1. 모든 자리에서 일치하는지 검사를 하면 시간 초과가 남
2. OI가 반복되는 것을 이용해서 IOI 패턴이 나오면 i++을 해줘서 IOI"OI"로 이동한다 그럼 뒤에도 IOI 패턴이 일치하는지 확인할 수 있으며 일치하면 연속 카운트++해주고 일치하지 않으면 연속 카운트를 0으로 초기화 한다.
3. 연속카운트가 N과 같아지면 겹치는 경우를 처리하기 위해 연속 카운트--를 해주고 answer++해준다.