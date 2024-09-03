# [Gold V] 톱니바퀴 - 14891 

[문제 링크](https://www.acmicpc.net/problem/14891) 

### 분류

구현, 시뮬레이션

### 문제 설명

<p>총 8개의 톱니를 가지고 있는 톱니바퀴 4개가 아래 그림과 같이 일렬로 놓여져 있다. 또, 톱니는 N극 또는 S극 중 하나를 나타내고 있다. 톱니바퀴에는 번호가 매겨져 있는데, 가장 왼쪽 톱니바퀴가 1번, 그 오른쪽은 2번, 그 오른쪽은 3번, 가장 오른쪽 톱니바퀴는 4번이다.</p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14891/1.png" style="height:210px; width:918px"></p>

<p>이때, 톱니바퀴를 총 K번 회전시키려고 한다. 톱니바퀴의 회전은 한 칸을 기준으로 한다. 회전은 시계 방향과 반시계 방향이 있고, 아래 그림과 같이 회전한다.</p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14891/2.png" style="height:253px; width:660px"></p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14891/3.png" style="height:253px; width:602px"></p>

<p>톱니바퀴를 회전시키려면, 회전시킬 톱니바퀴와 회전시킬 방향을 결정해야 한다. 톱니바퀴가 회전할 때, 서로 맞닿은 극에 따라서 옆에 있는 톱니바퀴를 회전시킬 수도 있고, 회전시키지 않을 수도 있다. 톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하게 된다. 예를 들어, 아래와 같은 경우를 살펴보자.</p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14891/4.png" style="height:223px; width:923px"></p>

<p>두 톱니바퀴의 맞닿은 부분은 초록색 점선으로 묶여있는 부분이다. 여기서, 3번 톱니바퀴를 반시계 방향으로 회전했다면, 4번 톱니바퀴는 시계 방향으로 회전하게 된다. 2번 톱니바퀴는 맞닿은 부분이 S극으로 서로 같기 때문에, 회전하지 않게 되고, 1번 톱니바퀴는 2번이 회전하지 않았기 때문에, 회전하지 않게 된다. 따라서, 아래 그림과 같은 모양을 만들게 된다.</p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14891/5.png" style="height:222px; width:921px"></p>

<p>위와 같은 상태에서 1번 톱니바퀴를 시계 방향으로 회전시키면, 2번 톱니바퀴가 반시계 방향으로 회전하게 되고, 2번이 회전하기 때문에, 3번도 동시에 시계 방향으로 회전하게 된다. 4번은 3번이 회전하지만, 맞닿은 극이 같기 때문에 회전하지 않는다. 따라서, 아래와 같은 상태가 된다.</p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14891/6.png" style="height:222px; width:921px"></p>

<p>톱니바퀴의 초기 상태와 톱니바퀴를 회전시킨 방법이 주어졌을 때, 최종 톱니바퀴의 상태를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 1번 톱니바퀴의 상태, 둘째 줄에 2번 톱니바퀴의 상태, 셋째 줄에 3번 톱니바퀴의 상태, 넷째 줄에 4번 톱니바퀴의 상태가 주어진다. 상태는 8개의 정수로 이루어져 있고, 12시방향부터 시계방향 순서대로 주어진다. N극은 0, S극은 1로 나타나있다.</p>

<p>다섯째 줄에는 회전 횟수 K(1 ≤ K ≤ 100)가 주어진다. 다음 K개 줄에는 회전시킨 방법이 순서대로 주어진다. 각 방법은 두 개의 정수로 이루어져 있고, 첫 번째 정수는 회전시킨 톱니바퀴의 번호, 두 번째 정수는 방향이다. 방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.</p>

### 출력 

 <p>총 K번 회전시킨 이후에 네 톱니바퀴의 점수의 합을 출력한다. 점수란 다음과 같이 계산한다.</p>

<ul>
	<li>1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점</li>
	<li>2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점</li>
	<li>3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점</li>
	<li>4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점</li>
</ul>



#  🚀  오답노트 

```diff
import java.util.*;

-
public class Main {
    public static int gears[][] = new int[4][8];
+    public static int directions[];
+    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<4; i++){
            String row = sc.nextLine();
            for(int j=0; j<8; j++){
-                gears[i][j] = Integer.valueOf(row.charAt(j)-'0');
+                gears[i][j] = row.charAt(j) - '0';
            }
        }
        
+        // print();
+        
        int k = sc.nextInt();
        while(k-- > 0){
-            int num = sc.nextInt()-1;
+            int idx = sc.nextInt()-1;
            int dir = sc.nextInt();
            
-            simulation(num, dir);
+            directions = new int[4];
+            getDirections(idx, dir);
+            simulation();
        }
        
-        System.out.println(getSum());
-    }
-    
-    public static void print(){
-        for(int i=0; i<4; i++){
-            for(int j=0; j<8; j++){
-                System.out.print(gears[i][j]);
-            }
-            System.out.println();
-        }
-    }
-    
-    public static int getSum(){
        int sum=0;
        if(gears[0][0] == 1){
            sum += 1;
        }
        if(gears[1][0] == 1){
            sum += 2;
        }
        if(gears[2][0] == 1){
            sum += 4;
        }
        if(gears[3][0] == 1){
            sum += 8;
        }
        
-        return sum;
+        System.out.println(sum);
+        
    }
    
-    // 반시계 회전 함수
-    public static void leftMove(int num){
-        int tmp = gears[num][0];
-        for(int i=0; i<7; i++){
-            gears[num][i] = gears[num][i+1];
+    public static void simulation(){
+        for(int i=0; i<4; i++){
+            if(directions[i] == 0){
+                continue;
+            }
+            
+            // 반시계
+            if(directions[i] == -1){
+                int temp = gears[i][0];
+                for(int j=0; j<7; j++){
+                    gears[i][j] = gears[i][j+1];
+                }
+                gears[i][7] = temp;
+            }else{  // 시계
+                int temp = gears[i][7];
+                for(int j=7; j>0; j--){
+                    gears[i][j] = gears[i][j-1];
+                }
+                gears[i][0] = temp;
+            }
        }
-        gears[num][7] = tmp;
    }
    
-    public static void rightMove(int num){
-        int tmp = gears[num][7];
-        for(int i=7; i>0; i--){
-            gears[num][i] = gears[num][i-1];
-        }
-        gears[num][0] = tmp;
-    }
-    
-    public static void simulation(int num, int dir){       
-        // 왼쪽
-        int curDir = dir;
-        for(int i=num; i>0; i--){
-            if(gears[i][6] == gears[i-1][2]){
+    public static void getDirections(int idx, int dir){
+        directions[idx] = dir;
+        // 오른쪽
+        for(int i=idx+1; i<4; i++){
+            if(gears[i-1][2] == gears[i][6]){
                break;
            }else{
-                curDir *= -1;
-                if(curDir == -1){
-                    leftMove(i-1);
-                }else{
-                    rightMove(i-1);
-                }
+                directions[i] = -directions[i-1];
            }
        }
        
-        // 오른쪽
-        curDir = dir;
-        for(int i=num; i<3; i++){
-            if(gears[i][2] == gears[i+1][6]){
+        // 왼쪽
+        for(int i=idx-1; i>=0; i--){
+            if(gears[i+1][6] == gears[i][2]){
                break;
            }else{
-                curDir *= -1;
-                if(curDir == -1){
-                    leftMove(i+1);
-                }else{
-                    rightMove(i+1);
-                }
+                directions[i] = -directions[i+1];
            }
        }
-        
-        // target gear
-        if(dir == -1){ // 반시계
-            leftMove(num);
-        }else{      //  시계
-            rightMove(num);
+    }
+    
+    public static void print(){
+        for(int i=0; i<4; i++){
+            for(int j=0; j<8; j++){
+                System.out.print(gears[i][j]);
+            }
+            System.out.println();
        }
    }
}

```


 ## 🏆 전체 코멘트 

1. 먼저 대상이 되는 톱니바퀴를 돌리고 그 결과에 따라 주변 바퀴들의 회전이 정해지는 줄 알았는데 먼저 방향이 정해지고 그 것에 따라 모든 바퀴들이 돌아가는 것이었다.
문제를 잘 이해하고 풀어야겠다.
2. 회전 방향은 대상이 되는 톱니바퀴를 중심으로 왼쪽/오른쪽으로 나눠 구했다.
3. 시뮬레이션에서 배열 이동 시 덮어 써지는 방향에 유의할 것