# [Silver I] 팩토리얼 0의 개수 - 11687 

[문제 링크](https://www.acmicpc.net/problem/11687) 

### 분류

이분 탐색, 수학, 정수론

### 문제 설명

<p>가장 끝의 0의 개수가 M개인 N! 중에서 가장 작은 N을 찾는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 M (1 ≤ M ≤ 100,000,000)이 주어진다.</p>

### 출력 

 <p>가장 끝의 0의 개수가 M개인 N! 중에서 가장 작은 N을 출력한다. 그러한 N이 없는 경우에는 -1을 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;

public class Main {
    public static int M;
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        
        int lt = 1;
        int rt = 1000000000;
        
        boolean find = false;
        int min = rt-1;
        while(lt <= rt){
            int mid = (lt + rt) / 2;
            
            int tempCnt = check(mid);
            if(tempCnt >= M){
                if(tempCnt == M){
                    find = true;
                    min = Math.min(min, mid);
                }
                rt = mid-1;
            }else{
                lt = mid+1;
            }
        }
        
-        // if(find){
-            // System.out.println(min);
-        // }else{
-            // System.out.println(-1);
-        // }
+        if(find){
+            System.out.println(min);
+        }else{
+            System.out.println(-1);
+        }
        
    }
    
    public static int check(int mid){
        int cnt = 0;
        for(int i=5; i<=mid; i*=5){
            cnt+=(mid/i);
        }
        return cnt;
    }
}


// 1
// 2
// 6
// 24
// 120            5!
// 760
// 5060
// 40320
// 362880
// 3628800        10!
// 1307674368000  15!
```


 ## 🏆 전체 코멘트 

1. 팩토리얼의 성질 : 뒤에 0이 늘어날 때는 2*5의 조합이 생길 때임
2는 2의 배수마다 생기므로 5보다 항상 더 많이 생기니까 5의 갯수에 따라 0이 붙는게 결정된다. (5!=0-1개, 10!=0-2개, 15!=0-3개, 25!의 경우 (5*5)! 이므로 5가 두개 나오니까 5의 배수로 나눴을 때의 갯수를 찾아야함)
2. 5의 갯수가 M보다 크거나 같다면 rt를 mid-1로 해줌 (==같은 경우 확실히 존재하기 때문에 find 변수로 체크, 정답 mid를 N에 저장해줌)
작다면 lt는 mid+1
