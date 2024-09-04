# [Silver V] 다리 놓기 - 1010 

[문제 링크](https://www.acmicpc.net/problem/1010) 

### 분류

조합론, 다이나믹 프로그래밍, 수학

### 문제 설명

<p>재원이는 한 도시의 시장이 되었다. 이 도시에는 도시를 동쪽과 서쪽으로 나누는 큰 일직선 모양의 강이 흐르고 있다. 하지만 재원이는 다리가 없어서 시민들이 강을 건너는데 큰 불편을 겪고 있음을 알고 다리를 짓기로 결심하였다. 강 주변에서 다리를 짓기에 적합한 곳을 사이트라고 한다. 재원이는 강 주변을 면밀히 조사해 본 결과 강의 서쪽에는 N개의 사이트가 있고 동쪽에는 M개의 사이트가 있다는 것을 알았다. (N ≤ M)</p>

<p>재원이는 서쪽의 사이트와 동쪽의 사이트를 다리로 연결하려고 한다. (이때 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.) 재원이는 다리를 최대한 많이 지으려고 하기 때문에 서쪽의 사이트 개수만큼 (N개) 다리를 지으려고 한다. 다리끼리는 서로 겹쳐질 수 없다고 할 때 다리를 지을 수 있는 경우의 수를 구하는 프로그램을 작성하라.</p>

<p><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/upload/201003/pic1.JPG" style="height:353px; width:329px"></p>

### 입력 

 <p>입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 그 다음 줄부터 각각의 테스트케이스에 대해 강의 서쪽과 동쪽에 있는 사이트의 개수 정수 N, M (0 < N ≤ M < 30)이 주어진다.</p>

### 출력 

 <p>각 테스트 케이스에 대해 주어진 조건하에 다리를 지을 수 있는 경우의 수를 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;


public class Main {
+    public static int dp[][] = new int[31][31];
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
+        
        while(t-- > 0){
            int west = sc.nextInt();
            int east = sc.nextInt();
            
-            int answer=1;
-            for(int i=east; i>east-west; i--){
-                answer *= i;
-            }
-            System.out.println(answer);
+            // M개에서 N개를 선택.. 서로 중복되면 안된다.. -> 조합!!
+            // 교차하면 안되는 조건? -> 조합은 순서에 상관없이 1개로 보기 때문에 고려할 필요 없음!!
+            BC(east, west);
+            
+            System.out.println(dp[east][west]);
+            
        }
    }
+    
+    public static int BC(int x, int y){
+        // 이미 풀었던 sub문제일 경우 값을 재활용
+        if(dp[x][y] > 0){
+            return dp[x][y];
+        }
+        
+        // 2번 성질
+        if(x==y || y==0){
+            return dp[x][y] = 1;
+        }
+        
+        // 1번 성질
+        return dp[x][y] = BC(x-1, y-1) + BC(x-1, y);
+    }
}




```


 ## 🏆 전체 코멘트 

1. 재귀로 접근하려 했으나 수행시간 제한이 0.5초라서 수학적 접근을 생각했다. 그러나 조합 공식 및 성질을 못떠올렸다 ㅜㅜ
2. east개중에서 west개를 고르는 조합을 생각하면 되는데, 조합의 경우 {1, 3, 4}(교차x)나 {3, 1, 4}(교차o) 모두 하나의 경우로 보기 때문에 교차하는 경우를 고려할 필요가 없다.
3. 또한 dp를 사용해서 bottom-up을 하려고 했으나 t번 만큼 반복해야하기 때문에 먼저 dp 2차원 배열을 만들고 과거의 테스트 결과를 그대로 기억해두기로 함
4. 다음 테스트에서 중복되는 계산을 할 필요가 없기 때문에 재귀 + dp를 활용해서 이미 계산된 값이 있으면 바로 리턴하고 조합공식의 2번 성질을 활용해 (n==k, k==0)인 경우는 1을 저장하고 리턴 이외는 1번 성질을 이용해서 n-1,k-1과 n-1,k의 결과를 가져오도록함