# [Gold V] 노드사이의 거리 - 1240 

[문제 링크](https://www.acmicpc.net/problem/1240) 

### 분류

너비 우선 탐색, 깊이 우선 탐색, 그래프 이론, 그래프 탐색, 트리

### 문제 설명

<p>$N$개의 노드로 이루어진 트리가 주어지고 M개의 두 노드 쌍을 입력받을 때 두 노드 사이의 거리를 출력하라.</p>

### 입력 

 <p>첫째 줄에 노드의 개수 $N$과 거리를 알고 싶은 노드 쌍의 개수 $M$이 입력되고 다음 $N-1$개의 줄에 트리 상에 연결된 두 점과 거리를 입력받는다. 그 다음 줄에는 거리를 알고 싶은 $M$개의 노드 쌍이 한 줄에 한 쌍씩 입력된다.</p>

### 출력 

 <p>$M$개의 줄에 차례대로 입력받은 두 노드 사이의 거리를 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;

class Node{
    int idx, w;

    public Node(int idx, int w){
        this.idx=idx;
        this.w=w;
    }
}

public class Main {
    public static Queue<Node> q = new LinkedList<>();
    public static ArrayList<Node>[] graph;
    public static int[] weights;
    public static int N, M;

    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList[N];
        for(int i=0; i<N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++){
            int s = sc.nextInt()-1;
            int e = sc.nextInt()-1;
            int w = sc.nextInt();

            graph[s].add(new Node(e, w));
            graph[e].add(new Node(s, w));
        }

        while(M-- > 0){
            weights = new int[N];
-            Arrays.fill(weights, 10001);
+            Arrays.fill(weights, 100000001);
            int st = sc.nextInt()-1;
            int ed = sc.nextInt()-1;

            weights[st] = 0;
            q.add(new Node(st, 0));
            dajkstra();

            System.out.println(weights[ed]);
        }


    }

    public static void dajkstra(){
        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<graph[cur.idx].size(); i++){
                Node nx = graph[cur.idx].get(i);
                if(weights[nx.idx] > weights[cur.idx] + nx.w){
                    q.add(nx);
                    weights[nx.idx] = Math.min(weights[nx.idx], weights[cur.idx] + nx.w);
                }
            }
        }
    }
}

```


 ## 🏆 전체 코멘트 

1. 노드 하나당 거리가 최대 10000이고 노드의 갯수는 최대 1000개이니까 weights의 초기값을 10000*1000보다 크게 설정한다.