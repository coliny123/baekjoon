import java.util.*;

class Solution {
    public static Set<Integer> set = new HashSet<>();
    public static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        
        DFS("", numbers);
        
        answer = set.size();
        
        return answer;
    }
    
    public static void DFS(String str, String numbers){
        if(str.length() != 0 && str.length() <= numbers.length()){
            if(isPrime(Integer.valueOf(str))){
                set.add(Integer.valueOf(str));
            }
        }
        
        
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(str+numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }
    
    public static boolean isPrime(int a){
        if(a == 0 || a == 1) return false;
        
        for(int i=2; i<=Math.sqrt(a); i++){
            if(a % i == 0) return false;
        }
        
        return true;
    }
}