# [Silver II] 나무 자르기 - 2805 

[문제 링크](https://www.acmicpc.net/problem/2805) 

### 분류

이분 탐색, 매개 변수 탐색

### 문제 설명

<p>상근이는 나무 M미터가 필요하다. 근처에 나무를 구입할 곳이 모두 망해버렸기 때문에, 정부에 벌목 허가를 요청했다. 정부는 상근이네 집 근처의 나무 한 줄에 대한 벌목 허가를 내주었고, 상근이는 새로 구입한 목재절단기를 이용해서 나무를 구할것이다.</p>

<p>목재절단기는 다음과 같이 동작한다. 먼저, 상근이는 절단기에 높이 H를 지정해야 한다. 높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라간다. 그 다음, 한 줄에 연속해있는 나무를 모두 절단해버린다. 따라서, 높이가 H보다 큰 나무는 H 위의 부분이 잘릴 것이고, 낮은 나무는 잘리지 않을 것이다. 예를 들어, 한 줄에 연속해있는 나무의 높이가 20, 15, 10, 17이라고 하자. 상근이가 높이를 15로 지정했다면, 나무를 자른 뒤의 높이는 15, 15, 10, 15가 될 것이고, 상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈 것이다. (총 7미터를 집에 들고 간다) 절단기에 설정할 수 있는 높이는 양의 정수 또는 0이다.</p>

<p>상근이는 환경에 매우 관심이 많기 때문에, 나무를 필요한 만큼만 집으로 가져가려고 한다. 이때, 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 나무의 수 N과 상근이가 집으로 가져가려고 하는 나무의 길이 M이 주어진다. (1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000)</p>

<p>둘째 줄에는 나무의 높이가 주어진다. 나무의 높이의 합은 항상 M보다 크거나 같기 때문에, 상근이는 집에 필요한 나무를 항상 가져갈 수 있다. 높이는 1,000,000,000보다 작거나 같은 양의 정수 또는 0이다.</p>

### 출력 

 <p>적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;

public class Main {
    public static int N, M;
    public static int trees[];
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        int max=0;
        trees = new int [N];
        for(int i=0; i<N; i++){
            trees[i] = sc.nextInt();
            max = Math.max(max, trees[i]);
        }
        
        
        System.out.println(BinarySearch(1, max, M));
        
    }
    
    public static long BinarySearch(int st, int ed, int target){
-        while(st < ed){
+        while(st <= ed){
            int mid = (st + ed) / 2;
            long sum=0;
            for(int tree:trees){
                if(tree-mid > 0){
                    sum += (tree-mid);
                }
            }
            
-            if(sum >= target){
+            if(sum < target){
+                ed = mid-1;
+            }else{
                st = mid+1;
-            }else{
-                ed = mid-1;
            }
        }
        
        return st-1;
    }
}

```


 ## 🏆 전체 코멘트 

1. 이분 탐색은 특정 값에 대한 배열의 특정 인덱스를 찾기 위한 것이다. 그러나 매개변수 탐색(파라메트릭 서치)는 인덱스가 아니라 조건에 일치하는 매개변수(길이)를 찾아야 하는 것이다.
즉, 간단하게 말하자면 최적화 문제를 결정 문제로 바꿔 푸는 방식이다.
최적화 : 적어도 M미터의 나무를 집에 가져가기 위해 절단기에 설정할 수 있는 H의 최댓값은 얼마인가?
결정 : 적어도 M미터의 나무를 집에 가져가기 위해 절단기에 설정할 수 있는 H가 되도록 할 수 있는가? (Yes or NO)

2. 이분 탐색에는 두가지 방식이 존재한다. (Upper Bound / Lower Bound)
Upper Bound : 찾고자 하는 특정 값을 초과하는 '첫 위치'를 반환
Lower Bound : 찾고자 하는 특정 값 이상인 '첫 위치'를 반환 
중복 값이 있을 때(sum) 길이가 가장 긴 것을 찾아야 하므로 Upper Bound(초과하는 첫위치)를 찾아주고 -1을 해주면 최대 길이가 된다.

3. 분기 조건(에 따라 upper bound / lower bound 나뉨)
잘라진 총 길이 >= 가져가야 할 길이 → 자르는 높이를 줄여야 함 → mid를 늘린다 → start = mid + 1
잘라진 총 길이 < 가져가야 할 길이 → 자르는 높이를 늘려야 함 → mid를 줄인다 → end = mid - 1