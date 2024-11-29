import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        
        TreeMap<String, Integer> map = new TreeMap<>();
        while(N-- > 0){
            String[] email = br.readLine().split("\\.");
            map.put(email[1], map.getOrDefault(email[1], 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(String key : map.keySet()){
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }
        
        System.out.print(sb);
    }
}
