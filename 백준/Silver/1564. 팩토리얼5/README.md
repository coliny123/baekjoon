# [Silver I] 팩토리얼5 - 1564 

[문제 링크](https://www.acmicpc.net/problem/1564) 

### 분류

수학, 정수론

### 문제 설명

<p>팩토리얼5란, N!의 0이 아닌 뒤 5자리를 말한다.</p>

<p>N이 주어졌을 때, 팩토리얼5를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 정수 N이 주어진다. N은 1,000,000보다 작거나 같다. 또, 9보다 크거나 같다.</p>

### 출력 

 <p>첫째 줄에 N의 팩토리얼5를 계산한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long dp[] = new long [N+1];
        
        dp[1] = 1;
        for(int i=2; i<=N; i++){
            long temp = dp[i-1] * i;
            if(temp%10 == 0){
                while(temp%10==0){
                    temp /= 10;
                }
            }
            
-            temp %= (long)1e14;
+            temp %= (long)1e12;
            dp[i] = temp;
        }
        
        String answer = "";
        long num = dp[N]%100000;
        if(num < 10000) answer += "0";
        if(num < 1000) answer += "0";
        if(num < 100) answer += "0";
        if(num < 10) answer += "0";
        
        answer += num + "";
        
        System.out.println(answer);

        
        
    }
    
    
    
}

```


 ## 🏆 전체 코멘트 

1. 꽤나 큰 수로 해야 됨
