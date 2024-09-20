# [Silver V] 올림픽 - 8979 

[문제 링크](https://www.acmicpc.net/problem/8979) 

### 분류

구현, 정렬

### 문제 설명

<p>올림픽은 참가에 의의가 있기에 공식적으로는 국가간 순위를 정하지 않는다. 그러나, 많은 사람들이 자신의 국가가 얼마나 잘 하는지에 관심이 많기 때문에 비공식적으로는 국가간 순위를 정하고 있다. 두 나라가 각각 얻은 금, 은, 동메달 수가 주어지면, 보통 다음 규칙을 따라 어느 나라가 더 잘했는지 결정한다.</p>

<ol>
	<li>금메달 수가 더 많은 나라 </li>
	<li>금메달 수가 같으면, 은메달 수가 더 많은 나라</li>
	<li>금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라 </li>
</ol>

<p>각 국가는 1부터 N 사이의 정수로 표현된다. 한 국가의 등수는 (자신보다 더 잘한 나라 수) + 1로 정의된다. 만약 두 나라가 금, 은, 동메달 수가 모두 같다면 두 나라의 등수는 같다. 예를 들어, 1번 국가가 금메달 1개, 은메달 1개를 얻었고, 2번 국가와 3번 국가가 모두 은메달 1개를 얻었으며, 4번 국가는 메달을 얻지 못하였다면, 1번 국가가 1등, 2번 국가와 3번 국가가 공동 2등, 4번 국가가 4등이 된다. 이 경우 3등은 없다. </p>

<p>각 국가의 금, 은, 동메달 정보를 입력받아서, 어느 국가가 몇 등을 했는지 알려주는 프로그램을 작성하시오. </p>

### 입력 

 <p>입력의 첫 줄은 국가의 수 N(1 ≤ N ≤ 1,000)과 등수를 알고 싶은 국가 K(1 ≤ K ≤ N)가 빈칸을 사이에 두고 주어진다. 각 국가는 1부터 N 사이의 정수로 표현된다. 이후 N개의 각 줄에는 차례대로 각 국가를 나타내는 정수와 이 국가가 얻은 금, 은, 동메달의 수가 빈칸을 사이에 두고 주어진다. 전체 메달 수의 총합은 1,000,000 이하이다.</p>

### 출력 

 <p>출력은 단 한 줄이며, 입력받은 국가 K의 등수를 하나의 정수로 출력한다. 등수는 반드시 문제에서 정의된 방식을 따라야 한다. </p>



#  🚀  오답노트 

```diff
import java.util.*;


class Country implements Comparable<Country>{
    int idx, gold, silver, bronze, rank;
    
    public Country(int idx, int gold, int silver, int bronze, int rank){
        this.idx=idx;
        this.gold=gold;
        this.silver=silver;
        this.bronze=bronze;
        this.rank=rank;
    }
    
    @Override
    public int compareTo(Country x){
        if(gold == x.gold){
            if(silver == x.silver){
                return x.bronze - bronze;
            }else{
                return x.silver - silver;
            }
        }else{
            return x.gold - gold;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        Country medals[] = new Country[N];
        
        for(int i=0; i<N; i++){
            int idx = sc.nextInt();
            int gold = sc.nextInt();
            int silver = sc.nextInt();
            int bronze = sc.nextInt();
            medals[i] = new Country(idx, gold, silver, bronze, 1);
        }
        
        Arrays.sort(medals);
        
-        int ranking=1;
-        for(int i=0; i<N-1; i++){
-            Country cur = medals[i];
-            Country nx= medals[i+1];
+        for(int i=1; i<N; i++){
+            Country cur = medals[i-1];
+            Country nx= medals[i];
            if(cur.gold == nx.gold && cur.silver == nx.silver && cur.bronze == nx.bronze){
                nx.rank = cur.rank;
            }else{
-                nx.rank = cur.rank+1;
+                nx.rank = i+1;
            }
-            
-            if(cur.idx == K){
-                System.out.println(cur.rank);
+        }
+
+        for(int i=0; i<N; i++){
+            if(medals[i].idx == K){
+                System.out.println(medals[i].rank);
                break;
            }
        }
+        
    }
}

```


 ## 🏆 전체 코멘트 

1. ranking 재할당 할 때 2등과 3등이 금은동이 모두 같은 경우 둘 다 2등이 되고 4등은 그대로 4등이기 때문에 for문의 i로 ranking을 부여한다.