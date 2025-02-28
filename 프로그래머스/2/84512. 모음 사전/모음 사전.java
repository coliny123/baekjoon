import java.util.*;

class Solution {
    public char[] moeum = {'A', 'E', 'I', 'O', 'U'};
    public List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        
        bt("");
        
        for(String tmp : list){
            if(tmp.equals(word)){
                break;
            }
            answer++;
        }
        
        return answer;
    }
    
    public void bt(String str){
        list.add(str);
        if(str.length() == 5) return;
        
        for(int i=0; i<5; i++){
            bt(str + moeum[i]);
        }
    }
}