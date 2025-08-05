import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int M = Integer.valueOf(input[1]);
        
        TreeMap<Integer, String> map = new TreeMap<>();
        
        while(N-- > 0){
            input = br.readLine().split(" ");
            String name = input[0];
            int cutLine = Integer.valueOf(input[1]);
            
            if(map.containsKey(cutLine)) continue;
            map.put(cutLine, name);
        }
        
        // for(int key : map.keySet()){
            // System.out.println(key + " = " + map.get(key));
        // }
        
        StringBuilder sb = new StringBuilder();
        while(M-- > 0){
            int power = Integer.valueOf(br.readLine());
            int key = map.ceilingKey(power);
            sb.append(map.get(key)).append("\n");
        }
        
        System.out.println(sb);
    }
}
