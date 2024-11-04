# [Gold IV] 가르침 - 1062 

[문제 링크](https://www.acmicpc.net/problem/1062) 

### 분류

백트래킹, 비트마스킹, 브루트포스 알고리즘

### 문제 설명

<p>남극에 사는 김지민 선생님은 학생들이 되도록이면 많은 단어를 읽을 수 있도록 하려고 한다. <span style="line-height:1.6em">그러나 지구온난화로 인해 얼음이 녹아서 곧 학교가 무너지기 때문에, 김지민은 K개의 글자를 가르칠 시간 밖에 없다. 김지민이 가르치고 난 후에는, 학생들은 그 K개의 글자로만 이루어진 단어만을 읽을 수 있다. 김지민은 어떤 K개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어의 개수가 최대가 되는지 고민에 빠졌다.</span></p>

<p>남극언어의 모든 단어는 "anta"로 시작되고, "tica"로 끝난다. 남극언어에 단어는 N개 밖에 없다고 가정한다. 학생들이 읽을 수 있는 단어의 최댓값을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 단어의 개수 N과 K가 주어진다. N은 50보다 작거나 같은 자연수이고, K는 26보다 작거나 같은 자연수 또는 0이다. 둘째 줄부터 N개의 줄에 남극 언어의 단어가 주어진다. 단어는 영어 소문자로만 이루어져 있고, 길이가 8보다 크거나 같고, 15보다 작거나 같다. 모든 단어는 중복되지 않는다.</p>

### 출력 

 <p>첫째 줄에 김지민이 K개의 글자를 가르칠 때, 학생들이 읽을 수 있는 단어 개수의 최댓값을 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;
-import java.io.*;

public class Main {
-    public static int N;
-    public static int K;
-    public static int M;
-    public static Set<Character> basicSet = Set.of('a', 'n', 't', 'i', 'c');
-    public static Set<Character> inputSet = new HashSet<>();
-    // public static Map<Character, Integer> map = new HashMap<>();
-    public static Set<Character> answerSet = new HashSet<>();
-    public static boolean visited [];
-    public static String targets[];
-    public static int max=0;
-    
-    
-    public static void main(String[] args) throws IOException{
+    public static int N, K;
+    public static String[] words;
+    public static boolean[] visited;
+    public static int max = 0;
+    public static void main(String[] args) {
        // 코드를 작성해주세요
-        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
-        String NK[] = br.readLine().split(" ");
-        N = Integer.valueOf(NK[0]);
-        K = Integer.valueOf(NK[1]);
-        int t = N;
+        Scanner sc = new Scanner(System.in);
+        N = sc.nextInt();
+        K = sc.nextInt();
        
-        M = K-5;
-        
-        if(M < 0){
+        words = new String[N];
+        visited = new boolean[26];
+        if(K < 5){
            System.out.println(0);
            return;
-        }else{
-            targets = new String[N];
-            while(t-- > 0){
-                String row = br.readLine();
-                String target = row.substring(4, row.length()-4);
-                for(int i=0; i<target.length(); i++){
-                    if(!basicSet.contains(target.charAt(i))){
-                        inputSet.add(target.charAt(i));
-                        // map.put(target.charAt(i), map.getOrDefault(target.charAt(i), 0)+1);
-                    }
-                }
-                targets[t] = target;
-            }
-            visited = new boolean[inputSet.size()];
-            
-            BT(0);
+        }else if(K == 26){
+            System.out.println(N);
+            return;
        }
        
+        sc.nextLine();
+        for(int i=0; i<N; i++){
+            String input = sc.nextLine();
+            input = input.replace("anta", "");
+            input = input.replace("tica", "");
+            words[i] = input;
+        }
+        
+        visited['a' - 'a'] = true;
+        visited['c' - 'a'] = true;
+        visited['i' - 'a'] = true;
+        visited['n' - 'a'] = true;
+        visited['t' - 'a'] = true;
+        
+        BT(0, 0);
+        
        System.out.println(max);
-        
    }
    
-    public static void BT(int depth){
-        if(depth == M){
-            max = Math.max(max, counting());
+    
+    public static void BT(int len, int st){
+        if(len == K-5){
+            int cnt=0;
+            for(int i=0; i<words.length; i++){
+                boolean flag = true;
+                for(int j=0; j<words[i].length(); j++){
+                    if(!visited[words[i].charAt(j) - 'a']){
+                        flag = false;
+                        break;
+                    }
+                }
+                if(flag) cnt++;
+            }
+            max = Math.max(max, cnt);
            return;
        }
        
-        int i=0;
-        for(char a:inputSet){
+        
+        for(int i=st; i<26; i++){
            if(!visited[i]){
-                answerSet.add(a);
                visited[i] = true;
-                BT(depth+1);
+                BT(len+1, i);
                visited[i] = false;
-                answerSet.remove(a);
            }
-            i++;
        }
    }
-    
-    public static int counting(){
-        int count=0;
-        for(int i=0; i<N; i++){
-            boolean flag = false;
-            if(targets[i].length()==0){
-                count++;
-            }
-            for(int j=0; j<targets[i].length(); j++){
-                if(!basicSet.contains(targets[i].charAt(j)) && !answerSet.contains(targets[i].charAt(j))){
-                    flag = true;
-                    break;
-                }
-            }
-            if(!flag){
-                count++;
-            }
-        }
-        return count;
-    }
}

```


 ## 🏆 전체 코멘트 

1. N이 최대 50이고, 알파벳이므로 26개, 글자최대가 anta, tica를 제외하면 7이라서 모든 경우의 수에 대해서 완전탐색을 진행하면 될 것 같다.
2. visited를 알파벳 크기만큼 선언하고 'a' - 'a' 로 0~25까지를 체크한다.