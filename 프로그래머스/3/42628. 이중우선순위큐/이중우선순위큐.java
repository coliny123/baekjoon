import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(String operation : operations){
            String[] input = operation.split(" ");
            
            int num = Integer.valueOf(input[1]);
            
            // 삽입
            if(input[0].equals("I")){
                map.put(num, map.getOrDefault(num, 0)+1);
            }
            
            // 최솟값 삭제
            if(input[0].equals("D") && num == -1 && map.size() != 0){
                int key = map.firstKey();
                int cnt = map.get(key);
                if(cnt == 1) map.remove(key);
                else map.put(key, cnt-1);
            }
            
            // 최댓값 삭제
            if(input[0].equals("D") && num == 1 && map.size() != 0){
                int key = map.lastKey();
                int cnt = map.get(key);
                if(cnt == 1) map.remove(key);
                else map.put(key, cnt-1);
            }
        }
        
        if(map.size() == 0) {
            list.add(0);
            list.add(0);
        }else{
            list.add(map.lastKey());
            list.add(map.firstKey());
        }
        
        answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}