import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        TreeMap<String, Integer> map = new TreeMap<>();
        
        String input = "";
        int total = 0;
        while((input = br.readLine()) != null) {
            map.put(input, map.getOrDefault(input, 0)+1);
            total++;
        }
        
        for(String key : map.keySet()){
            System.out.printf("%s %.4f\n", key, (double)map.get(key) / total * 100);
        }
        
        
        
    }
}
