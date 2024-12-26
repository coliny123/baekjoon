# [Gold V] LCS - 9251 

[문제 링크](https://www.acmicpc.net/problem/9251) 

### 분류

다이나믹 프로그래밍, 문자열

### 문제 설명

<p>LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.</p>

<p>예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.</p>

### 입력 

 <p>첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.</p>

### 출력 

 <p>첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.</p>



#  🚀  오답노트 

```diff
-import java.util.*;
-
-public class Main {
-    public static void main(String[] args) {
-        // 코드를 작성해주세요
-        Scanner sc = new Scanner(System.in);
-        
-        String a = sc.nextLine();
-        String b = sc.nextLine();
-        
-        int aLength = a.length();
-        int bLength = b.length();
-        
-        int[][] dp = new int[aLength+1][bLength+1];
-        
-        for(int i=1; i<=aLength; i++){
-            for(int j=1; j<=bLength; j++){
-                if(a.charAt(i-1) == b.charAt(j-1)){
-                    dp[i][j] = dp[i-1][j-1] + 1;
-                }else{
-                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
-                }
-            }
-        }
-        
-        
-        System.out.println(dp[aLength][bLength]);
-        
-        
-    }
-}

```


 ## 🏆 전체 코멘트 

1. LCS문제의 경우 의외로 쉽게 접근할 수 있는데, 부분수열에서 '순서'가 지켜지기 때문에 각 문자열들의 문자들을 서로 비교하면서 서로 같으면 값을 1씩 증가시키면서 누적합을 구하는 것이다.
2. 2차원 테이블을 만들어서 구할 수 있음