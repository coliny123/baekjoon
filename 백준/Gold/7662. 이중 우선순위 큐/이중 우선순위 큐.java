import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
        int t = Integer.valueOf(br.readLine());
        
        // 오름차순
        StringBuilder sb = new StringBuilder();
        
        while(t-- > 0){
            PriorityQueue<Integer> uq = new PriorityQueue<>();
            // 내림차순
            PriorityQueue<Integer> dq = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();
            int k = Integer.valueOf(br.readLine());
            while(k-- > 0){
                String input[] = br.readLine().split(" ");
                String com = input[0];
                int what = Integer.valueOf(input[1]);
                
                if(com.equals("I")){
                    map.put(what, map.getOrDefault(what, 0)+1);
                    uq.add(what);
                    dq.add(what);
                }else{
                    if(map.size()==0){
                        continue;
                    }
                    PriorityQueue<Integer> q;
                    if(what == -1){
                        q = uq;
                    }else{
                        q = dq;
                    }
                    
                    removeTarget(map, q);
                    
                    // if(map.size() != 0){
                        // if(what == -1){
                            // int uq.poll();
                            // dq.remove(uq.poll());
                        // }else{
                            // uq.remove(dq.poll());
                        // }
                    // }
                }
            }
            
            if(map.size()==0){
                System.out.println("EMPTY");
            }else{
                int n = removeTarget(map, dq);
                System.out.println(n + " " + (map.size() > 0 ? removeTarget(map, uq) : n));
            }   
        }
    }
    
    public static int removeTarget(Map<Integer, Integer> map, PriorityQueue<Integer> q){
        int num;
        while(true){ // 하나의 q에서만 삭제하니까 다른 쪽에서는 남아있을 수 있으므로 반복문으로 맞춰주는 과정
            num = q.poll();
            int cnt = map.getOrDefault(num, 0);
            if(cnt == 0){
                continue;
            }
            
            if(cnt == 1){
                map.remove(num);
            }else{
                map.put(num, map.get(num)-1);
            }
            
            break;
        }
        
        return num;
    }
}
