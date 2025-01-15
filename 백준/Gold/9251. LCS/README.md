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
-import java.io.*;
-
-public class Main {
-    public static void main(String[] args) throws IOException{
-        // 코드를 작성해주세요
-        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
-        
-        String first = br.readLine();
-        String second = br.readLine();
-        
-        
-        int[][] dp = new int[first.length()+1][second.length()+1];
-        
-        for(int i=1; i<=first.length(); i++){
-            for(int j=1; j<=second.length(); j++){
-                if(first.charAt(i-1) == second.charAt(j-1)){
-                    dp[i][j] = dp[i-1][j-1] + 1;
-                }else{
-                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
-                }
-            }
-        }
-        
-        // for(int i=0; i<=first.length(); i++){
-            // for(int j=0; j<=second.length(); j++){
-                // System.out.print(dp[i][j] + " ");
-            // }
-            // System.out.println();
-        // }
-        
-        System.out.println(dp[first.length()][second.length()]);
-        
-    }
-}

```


 ## 🏆 전체 코멘트 

1. LCS는 2차원 DP로 판단