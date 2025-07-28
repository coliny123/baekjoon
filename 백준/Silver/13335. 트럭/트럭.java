import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int N = Integer.valueOf(input[0]);
        int W = Integer.valueOf(input[1]);
        int L = Integer.valueOf(input[2]);
        
        Queue<Integer> waiting = new LinkedList<>();
        
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            waiting.add(Integer.valueOf(input[i]));
        }
        
        // 다리를 큐로 표현 (길이 W만큼 0으로 초기화)
        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0; i<W; i++){
            bridge.add(0);
        }
        
        int time = 0;
        int currentWeight = 0;
        
        while(!waiting.isEmpty() || currentWeight > 0){
            time++;
            
            int exitTruck = bridge.poll();
            currentWeight -= exitTruck;
            
            if(!waiting.isEmpty() && currentWeight + waiting.peek() <= L){
                int newTruck = waiting.poll();
                bridge.add(newTruck);
                currentWeight += newTruck;
            } else {
                bridge.add(0);
            }
        }
        
        System.out.println(time);
    }
}