# [Silver V] 폴리오미노 - 1343 

[문제 링크](https://www.acmicpc.net/problem/1343) 

### 분류

그리디 알고리즘, 구현

### 문제 설명

<p>민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. AAAA와 BB</p>

<p>이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다. 이때, '.'는 폴리오미노로 덮으면 안 된다.</p>

<p>폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 보드판이 주어진다. 보드판의 크기는 최대 50이다.</p>

### 출력 

 <p>첫째 줄에 사전순으로 가장 앞서는 답을 출력한다. 만약 덮을 수 없으면 -1을 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
-        String[] poly = {"AAAA", "BB"};
        String str = sc.nextLine();
-        StringBuilder sb = new StringBuilder();
-        int cnt=0;
-        for(int i=0; i<str.length(); i++){
-            if(str.charAt(i) != '.'){
-                cnt++;
-                if(cnt == 4){
-                    sb.append(poly[0]);
-                    cnt=0;
-                }
-            }else{
-                if(cnt % 2 == 0){
-                    if(cnt!=0) sb.append(poly[1]);
-                }else{
-                    System.out.println(-1);
-                    return;
-                }
-                sb.append(".");
-                cnt=0;
-            }
-        }
+        str = str.replaceAll("XXXX", "AAAA");
+        str = str.replaceAll("XX", "BB");
+        if(str.contains("X")) System.out.println(-1);
+        else System.out.println(str);
        
-        if(cnt%2==0){
-            if(cnt!=0) sb.append(poly[1]);
-        }else{
-            System.out.println(-1);
-            return;
-        }
        
-        System.out.println(sb);
-        
-        
    }
}

```


 ## 🏆 전체 코멘트 

1. string의 replaceAll 함수를 사용해서 XXXX -> AAAA먼저 바꾸고 XX -> BB를 바꾼다 그리고 X가 남아있으면 -1 아니면 STR 출력