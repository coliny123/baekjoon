import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes){
            String what = cloth[0];
            String category = cloth[1];
            map.put(category, map.getOrDefault(category, 0)+1);
        }
        
        int answer = 1;
        for(String key:map.keySet()){
            answer *= (map.get(key)+1);
        }
        
        return answer-1;
    }
}