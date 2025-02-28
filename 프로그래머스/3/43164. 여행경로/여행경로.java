import java.util.*;

class Solution {
    public boolean[] visited;
    public List<String> list = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[1].equals(o2[1])){
                return o1[0].compareTo(o2[0]);
            }else{
                return o1[1].compareTo(o2[1]);
            }
        });
         
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        
        String[] answer = list.get(0).split(" ");
        // String[] answer = list.toArray(new String[0]);
        
        return answer;
    }
    
    public void dfs(int cnt, String cur, String route, String[][] tickets){
        if(cnt == tickets.length){
            list.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            String[] line = tickets[i];
            if(line[0].equals(cur) && !visited[i]){
                visited[i] = true;
                dfs(cnt+1, line[1], route + " " + line[1], tickets);
                visited[i] = false;
            }
        }
        
    }
}