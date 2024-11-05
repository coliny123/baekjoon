# [Gold V] 다이어트 - 1484 

[문제 링크](https://www.acmicpc.net/problem/1484) 

### 분류

수학, 두 포인터

### 문제 설명

<p>성원이는 다이어트를 시도중이다. 성원이는 정말 정말 무겁기 때문에, 저울이 부셔졌다. 성원이의 힘겨운 다이어트 시도를 보고만 있던 엔토피아는 성원이에게 새로운 저울을 선물해 주었다. 성원이는 엔토피아가 선물해준 저울 위에 올라갔다. “안돼!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! G 킬로그램이나 더 쪘어ㅜㅠ”라고 성원이가 말했다. 여기서 말하는 G킬로그램은 성원이의 현재 몸무게의 제곱에서 성원이가 기억하고 있던 몸무게의 제곱을 뺀 것이다.</p>

<p>성원이의 현재 몸무게로 가능한 것을 모두 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 G가 주어진다. G는 100,000보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>첫째 줄부터 한 줄에 하나씩 가능한 성원이의 현재 몸무게를 오름차순으로 출력한다. 가능한 몸무게가 없을 때는 -1을 출력한다. 현재 몸무게는 자연수로 떨어지지 않을 수도 있는데, 이런 경우는 제외해야 한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int G = sc.nextInt();
        
        int lt = 1;
        int rt = 1;
        
-        TreeSet<Integer> set = new TreeSet<>();
-        
-        while((int)Math.pow(rt, 2) - (int)Math.pow(rt-1, 2) <= G){
-            int val = (int)Math.pow(rt, 2) - (int)Math.pow(lt, 2);
+        int cnt=0;
+        while(2*rt - 1 <= G){
+            int val = (rt + lt) * (rt - lt);
            if(val <= G){
-                if(val == G) set.add(rt);
+                if(val == G){
+                    cnt++;
+                    System.out.println(rt);
+                };
                rt++;
            }else{
                lt++;
            }
        }
        
-        for(int a : set){
-            System.out.println(a);
+        if(cnt == 0){
+            System.out.println(-1);
        }
    }
}

```


 ## 🏆 전체 코멘트 

1. 처음에 G만 제한이 있고 lt와 rt의 제한이 없어서 당황했다. 그러나 나열해서 확인해보니 10^2 - 9^2의 경우 15를 넘어 버리므로 이것으로 범위 제한을 두면 된다는 것을 알았다.
2. Math.pow(x,2)를 통해 제곱을 한 뒤 차를 구했지만, 이 방법은 시간초과가 발생했다. 그래서 메서드를 사용하지 않고 방정식을 풀어 계산하도록 수정했다.
2-1) rt^2 - (rt-1)^2 = (rt + (rt-1)) * (rt - (rt-1)) = 2rt +1
2-2) rt^2 - lt^2 = (rt + lt) * (rt - lt)