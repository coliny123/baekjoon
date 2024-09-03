# [Bronze I] 피보나치 수 2 - 2748 

[문제 링크](https://www.acmicpc.net/problem/2748) 

### 분류

다이나믹 프로그래밍, 수학

### 문제 설명

<p>피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.</p>

<p>이를 식으로 써보면 F<sub>n</sub> = F<sub>n-1</sub> + F<sub>n-2</sub> (n ≥ 2)가 된다.</p>

<p>n=17일때 까지 피보나치 수를 써보면 다음과 같다.</p>

<p>0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597</p>

<p>n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 n이 주어진다. n은 90보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>첫째 줄에 n번째 피보나치 수를 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
-        int dp[] = new int [n+1];
+        long dp[] = new long [n+1];
        
        dp[1]=1;
        if(n>=2){
            dp[2]=1;
            for(int i=3; i<=n; i++){
                dp[i] = dp[i-2] + dp[i-1];
            }
        }
        
        System.out.println(dp[n]);
    }
}

```


 ## 🏆 전체 코멘트 

1. n이 1일때 dp[2]하면 에러
2. 주어진 조건을 잘 보고 int인지 long인지 자료형 잘 생각하기