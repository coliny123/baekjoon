# [Silver II] 친구 - 1058 

[문제 링크](https://www.acmicpc.net/problem/1058) 

### 분류

브루트포스 알고리즘, 플로이드–워셜, 그래프 이론, 그래프 탐색, 최단 경로

### 문제 설명

<p>지민이는 세계에서 가장 유명한 사람이 누구인지 궁금해졌다. 가장 유명한 사람을 구하는 방법은 각 사람의 2-친구를 구하면 된다. 어떤 사람 A가 또다른 사람 B의 2-친구가 되기 위해선, 두 사람이 친구이거나, A와 친구이고, B와 친구인 C가 존재해야 된다. 여기서 가장 유명한 사람은 2-친구의 수가 가장 많은 사람이다. 가장 유명한 사람의 2-친구의 수를 출력하는 프로그램을 작성하시오.</p>

<p>A와 B가 친구면, B와 A도 친구이고, A와 A는 친구가 아니다.</p>

### 입력 

 <p>첫째 줄에 사람의 수 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 각 사람이 친구이면 Y, 아니면 N이 주어진다.</p>

### 출력 

 <p>첫째 줄에 가장 유명한 사람의 2-친구의 수를 출력한다.</p>



#  🚀  오답노트 

```diff
-import java.util.*;
-import java.io.*;
-
-public class Main {
-    public static void main(String[] args) throws IOException{
-        // 코드를 작성해주세요
-        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
-        int N = Integer.valueOf(br.readLine());
-        
-        int[][] friends = new int[N][N];
-        for(int i=0; i<N; i++){
-            String input = br.readLine();
-            for(int j=0; j<N; j++){
-                friends[i][j] = input.charAt(j) == 'Y' ? 1 : 100000000;
-            }
-        }
-        
-        
-        for(int i=0; i<N; i++){
-            for(int j=0; j<N; j++){
-                for(int k=0; k<N; k++){
-                    if(i==j) continue;
-                    friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
-                }
-            }
-        }
-        
-        int max=0;
-        for(int i=0; i<N; i++){
-            int cnt = 0;
-            for(int j=0; j<N; j++){
-                if(friends[i][j] <= 2) cnt++;
-            }
-            max = Math.max(max, cnt);
-        }
-        System.out.println(max);
-    }
-}

```


 ## 🏆 전체 코멘트 

1.플로이드워셜 사용 문제
모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구해야 하는 경우에 사용, 시간 복잡도는 O(N^3)
점화식 Dab = min(Dab, Dak + Dkb);

2. 먼저 친구 단계를 카운트하는 friends 배열을 Y일 경우는 1 나머지 경우는 큰 값으로 초기화 한다.
3. 플로이드워셜 알고리즘(3중 for문)을 돌며 
for문의 첫 번째 루프에서 i는 거쳐가는 노드의 인덱스를 나타낸다. 즉 1부터 N까지의 모든 노드들을 한 번씩 거쳐가는 경우를 검사한다.
for문의 두 번째와 세 번째 루프에서 j와 k는 출발 노드와 도착 노드의 인덱스를 나타낸다. 따라서 j부터 k까지의 최단 경로를 갱신하는 것이 목표이다.

이렇게 하게되면 친구의 단계가 나타난다.

4. 2차원배열을 탐색하면서 각 row별로 단계가 2 이하인 col의 갯수만 count하면 된다.


