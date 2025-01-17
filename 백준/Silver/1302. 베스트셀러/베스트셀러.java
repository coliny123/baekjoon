import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<String, Integer> map = new HashMap<>();
        
        int N = Integer.valueOf(br.readLine());
        
        int max = 0;
        while(N-- > 0){
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
            max = Math.max(max, map.get(name));
        }
        
        ArrayList<String> list = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) == max){
                list.add(key);
            }
        }
        
        Collections.sort(list);
        
        System.out.println(list.get(0));
    }
}
