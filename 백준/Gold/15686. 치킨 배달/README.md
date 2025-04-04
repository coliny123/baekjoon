# [Gold V] 치킨 배달 - 15686 

[문제 링크](https://www.acmicpc.net/problem/15686) 

### 분류

백트래킹, 브루트포스 알고리즘, 구현

### 문제 설명

<p>크기가 N×N인 도시가 있다. 도시는 1×1크기의 칸으로 나누어져 있다. 도시의 각 칸은 빈 칸, 치킨집, 집 중 하나이다. 도시의 칸은 (r, c)와 같은 형태로 나타내고, r행 c열 또는 위에서부터 r번째 칸, 왼쪽에서부터 c번째 칸을 의미한다. r과 c는 1부터 시작한다.</p>

<p>이 도시에 사는 사람들은 치킨을 매우 좋아한다. 따라서, 사람들은 "<strong>치킨 거리</strong>"라는 말을 주로 사용한다. <strong>치킨 거리</strong>는 집과 가장 가까운 치킨집 사이의 거리이다. 즉, 치킨 거리는 집을 기준으로 정해지며, 각각의 집은 <strong>치킨 거리</strong>를 가지고 있다. <strong>도시의 치킨 거리</strong>는 모든 집의 <strong>치킨 거리</strong>의 합이다.</p>

<p>임의의 두 칸 (r<sub>1</sub>, c<sub>1</sub>)과 (r<sub>2</sub>, c<sub>2</sub>) 사이의 거리는 |r<sub>1</sub>-r<sub>2</sub>| + |c<sub>1</sub>-c<sub>2</sub>|로 구한다.</p>

<p>예를 들어, 아래와 같은 지도를 갖는 도시를 살펴보자.</p>

<pre>0 2 0 1 0
1 0 1 0 0
0 0 0 0 0
0 0 0 1 1
0 0 0 1 2
</pre>

<p>0은 빈 칸, 1은 집, 2는 치킨집이다.</p>

<p>(2, 1)에 있는 집과 (1, 2)에 있는 치킨집과의 거리는 |2-1| + |1-2| = 2, (5, 5)에 있는 치킨집과의 거리는 |2-5| + |1-5| = 7이다. 따라서, (2, 1)에 있는 집의 치킨 거리는 2이다.</p>

<p>(5, 4)에 있는 집과 (1, 2)에 있는 치킨집과의 거리는 |5-1| + |4-2| = 6, (5, 5)에 있는 치킨집과의 거리는 |5-5| + |4-5| = 1이다. 따라서, (5, 4)에 있는 집의 치킨 거리는 1이다.</p>

<p>이 도시에 있는 치킨집은 모두 같은 프랜차이즈이다. 프렌차이즈 본사에서는 수익을 증가시키기 위해 일부 치킨집을 폐업시키려고 한다. 오랜 연구 끝에 이 도시에서 가장 수익을 많이 낼 수 있는  치킨집의 개수는 최대 M개라는 사실을 알아내었다.</p>

<p>도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다. 어떻게 고르면, <strong>도시의 치킨 거리</strong>가 가장 작게 될지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 13)이 주어진다.</p>

<p>둘째 줄부터 N개의 줄에는 도시의 정보가 주어진다.</p>

<p>도시의 정보는 0, 1, 2로 이루어져 있고, 0은 빈 칸, 1은 집, 2는 치킨집을 의미한다. 집의 개수는 2N개를 넘지 않으며, 적어도 1개는 존재한다. 치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다.</p>

### 출력 

 <p>첫째 줄에 폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값을 출력한다.</p>



#  🚀  오답노트 

```diff
-import java.util.*;
-import java.io.*;
-
-class Node{
-    int x, y;
-    
-    public Node(int x, int y){
-        this.x=x;
-        this.y=y;
-    }
-}
-
-public class Main {
-    public static int N, M;
-    public static int answer = Integer.MAX_VALUE;
-    public static ArrayList<Node> houses = new ArrayList<>();
-    public static ArrayList<Node> chickens = new ArrayList<>();
-    public static Node[] arr;
-    public static int[] distances;
-    
-    public static void main(String[] args) throws IOException{
-        // 코드를 작성해주세요
-        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
-        String[] input = br.readLine().split(" ");
-        
-        N = Integer.valueOf(input[0]);
-        M = Integer.valueOf(input[1]);
-        
-        arr = new Node[M];
-        
-        for(int i=0; i<N; i++){
-            input = br.readLine().split(" ");
-            for(int j=0; j<N; j++){
-                int dot = Integer.valueOf(input[j]);
-                // 1인 경우 집 arraylist에 저장
-                if(dot == 1){
-                    houses.add(new Node(i, j));
-                }
-                // 2인 경우 치킨집 arraylist에 저장
-                if(dot == 2){
-                    chickens.add(new Node(i, j));
-                }
-            }
-        }
-        
-        // 백트래킹으로 치킨집 C M 개 조합에 대해서 계산
-        BT(0,0);
-        
-        System.out.println(answer);
-    }
-    
-    public static void BT(int count, int start){
-        if(count == M){
-            int min = calcDistance();
-            answer = Math.min(answer, min);
-            return;
-        }
-        
-        
-        for(int i=start; i<chickens.size(); i++){
-            arr[count] = chickens.get(i);
-            BT(count+1, i+1);
-        }
-    }
-    
-    public static int calcDistance(){
-        int sum = 0;
-        distances = new int[houses.size()];
-        Arrays.fill(distances, Integer.MAX_VALUE);
-        
-        for(int i=0; i<arr.length; i++){
-            for(int j=0; j<houses.size(); j++){
-                Node chicken = arr[i];
-                Node house = houses.get(j);
-                
-                int dist = Math.abs(chicken.x - house.x) + Math.abs(chicken.y - house.y);
-                if(distances[j] > dist){
-                    distances[j] = dist;
-                }
-            }
-        }
-        
-        for(int dist : distances){
-            sum += dist;
-        }
-        
-        return sum;
-    }
-}

```


 ## 🏆 전체 코멘트 

1. 치킨집 X개에 대해서 M개를 고르는 것이므로 조합(백트래킹)으로 접근
2. 좌표사이의 거리를 구하는 것이기 때문에 각각 좌표 저장해서 2중 for문과 distance 배열로 각 조합마다 최소거리 구함