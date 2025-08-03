import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int N = Integer.valueOf(input[0]);
        int D = Integer.valueOf(input[1]);
        int K = Integer.valueOf(input[2]);
        int C = Integer.valueOf(input[3]);
        
        int[] sushi = new int[N];
        // int[] counting = new int[3001];
        
        for(int i=0; i<N; i++){
            sushi[i] = Integer.valueOf(br.readLine());
        }
        
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<K; i++){
            int num = sushi[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int answer = map.size();
        if(!map.containsKey(C)) answer++;
        
        for(int i=0; i<N; i++){
            int before = sushi[i];
            
            map.put(before, map.get(before) - 1);
            if(map.get(before) <= 0) map.remove(before);
            
            int nextIdx = (i+K) % N;
            int next = sushi[nextIdx];
            map.put(next, map.getOrDefault(next, 0) + 1);
            
            int curSize = map.size();
            if(!map.containsKey(C)) curSize++;
            
            answer = Math.max(answer, curSize);
        }
        
        System.out.println(answer);
        
    }
}
