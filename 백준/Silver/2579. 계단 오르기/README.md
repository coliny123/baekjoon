# [Silver III] 계단 오르기 - 2579 

[문제 링크](https://www.acmicpc.net/problem/2579) 

### 분류

다이나믹 프로그래밍

### 문제 설명

<p>계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다. <그림 1>과 같이 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.</p>

<p style="text-align: center;"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.comhttps://u.acmicpc.net/7177ea45-aa8d-4724-b256-7b84832c9b97/Screen%20Shot%202021-06-23%20at%203.00.46%20PM.png" style="width: 300px; height: 160px;"></p>

<p style="text-align: center;"><그림 1></p>

<p>예를 들어 <그림 2>와 같이 시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째 계단을 밟아 도착점에 도달하면 총 점수는 10 + 20 + 25 + 20 = 75점이 된다.</p>

<p style="text-align: center;"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.comhttps://u.acmicpc.net/f00b6121-1c25-492e-9bc0-d96377c586b0/Screen%20Shot%202021-06-23%20at%203.01.39%20PM.png" style="width: 300px; height: 190px;"></p>

<p style="text-align: center;"><그림 2></p>

<p>계단 오르는 데는 다음과 같은 규칙이 있다.</p>

<ol>
	<li>계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.</li>
	<li>연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.</li>
	<li>마지막 도착 계단은 반드시 밟아야 한다.</li>
</ol>

<p>따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.</p>

<p>각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>입력의 첫째 줄에 계단의 개수가 주어진다.</p>

<p>둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다. 계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.</p>

### 출력 

 <p>첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[] nums = new int[N+1];
        for(int i=1; i<=N;i++){
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[N+1];
        
        dp[1] = nums[1];
-        dp[2] = dp[1] + nums[2];
-        dp[3] = Math.max(nums[2], nums[1]) + nums[3];
-        for(int i=4; i<=N; i++){
-            dp[i] = Math.max(dp[i-2], dp[3-1]) + nums[i];
+        if(N >=2){
+            dp[2] = dp[1] + nums[2];
+            if(N>=3){
+                dp[3] = Math.max(nums[2], nums[1]) + nums[3];
+                for(int i=4; i<=N; i++){
+                    dp[i] = Math.max(dp[i-2], dp[i-3] + nums[i-1]) + nums[i];
+                }
+            }
        }
        
        
        System.out.println(dp[N]);
    }
}

```


 ## 🏆 전체 코멘트 

1. N이 1<= N 이니까 2, 3 이상일 때 처리
2. 3칸 연속으로 이동 못하니까 (2칸 전에서 2칸 점프할 때, 3칸 전에서 2칸 점프 후 1칸 이동) 이 둘 중 큰 값 + nums[i]를 해야한다.
(dp[i-2], dp[i-1])을 할 경우 dp[i-1]이 두 칸 연속 이동한 상태일 수 도 있기 때문