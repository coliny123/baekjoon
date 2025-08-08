import java.io.*;
import java.util.*;

public class Main {
    static class Car implements Comparable<Car>{
        public int index;
        public int pos;
        public int fuel;

        @Override
        public int compareTo(Car o) {//Arrays.sort를 위해
            return pos - o.pos;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        Car[] cars = new Car[N];
        boolean[] visit = new boolean[N+1];
        
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            cars[i] = new Car();
            cars[i].pos = Integer.parseInt(st.nextToken());
            cars[i].index = i + 1;
        }
        
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            cars[i].fuel = Integer.parseInt(st.nextToken());
        }
        
        
        Arrays.sort(cars);
        
        int startIdx = -1;
        for(int i = 0; i < N; i++){
            if(cars[i].index == S){
                startIdx = i;
                break;
            }
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        q.add(S-1);
        visit[cars[S-1].index] = true;
        
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            // 왼
            for(int i = now; i >= 0; i--){
                if(cars[i].pos < cars[now].pos - cars[now].fuel) break;
                 
                if(!visit[cars[i].index]){
                    q.add(i);
                    visit[cars[i].index] = true;
                }
            }
            
            // 오
            for(int i = now; i < N; i++){
                if(cars[i].pos > cars[now].pos + cars[now].fuel) break;
                 
                if(!visit[cars[i].index]){
                    q.add(i);
                    visit[cars[i].index] = true;
                }
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N+1; i++){
            if(visit[i]){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}