import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.*;

public class Main {
    static int N, M;
    static List<List<Integer>> graph=new ArrayList<>();
    static List<List<Integer>> reverseGraph=new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= parseInt(st.nextToken());
        M=parseInt(st.nextToken());

        visited=new boolean[N+1];

        /**
         * 방향 그래프 두 개 설정
         * 간선 정보를 그대로 담는 그래프(graph) 
         * 간선 정보를 역으로 담는 그래프(reverseGraph) 
         */
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int u=parseInt(st.nextToken());
            int v=parseInt(st.nextToken());

            graph.get(u).add(v);
            reverseGraph.get(v).add(u);
        }

        int median=(N+1)/2;
        int count=0;
        int bigCount, smallCount;

        /**
         * 자신보다 작은 노드의 수[ bfs(i, graph) ]와
         * 자신보다 큰 노드의 수[ bfs(i, reverseGraph ]를
         * 구한다. 두 값중 하나라도 중간 위치(median)보다
         * 크거나 같다면 중간이 될 수 없다.
         */
        for(int i=1; i<=N; i++){
            smallCount=bfs(i, graph);
            bigCount=bfs(i, reverseGraph);

            if(bigCount>=median || smallCount>=median)
                count++;
        }

        System.out.println(count);
        br.close();
    }

    static int bfs(int start, List<List<Integer>> graph){
        Arrays.fill(visited,false);

        Queue<Integer> queue = new ArrayDeque<>();
        visited[start]=true;
        queue.offer(start);

        while(!queue.isEmpty()){
            Integer current = queue.poll();

            for(Integer next:graph.get(current)){
                if(!visited[next]){
                    visited[next]=true;
                    queue.offer(next);
                }
            }
        }

        /**
         * 방문한 노드의 수를 카운트하여 반환.
         * 자기 스스로는 제해야 하기에 -1 연산
         */
        int count=0;
        for (boolean b : visited) {
            if(b) count++;
        }

        return count-1;
    }
}
