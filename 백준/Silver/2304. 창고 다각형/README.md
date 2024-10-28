# [Silver II] 창고 다각형 - 2304 

[문제 링크](https://www.acmicpc.net/problem/2304) 

### 분류

브루트포스 알고리즘, 자료 구조, 구현, 스택

### 문제 설명

<p>N 개의 막대 기둥이 일렬로 세워져 있다. 기둥들의 폭은 모두 1 m이며 높이는 다를 수 있다. 이 기둥들을 이용하여 양철로 된 창고를 제작하려고 한다. 창고에는 모든 기둥이 들어간다. 이 창고의 지붕을 다음과 같이 만든다.</p>

<ol>
	<li>지붕은 수평 부분과 수직 부분으로 구성되며, 모두 연결되어야 한다.</li>
	<li>지붕의 수평 부분은 반드시 어떤 기둥의 윗면과 닿아야 한다.</li>
	<li>지붕의 수직 부분은 반드시 어떤 기둥의 옆면과 닿아야 한다.</li>
	<li>지붕의 가장자리는 땅에 닿아야 한다.</li>
	<li>비가 올 때 물이 고이지 않도록 지붕의 어떤 부분도 오목하게 들어간 부분이 없어야 한다.</li>
</ol>

<p>그림 1은 창고를 옆에서 본 모습을 그린 것이다. 이 그림에서 굵은 선으로 표시된 부분이 지붕에 해당되고, 지붕과 땅으로 둘러싸인 다각형이 창고를 옆에서 본 모습이다. 이 다각형을 창고 다각형이라고 하자.</p>

<p style="text-align: center;"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/JudgeOnline/upload/201011/cd.png" style="height:331px; width:483px"></p>

<p style="text-align: center;">그림1 . 기둥과 지붕(굵은 선)의 예</p>

<p>창고 주인은 창고 다각형의 면적이 가장 작은 창고를 만들기를 원한다. 그림 1에서 창고 다각형의 면적은 98 ㎡이고, 이 경우가 가장 작은 창고 다각형이다.</p>

<p>기둥들의 위치와 높이가 주어질 때, 가장 작은 창고 다각형의 면적을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫 줄에는 기둥의 개수를 나타내는 정수 N이 주어진다. N은 1 이상 1,000 이하이다. 그 다음 N 개의 줄에는 각 줄에 각 기둥의 왼쪽 면의 위치를 나타내는 정수 L과 높이를 나타내는 정수 H가 한 개의 빈 칸을 사이에 두고 주어진다. L과 H는 둘 다 1 이상 1,000 이하이다.</p>

### 출력 

 <p>첫 줄에 창고 다각형의 면적을 나타내는 정수를 출력한다.</p>



#  🚀  오답노트 

```diff
+import java.util.*;
+
public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
+        Scanner sc = new Scanner(System.in);
+        
+        int N = sc.nextInt();
+        int[][] arr = new int[N][2];
+        
+        sc.nextLine();
+        int maxHight = 0;
+        for(int i=0; i<N; i++){
+            String[] input = sc.nextLine().split(" ");
+            int idx = Integer.valueOf(input[0]);
+            int high = Integer.valueOf(input[1]);
+            
+            arr[i] = new int[]{idx, high};
+            maxHight = Math.max(maxHight, high);
+        }
+        
+        Arrays.sort(arr, (o1, o2) -> (o1[0] - o2[0]));
+        
+        // left
+        long sum=0;
+        int[] lt = arr[0];
+        for(int i=1; i<N; i++){
+            if(lt[1] < arr[i][1]){
+                sum += lt[1] * (arr[i][0] - lt[0]);
+                lt = arr[i];
+                if(lt[1] == maxHight) break;
+            }
+        }
+        
+        // right
+        int[] rt = arr[N-1];
+        for(int i=N-2; i>=0; i--){
+            if(rt[1] < arr[i][1]){
+                sum += rt[1] * (rt[0] - arr[i][0]);
+                rt = arr[i];
+                if(rt[1] == maxHight) break;
+            }
+        }
+        
+        sum += (rt[0] - lt[0] + 1) * maxHight;
+        
+        System.out.println(sum);
    }
}

```


 ## 🏆 전체 코멘트 

1. maxHight을 찾는다.
2. 왼쪽과 오른쪽 양쪽에서 순회하며 현재 상태의 최대값을 갱신하며 sum을 더해간다.
3.maxHight에 도달한 경우 순회를 멈춘다.
4. 양쪽 max의 idx를 통해 마지막 제일 높은 부분을 더한다