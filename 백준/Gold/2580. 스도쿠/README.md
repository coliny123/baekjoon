# [Gold IV] 스도쿠 - 2580 

[문제 링크](https://www.acmicpc.net/problem/2580) 

### 분류

백트래킹

### 문제 설명

<p>스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다. 이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 게임 시작 전 일부 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/508363ac-0289-4a92-a639-427b10d66633/-/preview/" style="width: 240px; height: 230px;"></p>

<p>나머지 빈 칸을 채우는 방식은 다음과 같다.</p>

<ol>
	<li>각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.</li>
	<li>굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.</li>
</ol>

<p>위의 예의 경우, 첫째 줄에는 1을 제외한 나머지 2부터 9까지의 숫자들이 이미 나타나 있으므로 첫째 줄 빈칸에는 1이 들어가야 한다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/38e505c6-0452-4a56-b01c-760c85c6909b/-/preview/" style="width: 239px; height: 32px;"></p>

<p>또한 위쪽 가운데 위치한 3x3 정사각형의 경우에는 3을 제외한 나머지 숫자들이 이미 쓰여있으므로 가운데 빈 칸에는 3이 들어가야 한다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/89873d9d-56ae-44f7-adb2-bd5d7e243016/-/preview/" style="width: 86px; height: 82px;"></p>

<p>이와 같이 빈 칸을 차례로 채워 가면 다음과 같은 최종 결과를 얻을 수 있다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/fe68d938-770d-46ea-af71-a81076bc3963/-/preview/" style="width: 240px; height: 230px;"></p>

<p>게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>아홉 줄에 걸쳐 한 줄에 9개씩 게임 시작 전 스도쿠판 각 줄에 쓰여 있는 숫자가 한 칸씩 띄워서 차례로 주어진다. 스도쿠 판의 빈 칸의 경우에는 0이 주어진다. 스도쿠 판을 규칙대로 채울 수 없는 경우의 입력은 주어지지 않는다.</p>

### 출력 

 <p>모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉 줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력한다.</p>

<p>스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다.</p>



#  🚀  오답노트 

```diff
-import java.util.*;
-import java.io.*;
-
-public class Main {
-    public static int[][] grid = new int[9][9];
-    
-    public static void main(String[] args) throws IOException{
-        // 코드를 작성해주세요
-        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
-        
-        for(int i=0; i<9; i++){
-            String[] input = br.readLine().split(" ");
-            for(int j=0; j<9; j++){
-                grid[i][j] = Integer.valueOf(input[j]);
-            }
-        }
-        
-        
-        DFS(0, 0);
-        
-        
-    }
-    
-    
-    public static void DFS(int x, int y){
-        if(y == 9){
-            DFS(x+1, 0);
-            return;
-        }
-        
-        if(x == 9){
-            StringBuilder sb = new StringBuilder();
-            for(int i=0; i<9; i++){
-                for(int j=0; j<9; j++){
-                    sb.append(grid[i][j]).append(" ");
-                }
-                sb.append("\n");
-            }
-            System.out.print(sb);
-            System.exit(0);
-        }
-        
-        if(grid[x][y] == 0){            
-            for(int i=1; i<=9; i++){
-                if(check(x, y, i)){
-                    grid[x][y] = i;
-                    DFS(x, y+1);
-                }
-            }
-            grid[x][y] = 0;
-            return;
-        }
-        
-        DFS(x, y+1);
-    }
-    
-    public static boolean check(int row, int col, int value){
-        // 가로
-        for(int i=0; i<9; i++){
-            if(grid[row][i] == value){
-                return false;
-            }
-        }
-        
-        // 세로
-        for(int i=0; i<9; i++){
-            if(grid[i][col] == value){
-                return false;
-            }
-        }
-        
-        // 3x3
-        int st_row = (row / 3) * 3;
-        int st_col = (col / 3) * 3;
-        for(int i=st_row; i<st_row+3; i++){
-            for(int j=st_col; j<st_col+3; j++){
-                if(grid[i][j] == value){
-                    return false;
-                }
-            }
-        }
-        
-        return true;
-    }
-    
-    
-}

```


 ## 🏆 전체 코멘트 

1. N퀸 처럼 bt를 사용하면 될 것이라고 생각
2. 빈칸에 숫자를 넣을 때 가로, 세로, 3x3을 모두 확인해서 판단
3. dfs 조건은
3-1) 빈칸일 때 check해서 넣고 dfs, 없으면 잘못된 거니까 0으로 초기화하고 dfs 종료 시킴
3-2) col이 9일때는 그 row를 다 돌아봤기 때문에 아래 row로 DFS함
3-3)ROW가 9면 다 돌아봤으므로 프린트하고 종료