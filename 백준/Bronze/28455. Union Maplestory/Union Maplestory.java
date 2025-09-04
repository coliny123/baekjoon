import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = Integer.valueOf(sc.nextInt());
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        while(N-- > 0){
            pq.add(Integer.valueOf(sc.nextInt()));
        }
        
        
        int sum = 0;
        int power = 0;
        
        int cnt = 0;
        while(!pq.isEmpty()){
            cnt++;
            if(cnt > 42) break;
            int lv = pq.poll();
            sum += lv;
            
            if(lv >= 60) power++;
            if(lv >= 100) power++;
            if(lv >= 140) power++;
            if(lv >= 200) power++;
            if(lv >= 250) power++;
        }
        
        System.out.println(sum + " " + power);
    }
}
