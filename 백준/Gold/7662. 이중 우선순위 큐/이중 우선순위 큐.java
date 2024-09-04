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
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.valueOf(br.readLine());
            while(k-- > 0){
                String input[] = br.readLine().split(" ");
                String com = input[0];
                int what = Integer.valueOf(input[1]);
                
                if(com.equals("I")){
                    map.put(what, map.getOrDefault(what, 0)+1);
                }else{
                    if(map.size()==0) continue;
                    
                    int key;
                    // Entry<Integer, Integer> entry;
                    if(what == -1){
                        key = map.firstKey();
                        // entry = map.firstEntry();
                    }else{
                        key = map.lastKey();
                        // entry = map.lastEntry();
                    }
                    
                    if(map.get(key) == 1){
                        map.remove(key);
                    }else{
                        map.put(key, map.get(key)-1);
                        // map.replace(entry.getKey(), entry.getValue(), entry.getValue()-1);
                    }
                }
            }
            
            
            if(map.size() == 0){
                System.out.println("EMPTY");
            }else{
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
        
        
        
    }
}
