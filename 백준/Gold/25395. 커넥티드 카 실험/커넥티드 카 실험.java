import java.io.*;
import java.util.*;

public class Main {
    static class Car implements Comparable<Car>{
        public int index;
        public int pos;
        public int fuel;

        @Override
        public int compareTo(Car o) {
            return pos - o.pos;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        Car[] cars = new Car[N];
        boolean[] visit = new boolean[N];
        
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
        
        // 시작 자동차의 인덱스 찾기
        int startIdx = -1;
        for(int i = 0; i < N; i++){
            if(cars[i].index == S){
                startIdx = i;
                break;
            }
        }
        
        // 투포인터 초기화
        int left = startIdx;
        int right = startIdx;
        visit[startIdx] = true;
        
        // 현재 도달 가능한 범위
        int leftBound = cars[startIdx].pos - cars[startIdx].fuel;
        int rightBound = cars[startIdx].pos + cars[startIdx].fuel;
        
        boolean expanded = true;
        
        while(expanded) {
            expanded = false;
            
            // 왼쪽으로 확장
            while(left > 0 && cars[left-1].pos >= leftBound) {
                left--;
                if(!visit[left]) {
                    visit[left] = true;
                    int newLeftBound = cars[left].pos - cars[left].fuel;
                    if(newLeftBound < leftBound) {
                        leftBound = newLeftBound;
                        expanded = true;
                    }
                    int newRightBound = cars[left].pos + cars[left].fuel;
                    if(newRightBound > rightBound) {
                        rightBound = newRightBound;
                        expanded = true;
                    }
                }
            }
            
            // 오른쪽으로 확장
            while(right < N-1 && cars[right+1].pos <= rightBound) {
                right++;
                if(!visit[right]) {
                    visit[right] = true;
                    int newLeftBound = cars[right].pos - cars[right].fuel;
                    if(newLeftBound < leftBound) {
                        leftBound = newLeftBound;
                        expanded = true;
                    }
                    int newRightBound = cars[right].pos + cars[right].fuel;
                    if(newRightBound > rightBound) {
                        rightBound = newRightBound;
                        expanded = true;
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            if(visit[i]){
                sb.append(cars[i].index).append(" ");
            }
        }
        System.out.println(sb);
    }
}