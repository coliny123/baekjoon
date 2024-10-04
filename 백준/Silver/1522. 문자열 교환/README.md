# [Silver I] 문자열 교환 - 1522 

[문제 링크](https://www.acmicpc.net/problem/1522) 

### 분류

브루트포스 알고리즘, 슬라이딩 윈도우

### 문제 설명

<p>a와 b로만 이루어진 문자열이 주어질 때,  a를 모두 연속으로 만들기 위해서 필요한 교환의 회수를 최소로 하는 프로그램을 작성하시오.</p>

<p>이 문자열은 원형이기 때문에, 처음과 끝은 서로 인접해 있는 것이다.</p>

<p>예를 들어,  aabbaaabaaba이 주어졌을 때, 2번의 교환이면 a를 모두 연속으로 만들 수 있다.</p>

### 입력 

 <p>첫째 줄에 문자열이 주어진다. 문자열의 길이는 최대 1,000이다.</p>

### 출력 

 <p>첫째 줄에 필요한 교환의 회수의 최솟값을 출력한다.</p>



#  🚀  오답노트 

```diff
+import java.util.*;
+
+
public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
+        Scanner sc = new Scanner(System.in);
+        
+        String str = sc.nextLine();
+        
+        int a_cnt=0;
+        for(int i=0; i<str.length(); i++)
+            if(str.charAt(i) == 'a') a_cnt++;
+        
+        int min = str.length();
+        for(int i=0; i<str.length(); i++){
+            int b_cnt = 0;
+            for(int j=i; j<a_cnt+i; j++){
+                if(str.charAt(j%str.length()) == 'b') b_cnt++;
+            }
+            min = Math.min(min, b_cnt);
+        }
+        
+        System.out.println(min);
    }
}

```


 ## 🏆 전체 코멘트 

1. 이 문제의 알고리즘은 슬라이딩 윈도우다. 윈도우의 크기를 어떻게 잡아야할 지 고민했는데, b가 최소로 바뀌는 횟수는 문자열의 모든 a가 이어저있어야하므로 윈도우의 크기는 모든 a의 크기와 같아야한다.
2. 윈도우를 이동하며 b가 가장 적게 등장하는 값이 이동횟수의 최소값이다.
3. 또한 문자열이 앞과 뒤가 이어져있기 때문에 모듈러 연산을 통해 처리해주는 것이 필요하다.