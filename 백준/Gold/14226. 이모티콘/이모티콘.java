import java.util.*;

class Node {
    int cur, clipboard, time;
    
    public Node(int cur, int clipboard, int time){
        this.cur=cur;
        this.clipboard = clipboard;
        this.time=time;
    }
}

public class Main {
    static int S;
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        S = sc.nextInt();
        
        System.out.println(bfs());
        
    }
    
    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[2001][2001];
        q.add(new Node(1, 0, 0));
        visited[1][0] = true;
        
        int answer = -1;
        while(!q.isEmpty()){
            Node node = q.poll();
            
            if(node.cur == S){
                answer = node.time;
                break;
            }
            
            // 1. 클립보드에 저장
            q.add(new Node(node.cur, node.cur, node.time+1));
            
            if(node.cur+ node.clipboard <= 2000 && node.clipboard != 0 && !visited[node.cur + node.clipboard][node.clipboard]){
                // 2. 화면에 붙여넣기
                q.add(new Node(node.cur + node.clipboard, node.clipboard, node.time+1));
                visited[node.cur + node.clipboard][node.clipboard] = true;
            }
            
            if(node.cur-1 >= 0 && !visited[node.cur-1][node.clipboard]){
                // 3. 이모티콘 삭제
                q.add(new Node(node.cur-1, node.clipboard, node.time+1));
                visited[node.cur-1][node.clipboard] = true;
            }
            
        }
        
        return answer;
    }
}
