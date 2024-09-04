# [Bronze I] 이항 계수 1 - 11050 

[문제 링크](https://www.acmicpc.net/problem/11050) 

### 분류

조합론, 구현, 수학

### 문제 설명

<p>자연수 \(N\)과 정수 \(K\)가 주어졌을 때 이항 계수 \(\binom{N}{K}\)를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 \(N\)과 \(K\)가 주어진다. (1 ≤ \(N\) ≤ 10, 0 ≤ \(K\) ≤ \(N\))</p>

### 출력 

 <p> \(\binom{N}{K}\)를 출력한다.</p>



#  🚀  오답노트 

```diff
-import java.util.*;
-
-public class Main {
-    public static void main(String[] args) {
-        // 코드를 작성해주세요
-        Scanner sc = new Scanner(System.in);
-        
-        int n = sc.nextInt();
-        int k = sc.nextInt();
-        
-        int dp[][] = new int[n+1][k+1];
-        
-        // 2번 성질 (k==0)
-        for(int i=0; i<=n; i++){
-            dp[i][0] = 1;
-        }
-        
-        // 2번 성질 (n==k)
-        for(int i=0; i<=k; i++){
-            dp[i][i] = 1;
-        }
-        
-        for(int i=2; i<=n; i++){
-            for(int j=1; j<=k; j++){
-                // 1번 성질
-                dp[i][j]=dp[i-1][j-1] + dp[i-1][j];
-            }
-        }
-        
-        System.out.println(dp[n][k]);
-        
-    }
-}

```


 ## 🏆 전체 코멘트 

1. 이항 계수의 성질 2가지를 활용할 것 
1) 먼저 2번 성질(k==0, n==k 일 때 1이다)를 활용하여 dp[i][0], dp[i][i]를 1로 초기화 해준다.
2) 1번 성질(이항)를 활용하여 dp[i][j] = dp[i-1][j-1] + dp[i-1]+dp[j]의 점화식을 세워준다.
2. [0][0], [1][0], [1][1]이 모두 1로 초기화 되어 있으므로 [2][1]부터 bottum up 함 