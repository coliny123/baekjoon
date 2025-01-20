# [Gold II] 친구 네트워크 - 4195 

[문제 링크](https://www.acmicpc.net/problem/4195) 

### 분류

자료 구조, 분리 집합, 해시를 사용한 집합과 맵

### 문제 설명

<p>민혁이는 소셜 네트워크 사이트에서 친구를 만드는 것을 좋아하는 친구이다. 우표를 모으는 취미가 있듯이, 민혁이는 소셜 네트워크 사이트에서 친구를 모으는 것이 취미이다.</p>

<p>어떤 사이트의 친구 관계가 생긴 순서대로 주어졌을 때, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.</p>

<p>친구 네트워크란 친구 관계만으로 이동할 수 있는 사이를 말한다.</p>

### 입력 

 <p>첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스의 첫째 줄에는 친구 관계의 수 F가 주어지며, 이 값은 100,000을 넘지 않는다. 다음 F개의 줄에는 친구 관계가 생긴 순서대로 주어진다. 친구 관계는 두 사용자의 아이디로 이루어져 있으며, 알파벳 대문자 또는 소문자로만 이루어진 길이 20 이하의 문자열이다.</p>

### 출력 

 <p>친구 관계가 생길 때마다, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.</p>



#  🚀  오답노트 

```diff
-import java.util.*;
-import java.io.*;
-
-public class Main {
-    public static int[] parents;
-    public static int[] level;
-    public static void main(String[] args) throws IOException{
-        // 코드를 작성해주세요
-        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
-        int T = Integer.valueOf(br.readLine());
-        
-        while(T-- > 0){
-            int F = Integer.valueOf(br.readLine());
-            
-            parents = new int[F*2];
-            level = new int[F*2];
-            for(int i=0; i<F*2; i++){
-                parents[i] = i;
-                level[i] = 1;
-            }
-            
-            StringBuilder sb = new StringBuilder();
-            int idx=0;
-            Map<String, Integer> map = new HashMap<>();
-            for(int i=0; i<F; i++){
-                String[] input = br.readLine().split(" ");
-                if (!map.containsKey(input[0])) {
-                    map.put(input[0], idx++);
-                }
- 
-                if (!map.containsKey(input[1])) {
-                    map.put(input[1], idx++);
-                }
-                sb.append(union(map.get(input[0]), map.get(input[1]))).append("\n");
-            }
-            
-            
-            System.out.print(sb);
-        }
-    }
-    
-    public static int find(int x){
-        if(parents[x] == x) return x;
-        return parents[x] = find(parents[x]);
-    }
-    
-    public static int union(int x, int y){
-        x = find(x);
-        y = find(y);
-        
-        if(x != y){
-            parents[y] = x;
-            level[x] += level[y];
-            level[y] = 1; 
-        }
-        return level[x];
-    }
-}

```


 ## 🏆 전체 코멘트 

1. 사람이름은 map을 통해 idx를 관리한다 -> 이걸 통해 유니온 파인드를 적용
2. level이라는 배열을 만들어서 네트워크 인원을 업데이트, 관함