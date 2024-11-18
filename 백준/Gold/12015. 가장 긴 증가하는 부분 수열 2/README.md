# [Gold II] 가장 긴 증가하는 부분 수열 2 - 12015 

[문제 링크](https://www.acmicpc.net/problem/12015) 

### 분류

이분 탐색, 가장 긴 증가하는 부분 수열: O(n log n)

### 문제 설명

<p>수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.</p>

<p>예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {<strong>10</strong>, <strong>20</strong>, 10, <strong>30</strong>, 20, <strong>50</strong>} 이고, 길이는 4이다.</p>

### 입력 

 <p>첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.</p>

<p>둘째 줄에는 수열 A를 이루고 있는 A<sub>i</sub>가 주어진다. (1 ≤ A<sub>i</sub> ≤ 1,000,000)</p>

### 출력 

 <p>첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        
        int[] nums = new int[N];
        int[] LIS = new int[N];
        
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.valueOf(input[i]);
        }
        
        
        int length = 1;
        LIS[0] = nums[0];
        for(int i=1; i<N; i++){
-            if(LIS[length] < nums[i]){
+            if(LIS[length-1] < nums[i]){
                length++;
-                LIS[length] = nums[i];
+                LIS[length-1] = nums[i];
            }else {
                int loc = binarySearch(0, length, nums[i], LIS);
                LIS[loc] = nums[i];
            }
        }
        System.out.println(length);
    }
    
    public static int binarySearch(int st, int ed, int key, int[]LIS){
        int answer = 0;
        while(st <= ed){
            int mid = (st + ed) / 2;
            
            if(LIS[mid] < key){
                st = mid + 1;
            }else{
                ed = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}


```


 ## 🏆 전체 코멘트 

LIS(최장 길이 부분 수열) 푸는 방법 2가지
1. dp -> N^2;
2. 이분탐색 -> log N
LIS 배열을 만들고, length를 증가시키며 넣음
만약 LIS의 마지막 원소보다 작을 경우 이분탐색을 통해 LIS배열 내에서 해당 원소보다 처음으로 커지는 자리를 해당 원소로 변경