import java.util.*;

class Node{
    String str;
    int cnt;
    
    public Node(String str, int cnt){
        this.str=str;
        this.cnt=cnt;
    }
}

class Solution {
    public static Queue<Node> q = new LinkedList<>();
    public static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        
        q.add(new Node(begin, 0));
        
        return BFS(target, words);
    }
    
    public static int BFS(String target, String[] words){
        int answer = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.str.equals(target)){
                answer = cur.cnt;
                break;
            }
            
            for(int i=0; i<words.length; i++){
                if(!visited[i] && check(cur.str, words[i])){
                    visited[i] = true;
                    q.add(new Node(words[i], cur.cnt+1));
                }
            }
        }
        return answer;
    }
    
    public static boolean check(String a, String b){
        int cnt = 0;
        for(int i = 0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                if(++cnt > 1) return false;
            }
        }
        return true;
    }
}