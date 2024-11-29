import java.util.*;
import java.io.*;

class Jewel{
    int weight, price;
    
    public Jewel(int weight, int price){
        this.weight=weight;
        this.price=price;
    }

}


public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int K = Integer.valueOf(input[1]);
        
        
        Jewel[] jewelys = new Jewel[N];
        int[] bags = new int[K];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            jewelys[i] = new Jewel(Integer.valueOf(input[0]), Integer.valueOf(input[1]));
        }
        
        
        for(int i=0; i<K; i++){
            bags[i] = Integer.valueOf(br.readLine());
        }
        
        Arrays.sort(jewelys, (o1, o2) -> {
            if(o1.weight == o2.weight) {
            return o2.price - o1.price;  // 무게가 같으면 가격 내림차순
            }
            return o1.weight - o2.weight;    // 무게 오름차순
        });
        Arrays.sort(bags);
        
        int j_idx = 0;
        int j_length = jewelys.length;
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<K; i++){
            while(j_idx < j_length && bags[i] >= jewelys[j_idx].weight){
                pq.add(jewelys[j_idx].price);
                j_idx++;
            }
            
            if(!pq.isEmpty()){
                sum += pq.poll();
            }
        }
        
        System.out.println(sum);
    }
}
