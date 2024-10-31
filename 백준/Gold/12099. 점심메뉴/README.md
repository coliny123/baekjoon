# [Gold IV] 점심메뉴 - 12099 

[문제 링크](https://www.acmicpc.net/problem/12099) 

### 분류

이분 탐색, 정렬

### 문제 설명

<p>승관이와 영우는 앞으로 Q일 동안 점심을 같이 먹기로 했다. </p>

<p>승관이는 [u, v] 구간의 매운맛을 좋아하고 영우는 [x, y] 구간의 단맛을 좋아한다. (u, v, x, y는 매일 매일 기분 따라 바뀐다) </p>

<p>N가지 점심 메뉴의 매운맛 수치 a와, 단맛 수치 b가 주어지고, 앞으로 Q 일간의 u, v, x, y가 주어진다. </p>

<p>승관이와 영우의 점심 메뉴 선택을 돕기 위해, 날마다 승관이와 영우가 둘 다 좋아하는 메뉴의 수를 알려주는 프로그램을 만들어주자.</p>

### 입력 

 <p>입력의 첫 줄에 점심 메뉴의 수 N(1 ≤ N ≤ 10만)과, 점심을 같이 먹는 기간 Q(1 ≤ Q ≤ 5000)가 주어진다. </p>

<p>둘째 줄부터 N개의 줄에 각 메뉴의 매운맛, 단맛 수치인 a, b가 주어진다. (1≤ a, b ≤ 10억) </p>

<p>a, b값은 유니크하다. 즉 같은 a 값을 가지는 서로 다른 두 메뉴는 없고, 같은 b 값을 가지는 서로 다른 두 메뉴도 없다. </p>

<p>그 다음 줄부터 Q개의 줄에 각 날의 u, v, x, y가 주어진다. (1 ≤ u ≤ v ≤ 10억, v ≤ u + 10000, 1 ≤ x ≤ y ≤ 10억, y ≤ x + 10000) </p>

### 출력 

 <p>Q개의 줄에 줄마다 각 날의 영우와 승관이가 둘 다 좋아하는 메뉴의 수, 즉 u ≤ a ≤ v 이고, x ≤ b ≤ y 인 메뉴의 수를 출력한다 </p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

-class Pair implements Comparable<Pair>{
-    int idx, value;
+class Menu implements Comparable<Menu>{
+    int spicy, sweet;
    
-    public Pair(int idx, int value){
-        this.idx=idx;
-        this.value=value;
+    public Menu(int spicy, int sweet){
+        this.spicy=spicy;
+        this.sweet=sweet;
    }
    
    @Override
-    public int compareTo(Pair o){
-        return value - o.value;
+    public int compareTo(Menu o){
+        return spicy - o.spicy;
    }
}

public class Main {
-    public static Pair[] spicy;
-    public static Pair[] sweet;
+    public static Menu[] menus;
    
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int Q = Integer.valueOf(input[1]);
        
-        spicy = new Pair[N];
-        sweet = new Pair[N];
+        menus = new Menu[N];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
-            spicy[i] = new Pair(i, Integer.valueOf(input[0]));
-            sweet[i] = new Pair(i, Integer.valueOf(input[1]));
+            menus [i] = new Menu(Integer.valueOf(input[0]), Integer.valueOf(input[1]));
        }
        
-        Arrays.sort(spicy);
-        Arrays.sort(sweet);
+        Arrays.sort(menus);
        
        StringBuilder sb = new StringBuilder();
        while(Q-- > 0){
            input = br.readLine().split(" ");
            int u = Integer.valueOf(input[0]);
            int v = Integer.valueOf(input[1]);
            int x = Integer.valueOf(input[2]);
            int y = Integer.valueOf(input[3]);
            
-            int spicyLowerIdx = upperBound(0, spicy.length-1, u, spicy);
-            TreeSet<Integer> temp = new TreeSet<>();
+            int spicyLowerIdx = upperBound(0, menus.length-1, u, menus);
+            int cnt=0;
            for(int i=spicyLowerIdx; i<N; i++){
-                if(spicy[i].value > v) break;
-                temp.add(spicy[i].idx);
+                if(menus[i].spicy > v) break;
+                if(menus[i].sweet >= x && menus[i].sweet <= y) cnt++;
            }
-            int sweetLowerIdx = upperBound(0, sweet.length-1, x, sweet);
-            TreeSet<Integer> set = new TreeSet<>();
-            for(int i=sweetLowerIdx; i<N; i++){
-                if(sweet[i].value > y) break;
-                if(temp.contains(sweet[i].idx)){
-                    set.add(sweet[i].idx);
-                }
-            }
-            
-            sb.append(set.size()).append("\n");
+            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    
-    public static int upperBound(int lt, int rt, int target, Pair[] arr){
+    public static int upperBound(int lt, int rt, int target, Menu[] arr){
        int idx = rt-1;
        boolean find = false;
        while(lt <= rt){
            int mid = (lt + rt+1) / 2;
            
-            if(arr[mid].value < target){
+            if(arr[mid].spicy < target){
                lt = mid + 1;
            }else{
                rt = mid - 1;
                idx = mid;
            }
        }
        
        return idx;
    }
-    
-    public static int lowerBound(int lt, int rt, int target, Pair[] arr){
-        int idx = rt-1;
-        boolean find = false;
-        while(lt <= rt){
-            int mid = (lt + rt+1) / 2;
-            
-            if(arr[mid].value <= target){
-                lt = mid + 1;
-                idx = mid;
-            }else{
-                rt = mid - 1;
-            }
-        }
-        
-        return idx;
-    }
}

```


 ## 🏆 전체 코멘트 

1. 나는 spicy 따로 sweet따로 배열을 만들어서 spicy에서 구하고 sweet에서도 구해서 set으로 contains르 확인하며 정답을 찾았는데 이것은 Arrays.sort()에도 O(nlog(n))이 2번 걸리고
binarySearch O(longN) 도 2번 걸리므로 시간복잡도에서 틀린다.
2. spicy와 sweet을 Menu로 만들고 spicy로 정렬 후 최소 시작 지점만 찾고 N까지 가면서 V보다 큰수가 나오면 종료 조건을 걸고, 그 중에서 SWEET이 x<= sweet <= y인 경우에만 cnt++하면 효율적으로 구할 수 있다.