# [Gold IV] 공유기 설치 - 2110 

[문제 링크](https://www.acmicpc.net/problem/2110) 

### 분류

이분 탐색, 매개 변수 탐색

### 문제 설명

<p>도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x<sub>1</sub>, ..., x<sub>N</sub>이고, 집 여러개가 같은 좌표를 가지는 일은 없다.</p>

<p>도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다. 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고, 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.</p>

<p>C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고 주어진다. 둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 x<sub>i</sub> (0 ≤ x<sub>i</sub> ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.</p>

### 출력 

 <p>첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

public class Main {
    public static int N,C;
    public static int[] houses;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        C = Integer.valueOf(input[1]);
        
        houses = new int[N];
        for(int i=0; i<N; i++){
            houses[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(houses);
        
        
-        System.out.println(parametricSearch(houses[0], houses[N-1], C));
+        System.out.println(parametricSearch(1, houses[N - 1]-houses[0]+1, C));
    }
    
    
    
    public static int parametricSearch(int st, int ed, int count){
        int max = 0;
        while(st <= ed){
            int mid = (st + ed + 1) / 2;
            if(counting(mid) >= C){
                st = mid + 1;
                max = Math.max(max, mid);
            }else{
                ed = mid - 1;
            }
        }
        
        return max;
    }
    
    public static int counting(int distance){
        int cnt=1;
        int before = houses[0];
        for(int i=1; i<N; i++){
            if(houses[i] - before >= distance){
                before = houses[i];
                cnt++;
            }
        }
        
        return cnt;
    }
}


```


 ## 🏆 전체 코멘트 

1. 매개변수 탐색 문제,,, (처음에는 Xi가 1,000,000,000이라서 단순히 이분탐색을 사용하면 될 것이라고 생각했으나 거리 차이를 구하는 것을 떠올리지 못함)
2. 다른 매개변수 탐색 문제와 마찬가지로 "최적화 문제를 결정 문제로 바꿔서 푼다." -> 공유기를 설치하고 거리를 구하는 것이 아니라, 최소 거리에 따른 공유기 수를 구하고 그중 가장 큰 정답을 찾는 것
3. 공유기의 전체 갯수를 구하는 부분은 배열을 돌면서 (현재 위치 - 이전 공유기의 위치) >= distance인 경우로 구함
4. st와 ed는 처음에는 단순히 houses[0], houses[N-1]로 넣었지만 "최소거리차"와 "최대거리차"이므로 1, houses[N-1]-houses[0]+1로 해야한다.