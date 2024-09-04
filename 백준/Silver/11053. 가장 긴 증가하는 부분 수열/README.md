# [Silver II] 가장 긴 증가하는 부분 수열 - 11053 

[문제 링크](https://www.acmicpc.net/problem/11053) 

### 분류

다이나믹 프로그래밍

### 문제 설명

<p>수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.</p>

<p>예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {<strong>10</strong>, <strong>20</strong>, 10, <strong>30</strong>, 20, <strong>50</strong>} 이고, 길이는 4이다.</p>

### 입력 

 <p>첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.</p>

<p>둘째 줄에는 수열 A를 이루고 있는 A<sub>i</sub>가 주어진다. (1 ≤ A<sub>i</sub> ≤ 1,000)</p>

### 출력 

 <p>첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.</p>



#  🚀  오답노트 

```diff
-import java.util.*;
-
-public class Main {
-    public static void main(String[] args) {
-        // 코드를 작성해주세요
-        Scanner sc = new Scanner(System.in);
-        int n = sc.nextInt();
-        int nums[] = new int[n];
-        int dp[] = new int[n];
-        
-        for(int i=0; i<n; i++){
-            nums[i] = sc.nextInt();
-        }
-        
-        int max = 1;
-        for(int i=0; i<n; i++){
-            dp[i] = 1;
-            for(int j=0; j<i; j++){
-                if(nums[i] > nums[j] && dp[i] < dp[j]+1){
-                    dp[i] = dp[j] + 1;
-                }
-            }
-            max = Math.max(max, dp[i]);
-        }
-        
-        System.out.println(max);
-    }
-}

```


 ## 🏆 전체 코멘트 

1. 기본적으로 최대 길이를 1이라고 생각
2. 2번째 for문은 증가 수열이 끊겼을 때 이전 nums들 중에서 현재 값보다 작으며  증가 수열 길이(dp)가 큰 것을 현재 증가 수열 길이에 넣어준다. -> 그럼 자연스럽게 현재값보다 작으면서 증가 수열이 큰 값+1로 이어진다. 