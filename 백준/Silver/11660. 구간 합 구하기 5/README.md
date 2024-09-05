# [Silver I] 구간 합 구하기 5 - 11660 

[문제 링크](https://www.acmicpc.net/problem/11660) 

### 분류

다이나믹 프로그래밍, 누적 합

### 문제 설명

<p>N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오. (x, y)는 x행 y열을 의미한다.</p>

<p>예를 들어, N = 4이고, 표가 아래와 같이 채워져 있는 경우를 살펴보자.</p>

<table class="table table-bordered" style="line-height:20.8px; width:158px">
	<tbody>
		<tr>
			<td style="text-align:center">1</td>
			<td style="text-align:center">2</td>
			<td style="text-align:center">3</td>
			<td style="text-align:center">4</td>
		</tr>
		<tr>
			<td style="text-align:center">2</td>
			<td style="text-align:center">3</td>
			<td style="text-align:center">4</td>
			<td style="text-align:center">5</td>
		</tr>
		<tr>
			<td style="text-align:center">3</td>
			<td style="text-align:center">4</td>
			<td style="text-align:center">5</td>
			<td style="text-align:center">6</td>
		</tr>
		<tr>
			<td style="text-align:center">4</td>
			<td style="text-align:center">5</td>
			<td style="text-align:center">6</td>
			<td style="text-align:center">7</td>
		</tr>
	</tbody>
</table>

<p>여기서 (2, 2)부터 (3, 4)까지 합을 구하면 3+4+5+4+5+6 = 27이고, (4, 4)부터 (4, 4)까지 합을 구하면 7이다.</p>

<p>표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때, 이를 처리하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다. (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000) 둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다. 다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며, (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다. 표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다. (x1 ≤ x2, y1 ≤ y2)</p>

### 출력 

 <p>총 M줄에 걸쳐 (x1, y1)부터 (x2, y2)까지 합을 구해 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
-        int grid[][] = new int[n][n];
-        int sum[][] = new int[n][n];
+        int grid[][] = new int[n+1][n+1];
+        int sum[][] = new int[n+1][n+1];
        
-        for(int i=0; i<n; i++){
-            for(int j=0; j<n; j++){
+        for(int i=1; i<=n; i++){
+            for(int j=1; j<=n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        
-        for(int i=0; i<n; i++){
-            sum[i][0] = grid[i][0];
-        }
-        
-        for(int i=0; i<n; i++){
-            for(int j=1; j<n; j++){
-                sum[i][j] = sum[i][j-1] + grid[i][j];
+        for(int i=1; i<=n; i++){
+            for(int j=1; j<=n; j++){
+                // 위 + 왼쪽은 (i-1,j-1)가 중복되므로 한 번 빼서 중복 제거
+                sum[i][j] = sum[i][j-1] +sum[i-1][j] - sum[i-1][j-1] + grid[i][j];
            }
        }
        
+        // for(int i=0; i<=n; i++){
+            // for(int j=0; j<=n; j++){
+                // System.out.print(sum[i][j]+" ");
+            // }
+            // System.out.println();
+        // }
        
+        
        for(int k=0; k<m; k++){
-            int x1 = sc.nextInt()-1;  // 1
-            int y1 = sc.nextInt()-1;  // 1
-            int x2 = sc.nextInt()-1;  // 2
-            int y2 = sc.nextInt()-1;  // 3
-            
-            int answer=0;
-            for(int i=x1; i<=x2; i++){
-                answer += (sum[i][y2] - sum[i][y1] + grid[i][y1]);
-            }
-            
-            System.out.println(answer);
+            int x1 = sc.nextInt();  // 1
+            int y1 = sc.nextInt();  // 1
+            int x2 = sc.nextInt();  // 2
+            int y2 = sc.nextInt();  // 3
+
+            // [x2][y2]에서 위에 좌상단의
+            System.out.println(sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1 -1]);
        }
    }
}


```


 ## 🏆 전체 코멘트 

1. 첫 번째 시도
매 test마다 완전 탐색하게 되면 1024*1024*100000으로 시간 초과가 될 것이라고 생각하여 가로의 누적합을 사용하려 했다. 그러나 1024*100000도 102,400,000으로 1초를 넘게 된다.
가로 세로의 누적합을 사용하는 방법으로 다시 시도

2. [n][n]을 만들어 누적합을 구한 뒤 해당되는 지역을 구하려 했지만 제거되는 지역을 제거하려햇으나  [0][i]나 [i][0]처럼 이전 값이 없는 경우가 존재하고 이를 해결하려고 해당되는 지역이지만 제거된 경우를 구하려면 다시 탐색을 해야하는 경우가 발생했다.

3. [n+1[n+1]로 하여 이전의 [0][i]나 [i][0]처럼 이전 값이 없는 경우 전에 0으로 채워 2번에서 발생했던 문제를 해결하였다.

grid형식의 누적합을 사용할 경우 [n][n] 을 고집하기보단 [n+1][n+1]로도 생각해볼 것!